package net.nieadni.hyliacraft.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.RupeePouches;
import net.nieadni.hyliacraft.shop.Rupees;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Sends rupees a player walks over into their Rupee Pouch instead of their inventory.
 *
 * <p>This redirects the single {@code insertStack} call inside {@code onPlayerCollision} rather than
 * injecting at the head of the method. That matters twice over. Vanilla has already checked the pickup
 * delay and item ownership by the time it reaches this call, so those rules are respected without being
 * duplicated here and left to rot out of sync.
 *
 * <p>More importantly it keeps the hook on the pickup path only. Hooking {@code insertStack} itself would
 * have caught every rupee entering an inventory from any source, including coins the player had just
 * withdrawn from the pouch, which would go straight back in and make withdrawal silently impossible.
 */
@Mixin(ItemEntity.class)
public abstract class RupeePickupMixin {

    @Redirect(
            method = "onPlayerCollision",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerInventory;insertStack(Lnet/minecraft/item/ItemStack;)Z"
            )
    )
    private boolean hyliacraft$collectIntoPouch(PlayerInventory inventory, ItemStack stack) {
        int value = Rupees.valueOf(stack.getItem());

        if (value > 0) {
            // Whole coins only. Value may be spread across several pouches, but a single coin is never
            // split, so nothing is lost when the last pouch fills mid-stack.
            int coinsThatFit = Math.min(stack.getCount(), RupeePouches.totalSpace(inventory) / value);
            if (coinsThatFit > 0) {
                RupeePouches.deposit(inventory, coinsThatFit * value);
                stack.decrement(coinsThatFit);
            }
            if (stack.isEmpty()) {
                // Fully absorbed. Reporting success is what makes vanilla discard the item entity and
                // play the pickup effects.
                return true;
            }
        }

        // Not a rupee, or more than the pouches could hold: let the rest behave normally.
        return inventory.insertStack(stack);
    }
}
