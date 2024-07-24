package net.nieadni.hyliacraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PotBlock extends Block {

    //TODO: This is how it worked in Forge, it needs converting to Fabric

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public PotBlock(Settings properties) {
        super(properties);
    }

    public VoxelShape makeShapeNS(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.25, 0.03125, 0.25, 0.75, 0.53125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.25, 0.03125, 0.25, 0.75, 0.53125, 0.75), BooleanOp.OR);

        return shape;
    }

    public VoxelShape makeShapeEW(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.25, 0.03125, 0.25, 0.75, 0.53125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.25, 0.03125, 0.25, 0.75, 0.53125, 0.75), BooleanOp.OR);

        return shape;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case EAST, WEST -> {
                return makeShapeEW();
            }
            case NORTH, SOUTH -> {
                return makeShapeNS();
            }
        }
        return makeShapeNS();
    }
    /* FACING */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

}
