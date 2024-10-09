package net.nieadni.hyliacraft.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;

public class HCBlockEntityType {
    public static final BlockEntityType<IronChestBlockEntity> IRON_CHEST_BLOCK_ENTITY_BLOCK_ENTITY_TYPE = register("iron_chest_block_entity_block_entity_type",
            BlockEntityType.Builder.create(IronChestBlockEntity::new, HCBlocks.IRON_CHEST)
                    .build());

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(HyliaCraft.MOD_ID, name), type);
    }

    public static void registerHCBlockEntities() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its Block Entities.");
    }

}
