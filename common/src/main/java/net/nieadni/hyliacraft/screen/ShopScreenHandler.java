package net.nieadni.hyliacraft.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.MathHelper;
import net.nieadni.hyliacraft.entity.HappyMaskSalesmanEntity;
import net.nieadni.hyliacraft.item.HCItems;
import net.nieadni.hyliacraft.item.RupeePouches;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;
import net.nieadni.hyliacraft.shop.RupeeTrade;
import net.nieadni.hyliacraft.shop.Rupees;
import net.nieadni.hyliacraft.shop.ShopEntry;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

/**
 * The Happy Mask Salesman's shop.
 *
 * <p>Payment is handed over rather than deducted in the background: the player puts a Rupee Pouch, or a
 * stack of loose rupees, into the payment slot, and takes the goods out of the result slot. That is how
 * every other merchant in the game works, and it means nothing leaves a player's pockets without them
 * putting it on the counter first.
 *
 * <p>The scrollable list of offers on the left is not made of slots and never was. Only the three slots of
 * the trading area are real, plus the player's own inventory at vanilla's villager positions.
 */
public class ShopScreenHandler extends ScreenHandler {

    public static final int PAYMENT_SLOT = 0;
    public static final int TRADE_IN_SLOT = 1;
    public static final int RESULT_SLOT = 2;

    /** Where the player's own slots start, once the trading area's three are accounted for. */
    private static final int INVENTORY_START = 3;
    private static final int INVENTORY_END = INVENTORY_START + 36;

    /** Vanilla's villager trading area, which the background texture already draws slot frames for. */
    private static final int PAYMENT_X = 136;
    private static final int TRADE_IN_X = 162;
    private static final int RESULT_X = 220;
    private static final int TRADE_Y = 37;

    private final PlayerInventory playerInventory;
    private final List<ShopEntry> entries;

    /** Server side only. The client identifies rows by index into {@link #entries}. */
    @Nullable
    private final List<RupeeTrade> stock;
    @Nullable
    private final HappyMaskSalesmanEntity salesman;

    /** Payment and trade-in. Handed back to the player when the screen closes. */
    private final SimpleInventory inputs = new SimpleInventory(2);

    /**
     * What a purchase would yield, if one is currently possible.
     *
     * <p>A second inventory rather than a third slot of {@link #inputs}, and deliberately without a
     * listener: filling the result has to not count as a content change, or writing to it would ask for it
     * to be written again and never stop.
     */
    private final SimpleInventory result = new SimpleInventory(1);

    /** The row laid out in the trading area. Synced, so a rejected click cannot leave the two sides apart. */
    private int selectedIndex;

    private int syncedBalanceLow;
    private int syncedBalanceHigh;
    private final int[] syncedStock;

    /** Server-side construction, where the salesman and the authoritative stock are known. */
    public ShopScreenHandler(int syncId, PlayerInventory playerInventory,
                             @Nullable HappyMaskSalesmanEntity salesman, List<RupeeTrade> stock) {
        this(syncId, playerInventory, salesman, stock, stock.stream().map(ShopEntry::of).toList());
    }

    /** Client-side construction from the data sent when the screen opened. */
    public ShopScreenHandler(int syncId, PlayerInventory playerInventory, List<ShopEntry> entries) {
        this(syncId, playerInventory, null, null, entries);
    }

