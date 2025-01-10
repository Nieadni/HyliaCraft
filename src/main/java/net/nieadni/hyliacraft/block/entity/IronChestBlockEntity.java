package net.nieadni.hyliacraft.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class IronChestBlockEntity extends ChestBlockEntity {
    public IronChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(HCBlockEntityType.IRON_CHEST, blockPos, blockState);
    }

    protected Text getContainerName() {
        return Text.translatable("container.hyliacraft.iron_chest");
    }

}
