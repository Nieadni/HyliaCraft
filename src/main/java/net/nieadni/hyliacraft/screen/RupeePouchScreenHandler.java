package net.nieadni.hyliacraft.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.nieadni.hyliacraft.item.HCItems;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;
import net.nieadni.hyliacraft.shop.RupeeChange;

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

    /** Withdrawals of more than one coin are capped at a stack. */
    private static final int BULK_LIMIT = 64;

    private final PlayerInventory playerInventory;

    public RupeePouchScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(HCScreenHandlers.RUPEE_POUCH, syncId);
        this.playerInventory = playerInventory;

        // Player inventory, three rows, at the positions measured from the GUI texture.
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 48 + row * 18));
            }
        }
        // Hotbar.
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

    public int getBalance() {
        return RupeePouchItem.getBalance(getPouch());
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return !getPouch().isEmpty();
    }

    /**
     * Withdraws coins.
     *
     * <p>The button id packs the denomination and whether shift was held, because the vanilla button
     * channel carries a single integer: {@code index * 2 + (bulk ? 1 : 0)}.
     */
    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        int index = id >> 1;
        boolean bulk = (id & 1) == 1;

        if (index < 0 || index >= RupeeChange.DENOMINATIONS.size()) {
            return false;
        }
        ItemStack pouch = getPouch();
        if (pouch.isEmpty()) {
            return false;
        }

        RupeeChange.Denomination denomination = RupeeChange.DENOMINATIONS.get(index);
        int affordable = RupeePouchItem.getBalance(pouch) / denomination.value();
        if (affordable <= 0) {
            return false;
        }

        // Shift takes a stack, or everything affordable if that is less.
        int count = bulk ? Math.min(affordable, BULK_LIMIT) : 1;
        if (!RupeePouchItem.withdraw(pouch, count * denomination.value())) {
            return false;
        }

        ItemStack coins = new ItemStack(denomination.item(), count);
        if (!player.getInventory().insertStack(coins)) {
            // No room. Dropping is safe: the pickup hook only fires for items walked over, so these do not
            // vanish straight back into the pouch.
            player.dropItem(coins, false);
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
        int value = RupeeChange.valueOf(stack.getItem());
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
