package net.nieadni.hyliacraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.item.HCDataComponents;
import net.nieadni.hyliacraft.screen.RupeePouchScreenHandler;
import net.nieadni.hyliacraft.shop.RupeeChange;
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

    /** Right-clicking a held pouch opens it. */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack pouch = user.getStackInHand(hand);
        if (!world.isClient) {
            user.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, inventory, player) -> new RupeePouchScreenHandler(syncId, inventory),
                    pouch.getName()));
        }
        return TypedActionResult.success(pouch, world.isClient());
    }

    /**
     * How many of these coins the pouch can swallow.
     *
     * <p>Whole coins only. A pouch with 7 rupees of room cannot take part of a red rupee, so the coin
     * stays in the world rather than being cashed in at a discount.
     */
    private static int coinsThatFit(ItemStack pouch, ItemStack coins) {
        int value = RupeeChange.valueOf(coins.getItem());
        if (value <= 0) {
            return 0;
        }
        return Math.min(coins.getCount(), spaceLeft(pouch) / value);
    }

    /**
     * Rupees held on the cursor, right-clicked onto a pouch sitting in a slot.
     */
    @Override
    public boolean onClicked(ItemStack pouch, ItemStack cursorStack, Slot slot, ClickType clickType,
                             PlayerEntity player, StackReference cursorStackReference) {
        if (clickType != ClickType.RIGHT || cursorStack.isEmpty()) {
            return false;
        }
        int taking = coinsThatFit(pouch, cursorStack);
        if (taking <= 0) {
            return false;
        }
        deposit(pouch, taking * RupeeChange.valueOf(cursorStack.getItem()));
        cursorStack.decrement(taking);
        player.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8F, 0.8F);
        return true;
    }

    /**
     * The pouch held on the cursor, right-clicked onto rupees sitting in a slot.
     *
     * <p>The other half of the same gesture, so it works whichever way round the player picks things up.
     */
    @Override
    public boolean onStackClicked(ItemStack pouch, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT || !slot.canTakePartial(player)) {
            return false;
        }
        ItemStack coins = slot.getStack();
        int taking = coinsThatFit(pouch, coins);
        if (taking <= 0) {
            return false;
        }
        deposit(pouch, taking * RupeeChange.valueOf(coins.getItem()));
        slot.takeStackRange(taking, taking, player);
        player.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8F, 0.8F);
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.rupee_pouch.balance", getBalance(stack))
                .formatted(Formatting.GRAY));
    }
}
