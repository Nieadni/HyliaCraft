package net.nieadni.hyliacraft.entity.block_entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class IronChestBlockEntity extends ChestBlockEntity {
    protected IronChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(HCBlockEntityType.IRON_CHEST_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, blockPos, blockState);
    }

    protected Text getContainerName() {
        return Text.translatable("container.hyliacraft.iron_chest");
    }

}
