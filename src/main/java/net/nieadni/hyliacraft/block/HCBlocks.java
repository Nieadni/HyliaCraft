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
import net.nieadni.hyliacraft.block.custom.PotBlock;

import java.util.List;

public class HCBlocks extends Blocks {

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(HyliaCraft.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Block CLAY_POT = register(new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)),"clay_pot",true);
    public static final Block NATURAL_CLAY_POT = register(new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)),"natural_clay_pot",true);
    public static final Block CLAY_POT_WRITING = register(new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)),"clay_pot_writing",true);
    public static final Block NATURAL_CLAY_POT_WRITING = register(new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)),"natural_clay_pot_writing",true);
    public static final Block BLUE_CLAY_POT = register(new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE)),"blue_clay_pot",true);
    public static final Block NATURAL_BLUE_CLAY_POT = register(new PotBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE)),"natural_blue_clay_pot",true);

    public static final Block ARMORANTH = register(new FlowerBlock(createStewEffects(new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.RESISTANCE, 400)), AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), "armoranth", true);
    public static final Block ARMORANTH_POT = register("armoranth_pot", Blocks.createFlowerPotBlock(ARMORANTH));

    private static SuspiciousStewEffectsComponent createStewEffects(SuspiciousStewEffectsComponent.StewEffect... effects) {
        return new SuspiciousStewEffectsComponent(List.of(effects));
    }

    public static void initialize() {}

}
