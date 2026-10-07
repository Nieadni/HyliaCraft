package net.nieadni.hyliacraft.mixin.majoras_mask;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Strips the mask's protection from anyone who attacks a hostile mob.
 *
 * <p>The grudge belongs to that kind of mob, not to everything alive: strike a zombie and zombies come
 * for you while the skeletons carry on ignoring you, the way angering one zombified piglin brings other
 * piglins and nothing else. Pushing anger outward onto individual mobs instead would not stick, because
 * a targeting goal re-checks the predicate each tick and would drop the wearer straight away.
 */
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void hyliacraft$provokeMaskWearer(DamageSource source, float amount,
                                              CallbackInfoReturnable<Boolean> cir) {
        LivingEntity victim = (LivingEntity) (Object) this;
        if (victim.getWorld().isClient() || !(victim instanceof Monster)) {
            return;
        }

        // Thorns names the wearer as the attacker even though the mob started it, so a masked player in
        // thorns armour would provoke a whole species simply by being hit. Only a blow they chose counts.
        if (source.isOf(DamageTypes.THORNS)) {
            return;
        }

        if (source.getAttacker() instanceof PlayerEntity attacker && MajorasMaskItem.isWorn(attacker)) {
            // Only this kind of mob bears the grudge. Hitting a zombie should not interest the skeletons.
            MajorasMaskItem.provoke(attacker, victim.getType());
        }
    }
}
