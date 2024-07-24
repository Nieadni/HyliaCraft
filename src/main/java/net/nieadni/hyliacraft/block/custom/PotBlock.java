package net.nieadni.hyliacraft.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.*;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class PotBlock extends TransparentBlock {

    public PotBlock(Settings settings) {
        super(settings
                .sounds(BlockSoundGroup.GLASS)
                .breakInstantly()
                .nonOpaque()
                .pistonBehavior(PistonBehavior.DESTROY)
        );
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
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
