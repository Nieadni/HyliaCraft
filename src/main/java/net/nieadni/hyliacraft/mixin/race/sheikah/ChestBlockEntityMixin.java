package net.nieadni.hyliacraft.mixin.race.sheikah;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestBlockEntity.class)
public class ChestBlockEntityMixin {
    
    @Inject(method = "playSound(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/sound/SoundEvent;)V", at = @At("HEAD"), cancellable = true)
    private static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent, CallbackInfo ci) {
        if (HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.get() == true) {
            ci.cancel();
        }
    }
}
