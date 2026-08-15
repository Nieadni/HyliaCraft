package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.nieadni.hyliacraft.item.HCDataComponents;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A purse that holds rupees as a single number rather than as coins.
 *
 * <p>The balance lives in a data component on the stack, so it belongs to the pouch and not to the player.
 * Carrying three pouches means three separate balances.
 *
 * <p>Storing a total rather than per-denomination stacks is what makes the pouch worth having: paying 6666
 * rupees is impossible with coins, because a trade holds two stacks and 6666 needs 66 green rupees, but it
 * is trivial against a balance.
 */
public class RupeePouchItem extends Item {

    /** The most a single pouch can hold, per the original design note. */
    public static final int MAX_BALANCE = 9999;

    public RupeePouchItem(Settings settings) {
        super(settings);
    }

    /** Rupees currently in this pouch. Zero for a pouch that has never held anything. */
    public static int getBalance(ItemStack pouch) {
        return pouch.getOrDefault(HCDataComponents.RUPEES, 0);
    }

    /** Sets the balance, clamped into range. */
    public static void setBalance(ItemStack pouch, int value) {
        pouch.set(HCDataComponents.RUPEES, Math.clamp(value, 0, MAX_BALANCE));
    }

    /** Room left before this pouch is full. */
    public static int spaceLeft(ItemStack pouch) {
        return MAX_BALANCE - getBalance(pouch);
    }

    /**
     * Adds what fits and reports what did not.
     *
     * @return the rupees that would not fit, which the caller must not destroy
     */
    public static int deposit(ItemStack pouch, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int accepted = Math.min(amount, spaceLeft(pouch));
        if (accepted > 0) {
            setBalance(pouch, getBalance(pouch) + accepted);
        }
        return amount - accepted;
    }

    /**
     * Takes rupees out, all or nothing.
     *
     * @return true if the pouch had enough and the balance was reduced
     */
    public static boolean withdraw(ItemStack pouch, int amount) {
        if (amount <= 0 || getBalance(pouch) < amount) {
            return false;
        }
        setBalance(pouch, getBalance(pouch) - amount);
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.rupee_pouch.balance", getBalance(stack))
                .formatted(Formatting.GRAY));
    }
}
