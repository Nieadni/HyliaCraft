package net.nieadni.hyliacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;

public class HCItemGroups {

    public static final ItemGroup GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "1-gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.gear"))
                    .icon(() -> new ItemStack(HCItems.GODDESS_SWORD)).entries((displayContext, entries) -> {
                        entries.add(HCItems.MAJORAS_MASK);
                        entries.add(HCItems.PUMPKIN_MASK);

                        entries.add(HCItems.GODDESS_SWORD);
                        entries.add(HCItems.GODDESS_LONGSWORD);
                        entries.add(HCItems.GODDESS_WHITE_SWORD);
                        entries.add(HCItems.MASTER_SWORD);
                        entries.add(HCItems.TRUE_MASTER_SWORD);
                        entries.add(HCItems.HYLIAN_SHIELD);

                        entries.add(HCItems.SLINGSHOT);
                        entries.add(HCItems.IRON_BOW);
                        entries.add(HCItems.FAIRY_BOW);
                        entries.add(HCItems.BOOMERANG);
                        entries.add(HCItems.GALE_BOOMERANG);

                        entries.add(HCItems.DIGGING_MITT);
                        entries.add(HCItems.MOGMA_MITT);
                        entries.add(HCItems.PARAGLIDER);

                    }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "2-blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.blocks"))
                    .icon(() -> new ItemStack(HCBlocks.CLAY_POT)).entries((displayContext, entries) -> {
                        entries.add(HCBlocks.CLAY_POT.asItem());
                        entries.add(HCBlocks.NATURAL_CLAY_POT);
                        entries.add(HCBlocks.CLAY_POT_WRITING);
                        entries.add(HCBlocks.NATURAL_CLAY_POT_WRITING);
                        entries.add(HCBlocks.BLUE_CLAY_POT);
                        entries.add(HCBlocks.NATURAL_BLUE_CLAY_POT);
                        entries.add(HCBlocks.HATENO_CLAY_POT);

                        entries.add(HCBlocks.ARMORANTH);
                        entries.add(HCBlocks.BLUE_NIGHTSHADE);
                        entries.add(HCBlocks.SILENT_PRINCESS);
                        entries.add(HCBlocks.SWIFT_VIOLETS);

                    }).build());

    public static final ItemGroup COLOURED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "3-coloured_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.coloured_blocks"))
                    .icon(() -> new ItemStack(HCColouredBlocks.WHITE_BRICKS)).entries((displayContext, entries) -> {
                        entries.add(HCColouredBlocks.WHITE_BRICKS);
                        entries.add(HCColouredBlocks.WHITE_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.WHITE_BRICK_SLAB);
                        entries.add(HCColouredBlocks.WHITE_BRICK_WALL);
                        entries.add(HCColouredBlocks.LIGHT_GREY_BRICKS);
                        entries.add(HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.LIGHT_GREY_BRICK_SLAB);
                        entries.add(HCColouredBlocks.LIGHT_GREY_BRICK_WALL);
                        entries.add(HCColouredBlocks.GREY_BRICKS);
                        entries.add(HCColouredBlocks.GREY_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.GREY_BRICK_SLAB);
                        entries.add(HCColouredBlocks.GREY_BRICK_WALL);
                        entries.add(HCColouredBlocks.BLACK_BRICKS);
                        entries.add(HCColouredBlocks.BLACK_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.BLACK_BRICK_SLAB);
                        entries.add(HCColouredBlocks.BLACK_BRICK_WALL);
                        entries.add(HCColouredBlocks.BROWN_BRICKS);
                        entries.add(HCColouredBlocks.BROWN_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.BROWN_BRICK_SLAB);
                        entries.add(HCColouredBlocks.BROWN_BRICK_WALL);
                        entries.add(HCColouredBlocks.RED_BRICKS);
                        entries.add(HCColouredBlocks.RED_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.RED_BRICK_SLAB);
                        entries.add(HCColouredBlocks.RED_BRICK_WALL);
                        entries.add(HCColouredBlocks.ORANGE_BRICKS);
                        entries.add(HCColouredBlocks.ORANGE_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.ORANGE_BRICK_SLAB);
                        entries.add(HCColouredBlocks.ORANGE_BRICK_WALL);
                        entries.add(HCColouredBlocks.YELLOW_BRICKS);
                        entries.add(HCColouredBlocks.YELLOW_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.YELLOW_BRICK_SLAB);
                        entries.add(HCColouredBlocks.YELLOW_BRICK_WALL);
                        entries.add(HCColouredBlocks.LIME_BRICKS);
                        entries.add(HCColouredBlocks.LIME_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.LIME_BRICK_SLAB);
                        entries.add(HCColouredBlocks.LIME_BRICK_WALL);
                        entries.add(HCColouredBlocks.GREEN_BRICKS);
                        entries.add(HCColouredBlocks.GREEN_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.GREEN_BRICK_SLAB);
                        entries.add(HCColouredBlocks.GREEN_BRICK_WALL);
                        entries.add(HCColouredBlocks.CYAN_BRICKS);
                        entries.add(HCColouredBlocks.CYAN_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.CYAN_BRICK_SLAB);
                        entries.add(HCColouredBlocks.CYAN_BRICK_WALL);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_BRICKS);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_BRICK_WALL);
                        entries.add(HCColouredBlocks.BLUE_BRICKS);
                        entries.add(HCColouredBlocks.BLUE_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.BLUE_BRICK_SLAB);
                        entries.add(HCColouredBlocks.BLUE_BRICK_WALL);
                        entries.add(HCColouredBlocks.PURPLE_BRICKS);
                        entries.add(HCColouredBlocks.PURPLE_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.PURPLE_BRICK_SLAB);
                        entries.add(HCColouredBlocks.PURPLE_BRICK_WALL);
                        entries.add(HCColouredBlocks.MAGENTA_BRICKS);
                        entries.add(HCColouredBlocks.MAGENTA_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.MAGENTA_BRICK_SLAB);
                        entries.add(HCColouredBlocks.MAGENTA_BRICK_WALL);
                        entries.add(HCColouredBlocks.PINK_BRICKS);
                        entries.add(HCColouredBlocks.PINK_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.PINK_BRICK_SLAB);
                        entries.add(HCColouredBlocks.PINK_BRICK_WALL);


                    }).build());

    public static final ItemGroup MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "99-misc"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.misc"))
                    .icon(() -> new ItemStack(HCItems.GREEN_RUPEE)).entries((displayContext, entries) -> {
                        entries.add(HCItems.RUPEE_POUCH);
                        entries.add(HCItems.GREEN_RUPEE);
                        entries.add(HCItems.BLUE_RUPEE);
                        entries.add(HCItems.YELLOW_RUPEE);
                        entries.add(HCItems.RED_RUPEE);
                        entries.add(HCItems.PURPLE_RUPEE);
                        entries.add(HCItems.ORANGE_RUPEE);
                        entries.add(HCItems.SILVER_RUPEE);
                        entries.add(HCItems.GOLD_RUPEE);
                        entries.add(HCItems.PUMPKIN_SOUP);
                    }).build());

    public static void registerHCItemGroups() {
        HyliaCraft.LOGGER.info("Registering Item Groups for " + HyliaCraft.MOD_ID);
    }
}