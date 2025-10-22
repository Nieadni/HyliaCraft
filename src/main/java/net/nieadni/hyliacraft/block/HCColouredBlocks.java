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

    public static final Block RAINBOW_BRICKS = registerBlock("rainbow_bricks", new Block(AbstractBlock.Settings.copy(BRICKS).mapColor(MapColor.BRIGHT_RED)));
    public static final Block RAINBOW_BRICK_STAIRS = registerBlock("rainbow_brick_stairs", new StairsBlock(RAINBOW_BRICKS.getDefaultState(), Block.Settings.copy(RAINBOW_BRICKS)));
    public static final Block RAINBOW_BRICK_SLAB = registerBlock("rainbow_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(RAINBOW_BRICKS)));
    public static final Block RAINBOW_BRICK_WALL = registerBlock("rainbow_brick_wall", new WallBlock(AbstractBlock.Settings.copy(RAINBOW_BRICKS)));

    //

    public static final Block WHITE_STRIPPED_LOG = registerBlock("white_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.WHITE)));
    public static final Block WHITE_STRIPPED_WOOD = registerBlock("white_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.WHITE)));
    public static final Block WHITE_PLANKS = registerBlock("white_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.WHITE)));
    public static final Block WHITE_STAIRS = registerBlock("white_stairs", new StairsBlock(WHITE_PLANKS.getDefaultState(), Block.Settings.copy(WHITE_PLANKS)));
    public static final Block WHITE_SLAB = registerBlock("white_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_PLANKS)));
    public static final Block WHITE_FENCE = registerBlock("white_fence", new FenceBlock(AbstractBlock.Settings.copy(WHITE_PLANKS)));
    public static final Block WHITE_FENCE_GATE = registerBlock("white_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(WHITE_PLANKS)));
    public static final Block WHITE_PRESSURE_PLATE = registerBlock("white_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(WHITE_PLANKS)));
    public static final Block WHITE_BUTTON = registerBlock("white_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block LIGHT_GREY_STRIPPED_LOG = registerBlock("light_grey_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_STRIPPED_WOOD = registerBlock("light_grey_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_PLANKS = registerBlock("light_grey_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_STAIRS = registerBlock("light_grey_stairs", new StairsBlock(LIGHT_GREY_PLANKS.getDefaultState(), Block.Settings.copy(LIGHT_GREY_PLANKS)));
    public static final Block LIGHT_GREY_SLAB = registerBlock("light_grey_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GREY_PLANKS)));
    public static final Block LIGHT_GREY_FENCE = registerBlock("light_grey_fence", new FenceBlock(AbstractBlock.Settings.copy(LIGHT_GREY_PLANKS)));
    public static final Block LIGHT_GREY_FENCE_GATE = registerBlock("light_grey_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(LIGHT_GREY_PLANKS)));
    public static final Block LIGHT_GREY_PRESSURE_PLATE = registerBlock("light_grey_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(LIGHT_GREY_PLANKS)));
    public static final Block LIGHT_GREY_BUTTON = registerBlock("light_grey_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block GREY_STRIPPED_LOG = registerBlock("grey_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block GREY_STRIPPED_WOOD = registerBlock("grey_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block GREY_PLANKS = registerBlock("grey_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.GRAY)));
    public static final Block GREY_STAIRS = registerBlock("grey_stairs", new StairsBlock(GREY_PLANKS.getDefaultState(), Block.Settings.copy(GREY_PLANKS)));
    public static final Block GREY_SLAB = registerBlock("grey_slab", new SlabBlock(AbstractBlock.Settings.copy(GREY_PLANKS)));
    public static final Block GREY_FENCE = registerBlock("grey_fence", new FenceBlock(AbstractBlock.Settings.copy(GREY_PLANKS)));
    public static final Block GREY_FENCE_GATE = registerBlock("grey_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(GREY_PLANKS)));
    public static final Block GREY_PRESSURE_PLATE = registerBlock("grey_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(GREY_PLANKS)));
    public static final Block GREY_BUTTON = registerBlock("grey_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block BLACK_STRIPPED_LOG = registerBlock("black_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.BLACK)));
    public static final Block BLACK_STRIPPED_WOOD = registerBlock("black_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.BLACK)));
    public static final Block BLACK_PLANKS = registerBlock("black_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.BLACK)));
    public static final Block BLACK_STAIRS = registerBlock("black_stairs", new StairsBlock(BLACK_PLANKS.getDefaultState(), Block.Settings.copy(BLACK_PLANKS)));
    public static final Block BLACK_SLAB = registerBlock("black_slab", new SlabBlock(AbstractBlock.Settings.copy(BLACK_PLANKS)));
    public static final Block BLACK_FENCE = registerBlock("black_fence", new FenceBlock(AbstractBlock.Settings.copy(BLACK_PLANKS)));
    public static final Block BLACK_FENCE_GATE = registerBlock("black_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(BLACK_PLANKS)));
    public static final Block BLACK_PRESSURE_PLATE = registerBlock("black_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(BLACK_PLANKS)));
    public static final Block BLACK_BUTTON = registerBlock("black_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block BROWN_STRIPPED_LOG = registerBlock("brown_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block BROWN_STRIPPED_WOOD = registerBlock("brown_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block BROWN_PLANKS = registerBlock("brown_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.BROWN)));
    public static final Block BROWN_STAIRS = registerBlock("brown_stairs", new StairsBlock(BROWN_PLANKS.getDefaultState(), Block.Settings.copy(BROWN_PLANKS)));
    public static final Block BROWN_SLAB = registerBlock("brown_slab", new SlabBlock(AbstractBlock.Settings.copy(BROWN_PLANKS)));
    public static final Block BROWN_FENCE = registerBlock("brown_fence", new FenceBlock(AbstractBlock.Settings.copy(BROWN_PLANKS)));
    public static final Block BROWN_FENCE_GATE = registerBlock("brown_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(BROWN_PLANKS)));
    public static final Block BROWN_PRESSURE_PLATE = registerBlock("brown_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(BROWN_PLANKS)));
    public static final Block BROWN_BUTTON = registerBlock("brown_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block RED_STRIPPED_LOG = registerBlock("red_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.RED)));
    public static final Block RED_STRIPPED_WOOD = registerBlock("red_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.RED)));
    public static final Block RED_PLANKS = registerBlock("red_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.RED)));
    public static final Block RED_STAIRS = registerBlock("red_stairs", new StairsBlock(RED_PLANKS.getDefaultState(), Block.Settings.copy(RED_PLANKS)));
    public static final Block RED_SLAB = registerBlock("red_slab", new SlabBlock(AbstractBlock.Settings.copy(RED_PLANKS)));
    public static final Block RED_FENCE = registerBlock("red_fence", new FenceBlock(AbstractBlock.Settings.copy(RED_PLANKS)));
    public static final Block RED_FENCE_GATE = registerBlock("red_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(RED_PLANKS)));
    public static final Block RED_PRESSURE_PLATE = registerBlock("red_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(RED_PLANKS)));
    public static final Block RED_BUTTON = registerBlock("red_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block ORANGE_STRIPPED_LOG = registerBlock("orange_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_STRIPPED_WOOD = registerBlock("orange_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_PLANKS = registerBlock("orange_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_STAIRS = registerBlock("orange_stairs", new StairsBlock(ORANGE_PLANKS.getDefaultState(), Block.Settings.copy(ORANGE_PLANKS)));
    public static final Block ORANGE_SLAB = registerBlock("orange_slab", new SlabBlock(AbstractBlock.Settings.copy(ORANGE_PLANKS)));
    public static final Block ORANGE_FENCE = registerBlock("orange_fence", new FenceBlock(AbstractBlock.Settings.copy(ORANGE_PLANKS)));
    public static final Block ORANGE_FENCE_GATE = registerBlock("orange_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(ORANGE_PLANKS)));
    public static final Block ORANGE_PRESSURE_PLATE = registerBlock("orange_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(ORANGE_PLANKS)));
    public static final Block ORANGE_BUTTON = registerBlock("orange_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block YELLOW_STRIPPED_LOG = registerBlock("yellow_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_STRIPPED_WOOD = registerBlock("yellow_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_PLANKS = registerBlock("yellow_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_STAIRS = registerBlock("yellow_stairs", new StairsBlock(YELLOW_PLANKS.getDefaultState(), Block.Settings.copy(YELLOW_PLANKS)));
    public static final Block YELLOW_SLAB = registerBlock("yellow_slab", new SlabBlock(AbstractBlock.Settings.copy(YELLOW_PLANKS)));
    public static final Block YELLOW_FENCE = registerBlock("yellow_fence", new FenceBlock(AbstractBlock.Settings.copy(YELLOW_PLANKS)));
    public static final Block YELLOW_FENCE_GATE = registerBlock("yellow_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(YELLOW_PLANKS)));
    public static final Block YELLOW_PRESSURE_PLATE = registerBlock("yellow_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(YELLOW_PLANKS)));
    public static final Block YELLOW_BUTTON = registerBlock("yellow_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block LIME_STRIPPED_LOG = registerBlock("lime_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.LIME)));
    public static final Block LIME_STRIPPED_WOOD = registerBlock("lime_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.LIME)));
    public static final Block LIME_PLANKS = registerBlock("lime_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.LIME)));
    public static final Block LIME_STAIRS = registerBlock("lime_stairs", new StairsBlock(LIME_PLANKS.getDefaultState(), Block.Settings.copy(LIME_PLANKS)));
    public static final Block LIME_SLAB = registerBlock("lime_slab", new SlabBlock(AbstractBlock.Settings.copy(LIME_PLANKS)));
    public static final Block LIME_FENCE = registerBlock("lime_fence", new FenceBlock(AbstractBlock.Settings.copy(LIME_PLANKS)));
    public static final Block LIME_FENCE_GATE = registerBlock("lime_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(LIME_PLANKS)));
    public static final Block LIME_PRESSURE_PLATE = registerBlock("lime_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(LIME_PLANKS)));
    public static final Block LIME_BUTTON = registerBlock("lime_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block GREEN_STRIPPED_LOG = registerBlock("green_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.GREEN)));
    public static final Block GREEN_STRIPPED_WOOD = registerBlock("green_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.GREEN)));
    public static final Block GREEN_PLANKS = registerBlock("green_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.GREEN)));
    public static final Block GREEN_STAIRS = registerBlock("green_stairs", new StairsBlock(GREEN_PLANKS.getDefaultState(), Block.Settings.copy(GREEN_PLANKS)));
    public static final Block GREEN_SLAB = registerBlock("green_slab", new SlabBlock(AbstractBlock.Settings.copy(GREEN_PLANKS)));
    public static final Block GREEN_FENCE = registerBlock("green_fence", new FenceBlock(AbstractBlock.Settings.copy(GREEN_PLANKS)));
    public static final Block GREEN_FENCE_GATE = registerBlock("green_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(GREEN_PLANKS)));
    public static final Block GREEN_PRESSURE_PLATE = registerBlock("green_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(GREEN_PLANKS)));
    public static final Block GREEN_BUTTON = registerBlock("green_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block CYAN_STRIPPED_LOG = registerBlock("cyan_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.CYAN)));
    public static final Block CYAN_STRIPPED_WOOD = registerBlock("cyan_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.CYAN)));
    public static final Block CYAN_PLANKS = registerBlock("cyan_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.CYAN)));
    public static final Block CYAN_STAIRS = registerBlock("cyan_stairs", new StairsBlock(CYAN_PLANKS.getDefaultState(), Block.Settings.copy(CYAN_PLANKS)));
    public static final Block CYAN_SLAB = registerBlock("cyan_slab", new SlabBlock(AbstractBlock.Settings.copy(CYAN_PLANKS)));
    public static final Block CYAN_FENCE = registerBlock("cyan_fence", new FenceBlock(AbstractBlock.Settings.copy(CYAN_PLANKS)));
    public static final Block CYAN_FENCE_GATE = registerBlock("cyan_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(CYAN_PLANKS)));
    public static final Block CYAN_PRESSURE_PLATE = registerBlock("cyan_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(CYAN_PLANKS)));
    public static final Block CYAN_BUTTON = registerBlock("cyan_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block LIGHT_BLUE_STRIPPED_LOG = registerBlock("light_blue_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_STRIPPED_WOOD = registerBlock("light_blue_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_PLANKS = registerBlock("light_blue_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_STAIRS = registerBlock("light_blue_stairs", new StairsBlock(LIGHT_BLUE_PLANKS.getDefaultState(), Block.Settings.copy(LIGHT_BLUE_PLANKS)));
    public static final Block LIGHT_BLUE_SLAB = registerBlock("light_blue_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_PLANKS)));
    public static final Block LIGHT_BLUE_FENCE = registerBlock("light_blue_fence", new FenceBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_PLANKS)));
    public static final Block LIGHT_BLUE_FENCE_GATE = registerBlock("light_blue_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(LIGHT_BLUE_PLANKS)));
    public static final Block LIGHT_BLUE_PRESSURE_PLATE = registerBlock("light_blue_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(LIGHT_BLUE_PLANKS)));
    public static final Block LIGHT_BLUE_BUTTON = registerBlock("light_blue_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block BLUE_STRIPPED_LOG = registerBlock("blue_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block BLUE_STRIPPED_WOOD = registerBlock("blue_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block BLUE_PLANKS = registerBlock("blue_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block BLUE_STAIRS = registerBlock("blue_stairs", new StairsBlock(BLUE_PLANKS.getDefaultState(), Block.Settings.copy(BLUE_PLANKS)));
    public static final Block BLUE_SLAB = registerBlock("blue_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_PLANKS)));
    public static final Block BLUE_FENCE = registerBlock("blue_fence", new FenceBlock(AbstractBlock.Settings.copy(BLUE_PLANKS)));
    public static final Block BLUE_FENCE_GATE = registerBlock("blue_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(BLUE_PLANKS)));
    public static final Block BLUE_PRESSURE_PLATE = registerBlock("blue_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(BLUE_PLANKS)));
    public static final Block BLUE_BUTTON = registerBlock("blue_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block PURPLE_STRIPPED_LOG = registerBlock("purple_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_STRIPPED_WOOD = registerBlock("purple_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_PLANKS = registerBlock("purple_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_STAIRS = registerBlock("purple_stairs", new StairsBlock(PURPLE_PLANKS.getDefaultState(), Block.Settings.copy(PURPLE_PLANKS)));
    public static final Block PURPLE_SLAB = registerBlock("purple_slab", new SlabBlock(AbstractBlock.Settings.copy(PURPLE_PLANKS)));
    public static final Block PURPLE_FENCE = registerBlock("purple_fence", new FenceBlock(AbstractBlock.Settings.copy(PURPLE_PLANKS)));
    public static final Block PURPLE_FENCE_GATE = registerBlock("purple_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(PURPLE_PLANKS)));
    public static final Block PURPLE_PRESSURE_PLATE = registerBlock("purple_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(PURPLE_PLANKS)));
    public static final Block PURPLE_BUTTON = registerBlock("purple_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block MAGENTA_STRIPPED_LOG = registerBlock("magenta_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_STRIPPED_WOOD = registerBlock("magenta_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_PLANKS = registerBlock("magenta_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_STAIRS = registerBlock("magenta_stairs", new StairsBlock(MAGENTA_PLANKS.getDefaultState(), Block.Settings.copy(MAGENTA_PLANKS)));
    public static final Block MAGENTA_SLAB = registerBlock("magenta_slab", new SlabBlock(AbstractBlock.Settings.copy(MAGENTA_PLANKS)));
    public static final Block MAGENTA_FENCE = registerBlock("magenta_fence", new FenceBlock(AbstractBlock.Settings.copy(MAGENTA_PLANKS)));
    public static final Block MAGENTA_FENCE_GATE = registerBlock("magenta_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(MAGENTA_PLANKS)));
    public static final Block MAGENTA_PRESSURE_PLATE = registerBlock("magenta_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(MAGENTA_PLANKS)));
    public static final Block MAGENTA_BUTTON = registerBlock("magenta_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block PINK_STRIPPED_LOG = registerBlock("pink_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.PINK)));
    public static final Block PINK_STRIPPED_WOOD = registerBlock("pink_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.PINK)));
    public static final Block PINK_PLANKS = registerBlock("pink_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.PINK)));
    public static final Block PINK_STAIRS = registerBlock("pink_stairs", new StairsBlock(PINK_PLANKS.getDefaultState(), Block.Settings.copy(PINK_PLANKS)));
    public static final Block PINK_SLAB = registerBlock("pink_slab", new SlabBlock(AbstractBlock.Settings.copy(PINK_PLANKS)));
    public static final Block PINK_FENCE = registerBlock("pink_fence", new FenceBlock(AbstractBlock.Settings.copy(PINK_PLANKS)));
    public static final Block PINK_FENCE_GATE = registerBlock("pink_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(PINK_PLANKS)));
    public static final Block PINK_PRESSURE_PLATE = registerBlock("pink_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(PINK_PLANKS)));
    public static final Block PINK_BUTTON = registerBlock("pink_button", createWoodenButtonBlock(BlockSetType.OAK));

    public static final Block RAINBOW_STRIPPED_LOG = registerBlock("rainbow_stripped_log", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).mapColor(MapColor.YELLOW))); // Example color
    public static final Block RAINBOW_STRIPPED_WOOD = registerBlock("rainbow_stripped_wood", new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).mapColor(MapColor.YELLOW))); // Example color
    public static final Block RAINBOW_PLANKS = registerBlock("rainbow_planks", new Block(AbstractBlock.Settings.copy(OAK_PLANKS).mapColor(MapColor.YELLOW))); // Example color
    public static final Block RAINBOW_STAIRS = registerBlock("rainbow_stairs", new StairsBlock(RAINBOW_PLANKS.getDefaultState(), Block.Settings.copy(RAINBOW_PLANKS)));
    public static final Block RAINBOW_SLAB = registerBlock("rainbow_slab", new SlabBlock(AbstractBlock.Settings.copy(RAINBOW_PLANKS)));
    public static final Block RAINBOW_FENCE = registerBlock("rainbow_fence", new FenceBlock(AbstractBlock.Settings.copy(RAINBOW_PLANKS)));
    public static final Block RAINBOW_FENCE_GATE = registerBlock("rainbow_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(RAINBOW_PLANKS)));
    public static final Block RAINBOW_PRESSURE_PLATE = registerBlock("rainbow_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(RAINBOW_PLANKS)));
    public static final Block RAINBOW_BUTTON = registerBlock("rainbow_button", createWoodenButtonBlock(BlockSetType.OAK));

    //

    public static final Block WHITE_SHINGLES = registerBlock("white_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.WHITE)));
    public static final Block WHITE_SHINGLE_STAIRS = registerBlock("white_shingle_stairs", new StairsBlock(WHITE_SHINGLES.getDefaultState(), Block.Settings.copy(WHITE_SHINGLES)));
    public static final Block WHITE_SHINGLE_SLAB = registerBlock("white_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_SHINGLES)));
    public static final Block WHITE_SHINGLE_WALL = registerBlock("white_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(WHITE_SHINGLES)));

    public static final Block LIGHT_GREY_SHINGLES = registerBlock("light_grey_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GREY_SHINGLE_STAIRS = registerBlock("light_grey_shingle_stairs", new StairsBlock(LIGHT_GREY_SHINGLES.getDefaultState(), Block.Settings.copy(LIGHT_GREY_SHINGLES)));
    public static final Block LIGHT_GREY_SHINGLE_SLAB = registerBlock("light_grey_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GREY_SHINGLES)));
    public static final Block LIGHT_GREY_SHINGLE_WALL = registerBlock("light_grey_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_GREY_SHINGLES)));

    public static final Block GREY_SHINGLES = registerBlock("grey_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.GRAY)));
    public static final Block GREY_SHINGLE_STAIRS = registerBlock("grey_shingle_stairs", new StairsBlock(GREY_SHINGLES.getDefaultState(), Block.Settings.copy(GREY_SHINGLES)));
    public static final Block GREY_SHINGLE_SLAB = registerBlock("grey_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(GREY_SHINGLES)));
    public static final Block GREY_SHINGLE_WALL = registerBlock("grey_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(GREY_SHINGLES)));

    public static final Block BLACK_SHINGLES = registerBlock("black_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.BLACK)));
    public static final Block BLACK_SHINGLE_STAIRS = registerBlock("black_shingle_stairs", new StairsBlock(BLACK_SHINGLES.getDefaultState(), Block.Settings.copy(BLACK_SHINGLES)));
    public static final Block BLACK_SHINGLE_SLAB = registerBlock("black_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(BLACK_SHINGLES)));
    public static final Block BLACK_SHINGLE_WALL = registerBlock("black_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(BLACK_SHINGLES)));

    public static final Block BROWN_SHINGLES = registerBlock("brown_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.BROWN)));
    public static final Block BROWN_SHINGLE_STAIRS = registerBlock("brown_shingle_stairs", new StairsBlock(BROWN_SHINGLES.getDefaultState(), Block.Settings.copy(BROWN_SHINGLES)));
    public static final Block BROWN_SHINGLE_SLAB = registerBlock("brown_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(BROWN_SHINGLES)));
    public static final Block BROWN_SHINGLE_WALL = registerBlock("brown_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(BROWN_SHINGLES)));

    public static final Block RED_SHINGLES = registerBlock("red_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.RED)));
    public static final Block RED_SHINGLE_STAIRS = registerBlock("red_shingle_stairs", new StairsBlock(RED_SHINGLES.getDefaultState(), Block.Settings.copy(RED_SHINGLES)));
    public static final Block RED_SHINGLE_SLAB = registerBlock("red_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(RED_SHINGLES)));
    public static final Block RED_SHINGLE_WALL = registerBlock("red_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(RED_SHINGLES)));

    public static final Block ORANGE_SHINGLES = registerBlock("orange_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.ORANGE)));
    public static final Block ORANGE_SHINGLE_STAIRS = registerBlock("orange_shingle_stairs", new StairsBlock(ORANGE_SHINGLES.getDefaultState(), Block.Settings.copy(ORANGE_SHINGLES)));
    public static final Block ORANGE_SHINGLE_SLAB = registerBlock("orange_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(ORANGE_SHINGLES)));
    public static final Block ORANGE_SHINGLE_WALL = registerBlock("orange_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(ORANGE_SHINGLES)));

    public static final Block YELLOW_SHINGLES = registerBlock("yellow_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.YELLOW)));
    public static final Block YELLOW_SHINGLE_STAIRS = registerBlock("yellow_shingle_stairs", new StairsBlock(YELLOW_SHINGLES.getDefaultState(), Block.Settings.copy(YELLOW_SHINGLES)));
    public static final Block YELLOW_SHINGLE_SLAB = registerBlock("yellow_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(YELLOW_SHINGLES)));
    public static final Block YELLOW_SHINGLE_WALL = registerBlock("yellow_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(YELLOW_SHINGLES)));

    public static final Block LIME_SHINGLES = registerBlock("lime_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.LIME)));
    public static final Block LIME_SHINGLE_STAIRS = registerBlock("lime_shingle_stairs", new StairsBlock(LIME_SHINGLES.getDefaultState(), Block.Settings.copy(LIME_SHINGLES)));
    public static final Block LIME_SHINGLE_SLAB = registerBlock("lime_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(LIME_SHINGLES)));
    public static final Block LIME_SHINGLE_WALL = registerBlock("lime_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(LIME_SHINGLES)));

    public static final Block GREEN_SHINGLES = registerBlock("green_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.GREEN)));
    public static final Block GREEN_SHINGLE_STAIRS = registerBlock("green_shingle_stairs", new StairsBlock(GREEN_SHINGLES.getDefaultState(), Block.Settings.copy(GREEN_SHINGLES)));
    public static final Block GREEN_SHINGLE_SLAB = registerBlock("green_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(GREEN_SHINGLES)));
    public static final Block GREEN_SHINGLE_WALL = registerBlock("green_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(GREEN_SHINGLES)));

    public static final Block CYAN_SHINGLES = registerBlock("cyan_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.CYAN)));
    public static final Block CYAN_SHINGLE_STAIRS = registerBlock("cyan_shingle_stairs", new StairsBlock(CYAN_SHINGLES.getDefaultState(), Block.Settings.copy(CYAN_SHINGLES)));
    public static final Block CYAN_SHINGLE_SLAB = registerBlock("cyan_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(CYAN_SHINGLES)));
    public static final Block CYAN_SHINGLE_WALL = registerBlock("cyan_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(CYAN_SHINGLES)));

    public static final Block LIGHT_BLUE_SHINGLES = registerBlock("light_blue_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIGHT_BLUE_SHINGLE_STAIRS = registerBlock("light_blue_shingle_stairs", new StairsBlock(LIGHT_BLUE_SHINGLES.getDefaultState(), Block.Settings.copy(LIGHT_BLUE_SHINGLES)));
    public static final Block LIGHT_BLUE_SHINGLE_SLAB = registerBlock("light_blue_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_SHINGLES)));
    public static final Block LIGHT_BLUE_SHINGLE_WALL = registerBlock("light_blue_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_SHINGLES)));

    public static final Block BLUE_SHINGLES = registerBlock("blue_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.BLUE)));
    public static final Block BLUE_SHINGLE_STAIRS = registerBlock("blue_shingle_stairs", new StairsBlock(BLUE_SHINGLES.getDefaultState(), Block.Settings.copy(BLUE_SHINGLES)));
    public static final Block BLUE_SHINGLE_SLAB = registerBlock("blue_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_SHINGLES)));
    public static final Block BLUE_SHINGLE_WALL = registerBlock("blue_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(BLUE_SHINGLES)));

    public static final Block PURPLE_SHINGLES = registerBlock("purple_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.PURPLE)));
    public static final Block PURPLE_SHINGLE_STAIRS = registerBlock("purple_shingle_stairs", new StairsBlock(PURPLE_SHINGLES.getDefaultState(), Block.Settings.copy(PURPLE_SHINGLES)));
    public static final Block PURPLE_SHINGLE_SLAB = registerBlock("purple_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(PURPLE_SHINGLES)));
    public static final Block PURPLE_SHINGLE_WALL = registerBlock("purple_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(PURPLE_SHINGLES)));

    public static final Block MAGENTA_SHINGLES = registerBlock("magenta_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.MAGENTA)));
    public static final Block MAGENTA_SHINGLE_STAIRS = registerBlock("magenta_shingle_stairs", new StairsBlock(MAGENTA_SHINGLES.getDefaultState(), Block.Settings.copy(MAGENTA_SHINGLES)));
    public static final Block MAGENTA_SHINGLE_SLAB = registerBlock("magenta_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(MAGENTA_SHINGLES)));
    public static final Block MAGENTA_SHINGLE_WALL = registerBlock("magenta_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(MAGENTA_SHINGLES)));

    public static final Block PINK_SHINGLES = registerBlock("pink_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.PINK)));
    public static final Block PINK_SHINGLE_STAIRS = registerBlock("pink_shingle_stairs", new StairsBlock(PINK_SHINGLES.getDefaultState(), Block.Settings.copy(PINK_SHINGLES)));
    public static final Block PINK_SHINGLE_SLAB = registerBlock("pink_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(PINK_SHINGLES)));
    public static final Block PINK_SHINGLE_WALL = registerBlock("pink_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(PINK_SHINGLES)));

    public static final Block RAINBOW_SHINGLES = registerBlock("rainbow_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.BRIGHT_RED)));
    public static final Block RAINBOW_SHINGLE_STAIRS = registerBlock("rainbow_shingle_stairs", new StairsBlock(RAINBOW_SHINGLES.getDefaultState(), Block.Settings.copy(RAINBOW_SHINGLES)));
    public static final Block RAINBOW_SHINGLE_SLAB = registerBlock("rainbow_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(RAINBOW_SHINGLES)));
    public static final Block RAINBOW_SHINGLE_WALL = registerBlock("rainbow_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(RAINBOW_SHINGLES)));

    public static void registerHCColouredBlocks() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its colourful blocks!");
    }

}
