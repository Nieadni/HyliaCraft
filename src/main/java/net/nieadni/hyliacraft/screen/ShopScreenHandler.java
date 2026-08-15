package net.nieadni.hyliacraft.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.nieadni.hyliacraft.entity.HappyMaskSalesmanEntity;
import net.nieadni.hyliacraft.item.RupeePouches;
import net.nieadni.hyliacraft.shop.ShopEntry;
import net.nieadni.hyliacraft.shop.ShopRow;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The Happy Mask Salesman's shop.
 *
 * <p>Nothing is bought by placing items: payment comes from the player's Rupee Pouches, so clicking a row
 * is the whole transaction. The player's own inventory is still shown, at vanilla's villager positions,
 * because a shop you cannot see your belongings in is disorienting and the background draws the slots
 * whether or not anything backs them.
 *
 * <p>The row list arrives with the screen, since prices live in server-side datapacks the client never
 * receives. Money and remaining stock sync as properties, both changing during a visit.
 */
public class ShopScreenHandler extends ScreenHandler {

    private final PlayerInventory playerInventory;
    private final List<ShopEntry> entries;

    /** Server side only. The client identifies rows by index into {@link #entries}. */
    @Nullable
    private final List<ShopRow> rows;
    @Nullable
    private final HappyMaskSalesmanEntity salesman;

    private int syncedBalance;
    private final int[] syncedStock;

    /** Server-side construction, where the salesman and the authoritative rows are known. */
    public ShopScreenHandler(int syncId, PlayerInventory playerInventory,
                             @Nullable HappyMaskSalesmanEntity salesman, List<ShopRow> rows) {
        this(syncId, playerInventory, salesman, rows, rows.stream().map(ShopRow::toEntry).toList());
    }

    /** Client-side construction from the data sent when the screen opened. */
    public ShopScreenHandler(int syncId, PlayerInventory playerInventory, List<ShopEntry> entries) {
        this(syncId, playerInventory, null, null, entries);
    }

    private ShopScreenHandler(int syncId, PlayerInventory playerInventory,
                              @Nullable HappyMaskSalesmanEntity salesman,
                              @Nullable List<ShopRow> rows, List<ShopEntry> entries) {
        super(HCScreenHandlers.SHOP, syncId);
        this.playerInventory = playerInventory;
        this.salesman = salesman;
        this.rows = rows;
        this.entries = entries;
        this.syncedStock = new int[entries.size()];

        // Vanilla's villager layout puts the player inventory to the right of the trade list.
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 108 + column * 18, 84 + row * 18));
            }
        }
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, 108 + column * 18, 142));
        }

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

        // One flag per row. Both sides build from the same list, so the property counts always agree.
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
        if (this.rows == null || this.salesman == null || index < 0 || index >= this.rows.size()) {
            return false;
        }
        return this.salesman.isInStock(this.rows.get(index).cost());
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.salesman == null || (this.salesman.isAlive() && this.salesman.isInRange(player, 8.0));
    }

    /**
     * Buying. The button id is the row index.
     *
     * <p>Rows are a snapshot taken when the screen opened, so a datapack reload mid-visit cannot shift what
     * a click resolves to.
     */
    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.rows == null || this.salesman == null || id < 0 || id >= this.rows.size()) {
            return false;
        }
        ShopRow row = this.rows.get(id);
        if (!this.salesman.isInStock(row.cost())) {
            return false;
        }

        // Find the required item before any money moves.
        int inputSlot = row.hasAccepted() ? findAccepted(player, row) : -1;
        if (row.hasAccepted() && inputSlot < 0) {
            return false;
        }

        // The goods land on the cursor, the way taking from any slot behaves. Check there is room for them
        // before charging, or a full cursor would take the player's money and give nothing back.
        ItemStack bought = new ItemStack(row.cost().item());
        ItemStack cursor = this.getCursorStack();
        boolean ontoEmptyCursor = cursor.isEmpty();
        if (!ontoEmptyCursor && !(ItemStack.areItemsAndComponentsEqual(cursor, bought)
                && cursor.getCount() + bought.getCount() <= cursor.getMaxCount())) {
            return false;
        }

        // Debit last, and all or nothing, so a failed purchase never leaves a player out of pocket.
        if (!RupeePouches.debit(player.getInventory(), row.cost().cost())) {
            return false;
        }

        if (inputSlot >= 0) {
            player.getInventory().removeStack(inputSlot, 1);
        }

        this.salesman.recordPurchase(row.cost());

        if (ontoEmptyCursor) {
            this.setCursorStack(bought);
        } else {
            cursor.increment(bought.getCount());
        }
        return true;
    }

    /** Index of the first inventory slot holding this row's required item, or -1. */
    private static int findAccepted(PlayerEntity player, ShopRow row) {
        PlayerInventory inventory = player.getInventory();
        for (int slot = 0; slot < inventory.size(); slot++) {
            if (inventory.getStack(slot).isOf(row.accepted())) {
                return slot;
            }
        }
        return -1;
    }

    /** Shift-clicking has nowhere to move things to, since the shop owns no slots of its own. */
    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        return ItemStack.EMPTY;
    }
}
