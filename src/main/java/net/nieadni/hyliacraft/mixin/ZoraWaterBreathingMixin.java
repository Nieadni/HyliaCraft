package net.nieadni.hyliacraft.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class ZoraWaterBreathingMixin {

    @Inject(method = "canBreatheInWater()Z", at = @At("HEAD"), cancellable = true)
    public void canBreatheInWater(CallbackInfoReturnable<Boolean> cir) {
        Object t = this;
        if (t instanceof PlayerEntity player) {
            if (HyliaCraftRace.getRace(player) == HyliaCraftRace.ZORA) {
                cir.setReturnValue(true);
            }
        }
    }
}
