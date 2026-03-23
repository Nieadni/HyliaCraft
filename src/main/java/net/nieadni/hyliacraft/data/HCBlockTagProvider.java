package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;

import java.util.concurrent.CompletableFuture;

public class HCBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public HCBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(HCBlockTags.GRASSES)
                .add(Blocks.SHORT_GRASS, Blocks.TALL_GRASS);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(HCBlocks.ARMORANTH, HCBlocks.BLUE_NIGHTSHADE, HCBlocks.SILENT_PRINCESS, HCBlocks.SWIFT_VIOLETS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(HCBlocks.ARMORANTH_POT, HCBlocks.BLUE_NIGHTSHADE_POT, HCBlocks.SILENT_PRINCESS_POT, HCBlocks.SWIFT_VIOLETS_POT);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(HCBlocks.IRON_CHEST);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(HCBlocks.IRON_CHEST);
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(HCBlocks.WHITE_SHINGLE_STAIRS, HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS, HCBlocks.GRAY_SHINGLE_STAIRS,
                        HCBlocks.BLACK_SHINGLE_STAIRS, HCBlocks.BROWN_SHINGLE_STAIRS, HCBlocks.RED_SHINGLE_STAIRS, HCBlocks.ORANGE_SHINGLE_STAIRS,
                        HCBlocks.YELLOW_SHINGLE_STAIRS, HCBlocks.LIME_SHINGLE_STAIRS, HCBlocks.GREEN_SHINGLE_STAIRS, HCBlocks.CYAN_SHINGLE_STAIRS,
                        HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS, HCBlocks.BLUE_SHINGLE_STAIRS, HCBlocks.PURPLE_SHINGLE_STAIRS, HCBlocks.MAGENTA_SHINGLE_STAIRS,
                        HCBlocks.PINK_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(HCBlocks.WHITE_SHINGLE_SLAB, HCBlocks.LIGHT_GRAY_SHINGLE_SLAB, HCBlocks.GRAY_SHINGLE_SLAB,
                        HCBlocks.BLACK_SHINGLE_SLAB, HCBlocks.BROWN_SHINGLE_SLAB, HCBlocks.RED_SHINGLE_SLAB, HCBlocks.ORANGE_SHINGLE_SLAB,
                        HCBlocks.YELLOW_SHINGLE_SLAB, HCBlocks.LIME_SHINGLE_SLAB, HCBlocks.GREEN_SHINGLE_SLAB, HCBlocks.CYAN_SHINGLE_SLAB,
                        HCBlocks.LIGHT_BLUE_SHINGLE_SLAB, HCBlocks.BLUE_SHINGLE_SLAB, HCBlocks.PURPLE_SHINGLE_SLAB, HCBlocks.MAGENTA_SHINGLE_SLAB,
                        HCBlocks.PINK_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(HCBlocks.WHITE_SHINGLE_WALL, HCBlocks.LIGHT_GRAY_SHINGLE_WALL, HCBlocks.GRAY_SHINGLE_WALL, HCBlocks.BLACK_SHINGLE_WALL,
                        HCBlocks.BROWN_SHINGLE_WALL, HCBlocks.RED_SHINGLE_WALL, HCBlocks.ORANGE_SHINGLE_WALL, HCBlocks.YELLOW_SHINGLE_WALL,
                        HCBlocks.LIME_SHINGLE_WALL, HCBlocks.GREEN_SHINGLE_WALL, HCBlocks.CYAN_SHINGLE_WALL, HCBlocks.LIGHT_BLUE_SHINGLE_WALL,
                        HCBlocks.BLUE_SHINGLE_WALL, HCBlocks.PURPLE_SHINGLE_WALL, HCBlocks.MAGENTA_SHINGLE_WALL, HCBlocks.PINK_SHINGLE_WALL);
    }
}