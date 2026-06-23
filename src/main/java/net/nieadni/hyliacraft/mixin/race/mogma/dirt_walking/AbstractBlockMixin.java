package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {

    @Inject(method = "getCollisionShape(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;", at = @At("HEAD"), cancellable = true)
    private void getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            if (context instanceof EntityShapeContext entityShapeContext) {
                Entity entity = entityShapeContext.getEntity();
                if (entity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.MOGMA) {
                    boolean isOnTop = context.isAbove(VoxelShapes.fullCube(), pos, true) && !context.isDescending();
                    if (isOnTop) {
                        cir.setReturnValue(VoxelShapes.fullCube());
                    } else {
                        cir.setReturnValue(VoxelShapes.empty());
                    }
                }
            }
        }
    }

    @Inject(method = "getCullingShape(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/shape/VoxelShape;", at = @At("HEAD"), cancellable = true)
    private void getCullingShape(BlockState state, BlockView world, BlockPos pos, CallbackInfoReturnable<VoxelShape> cir) {
        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            cir.setReturnValue(VoxelShapes.empty());
        }
    }

//    @Inject(method = "getCameraCollisionShape(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;", at = @At("HEAD"), cancellable = true)
//    private void getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
//        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
//            cir.setReturnValue(VoxelShapes.empty());
//        }
//    }

    @Inject(method = "isSideInvisible(Lnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;)Z", at = @At("HEAD"), cancellable = true)
    private void isSideInvisible(BlockState state, BlockState stateFrom, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH) && stateFrom.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            cir.setReturnValue(true);
        }
    }
}
