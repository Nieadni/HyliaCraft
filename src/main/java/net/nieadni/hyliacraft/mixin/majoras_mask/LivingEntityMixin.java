package net.nieadni.hyliacraft.mixin.majoras_mask;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Strips the mask's protection from anyone who attacks a hostile mob.
 *
 * <p>The wearer is not hidden from that mob alone: the mask simply stops working for a while, so every
 * hostile that can see them takes notice. Pushing anger outward instead would not stick, because a
 * targeting goal re-checks the predicate each tick and would drop a wearer straight away.
 */
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void hyliacraft$provokeMaskWearer(DamageSource source, float amount,
                                              CallbackInfoReturnable<Boolean> cir) {
        LivingEntity victim = (LivingEntity) (Object) this;
        if (victim.getWorld().isClient() || !(victim instanceof HostileEntity)) {
            return;
        }
        if (source.getAttacker() instanceof LivingEntity attacker && MajorasMaskItem.isWorn(attacker)) {
            MajorasMaskItem.provoke(attacker);
        }
    }
}
