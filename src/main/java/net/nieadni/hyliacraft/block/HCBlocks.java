package net.nieadni.hyliacraft.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.custom.PotBlock;

import org.jetbrains.annotations.*;

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

    public static final Block ARMORANTH = registerBlock("armoranth", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.RESISTANCE, 400)), AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ARMORANTH_POT = registerBlock("armoranth_pot", Blocks.createFlowerPotBlock(ARMORANTH));
    public static final Block BLUE_NIGHTSHADE = registerBlock( "blue_nightshade", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.INVISIBILITY, 400)), AbstractBlock.Settings.create().mapColor(MapColor.BLUE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLUE_NIGHTSHADE_POT = registerBlock("blue_nightshade_pot", Blocks.createFlowerPotBlock(BLUE_NIGHTSHADE));
    public static final Block SILENT_PRINCESS = registerBlock("silent_princess", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.INVISIBILITY, 400)), AbstractBlock.Settings.create().mapColor(MapColor.WHITE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SILENT_PRINCESS_POT = registerBlock("silent_princess_pot", Blocks.createFlowerPotBlock(SILENT_PRINCESS));
    public static final Block SWIFT_VIOLETS = registerBlock("swift_violets", new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.SPEED, 400)), AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SWIFT_VIOLETS_POT = registerBlock("swift_violets_pot", Blocks.createFlowerPotBlock(SWIFT_VIOLETS));

    @Contract("_ -> new")
    private static @NotNull SuspiciousStewEffectsComponent createStewEffects(SuspiciousStewEffectsComponent.StewEffect... effects) {
        return new SuspiciousStewEffectsComponent(List.of(effects));
    }

    public static void registerHCBlocks() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its blocks!");
    }
}