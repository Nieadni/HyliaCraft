package net.nieadni.hyliacraft.block.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.*;
import net.minecraft.util.function.BooleanBiFunction;

public class PotBlock extends Block {

    public PotBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, @NotNull BlockPos blockPos, CollisionContext collisionContext) {
        return Stream.of(
            Block.createCuboidShape(4, 0.6, 4, 12, 8.6, 12),
            Block.createCuboidShape(3.5, 0.1, 3.5, 12.5, 9.1, 12.5),
            Block.createCuboidShape(3.5, 0.1, 3.5, 12.5, 0.1, 12.5),
            Block.createCuboidShape(3.5, 0.1, 12.5, 12.5, 9.1, 12.5),
            Block.createCuboidShape(12.5, 0.1, 3.5, 12.5, 9.1, 12.5),
            Block.createCuboidShape(3.5, 0.1, 3.5, 12.5, 9.1, 3.5),
            Block.createCuboidShape(3.5, 0.1, 3.5, 3.5, 9.1, 12.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    }
}
