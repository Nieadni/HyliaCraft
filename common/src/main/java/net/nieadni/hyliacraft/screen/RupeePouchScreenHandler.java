package net.nieadni.hyliacraft.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.nieadni.hyliacraft.item.HCItems;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;
import net.nieadni.hyliacraft.shop.Rupees;

/**
 * The Rupee Pouch screen.
 *
 * <p>Only the player's own inventory is backed by real {@link Slot}s. The eight denominations along the top
 * are not slots at all: a pouch holds one number, not eight stacks, so there is nothing for a slot to be
 * attached to. They are buttons, and the client reports clicks through the vanilla button channel rather
 * than through a custom packet.
 *
 * <p>The open pouch is resolved from the player's hands on every operation rather than captured once. That
 * way the balance cannot be read from a stale copy if the stack moves underneath the screen.
 */
public class RupeePouchScreenHandler extends ScreenHandler {

    private final PlayerInventory playerInventory;

    /** The balance as last told to us by the server. Only meaningful on the client. */
    private int syncedBalance;

    public RupeePouchScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(HCScreenHandlers.RUPEE_POUCH, syncId);
        this.playerInventory = playerInventory;

        // The balance is synced explicitly rather than read off the stack on the client. A screen only
        // syncs the slots it owns, and the pouch may be held in the off hand, which no slot here tracks.
        // Reading the client's copy of the stack would then show a number frozen at whatever it was when
        // the screen opened, with withdrawals appearing to do nothing.
        this.addProperty(new Property() {
            @Override
            public int get() {
                return RupeePouchItem.getBalance(getPouch());
            }

            @Override
            public void set(int value) {
                syncedBalance = value;
            }
        });

        // Positions measured from the GUI texture.
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 48 + row * 18));
            }
        }
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, 8 + column * 18, 106));
        }
    }

    /** The pouch this screen is showing, or empty if the player is no longer holding one. */
    public ItemStack getPouch() {
        PlayerEntity player = this.playerInventory.player;
        ItemStack mainHand = player.getMainHandStack();
        if (mainHand.isOf(HCItems.RUPEE_POUCH)) {
            return mainHand;
        }
        ItemStack offHand = player.getOffHandStack();
        if (offHand.isOf(HCItems.RUPEE_POUCH)) {
            return offHand;
        }
        return ItemStack.EMPTY;
    }

    /** Rupees in the open pouch. Safe to call on either side. */
    public int getBalance() {
        return this.playerInventory.player.getWorld().isClient()
                ? this.syncedBalance
                : RupeePouchItem.getBalance(getPouch());
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return !getPouch().isEmpty();
    }

    /**
     * Withdraws coins onto the cursor.
     *
     * <p>The button id packs the denomination and whether shift was held, because the vanilla button
     * channel carries a single integer: {@code index * 2 + (bulk ? 1 : 0)}.
     *
     * <p>Coins are picked up rather than posted into the inventory, so taking money out of a pouch feels
     * like taking anything out of any other slot. The cursor's remaining room is therefore the real limit
     * on a withdrawal, and it is measured before the balance is touched: money must never leave the pouch
     * without somewhere to land.
     */
    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        int index = id >> 1;
        boolean bulk = (id & 1) == 1;

        if (index < 0 || index >= Rupees.DENOMINATIONS.size()) {
            return false;
        }
        ItemStack pouch = getPouch();
        if (pouch.isEmpty()) {
            return false;
        }

        Rupees.Denomination denomination = Rupees.DENOMINATIONS.get(index);
        int affordable = RupeePouchItem.getBalance(pouch) / denomination.value();
        if (affordable <= 0) {
            return false;
        }

        ItemStack cursor = this.getCursorStack();
        boolean ontoEmptyCursor = cursor.isEmpty();
        int room;
        if (ontoEmptyCursor) {
            room = denomination.item().getMaxCount();
        } else if (cursor.isOf(denomination.item())) {
            room = cursor.getMaxCount() - cursor.getCount();
        } else {
            // Holding something else entirely. Refuse rather than shuffle it aside.
            return false;
        }
        if (room <= 0) {
            return false;
        }

        // Shift takes as many as the balance allows; either way the cursor caps it at a stack.
        int count = Math.min(bulk ? affordable : 1, room);
        if (!RupeePouchItem.withdraw(pouch, count * denomination.value())) {
            return false;
        }

        if (ontoEmptyCursor) {
            this.setCursorStack(new ItemStack(denomination.item(), count));
        } else {
            cursor.increment(count);
        }
        return true;
    }

    /**
     * Shift-clicking rupees banks them, which is what players will try first.
     *
     * <p>Always returns empty so vanilla stops looping. There is no container inventory to move things
     * into, so a conventional transfer implementation has nothing to do here.
     */
    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        Slot slot = this.slots.get(slotIndex);
        if (!slot.hasStack()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = slot.getStack();
        int value = Rupees.valueOf(stack.getItem());
        ItemStack pouch = getPouch();
        if (value <= 0 || pouch.isEmpty()) {
            return ItemStack.EMPTY;
        }

        int fitting = Math.min(stack.getCount(), RupeePouchItem.spaceLeft(pouch) / value);
        if (fitting <= 0) {
            return ItemStack.EMPTY;
        }

        RupeePouchItem.deposit(pouch, fitting * value);
        stack.decrement(fitting);
        slot.markDirty();
        return ItemStack.EMPTY;
    }
}
