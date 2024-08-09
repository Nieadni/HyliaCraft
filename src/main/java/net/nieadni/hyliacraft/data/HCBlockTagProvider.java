package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;

import java.util.concurrent.CompletableFuture;

public class HCBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public HCBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.ARMORANTH);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.ARMORANTH_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.BLUE_NIGHTSHADE);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.BLUE_NIGHTSHADE_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.SILENT_PRINCESS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.SILENT_PRINCESS_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.SWIFT_VIOLETS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.SWIFT_VIOLETS_POT);

        // Coloured Blocks

        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.WHITE_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.WHITE_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.WHITE_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.LIGHT_GREY_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.LIGHT_GREY_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.GREY_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.GREY_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.GREY_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.BLACK_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.BLACK_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.BLACK_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.BROWN_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.BROWN_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.BROWN_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.RED_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.RED_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.RED_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.ORANGE_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.ORANGE_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.ORANGE_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.YELLOW_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.YELLOW_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.YELLOW_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.LIME_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.LIME_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.LIME_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.GREEN_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.GREEN_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.GREEN_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.CYAN_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.CYAN_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.CYAN_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.LIGHT_BLUE_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.BLUE_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.BLUE_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.BLUE_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.PURPLE_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.PURPLE_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.PURPLE_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.MAGENTA_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.MAGENTA_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.MAGENTA_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.PINK_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.PINK_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.PINK_BRICK_WALL);

    }
}