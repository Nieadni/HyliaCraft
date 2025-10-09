package net.nieadni.hyliacraft.mixin.race.goron.mining;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class SpeedMixin {

    @Inject(method = "getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F", at = @At("HEAD"), cancellable = true)
    private void getBlockBreakingSpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        PlayerEntity player = (PlayerEntity) ((Object) this);
        if (player.getStackInHand(Hand.MAIN_HAND).isEmpty() && HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON) {
            cir.setReturnValue(HyliaCraftRace.GORON_FIST_MINING_STACK.getMiningSpeedMultiplier(state));
        }
    }
}
