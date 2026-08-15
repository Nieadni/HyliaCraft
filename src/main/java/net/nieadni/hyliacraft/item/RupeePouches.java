package net.nieadni.hyliacraft.item;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory-wide rupee pouch operations.
 *
 * <p>{@link RupeePouchItem} handles one pouch. This handles a player's whole collection of them, which is
 * the level merchants and pickup care about: a player may carry several pouches and each holds its own
 * balance, so spending or collecting has to cascade across them.
 */
public final class RupeePouches {

    private RupeePouches() {
    }

    /**
     * Every pouch a player is carrying, in the order they are used.
     *
     * <p>Hotbar first, then the rest of the main inventory, then the off hand. That falls out of
     * {@code inventory.main} being laid out with the hotbar at indices 0 to 8, and it means the pouch a
     * player can see is the one that fills and pays first.
     */
    public static List<ItemStack> pouchesIn(PlayerInventory inventory) {
        List<ItemStack> found = new ArrayList<>();
        for (ItemStack stack : inventory.main) {
            if (stack.isOf(HCItems.RUPEE_POUCH)) {
                found.add(stack);
            }
        }
        for (ItemStack stack : inventory.offHand) {
            if (stack.isOf(HCItems.RUPEE_POUCH)) {
                found.add(stack);
            }
        }
        return found;
    }

    /** Room left across every pouch carried. */
    public static int totalSpace(PlayerInventory inventory) {
        int space = 0;
        for (ItemStack pouch : pouchesIn(inventory)) {
            space += RupeePouchItem.spaceLeft(pouch);
        }
        return space;
    }

    /** Total rupees across every pouch carried. */
    public static int totalBalance(PlayerInventory inventory) {
        int total = 0;
        for (ItemStack pouch : pouchesIn(inventory)) {
            total += RupeePouchItem.getBalance(pouch);
        }
        return total;
    }

    /**
     * Fills pouches in order until the rupees run out.
     *
     * @return what would not fit in any pouch. The caller owns those rupees and must place or drop them;
     *         currency is never destroyed here.
     */
    public static int deposit(PlayerInventory inventory, int amount) {
        int remaining = amount;
        for (ItemStack pouch : pouchesIn(inventory)) {
            if (remaining <= 0) {
                break;
            }
            remaining = RupeePouchItem.deposit(pouch, remaining);
        }
        return remaining;
    }

    /**
     * Spends rupees across every pouch carried, all or nothing.
     *
     * <p>This is what a merchant calls. It checks the total first so a purchase can never half-succeed and
     * leave a player short with nothing to show for it.
     *
     * @return true if the player could afford it and the balances were reduced
     */
    public static boolean debit(PlayerInventory inventory, int amount) {
        if (amount <= 0) {
            return amount == 0;
        }
        List<ItemStack> pouches = pouchesIn(inventory);

        int available = 0;
        for (ItemStack pouch : pouches) {
            available += RupeePouchItem.getBalance(pouch);
        }
        if (available < amount) {
            return false;
        }

        int remaining = amount;
        for (ItemStack pouch : pouches) {
            if (remaining <= 0) {
                break;
            }
            int taken = Math.min(remaining, RupeePouchItem.getBalance(pouch));
            RupeePouchItem.withdraw(pouch, taken);
            remaining -= taken;
        }
        return true;
    }
}
