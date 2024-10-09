package net.nieadni.hyliacraft.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class IronChestBlockEntity extends ChestBlockEntity {
    protected IronChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(HCBlockEntityType.IRON_CHEST_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, blockPos, blockState);
    }

    protected Text getContainerName() {
        return Text.translatable("container.hyliacraft.iron_chest");
    }

    private int numPlayersOpen;
    public float lidAngle;

    public int getNumPlayersOpen() {
        return this.numPlayersOpen;
    }

    public SimpleInventory getInventory() {
        return this.getInventory();
    }
}
