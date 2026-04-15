package net.nieadni.hyliacraft.mixin.race.sheikah;

import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PowderSnowBlock.class)
public class PowderSnowFallSoundMixin {
    
    @Redirect(method = "onLandedUpon(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"))
    private void tryPlaySound(Entity it, SoundEvent sound, float volume, float pitch) {
        if (!(it instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.SHEIKAH)) {
            it.playSound(sound, volume, pitch);
        }
    }
}
