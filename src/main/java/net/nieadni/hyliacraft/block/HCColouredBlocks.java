package net.nieadni.hyliacraft.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

// Made this class as to not clog up HCBlocks
public class HCColouredBlocks extends Blocks {

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(HyliaCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(HyliaCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings().maxCount(64)));
    }

    public static final Block WHITE_BRICKS = registerBlock("white_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.WHITE)));
    public static final Block WHITE_BRICK_STAIRS = registerBlock("white_brick_stairs", new StairsBlock(WHITE_BRICKS.getDefaultState(), Block.Settings.copy(WHITE_BRICKS)));
    public static final Block WHITE_BRICK_SLAB = registerBlock("white_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_BRICKS)));
    public static final Block WHITE_BRICK_WALL = registerBlock("white_brick_wall", new WallBlock(AbstractBlock.Settings.copy(WHITE_BRICKS)));

    public static final Block LIGHT_GREY_BRICKS = registerBlock("light_grey_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_BRICK_STAIRS = registerBlock("light_grey_brick_stairs", new StairsBlock(LIGHT_GREY_BRICKS.getDefaultState(), Block.Settings.copy(LIGHT_GREY_BRICKS)));
    public static final Block LIGHT_GREY_BRICK_SLAB = registerBlock("light_grey_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GREY_BRICKS)));
    public static final Block LIGHT_GREY_BRICK_WALL = registerBlock("light_grey_brick_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_GREY_BRICKS)));

    public static final Block GREY_BRICKS = registerBlock("grey_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.GRAY)));
    public static final Block GREY_BRICK_STAIRS = registerBlock("grey_brick_stairs", new StairsBlock(GREY_BRICKS.getDefaultState(), Block.Settings.copy(GREY_BRICKS)));
    public static final Block GREY_BRICK_SLAB = registerBlock("grey_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(GREY_BRICKS)));
    public static final Block GREY_BRICK_WALL = registerBlock("grey_brick_wall", new WallBlock(AbstractBlock.Settings.copy(GREY_BRICKS)));

    public static final Block BLACK_BRICKS = registerBlock("black_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.BLACK)));
    public static final Block BLACK_BRICK_STAIRS = registerBlock("black_brick_stairs", new StairsBlock(BLACK_BRICKS.getDefaultState(), Block.Settings.copy(BLACK_BRICKS)));
    public static final Block BLACK_BRICK_SLAB = registerBlock("black_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(BLACK_BRICKS)));
    public static final Block BLACK_BRICK_WALL = registerBlock("black_brick_wall", new WallBlock(AbstractBlock.Settings.copy(BLACK_BRICKS)));

    public static final Block BROWN_BRICKS = registerBlock("brown_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.BROWN)));
    public static final Block BROWN_BRICK_STAIRS = registerBlock("brown_brick_stairs", new StairsBlock(BROWN_BRICKS.getDefaultState(), Block.Settings.copy(BROWN_BRICKS)));
    public static final Block BROWN_BRICK_SLAB = registerBlock("brown_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(BROWN_BRICKS)));
    public static final Block BROWN_BRICK_WALL = registerBlock("brown_brick_wall", new WallBlock(AbstractBlock.Settings.copy(BROWN_BRICKS)));

    public static final Block RED_BRICKS = registerBlock("red_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.RED)));
    public static final Block RED_BRICK_STAIRS = registerBlock("red_brick_stairs", new StairsBlock(RED_BRICKS.getDefaultState(), Block.Settings.copy(RED_BRICKS)));
    public static final Block RED_BRICK_SLAB = registerBlock("red_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(RED_BRICKS)));
    public static final Block RED_BRICK_WALL = registerBlock("red_brick_wall", new WallBlock(AbstractBlock.Settings.copy(RED_BRICKS)));

    public static final Block ORANGE_BRICKS = registerBlock("orange_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_BRICK_STAIRS = registerBlock("orange_brick_stairs", new StairsBlock(ORANGE_BRICKS.getDefaultState(), Block.Settings.copy(ORANGE_BRICKS)));
    public static final Block ORANGE_BRICK_SLAB = registerBlock("orange_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(ORANGE_BRICKS)));
    public static final Block ORANGE_BRICK_WALL = registerBlock("orange_brick_wall", new WallBlock(AbstractBlock.Settings.copy(ORANGE_BRICKS)));

    public static final Block YELLOW_BRICKS = registerBlock("yellow_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_BRICK_STAIRS = registerBlock("yellow_brick_stairs", new StairsBlock(YELLOW_BRICKS.getDefaultState(), Block.Settings.copy(YELLOW_BRICKS)));
    public static final Block YELLOW_BRICK_SLAB = registerBlock("yellow_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(YELLOW_BRICKS)));
    public static final Block YELLOW_BRICK_WALL = registerBlock("yellow_brick_wall", new WallBlock(AbstractBlock.Settings.copy(YELLOW_BRICKS)));

    public static final Block LIME_BRICKS = registerBlock("lime_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.LIME)));
    public static final Block LIME_BRICK_STAIRS = registerBlock("lime_brick_stairs", new StairsBlock(LIME_BRICKS.getDefaultState(), Block.Settings.copy(LIME_BRICKS)));
    public static final Block LIME_BRICK_SLAB = registerBlock("lime_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(LIME_BRICKS)));
    public static final Block LIME_BRICK_WALL = registerBlock("lime_brick_wall", new WallBlock(AbstractBlock.Settings.copy(LIME_BRICKS)));

    public static final Block GREEN_BRICKS = registerBlock("green_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.GREEN)));
    public static final Block GREEN_BRICK_STAIRS = registerBlock("green_brick_stairs", new StairsBlock(GREEN_BRICKS.getDefaultState(), Block.Settings.copy(GREEN_BRICKS)));
    public static final Block GREEN_BRICK_SLAB = registerBlock("green_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(GREEN_BRICKS)));
    public static final Block GREEN_BRICK_WALL = registerBlock("green_brick_wall", new WallBlock(AbstractBlock.Settings.copy(GREEN_BRICKS)));

    public static final Block CYAN_BRICKS = registerBlock("cyan_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.CYAN)));
    public static final Block CYAN_BRICK_STAIRS = registerBlock("cyan_brick_stairs", new StairsBlock(CYAN_BRICKS.getDefaultState(), Block.Settings.copy(CYAN_BRICKS)));
    public static final Block CYAN_BRICK_SLAB = registerBlock("cyan_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(CYAN_BRICKS)));
    public static final Block CYAN_BRICK_WALL = registerBlock("cyan_brick_wall", new WallBlock(AbstractBlock.Settings.copy(CYAN_BRICKS)));

    public static final Block LIGHT_BLUE_BRICKS = registerBlock("light_blue_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_BRICK_STAIRS = registerBlock("light_blue_brick_stairs", new StairsBlock(LIGHT_BLUE_BRICKS.getDefaultState(), Block.Settings.copy(LIGHT_BLUE_BRICKS)));
    public static final Block LIGHT_BLUE_BRICK_SLAB = registerBlock("light_blue_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_BRICKS)));
    public static final Block LIGHT_BLUE_BRICK_WALL = registerBlock("light_blue_brick_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_BRICKS)));

    public static final Block BLUE_BRICKS = registerBlock("blue_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.BLUE)));
    public static final Block BLUE_BRICK_STAIRS = registerBlock("blue_brick_stairs", new StairsBlock(BLUE_BRICKS.getDefaultState(), Block.Settings.copy(BLUE_BRICKS)));
    public static final Block BLUE_BRICK_SLAB = registerBlock("blue_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_BRICKS)));
    public static final Block BLUE_BRICK_WALL = registerBlock("blue_brick_wall", new WallBlock(AbstractBlock.Settings.copy(BLUE_BRICKS)));

    public static final Block PURPLE_BRICKS = registerBlock("purple_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_BRICK_STAIRS = registerBlock("purple_brick_stairs", new StairsBlock(PURPLE_BRICKS.getDefaultState(), Block.Settings.copy(PURPLE_BRICKS)));
    public static final Block PURPLE_BRICK_SLAB = registerBlock("purple_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(PURPLE_BRICKS)));
    public static final Block PURPLE_BRICK_WALL = registerBlock("purple_brick_wall", new WallBlock(AbstractBlock.Settings.copy(PURPLE_BRICKS)));

    public static final Block MAGENTA_BRICKS = registerBlock("magenta_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_BRICK_STAIRS = registerBlock("magenta_brick_stairs", new StairsBlock(MAGENTA_BRICKS.getDefaultState(), Block.Settings.copy(MAGENTA_BRICKS)));
    public static final Block MAGENTA_BRICK_SLAB = registerBlock("magenta_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(MAGENTA_BRICKS)));
    public static final Block MAGENTA_BRICK_WALL = registerBlock("magenta_brick_wall", new WallBlock(AbstractBlock.Settings.copy(MAGENTA_BRICKS)));

    public static final Block PINK_BRICKS = registerBlock("pink_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.PINK)));
    public static final Block PINK_BRICK_STAIRS = registerBlock("pink_brick_stairs", new StairsBlock(PINK_BRICKS.getDefaultState(), Block.Settings.copy(PINK_BRICKS)));
    public static final Block PINK_BRICK_SLAB = registerBlock("pink_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(PINK_BRICKS)));
    public static final Block PINK_BRICK_WALL = registerBlock("pink_brick_wall", new WallBlock(AbstractBlock.Settings.copy(PINK_BRICKS)));

    //

    public static final Block WHITE_STRIPPED_LOG = registerBlock("white_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.WHITE)));
    public static final Block WHITE_STRIPPED_WOOD = registerBlock("white_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.WHITE)));
    public static final Block WHITE_PLANKS = registerBlock("white_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.WHITE)));
    public static final Block WHITE_STAIRS = registerBlock("white_stairs", new StairsBlock(WHITE_PLANKS.getDefaultState(), Block.Settings.copy(WHITE_BRICKS)));
    public static final Block WHITE_SLAB = registerBlock("white_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_PLANKS)));
    public static final Block WHITE_FENCE = registerBlock("white_fence", new FenceBlock(AbstractBlock.Settings.copy(WHITE_PLANKS)));

    public static final Block LIGHT_GREY_STRIPPED_LOG = registerBlock("light_grey_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_STRIPPED_WOOD = registerBlock("light_grey_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_PLANKS = registerBlock("light_grey_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_STAIRS = registerBlock("light_grey_stairs", new StairsBlock(LIGHT_GREY_PLANKS.getDefaultState(), Block.Settings.copy(LIGHT_GREY_BRICKS)));
    public static final Block LIGHT_GREY_SLAB = registerBlock("light_grey_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GREY_PLANKS)));
    public static final Block LIGHT_GREY_FENCE = registerBlock("light_grey_fence", new FenceBlock(AbstractBlock.Settings.copy(LIGHT_GREY_PLANKS)));

    public static final Block GREY_STRIPPED_LOG = registerBlock("grey_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block GREY_STRIPPED_WOOD = registerBlock("grey_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block GREY_PLANKS = registerBlock("grey_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.GRAY)));
    public static final Block GREY_STAIRS = registerBlock("grey_stairs", new StairsBlock(GREY_PLANKS.getDefaultState(), Block.Settings.copy(GREY_BRICKS)));
    public static final Block GREY_SLAB = registerBlock("grey_slab", new SlabBlock(AbstractBlock.Settings.copy(GREY_PLANKS)));
    public static final Block GREY_FENCE = registerBlock("grey_fence", new FenceBlock(AbstractBlock.Settings.copy(GREY_PLANKS)));

    public static final Block BLACK_STRIPPED_LOG = registerBlock("black_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.BLACK)));
    public static final Block BLACK_STRIPPED_WOOD = registerBlock("black_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.BLACK)));
    public static final Block BLACK_PLANKS = registerBlock("black_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.BLACK)));
    public static final Block BLACK_STAIRS = registerBlock("black_stairs", new StairsBlock(BLACK_PLANKS.getDefaultState(), Block.Settings.copy(BLACK_BRICKS)));
    public static final Block BLACK_SLAB = registerBlock("black_slab", new SlabBlock(AbstractBlock.Settings.copy(BLACK_PLANKS)));
    public static final Block BLACK_FENCE = registerBlock("black_fence", new FenceBlock(AbstractBlock.Settings.copy(BLACK_PLANKS)));

    public static final Block BROWN_STRIPPED_LOG = registerBlock("brown_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block BROWN_STRIPPED_WOOD = registerBlock("brown_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block BROWN_PLANKS = registerBlock("brown_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.BROWN)));
    public static final Block BROWN_STAIRS = registerBlock("brown_stairs", new StairsBlock(BROWN_PLANKS.getDefaultState(), Block.Settings.copy(BROWN_BRICKS)));
    public static final Block BROWN_SLAB = registerBlock("brown_slab", new SlabBlock(AbstractBlock.Settings.copy(BROWN_PLANKS)));
    public static final Block BROWN_FENCE = registerBlock("brown_fence", new FenceBlock(AbstractBlock.Settings.copy(BROWN_PLANKS)));

    public static final Block RED_STRIPPED_LOG = registerBlock("red_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.RED)));
    public static final Block RED_STRIPPED_WOOD = registerBlock("red_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.RED)));
    public static final Block RED_PLANKS = registerBlock("red_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.RED)));
    public static final Block RED_STAIRS = registerBlock("red_stairs", new StairsBlock(RED_PLANKS.getDefaultState(), Block.Settings.copy(RED_BRICKS)));
    public static final Block RED_SLAB = registerBlock("red_slab", new SlabBlock(AbstractBlock.Settings.copy(RED_PLANKS)));
    public static final Block RED_FENCE = registerBlock("red_fence", new FenceBlock(AbstractBlock.Settings.copy(RED_PLANKS)));

    public static final Block ORANGE_STRIPPED_LOG = registerBlock("orange_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_STRIPPED_WOOD = registerBlock("orange_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_PLANKS = registerBlock("orange_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_STAIRS = registerBlock("orange_stairs", new StairsBlock(ORANGE_PLANKS.getDefaultState(), Block.Settings.copy(ORANGE_BRICKS)));
    public static final Block ORANGE_SLAB = registerBlock("orange_slab", new SlabBlock(AbstractBlock.Settings.copy(ORANGE_PLANKS)));
    public static final Block ORANGE_FENCE = registerBlock("orange_fence", new FenceBlock(AbstractBlock.Settings.copy(ORANGE_PLANKS)));

    public static final Block YELLOW_STRIPPED_LOG = registerBlock("yellow_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_STRIPPED_WOOD = registerBlock("yellow_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_PLANKS = registerBlock("yellow_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_STAIRS = registerBlock("yellow_stairs", new StairsBlock(YELLOW_PLANKS.getDefaultState(), Block.Settings.copy(YELLOW_BRICKS)));
    public static final Block YELLOW_SLAB = registerBlock("yellow_slab", new SlabBlock(AbstractBlock.Settings.copy(YELLOW_PLANKS)));
    public static final Block YELLOW_FENCE = registerBlock("yellow_fence", new FenceBlock(AbstractBlock.Settings.copy(YELLOW_PLANKS)));

    public static final Block LIME_STRIPPED_LOG = registerBlock("lime_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.LIME)));
    public static final Block LIME_STRIPPED_WOOD = registerBlock("lime_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.LIME)));
    public static final Block LIME_PLANKS = registerBlock("lime_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.LIME)));
    public static final Block LIME_STAIRS = registerBlock("lime_stairs", new StairsBlock(LIME_PLANKS.getDefaultState(), Block.Settings.copy(LIME_BRICKS)));
    public static final Block LIME_SLAB = registerBlock("lime_slab", new SlabBlock(AbstractBlock.Settings.copy(LIME_PLANKS)));
    public static final Block LIME_FENCE = registerBlock("lime_fence", new FenceBlock(AbstractBlock.Settings.copy(LIME_PLANKS)));

    public static final Block GREEN_STRIPPED_LOG = registerBlock("green_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.GREEN)));
    public static final Block GREEN_STRIPPED_WOOD = registerBlock("green_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.GREEN)));
    public static final Block GREEN_PLANKS = registerBlock("green_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.GREEN)));
    public static final Block GREEN_STAIRS = registerBlock("green_stairs", new StairsBlock(GREEN_PLANKS.getDefaultState(), Block.Settings.copy(GREEN_BRICKS)));
    public static final Block GREEN_SLAB = registerBlock("green_slab", new SlabBlock(AbstractBlock.Settings.copy(GREEN_PLANKS)));
    public static final Block GREEN_FENCE = registerBlock("green_fence", new FenceBlock(AbstractBlock.Settings.copy(GREEN_PLANKS)));

    public static final Block CYAN_STRIPPED_LOG = registerBlock("cyan_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.CYAN)));
    public static final Block CYAN_STRIPPED_WOOD = registerBlock("cyan_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.CYAN)));
    public static final Block CYAN_PLANKS = registerBlock("cyan_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.CYAN)));
    public static final Block CYAN_STAIRS = registerBlock("cyan_stairs", new StairsBlock(CYAN_PLANKS.getDefaultState(), Block.Settings.copy(CYAN_BRICKS)));
    public static final Block CYAN_SLAB = registerBlock("cyan_slab", new SlabBlock(AbstractBlock.Settings.copy(CYAN_PLANKS)));
    public static final Block CYAN_FENCE = registerBlock("cyan_fence", new FenceBlock(AbstractBlock.Settings.copy(CYAN_PLANKS)));

    public static final Block LIGHT_BLUE_STRIPPED_LOG = registerBlock("light_blue_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_STRIPPED_WOOD = registerBlock("light_blue_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_PLANKS = registerBlock("light_blue_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_STAIRS = registerBlock("light_blue_stairs", new StairsBlock(LIGHT_BLUE_PLANKS.getDefaultState(), Block.Settings.copy(LIGHT_BLUE_BRICKS)));
    public static final Block LIGHT_BLUE_SLAB = registerBlock("light_blue_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_PLANKS)));
    public static final Block LIGHT_BLUE_FENCE = registerBlock("light_blue_fence", new FenceBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_PLANKS)));

    public static final Block BLUE_STRIPPED_LOG = registerBlock("blue_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block BLUE_STRIPPED_WOOD = registerBlock("blue_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block BLUE_PLANKS = registerBlock("blue_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block BLUE_STAIRS = registerBlock("blue_stairs", new StairsBlock(BLUE_PLANKS.getDefaultState(), Block.Settings.copy(BLUE_BRICKS)));
    public static final Block BLUE_SLAB = registerBlock("blue_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_PLANKS)));
    public static final Block BLUE_FENCE = registerBlock("blue_fence", new FenceBlock(AbstractBlock.Settings.copy(BLUE_PLANKS)));

    public static final Block PURPLE_STRIPPED_LOG = registerBlock("purple_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_STRIPPED_WOOD = registerBlock("purple_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_PLANKS = registerBlock("purple_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_STAIRS = registerBlock("purple_stairs", new StairsBlock(PURPLE_PLANKS.getDefaultState(), Block.Settings.copy(PURPLE_BRICKS)));
    public static final Block PURPLE_SLAB = registerBlock("purple_slab", new SlabBlock(AbstractBlock.Settings.copy(PURPLE_PLANKS)));
    public static final Block PURPLE_FENCE = registerBlock("purple_fence", new FenceBlock(AbstractBlock.Settings.copy(PURPLE_PLANKS)));

    public static final Block MAGENTA_STRIPPED_LOG = registerBlock("magenta_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_STRIPPED_WOOD = registerBlock("magenta_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_PLANKS = registerBlock("magenta_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_STAIRS = registerBlock("magenta_stairs", new StairsBlock(MAGENTA_PLANKS.getDefaultState(), Block.Settings.copy(MAGENTA_BRICKS)));
    public static final Block MAGENTA_SLAB = registerBlock("magenta_slab", new SlabBlock(AbstractBlock.Settings.copy(MAGENTA_PLANKS)));
    public static final Block MAGENTA_FENCE = registerBlock("magenta_fence", new FenceBlock(AbstractBlock.Settings.copy(MAGENTA_PLANKS)));

    public static final Block PINK_STRIPPED_LOG = registerBlock("pink_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.PINK)));
    public static final Block PINK_STRIPPED_WOOD = registerBlock("pink_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.PINK)));
    public static final Block PINK_PLANKS = registerBlock("pink_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.PINK)));
    public static final Block PINK_STAIRS = registerBlock("pink_stairs", new StairsBlock(PINK_PLANKS.getDefaultState(), Block.Settings.copy(PINK_BRICKS)));
    public static final Block PINK_SLAB = registerBlock("pink_slab", new SlabBlock(AbstractBlock.Settings.copy(PINK_PLANKS)));
    public static final Block PINK_FENCE = registerBlock("pink_fence", new FenceBlock(AbstractBlock.Settings.copy(PINK_PLANKS)));

    public static void registerHCColouredBlocks() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its colourful blocks!");
    }

}