    private ShopScreenHandler(int syncId, PlayerInventory playerInventory,
                              @Nullable HappyMaskSalesmanEntity salesman,
                              @Nullable List<RupeeTrade> stock, List<ShopEntry> entries) {
        super(HCScreenHandlers.SHOP, syncId);
        this.playerInventory = playerInventory;
        this.salesman = salesman;
        this.stock = stock;
        this.entries = entries;
        this.syncedStock = new int[entries.size()];

        this.addSlot(new PaymentSlot(this.inputs, PAYMENT_SLOT, PAYMENT_X, TRADE_Y));
        this.addSlot(new TradeInSlot(this.inputs, TRADE_IN_SLOT, TRADE_IN_X, TRADE_Y));
        this.addSlot(new ResultSlot(this.result, 0, RESULT_X, TRADE_Y));

        // Vanilla's villager layout puts the player inventory to the right of the trade list.
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 108 + column * 18, 84 + row * 18));
            }
        }
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, 108 + column * 18, 142));
        }

        // Sent as two halves. A screen property travels as a signed 16-bit short, and a total across
        // several pouches passes 32767 with only four of them, at which point it wraps negative on the
        // client and every row reads as unaffordable. Masking to 16 bits survives the sign extension on
        // the way back, because writeShort keeps the low bits either way.
        //
        // The player-wide figure, not the inventory one: this is what the shopper reads, and a pouch put
        // on the counter must not look like money that has gone missing.
        this.addProperty(new Property() {
            @Override
            public int get() {
                return RupeePouches.totalBalance(playerInventory.player) & 0xFFFF;
            }

            @Override
            public void set(int value) {
                syncedBalanceLow = value & 0xFFFF;
            }
        });
        this.addProperty(new Property() {
            @Override
            public int get() {
                return (RupeePouches.totalBalance(playerInventory.player) >>> 16) & 0xFFFF;
            }

            @Override
            public void set(int value) {
                syncedBalanceHigh = value & 0xFFFF;
            }
        });

        // The client picks a row optimistically so the trading area responds to the click at once, and
        // this property is the server correcting it if the click was refused.
        this.addProperty(new Property() {
            @Override
            public int get() {
                return selectedIndex;
            }

            @Override
            public void set(int value) {
                selectedIndex = value;
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

        this.inputs.addListener(this::onContentChanged);
    }

    public List<ShopEntry> getEntries() {
        return this.entries;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    /** Called by the screen so a click lands immediately rather than after a round trip to the server. */
    public void selectLocally(int index) {
        this.selectedIndex = index;
    }

    /** The row laid out in the trading area, or null when there is none. */
    @Nullable
    public ShopEntry selectedEntry() {
        return this.selectedIndex >= 0 && this.selectedIndex < this.entries.size()
                ? this.entries.get(this.selectedIndex)
                : null;
    }

    private boolean isClient() {
        return this.playerInventory.player.getWorld().isClient();
    }

    /**
     * Rupees the shopper owns across every pouch they carry.
     *
     * <p>This is what colours a row's price, not what decides a purchase. "Could I afford this at all" is
     * the useful question while browsing; what is actually spendable is whatever is in the payment slot.
     */
    public int getBalance() {
        return isClient()
                ? (this.syncedBalanceHigh << 16) | this.syncedBalanceLow
                : RupeePouches.totalBalance(this.playerInventory.player);
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
        if (this.stock == null || this.salesman == null || index < 0 || index >= this.stock.size()) {
            return false;
        }
        return this.salesman.isInStock(this.stock.get(index));
    }

    @Nullable
    private RupeeTrade selectedCost() {
        return this.stock != null && this.selectedIndex >= 0 && this.selectedIndex < this.stock.size()
                ? this.stock.get(this.selectedIndex)
                : null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.salesman == null || (this.salesman.isAlive() && this.salesman.isInRange(player, 8.0));
    }

    // ------------------------------------------------------------------ payment

    /**
     * Rupees the payment slot can raise.
     *
     * <p>A pouch is topped up from the others the player carries, because one pouch holds 999 and a
     * datapack is free to price something above that. Loose coins stand alone: quietly reaching into a
     * pouch the player did not put on the counter is exactly the behaviour this slot exists to remove.
     *
     * <p>The inventory-only total here, deliberately, not the player-wide one used for display. The
     * player-wide figure already counts the pouch sitting in the payment slot, so adding it to the
     * slotted pouch's own balance would let a single pouch pay for everything twice.
     */
    private int availableFunds() {
        ItemStack payment = this.inputs.getStack(PAYMENT_SLOT);
        if (payment.isOf(HCItems.RUPEE_POUCH)) {
            return RupeePouchItem.getBalance(payment) + RupeePouches.totalBalance(this.playerInventory);
        }
        int value = Rupees.valueOf(payment.getItem());
        return value > 0 ? value * payment.getCount() : 0;
    }

    /**
     * Whether the selected row could be bought right now with what is on the counter.
     *
     * <p>Deliberately answerable on both sides, from {@link #entries} and the synced stock flags rather
     * than from the server's price list. The result slot's {@code canTakeItems} asks this question, and a
     * client that always answered no would refuse its own click and then have the purchase appear a tick
     * later when the server corrected it.
     */
    private boolean payable() {
        ShopEntry entry = selectedEntry();
        if (entry == null || !isInStock(this.selectedIndex)) {
            return false;
        }
        // satisfiedBy covers "nothing handed over", "the wrong thing" and "not enough of the right thing"
        // in one question, since an empty stack reports AIR and no entry ever lists it.
        if (entry.hasAccepted() && !entry.satisfiedBy(this.inputs.getStack(TRADE_IN_SLOT))) {
            return false;
        }
        return availableFunds() >= entry.cost();
    }

    /**
     * Fills or empties the result slot.
     *
     * <p>Server side only; the client receives the outcome as an ordinary slot update. Were the client to
     * compute it too, it would clear the slot on every content change and fight the sync for it.
     */
    private void updateResult() {
        if (this.stock == null) {
            return;
        }
        RupeeTrade trade = selectedCost();
        this.result.setStack(0,
                trade != null && payable() ? new ItemStack(trade.item(), trade.count()) : ItemStack.EMPTY);
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        super.onContentChanged(inventory);
        updateResult();
    }

    /**
     * Takes the price out of the payment slot.
     *
     * <p>Coins are spent whole, so the fewest that cover the price are taken and the difference comes back
     * as change: paying 666 with gold rupees hands over three and returns 234.
     */
    private void charge(PlayerEntity player, int cost) {
        ItemStack payment = this.inputs.getStack(PAYMENT_SLOT);

        if (payment.isOf(HCItems.RUPEE_POUCH)) {
            int fromCounter = Math.min(cost, RupeePouchItem.getBalance(payment));
            RupeePouchItem.withdraw(payment, fromCounter);
            RupeePouches.debit(player.getInventory(), cost - fromCounter);
            this.inputs.markDirty();
            return;
        }

        int value = Rupees.valueOf(payment.getItem());
        if (value <= 0) {
            return;
        }
        int spent = MathHelper.ceilDiv(cost, value);
        this.inputs.removeStack(PAYMENT_SLOT, spent);
        giveChange(player, spent * value - cost);
    }

    /**
     * Hands back overpayment.
     *
     * <p>Into the inventory rather than onto the cursor: the cursor is holding the goods at this point,
     * and change is at most nine coins over five stacks, which the cursor could not carry anyway.
     */
    private void giveChange(PlayerEntity player, int amount) {
        for (ItemStack coins : Rupees.change(amount)) {
            player.getInventory().insertStack(coins);
            // Test the stack, not the return value. insertStack reports whether it placed *any* items and
            // empties what it took from the stack it was given, so a partial insert returns true while
            // leaving coins behind. Trusting the boolean would destroy the remainder.
            if (!coins.isEmpty()) {
                player.dropItem(coins, false);
            }
        }
    }

    /**
     * Charges for a purchase whose goods have already left the result slot.
     *
     * <p>Paying after the goods have gone is safe only because the result slot is empty unless
     * {@link #payable()} holds, and nothing can change between the two on a single thread. If that
     * invariant is ever broken, this is where items start being given away.
     */
    private void completePurchase(PlayerEntity player) {
        RupeeTrade cost = selectedCost();
        if (cost == null || this.salesman == null) {
            return;
        }

        charge(player, cost.cost());
        // Read the count off the item actually handed over, not off the first alternative: a row taking
        // two ingots or one block must consume the right number of whichever the player chose.
        int handedOver = cost.requiredCount(this.inputs.getStack(TRADE_IN_SLOT).getItem());
        if (handedOver > 0) {
            this.inputs.removeStack(TRADE_IN_SLOT, handedOver);
        }
        this.salesman.recordPurchase(cost);
        updateResult();
    }

    // ------------------------------------------------------------------ interaction

    /**
     * Selecting a row. The button id is the row index.
     *
     * <p>Buying is no longer done here: a click on a row only chooses what the trading area shows, and the
     * purchase happens when the result slot is taken, the way a villager trade completes.
     */
    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (id < 0 || id >= this.entries.size()) {
            return false;
        }
        this.selectedIndex = id;
        returnUnacceptedTradeIn(player);
        autofill(player);
        updateResult();
        return true;
    }

    /**
     * Pulls what the selected row needs out of the player's inventory, the way a villager fills its own
     * ingredient slots when a trade is picked.
     *
     * <p>Only ever fills a slot that is empty. Someone who has already put loose coins on the counter, or
     * chosen which of several accepted items to hand over, has made a decision this must not overwrite.
     *
     * <p>Any pouch will do rather than the fattest one, because {@link #availableFunds()} tops up from
     * whatever else the player is carrying; picking one is a convenience, not a commitment.
     */
    private void autofill(PlayerEntity player) {
        ShopEntry entry = selectedEntry();
        if (entry == null) {
            return;
        }
        if (this.inputs.getStack(PAYMENT_SLOT).isEmpty()) {
            takeFromInventory(player, stack -> stack.isOf(HCItems.RUPEE_POUCH), PAYMENT_SLOT);
        }
        if (entry.hasAccepted() && this.inputs.getStack(TRADE_IN_SLOT).isEmpty()) {
            takeFromInventory(player, stack -> entry.requiredCount(stack.getItem()) > 0, TRADE_IN_SLOT);
        }
    }

    /**
     * Moves the first matching stack from the player's inventory into a trading slot.
     *
     * <p>Bounded to {@link PlayerInventory#MAIN_SIZE} on purpose. {@code inventory.size()} is 41 and spans
     * armour and the off hand, and taking from it bypasses {@link Slot} entirely, so a player wearing a
     * carved pumpkin would have it stripped off their head to fill the trade-in slot for a Pumpkin Mask,
     * curse of binding included.
     *
     * <p>The whole stack moves, not one item, so repeat purchases work without refilling the slot by hand.
     * Anything left over is handed back when the screen closes.
     */
    private void takeFromInventory(PlayerEntity player, Predicate<ItemStack> wanted, int target) {
        PlayerInventory inventory = player.getInventory();
        for (int slot = 0; slot < PlayerInventory.MAIN_SIZE; slot++) {
            ItemStack candidate = inventory.getStack(slot);
            if (wanted.test(candidate)) {
                this.inputs.setStack(target, inventory.removeStack(slot, candidate.getCount()));
                return;
            }
        }
    }

    /**
     * Pushes the trade-in item back when the newly selected row will not take it.
     *
     * <p>Without this, switching rows can leave an item sitting in a slot that now refuses it. The
     * purchase then silently will not complete, and nothing on screen says why.
     */
    private void returnUnacceptedTradeIn(PlayerEntity player) {
        ItemStack tradeIn = this.inputs.getStack(TRADE_IN_SLOT);
        ShopEntry entry = selectedEntry();
        if (tradeIn.isEmpty() || (entry != null && entry.requiredCount(tradeIn.getItem()) > 0)) {
            return;
        }
        this.inputs.setStack(TRADE_IN_SLOT, ItemStack.EMPTY);
        player.getInventory().insertStack(tradeIn);
        if (!tradeIn.isEmpty()) {
            player.dropItem(tradeIn, false);
        }
    }

    /**
     * Refuses double-click gather, exactly as {@code MerchantScreenHandler} does, and for the same reason.
     *
     * <p>{@code PICKUP_ALL} sweeps every slot it is allowed to take from and calls {@code takeStackRange}
     * directly, never {@code onTakeItem}. The result slot would hand its contents over without anything
     * charging for them: buy one stackable item legitimately, then double-click with it on the cursor and
     * take the next one free. Returning false here is the only hook vanilla offers to stop that.
     */
    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return false;
    }

    /** Releases the salesman and gives the player back everything they put on the counter. */
    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        if (this.salesman != null) {
            this.salesman.setCustomer(null);
        }
        // The result was a preview of a purchase that was never paid for.
        this.result.clear();
        this.dropInventory(player, this.inputs);
    }

    /**
     * Shift-clicking.
     *
     * <p>Out of the trading area into the inventory, and out of the inventory into whichever trading slot
     * will have it. Shift-clicking the result buys repeatedly while the money and the stock last, which is
     * what vanilla's own quick-move loop does with a villager and what players will expect.
     */
    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        Slot slot = this.slots.get(slotIndex);
        if (!slot.hasStack()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = slot.getStack();
        ItemStack original = stack.copy();

        if (slotIndex == RESULT_SLOT) {
            if (!slot.canTakeItems(player) || !insertItem(stack, INVENTORY_START, INVENTORY_END, true)) {
                return ItemStack.EMPTY;
            }
        } else if (slotIndex < INVENTORY_START) {
            if (!insertItem(stack, INVENTORY_START, INVENTORY_END, true)) {
                return ItemStack.EMPTY;
            }
        } else if (!insertItem(stack, PAYMENT_SLOT, RESULT_SLOT, false)) {
            return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            slot.setStack(ItemStack.EMPTY);
        } else {
            slot.markDirty();
        }
        if (stack.getCount() == original.getCount()) {
            return ItemStack.EMPTY;
        }
        slot.onTakeItem(player, stack);
        return original;
    }

    // ------------------------------------------------------------------ slots

    /** Takes a Rupee Pouch, or loose rupees for a player who has not found a pouch yet. */
    private static class PaymentSlot extends Slot {

        PaymentSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return stack.isOf(HCItems.RUPEE_POUCH) || Rupees.valueOf(stack.getItem()) > 0;
        }
    }

    /** Takes whatever the selected row accepts, and nothing at all when it wants rupees alone. */
    private class TradeInSlot extends Slot {

        TradeInSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            ShopEntry entry = selectedEntry();
            return entry != null && entry.requiredCount(stack.getItem()) > 0;
        }
    }

    /**
     * The purchase itself.
     *
     * <p>Empty unless the trade can be paid for, so taking it is both the confirmation and the trigger.
     * That is the vanilla merchant contract, and it is what lets the transaction be charged after the fact
     * without ever handing something over for free.
     */
    private class ResultSlot extends Slot {

        ResultSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }

        @Override
        public boolean canTakeItems(PlayerEntity player) {
            return payable();
        }

        @Override
        public void onTakeItem(PlayerEntity player, ItemStack stack) {
            completePurchase(player);
        }
    }
}
