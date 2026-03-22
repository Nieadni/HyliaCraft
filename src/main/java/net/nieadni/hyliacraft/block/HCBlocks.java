package net.nieadni.hyliacraft.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.custom.IronChestBlock;
import net.nieadni.hyliacraft.block.custom.PotBlock;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HCBlocks extends Blocks {

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(HyliaCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(HyliaCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings().maxCount(64)));
    }

    public static final Block CLAY_POT = registerBlock("clay_pot", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)));
    public static final Block NATURAL_CLAY_POT = registerBlock("natural_clay_pot", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)));
    public static final Block CLAY_POT_WRITING = registerBlock("clay_pot_writing", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)));
    public static final Block NATURAL_CLAY_POT_WRITING = registerBlock("natural_clay_pot_writing", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)));
    public static final Block BLUE_CLAY_POT = registerBlock("blue_clay_pot", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE)));
    public static final Block NATURAL_BLUE_CLAY_POT = registerBlock("natural_blue_clay_pot", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE)));
    public static final Block HATENO_CLAY_POT = registerBlock("hateno_clay_pot", new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BROWN)));

    public static final Block ARMORANTH = registerBlock("armoranth", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.RESISTANCE, 400)), AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ARMORANTH_POT = registerBlock("armoranth_pot", Blocks.createFlowerPotBlock(ARMORANTH));
    public static final Block BLUE_NIGHTSHADE = registerBlock( "blue_nightshade", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.INVISIBILITY, 400)), AbstractBlock.Settings.create().mapColor(MapColor.BLUE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLUE_NIGHTSHADE_POT = registerBlock("blue_nightshade_pot", Blocks.createFlowerPotBlock(BLUE_NIGHTSHADE));
    public static final Block SILENT_PRINCESS = registerBlock("silent_princess", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.INVISIBILITY, 400)), AbstractBlock.Settings.create().mapColor(MapColor.WHITE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SILENT_PRINCESS_POT = registerBlock("silent_princess_pot", Blocks.createFlowerPotBlock(SILENT_PRINCESS));
    public static final Block SWIFT_VIOLETS = registerBlock("swift_violets", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.SPEED, 400)), AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SWIFT_VIOLETS_POT = registerBlock("swift_violets_pot", Blocks.createFlowerPotBlock(SWIFT_VIOLETS));

    public static final Block IRON_CHEST = registerBlock("iron_chest", new IronChestBlock(AbstractBlock.Settings.create(), () -> {
        return HCBlockEntityType.IRON_CHEST;}));

    public static final Block WHITE_SHINGLES = registerBlock("white_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.WHITE)));
    public static final Block WHITE_SHINGLE_STAIRS = registerBlock("white_shingle_stairs", new StairsBlock(WHITE_SHINGLES.getDefaultState(), Block.Settings.copy(WHITE_SHINGLES)));
    public static final Block WHITE_SHINGLE_SLAB = registerBlock("white_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_SHINGLES)));
    public static final Block WHITE_SHINGLE_WALL = registerBlock("white_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(WHITE_SHINGLES)));

    public static final Block LIGHT_GRAY_SHINGLES = registerBlock("light_gray_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block LIGHT_GRAY_SHINGLE_STAIRS = registerBlock("light_gray_shingle_stairs", new StairsBlock(LIGHT_GRAY_SHINGLES.getDefaultState(), Block.Settings.copy(LIGHT_GRAY_SHINGLES)));
    public static final Block LIGHT_GRAY_SHINGLE_SLAB = registerBlock("light_gray_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_SHINGLES)));
    public static final Block LIGHT_GRAY_SHINGLE_WALL = registerBlock("light_gray_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_SHINGLES)));

    public static final Block GRAY_SHINGLES = registerBlock("gray_shingles", new Block(AbstractBlock.Settings.copy(TERRACOTTA).mapColor(MapColor.GRAY)));
    public static final Block GRAY_SHINGLE_STAIRS = registerBlock("gray_shingle_stairs", new StairsBlock(GRAY_SHINGLES.getDefaultState(), Block.Settings.copy(GRAY_SHINGLES)));
    public static final Block GRAY_SHINGLE_SLAB = registerBlock("gray_shingle_slab", new SlabBlock(AbstractBlock.Settings.copy(GRAY_SHINGLES)));
    public static final Block GRAY_SHINGLE_WALL = registerBlock("gray_shingle_wall", new WallBlock(AbstractBlock.Settings.copy(GRAY_SHINGLES)));

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


    @Contract("_ -> new")
    private static @NotNull SuspiciousStewEffectsComponent createStewEffects(SuspiciousStewEffectsComponent.StewEffect... effects) {
        return new SuspiciousStewEffectsComponent(List.of(effects));
    }

    public static void registerHCBlocks() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its blocks!");
    }
}