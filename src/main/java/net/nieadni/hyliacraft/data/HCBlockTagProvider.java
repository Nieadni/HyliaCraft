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
        getOrCreateTagBuilder(BlockTags.STAIRS).add(HCColouredBlocks.RAINBOW_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(HCColouredBlocks.RAINBOW_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(HCColouredBlocks.RAINBOW_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.WHITE_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.WHITE_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.WHITE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.WHITE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.WHITE_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.LIGHT_GREY_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.LIGHT_GREY_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.LIGHT_GREY_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.GREY_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.GREY_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.GREY_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.GREY_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.GREY_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.BLACK_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.BLACK_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.BLACK_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.BLACK_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.BLACK_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.BROWN_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.BROWN_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.BROWN_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.BROWN_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.BROWN_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.RED_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.RED_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.RED_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.RED_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.RED_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.ORANGE_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.ORANGE_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.ORANGE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.ORANGE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.ORANGE_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.YELLOW_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.YELLOW_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.YELLOW_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.YELLOW_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.YELLOW_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.LIME_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.LIME_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.LIME_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.LIME_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.LIME_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.GREEN_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.GREEN_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.GREEN_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.GREEN_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.GREEN_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.CYAN_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.CYAN_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.CYAN_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.CYAN_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.CYAN_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.LIGHT_BLUE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.LIGHT_BLUE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.LIGHT_BLUE_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.BLUE_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.BLUE_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.BLUE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.BLUE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.BLUE_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.PURPLE_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.PURPLE_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.PURPLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.PURPLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.PURPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.MAGENTA_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.MAGENTA_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.MAGENTA_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.MAGENTA_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.MAGENTA_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.PINK_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.PINK_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.PINK_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.PINK_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.PINK_FENCE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.RAINBOW_STRIPPED_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(HCColouredBlocks.RAINBOW_STRIPPED_WOOD);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(HCColouredBlocks.RAINBOW_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(HCColouredBlocks.RAINBOW_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(HCColouredBlocks.RAINBOW_FENCE);
        
    }
}