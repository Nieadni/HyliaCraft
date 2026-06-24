package net.nieadni.hyliacraft.mixin.race;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class WaterBreathingMixin {

    @Inject(method = "canBreatheInWater()Z", at = @At("HEAD"), cancellable = true)
    public void canBreatheInWater(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity livingEntity = (LivingEntity) ((Object) this);
        if (livingEntity instanceof PlayerEntity player) {
            HyliaCraftRace race = HyliaCraftRace.getRace(player);
            if (race == HyliaCraftRace.ZORA || race == HyliaCraftRace.GORON) {
                cir.setReturnValue(true);
            }
        }
    }
}
