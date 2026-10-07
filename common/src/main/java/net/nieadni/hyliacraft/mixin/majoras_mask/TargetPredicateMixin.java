package net.nieadni.hyliacraft.mixin.majoras_mask;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.mob.Monster;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Hides a Majora's Mask wearer from hostile mobs.
 *
 * <p>This is the check every targeting goal runs before choosing someone, so a mob never picks the
 * wearer at all and {@code setTarget} is never called, which keeps the Kokiri invisibility mixin that
 * counts targeters there accurate.
 *
 * <p>It only prevents a mob choosing the wearer. Ending a chase already underway needs
 * {@link TrackTargetGoalMixin}, because {@code shouldContinue} never re-runs this predicate.
 *
 * <p>Gated on {@link Monster}, the interface, rather than {@code HostileEntity}, the class. Slimes,
 * ghasts, phantoms, shulkers and hoglins are all monsters without extending that class, and a mask that
 * fooled zombies while a ghast kept firing would read as broken rather than as a rule. {@code Monster}
 * also correctly excludes wolves, bees, polar bears and iron golems, which get angry but are not
 * hostile, and which the same predicate serves for mating and fleeing.
 */
@Mixin(TargetPredicate.class)
public class TargetPredicateMixin {

    @Inject(method = "test", at = @At("HEAD"), cancellable = true)
    private void hyliacraft$overlookMaskWearer(LivingEntity tester, LivingEntity target,
                                               CallbackInfoReturnable<Boolean> cir) {
        if (tester instanceof Monster && MajorasMaskItem.hidesFrom(target, tester.getType())) {
            cir.setReturnValue(false);
        }
    }
}
