package net.nieadni.hyliacraft.mixin.race.sheikah;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.sound.SoundEvent;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BarrelBlockEntity.class)
public class BarrelBlockEntityMixin {
    
    @Inject(method = "playSound(Lnet/minecraft/block/BlockState;Lnet/minecraft/sound/SoundEvent;)V", at = @At("HEAD"), cancellable = true)
    private void playSound(BlockState state, SoundEvent soundEvent, CallbackInfo ci) {
        if (HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.get() == true) {
            ci.cancel();
        }
    }
}
