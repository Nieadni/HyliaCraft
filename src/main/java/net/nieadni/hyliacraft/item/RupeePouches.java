package net.nieadni.hyliacraft.item;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory-wide pouch operations. {@link RupeePouchItem} handles one pouch; a player may carry several,
 * each with its own balance, so spending and collecting cascade across them.
 */
public final class RupeePouches {

    private RupeePouches() {
    }

    /** Pouches in the order they are used: hotbar, rest of the inventory, then off hand. */
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
     * Spends rupees across every pouch carried, all or nothing. The total is checked before any pouch is
     * touched, so a purchase can never half-succeed and leave a player short with nothing to show for it.
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
