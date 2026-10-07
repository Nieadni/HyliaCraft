package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nieadni.hyliacraft.block.HCBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FluidRenderer.class)
public class FluidRendererMixin {

    @Definition(id = "state", local = @Local(argsOnly = true, type = BlockState.class))
    @Definition(id = "getCullingShape", method = "Lnet/minecraft/block/BlockState;getCullingShape(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/shape/VoxelShape;")
    @Expression("state.getCullingShape(?, ?)")
    @ModifyExpressionValue(method = "isSideCovered(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/Direction;FLnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static VoxelShape modifyCullingShape(VoxelShape original, @Local(argsOnly = true) BlockView world, @Local(argsOnly = true) BlockPos pos, @Local(argsOnly = true) BlockState state) {
        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) return state.getOutlineShape(world, pos);
        return original;
    }
}
