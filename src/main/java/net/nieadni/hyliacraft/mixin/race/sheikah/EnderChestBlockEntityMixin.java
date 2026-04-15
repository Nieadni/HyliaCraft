package net.nieadni.hyliacraft.mixin.race.sheikah;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = {"net.minecraft.block.entity.EnderChestBlockEntity$1"})
public class EnderChestBlockEntityMixin {
    
    @Redirect(method = "onContainerOpen", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"))
    private void openPlaySound(World instance, PlayerEntity source, double x, double y, double z, SoundEvent sound, SoundCategory category, float volume, float pitch) {
        if (HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.get() != true) {
            instance.playSound(source, x, y, z, sound, category, volume, pitch);
        }
    }

    @Redirect(method = "onContainerClose", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"))
    private void closePlaySound(World instance, PlayerEntity source, double x, double y, double z, SoundEvent sound, SoundCategory category, float volume, float pitch) {
        if (HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.get() != true) {
            instance.playSound(source, x, y, z, sound, category, volume, pitch);
        }
    }
}
