package net.nieadni.hyliacraft.block;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCBlockTags {

    //public static final TagKey<Block> BRICKS = TagKey.of(RegistryKeys.BLOCK, new Identifier(HyliaCraft.MOD_ID, "bricks"));
    public static final TagKey<Block> GERUDO_FAST = TagKey.of(RegistryKeys.BLOCK, Identifier.of(HyliaCraft.MOD_ID, "gerudo_fast"));

    public static void registerHCBlockTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its Block tags.");
    }
}