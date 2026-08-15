package net.nieadni.hyliacraft.mixin.majoras_mask;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Makes a mob already chasing someone give up when they put the mask on.
 *
 * <p>Hiding the wearer from {@code TargetPredicate} only stops a mob choosing them in the first place.
 * It does not end a chase already underway, because {@code shouldContinue} checks distance, teams and
 * {@code canTarget} and never re-runs the predicate. Without this, putting the mask on in front of a
 * zombie already coming for you does nothing at all.
 *
 * <p>Returning false here makes the goal stop, which sets the mob's target to null through the usual
 * path, so the Kokiri invisibility counter that watches {@code setTarget} sees the release correctly.
 */
@Mixin(TrackTargetGoal.class)
public abstract class TrackTargetGoalMixin {

    @Shadow
    protected MobEntity mob;

    @Inject(method = "shouldContinue", at = @At("HEAD"), cancellable = true)
    private void hyliacraft$stopChasingMaskWearer(CallbackInfoReturnable<Boolean> cir) {
        if (!(this.mob instanceof Monster)) {
            return;
        }
        LivingEntity target = this.mob.getTarget();
        if (target != null && MajorasMaskItem.hidesFrom(target, this.mob.getType())) {
            cir.setReturnValue(false);
        }
    }
}
