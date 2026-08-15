package net.nieadni.hyliacraft.mixin.majoras_mask;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.mob.HostileEntity;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Hides a Majora's Mask wearer from hostile mobs.
 *
 * <p>This is the check every targeting goal runs before choosing someone, which makes it the right place
 * for two reasons. A mob never picks the wearer at all, so {@code setTarget} is not called and the Kokiri
 * invisibility mixin that counts targeters there stays accurate. And because
 * {@code TrackTargetGoal.canTrack} re-tests it to decide whether to keep chasing, mobs already after a
 * player lose interest the moment the mask goes on, and find them again the moment it comes off.
 *
 * <p>Restricted to {@link HostileEntity} on purpose. The same predicate serves animal mating, fleeing
 * and iron golem tracking, none of which should care about a mask.
 */
@Mixin(TargetPredicate.class)
public class TargetPredicateMixin {

    @Inject(method = "test", at = @At("HEAD"), cancellable = true)
    private void hyliacraft$overlookMaskWearer(LivingEntity tester, LivingEntity target,
                                               CallbackInfoReturnable<Boolean> cir) {
        if (tester instanceof HostileEntity && MajorasMaskItem.hidesFrom(target, tester.getType())) {
            cir.setReturnValue(false);
        }
    }
}
