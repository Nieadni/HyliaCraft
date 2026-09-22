package net.nieadni.hyliacraft.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.nieadni.hyliacraft.item.RupeePouches;
import net.nieadni.hyliacraft.shop.Rupees;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Sends rupees a player walks over into their Rupee Pouch instead of their inventory.
 *
 * <p>Instead of the ideal approach using {@code Redirect}, we use {@code Inject} to maintain compatibility with
 * Serilum's Collective. Because our code is injected directly before the invocation of {@code insertStack}, it
 * behaves similarly to a redirect - although we can't influence the original method call, resulting in some
 * duplicate code. The injection point is precise enough that we don't need to check the pickup delay and item
 * ownership.
 *
 * <p>Hooking {@code insertStack} itself would have caught every rupee entering an inventory from any source,
 * including coins the player had just withdrawn from the pouch, which would go straight back in and make
 * withdrawal silently impossible.
 */
@Mixin(ItemEntity.class)
public abstract class RupeePickupMixin {

    @Inject(
            method = "onPlayerCollision",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerInventory;insertStack(Lnet/minecraft/item/ItemStack;)Z"
            ),
            cancellable = true
    )
    private void hyliacraft$collectIntoPouch(
            PlayerEntity player,
            CallbackInfo ci,
            @Local(name = "itemStack") ItemStack stack,
            @Local(name = "i") int i,
            @Local(name = "item") Item item
    ) {
        int value = Rupees.valueOf(item);

        if (value > 0) {
            PlayerInventory inventory = player.getInventory();

            // Whole coins only. Value may be spread across several pouches, but a single coin is never
            // split, so nothing is lost when the last pouch fills mid-stack.
            int coinsThatFit = Math.min(stack.getCount(), RupeePouches.totalSpace(inventory) / value);
            if (coinsThatFit > 0) {
                RupeePouches.deposit(inventory, coinsThatFit * value);
                stack.decrement(coinsThatFit);
            }
            if (stack.isEmpty()) {
                // Fully absorbed. Discard the item entity and play the pickup effects.
                ItemEntity me = (ItemEntity) (Object) this;
                player.sendPickup(me, i);
                if (stack.isEmpty()) {
                    me.discard();
                    stack.setCount(i);
                }

                player.increaseStat(Stats.PICKED_UP.getOrCreateStat(item), i);
                player.triggerItemPickedUpByEntityCriteria(me);
                
                // We don't need/want to try to add the stack to our normal inventory.
                ci.cancel();
            }
        }

        // Not a rupee, or more than the pouches could hold: let the rest behave normally.
    }
}
