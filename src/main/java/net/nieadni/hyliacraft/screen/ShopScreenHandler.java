package net.nieadni.hyliacraft.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.nieadni.hyliacraft.entity.HappyMaskSalesmanEntity;
import net.nieadni.hyliacraft.item.RupeePouches;
import net.nieadni.hyliacraft.shop.RupeeCost;
import net.nieadni.hyliacraft.shop.RupeeCostLoader;
import net.nieadni.hyliacraft.shop.ShopEntry;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The Happy Mask Salesman's shop.
 *
 * <p>There are no slots at all. Everything a player can buy is paid for from their Rupee Pouches, so
 * nothing is ever placed in the window; clicking a row is the whole transaction. The row list arrives with
 * the screen because prices live in server-side datapacks the client never receives, while the two things
 * that change during a visit, the player's money and what is left in stock, sync as properties.
 */
public class ShopScreenHandler extends ScreenHandler {

    private final PlayerInventory playerInventory;
    private final List<ShopEntry> entries;

    /** Present only on the server. The client identifies rows by index. */
    @Nullable
    private final HappyMaskSalesmanEntity salesman;

    private int syncedBalance;
    private final int[] syncedStock;

    /** Server-side construction, where the salesman is known. */
    public ShopScreenHandler(int syncId, PlayerInventory playerInventory,
                             @Nullable HappyMaskSalesmanEntity salesman, List<ShopEntry> entries) {
        super(HCScreenHandlers.SHOP, syncId);
        this.playerInventory = playerInventory;
        this.salesman = salesman;
        this.entries = entries;
        this.syncedStock = new int[entries.size()];

        this.addProperty(new Property() {
            @Override
            public int get() {
                return RupeePouches.totalBalance(playerInventory);
            }

            @Override
            public void set(int value) {
                syncedBalance = value;
            }
        });

        // One flag per row. Properties are fixed in number, which is fine here because both sides build
        // the handler from the same entry list, so the counts always agree.
        for (int row = 0; row < entries.size(); row++) {
            int index = row;
            this.addProperty(new Property() {
                @Override
                public int get() {
                    return isInStockOnServer(index) ? 1 : 0;
                }

                @Override
                public void set(int value) {
                    syncedStock[index] = value;
                }
            });
        }
    }

    /** Client-side construction from the data sent when the screen opened. */
    public ShopScreenHandler(int syncId, PlayerInventory playerInventory, List<ShopEntry> entries) {
        this(syncId, playerInventory, null, entries);
    }

    public List<ShopEntry> getEntries() {
        return this.entries;
    }

    private boolean isClient() {
        return this.playerInventory.player.getWorld().isClient();
    }

    /** Rupees the shopper has across every pouch they carry. */
    public int getBalance() {
        return isClient() ? this.syncedBalance : RupeePouches.totalBalance(this.playerInventory);
    }

    public boolean canAfford(int index) {
        return index >= 0 && index < this.entries.size() && getBalance() >= this.entries.get(index).cost();
    }

    public boolean isInStock(int index) {
        if (index < 0 || index >= this.entries.size()) {
            return false;
        }
        return isClient() ? this.syncedStock[index] == 1 : isInStockOnServer(index);
    }

    private boolean isInStockOnServer(int index) {
        RupeeCost cost = serverCost(index);
        return cost != null && this.salesman != null && this.salesman.isInStock(cost);
    }

    /**
     * The authoritative price entry for a row.
     *
     * <p>Looked up by item rather than trusting the index, because the price list can be reloaded while a
     * player has the shop open and the row order would shift underneath them.
     */
    @Nullable
    private RupeeCost serverCost(int index) {
        if (index < 0 || index >= this.entries.size()) {
            return null;
        }
        Item wanted = this.entries.get(index).item();
        for (RupeeCost candidate : RupeeCostLoader.getSorted()) {
            if (candidate.item() == wanted) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.salesman == null || (this.salesman.isAlive() && this.salesman.isInRange(player, 8.0));
    }

    /** Buying. The button id is the row index. */
    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        RupeeCost cost = serverCost(id);
        if (cost == null || this.salesman == null || !this.salesman.isInStock(cost)) {
            return false;
        }

        // An accepted item, if the entry wants one, must be found before any money moves.
        int inputSlot = cost.accepts().isEmpty() ? -1 : findAccepted(player, cost);
        if (!cost.accepts().isEmpty() && inputSlot < 0) {
            return false;
        }

        // Debit last, and all-or-nothing, so a failed purchase never leaves a player out of pocket.
        if (!RupeePouches.debit(player.getInventory(), cost.cost())) {
            return false;
        }

        if (inputSlot >= 0) {
            player.getInventory().removeStack(inputSlot, 1);
        }

        this.salesman.recordPurchase(cost);

        ItemStack bought = new ItemStack(cost.item());
        if (!player.getInventory().insertStack(bought)) {
            player.dropItem(bought, false);
        }
        return true;
    }

    /** Index of the first inventory slot holding something this entry accepts, or -1. */
    private static int findAccepted(PlayerEntity player, RupeeCost cost) {
        PlayerInventory inventory = player.getInventory();
        for (int slot = 0; slot < inventory.size(); slot++) {
            ItemStack stack = inventory.getStack(slot);
            if (!stack.isEmpty() && cost.accepts().contains(stack.getItem())) {
                return slot;
            }
        }
        return -1;
    }

    /** No slots, so there is nothing to shift-click between. */
    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        return ItemStack.EMPTY;
    }
}
