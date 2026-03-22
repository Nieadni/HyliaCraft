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

        getOrCreateTagBuilder(HCBlockTags.GRASSES).add(Blocks.SHORT_GRASS);
        getOrCreateTagBuilder(HCBlockTags.GRASSES).add(Blocks.TALL_GRASS);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.ARMORANTH);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.ARMORANTH_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.BLUE_NIGHTSHADE);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.BLUE_NIGHTSHADE_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.SILENT_PRINCESS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.SILENT_PRINCESS_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.SWIFT_VIOLETS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.SWIFT_VIOLETS_POT);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add(HCBlocks.IRON_CHEST);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(HCBlocks.IRON_CHEST);

        //

        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.WHITE_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.WHITE_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.WHITE_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.LIGHT_GRAY_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.GRAY_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.GRAY_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.GRAY_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.BLACK_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.BLACK_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.BLACK_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.BROWN_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.BROWN_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.BROWN_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.RED_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.RED_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.RED_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.ORANGE_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.ORANGE_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.ORANGE_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.YELLOW_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.YELLOW_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.YELLOW_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.LIME_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.LIME_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.LIME_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.GREEN_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.GREEN_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.GREEN_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.CYAN_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.CYAN_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.CYAN_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.LIGHT_BLUE_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.BLUE_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.BLUE_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.BLUE_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.PURPLE_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.PURPLE_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.PURPLE_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.MAGENTA_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.MAGENTA_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.MAGENTA_SHINGLE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCBlocks.PINK_SHINGLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCBlocks.PINK_SHINGLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCBlocks.PINK_SHINGLE_WALL);
    }
}