package net.nieadni.hyliacraft.mixin.race.sheikah;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    
    @Inject(method = "playStepSound(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At("HEAD"), cancellable = true)
    private void playStepSound(BlockPos pos, BlockState state, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (HyliaCraftRace.getRace(player) == HyliaCraftRace.SHEIKAH) {
            ci.cancel();
        }
    }
}
