package net.nieadni.hyliacraft.mixin.race.kokiri;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(HungerManager.class)
public class HealingMixin {
    
    @ModifyArg(method = "update(Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;heal(F)V"))
    private float modifyHealAmount(float amount, @Local(argsOnly = true) PlayerEntity player) {
        if (HyliaCraftRace.getRace(player) == HyliaCraftRace.KOKIRI) {
            return amount * 2;
        }
        return amount;
    }
}
