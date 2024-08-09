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

    public static void registerHCColouredBlocks() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its colourful blocks!");
    }

}
