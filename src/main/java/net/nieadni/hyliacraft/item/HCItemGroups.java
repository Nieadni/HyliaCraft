package net.nieadni.hyliacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
                        entries.add(HCItems.PHRYGIAN_CAP_SS);
                        entries.add(HCItems.PHRYGIAN_CAP_TP);
                        entries.add(HCItems.PHRYGIAN_CAP_CLASSIC);
                        entries.add(HCItems.BUNNY_HOOD);
                        entries.add(HCItems.FIRESHIELD_EARRING);
                        entries.add(HCItems.WATER_DRAGON_SCALE);
                        entries.add(HCItems.SHADOW_CRYSTAL);

                        entries.add(HCItems.SLINGSHOT);
                        entries.add(HCItems.IRON_BOW);
                        entries.add(HCItems.FAIRY_BOW);
                        entries.add(HCItems.BOOMERANG);
                        entries.add(HCItems.GALE_BOOMERANG);

                        entries.add(HCItems.GODDESS_SWORD);
                        entries.add(HCItems.GODDESS_LONGSWORD);
                        entries.add(HCItems.GODDESS_WHITE_SWORD);
                        entries.add(HCItems.MASTER_SWORD);
                        entries.add(HCItems.TRUE_MASTER_SWORD);
                        entries.add(HCItems.BOULDER_BREAKER);

                        entries.add(HCItems.DIGGING_MITT);
                        entries.add(HCItems.MOGMA_MITT);

                        entries.add(HCItems.HORSE_CALL);
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

                        entries.add(HCBlocks.IRON_CHEST);

                    }).build());

    public static final ItemGroup COLOURED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "3-coloured_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.coloured_blocks"))
                    .icon(() -> new ItemStack(HCColouredBlocks.RAINBOW_BRICKS)).entries((displayContext, entries) -> {
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
                        entries.add(HCColouredBlocks.RAINBOW_BRICKS);
                        entries.add(HCColouredBlocks.RAINBOW_BRICK_STAIRS);
                        entries.add(HCColouredBlocks.RAINBOW_BRICK_SLAB);
                        entries.add(HCColouredBlocks.RAINBOW_BRICK_WALL);
                        entries.add(HCColouredBlocks.WHITE_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.WHITE_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.WHITE_PLANKS);
                        entries.add(HCColouredBlocks.WHITE_STAIRS);
                        entries.add(HCColouredBlocks.WHITE_SLAB);
                        entries.add(HCColouredBlocks.WHITE_FENCE);
                        entries.add(HCColouredBlocks.WHITE_FENCE_GATE);
                        entries.add(HCColouredBlocks.WHITE_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.WHITE_BUTTON);
                        entries.add(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.LIGHT_GREY_PLANKS);
                        entries.add(HCColouredBlocks.LIGHT_GREY_STAIRS);
                        entries.add(HCColouredBlocks.LIGHT_GREY_SLAB);
                        entries.add(HCColouredBlocks.LIGHT_GREY_FENCE);
                        entries.add(HCColouredBlocks.LIGHT_GREY_FENCE_GATE);
                        entries.add(HCColouredBlocks.LIGHT_GREY_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.LIGHT_GREY_BUTTON);
                        entries.add(HCColouredBlocks.GREY_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.GREY_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.GREY_PLANKS);
                        entries.add(HCColouredBlocks.GREY_STAIRS);
                        entries.add(HCColouredBlocks.GREY_SLAB);
                        entries.add(HCColouredBlocks.GREY_FENCE);
                        entries.add(HCColouredBlocks.GREY_FENCE_GATE);
                        entries.add(HCColouredBlocks.GREY_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.GREY_BUTTON);
                        entries.add(HCColouredBlocks.BLACK_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.BLACK_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.BLACK_PLANKS);
                        entries.add(HCColouredBlocks.BLACK_STAIRS);
                        entries.add(HCColouredBlocks.BLACK_SLAB);
                        entries.add(HCColouredBlocks.BLACK_FENCE);
                        entries.add(HCColouredBlocks.BLACK_FENCE_GATE);
                        entries.add(HCColouredBlocks.BLACK_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.BLACK_BUTTON);
                        entries.add(HCColouredBlocks.BROWN_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.BROWN_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.BROWN_PLANKS);
                        entries.add(HCColouredBlocks.BROWN_STAIRS);
                        entries.add(HCColouredBlocks.BROWN_SLAB);
                        entries.add(HCColouredBlocks.BROWN_FENCE);
                        entries.add(HCColouredBlocks.BROWN_FENCE_GATE);
                        entries.add(HCColouredBlocks.BROWN_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.BROWN_BUTTON);
                        entries.add(HCColouredBlocks.RED_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.RED_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.RED_PLANKS);
                        entries.add(HCColouredBlocks.RED_STAIRS);
                        entries.add(HCColouredBlocks.RED_SLAB);
                        entries.add(HCColouredBlocks.RED_FENCE);
                        entries.add(HCColouredBlocks.RED_FENCE_GATE);
                        entries.add(HCColouredBlocks.RED_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.RED_BUTTON);
                        entries.add(HCColouredBlocks.ORANGE_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.ORANGE_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.ORANGE_PLANKS);
                        entries.add(HCColouredBlocks.ORANGE_STAIRS);
                        entries.add(HCColouredBlocks.ORANGE_SLAB);
                        entries.add(HCColouredBlocks.ORANGE_FENCE);
                        entries.add(HCColouredBlocks.ORANGE_FENCE_GATE);
                        entries.add(HCColouredBlocks.ORANGE_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.ORANGE_BUTTON);
                        entries.add(HCColouredBlocks.YELLOW_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.YELLOW_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.YELLOW_PLANKS);
                        entries.add(HCColouredBlocks.YELLOW_STAIRS);
                        entries.add(HCColouredBlocks.YELLOW_SLAB);
                        entries.add(HCColouredBlocks.YELLOW_FENCE);
                        entries.add(HCColouredBlocks.YELLOW_FENCE_GATE);
                        entries.add(HCColouredBlocks.YELLOW_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.YELLOW_BUTTON);
                        entries.add(HCColouredBlocks.LIME_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.LIME_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.LIME_PLANKS);
                        entries.add(HCColouredBlocks.LIME_STAIRS);
                        entries.add(HCColouredBlocks.LIME_SLAB);
                        entries.add(HCColouredBlocks.LIME_FENCE);
                        entries.add(HCColouredBlocks.LIME_FENCE_GATE);
                        entries.add(HCColouredBlocks.LIME_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.LIME_BUTTON);
                        entries.add(HCColouredBlocks.GREEN_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.GREEN_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.GREEN_PLANKS);
                        entries.add(HCColouredBlocks.GREEN_STAIRS);
                        entries.add(HCColouredBlocks.GREEN_SLAB);
                        entries.add(HCColouredBlocks.GREEN_FENCE);
                        entries.add(HCColouredBlocks.GREEN_FENCE_GATE);
                        entries.add(HCColouredBlocks.GREEN_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.GREEN_BUTTON);
                        entries.add(HCColouredBlocks.CYAN_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.CYAN_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.CYAN_PLANKS);
                        entries.add(HCColouredBlocks.CYAN_STAIRS);
                        entries.add(HCColouredBlocks.CYAN_SLAB);
                        entries.add(HCColouredBlocks.CYAN_FENCE);
                        entries.add(HCColouredBlocks.CYAN_FENCE_GATE);
                        entries.add(HCColouredBlocks.CYAN_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.CYAN_BUTTON);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_PLANKS);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_STAIRS);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_SLAB);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_FENCE);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_FENCE_GATE);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.LIGHT_BLUE_BUTTON);
                        entries.add(HCColouredBlocks.BLUE_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.BLUE_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.BLUE_PLANKS);
                        entries.add(HCColouredBlocks.BLUE_STAIRS);
                        entries.add(HCColouredBlocks.BLUE_SLAB);
                        entries.add(HCColouredBlocks.BLUE_FENCE);
                        entries.add(HCColouredBlocks.BLUE_FENCE_GATE);
                        entries.add(HCColouredBlocks.BLUE_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.BLUE_BUTTON);
                        entries.add(HCColouredBlocks.PURPLE_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.PURPLE_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.PURPLE_PLANKS);
                        entries.add(HCColouredBlocks.PURPLE_STAIRS);
                        entries.add(HCColouredBlocks.PURPLE_SLAB);
                        entries.add(HCColouredBlocks.PURPLE_FENCE);
                        entries.add(HCColouredBlocks.PURPLE_FENCE_GATE);
                        entries.add(HCColouredBlocks.PURPLE_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.PURPLE_BUTTON);
                        entries.add(HCColouredBlocks.MAGENTA_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.MAGENTA_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.MAGENTA_PLANKS);
                        entries.add(HCColouredBlocks.MAGENTA_STAIRS);
                        entries.add(HCColouredBlocks.MAGENTA_SLAB);
                        entries.add(HCColouredBlocks.MAGENTA_FENCE);
                        entries.add(HCColouredBlocks.MAGENTA_FENCE_GATE);
                        entries.add(HCColouredBlocks.MAGENTA_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.MAGENTA_BUTTON);
                        entries.add(HCColouredBlocks.PINK_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.PINK_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.PINK_PLANKS);
                        entries.add(HCColouredBlocks.PINK_STAIRS);
                        entries.add(HCColouredBlocks.PINK_SLAB);
                        entries.add(HCColouredBlocks.PINK_FENCE);
                        entries.add(HCColouredBlocks.PINK_FENCE_GATE);
                        entries.add(HCColouredBlocks.PINK_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.PINK_BUTTON);
                        entries.add(HCColouredBlocks.RAINBOW_STRIPPED_LOG);
                        entries.add(HCColouredBlocks.RAINBOW_STRIPPED_WOOD);
                        entries.add(HCColouredBlocks.RAINBOW_PLANKS);
                        entries.add(HCColouredBlocks.RAINBOW_STAIRS);
                        entries.add(HCColouredBlocks.RAINBOW_SLAB);
                        entries.add(HCColouredBlocks.RAINBOW_FENCE);
                        entries.add(HCColouredBlocks.RAINBOW_FENCE_GATE);
                        entries.add(HCColouredBlocks.RAINBOW_PRESSURE_PLATE);
                        entries.add(HCColouredBlocks.RAINBOW_BUTTON);

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
                        entries.add(HCItems.DUBIOUS_FOOD);
                        entries.add(HCItems.FARORE_FLAME);
                        entries.add(HCItems.NAYRU_FLAME);
                        entries.add(HCItems.DIN_FLAME);
                        entries.add(HCItems.GORON_SPICE);
                        entries.add(HCItems.FAIRY_BOTTLE);

                    }).build());

    public static void registerHCItemGroups() {
        HyliaCraft.LOGGER.info("Registering Item Groups for " + HyliaCraft.MOD_ID);
    }
}