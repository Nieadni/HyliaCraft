package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.nieadni.hyliacraft.block.HCBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {

    @Inject(method = "isSolidBlock(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
    private void isSolidBlock(BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        AbstractBlock.AbstractBlockState state = (AbstractBlock.AbstractBlockState) ((Object) this);
        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            cir.setReturnValue(false);
        }
    }
}
