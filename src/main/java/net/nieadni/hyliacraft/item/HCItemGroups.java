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

public class HCItemGroups {

    public static final ItemGroup GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "01-gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.gear"))
                    .icon(() -> new ItemStack(HCItems.GODDESS_SWORD)).entries((displayContext, entries) -> {

                        entries.add(HCItems.MAJORAS_MASK);
                        entries.add(HCItems.MIDNA_HELM);
                        entries.add(HCItems.PUMPKIN_MASK);
                        entries.add(HCItems.PHRYGIAN_CAP);
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
                        //entries.add(HCItems.GALE_BOOMERANG);

                        entries.add(HCItems.GODDESS_SWORD);
                        entries.add(HCItems.GODDESS_LONGSWORD);
                        entries.add(HCItems.GODDESS_WHITE_SWORD);
                        entries.add(HCItems.MASTER_SWORD);
                        entries.add(HCItems.TRUE_MASTER_SWORD);
                        entries.add(HCItems.BOULDER_BREAKER);
                        entries.add(HCItems.DOUBLE_HELIX_SWORD);
                        entries.add(HCItems.ONE_HIT_OBLITERATOR);

                        entries.add(HCItems.DIGGING_MITT);
                        entries.add(HCItems.MOGMA_MITT);
                        entries.add(HCItems.VICIOUS_SICKLE);

                        entries.add(HCItems.HORSE_CALL);
                        entries.add(HCItems.PARAGLIDER);

                    }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "02-blocks"),
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

                        entries.add(HCBlocks.WHITE_SHINGLES);
                        entries.add(HCBlocks.WHITE_SHINGLE_STAIRS);
                        entries.add(HCBlocks.WHITE_SHINGLE_SLAB);
                        entries.add(HCBlocks.WHITE_SHINGLE_WALL);
                        entries.add(HCBlocks.LIGHT_GRAY_SHINGLES);
                        entries.add(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS);
                        entries.add(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB);
                        entries.add(HCBlocks.LIGHT_GRAY_SHINGLE_WALL);
                        entries.add(HCBlocks.GRAY_SHINGLES);
                        entries.add(HCBlocks.GRAY_SHINGLE_STAIRS);
                        entries.add(HCBlocks.GRAY_SHINGLE_SLAB);
                        entries.add(HCBlocks.GRAY_SHINGLE_WALL);
                        entries.add(HCBlocks.BLACK_SHINGLES);
                        entries.add(HCBlocks.BLACK_SHINGLE_STAIRS);
                        entries.add(HCBlocks.BLACK_SHINGLE_SLAB);
                        entries.add(HCBlocks.BLACK_SHINGLE_WALL);
                        entries.add(HCBlocks.BROWN_SHINGLES);
                        entries.add(HCBlocks.BROWN_SHINGLE_STAIRS);
                        entries.add(HCBlocks.BROWN_SHINGLE_SLAB);
                        entries.add(HCBlocks.BROWN_SHINGLE_WALL);
                        entries.add(HCBlocks.RED_SHINGLES);
                        entries.add(HCBlocks.RED_SHINGLE_STAIRS);
                        entries.add(HCBlocks.RED_SHINGLE_SLAB);
                        entries.add(HCBlocks.RED_SHINGLE_WALL);
                        entries.add(HCBlocks.ORANGE_SHINGLES);
                        entries.add(HCBlocks.ORANGE_SHINGLE_STAIRS);
                        entries.add(HCBlocks.ORANGE_SHINGLE_SLAB);
                        entries.add(HCBlocks.ORANGE_SHINGLE_WALL);
                        entries.add(HCBlocks.YELLOW_SHINGLES);
                        entries.add(HCBlocks.YELLOW_SHINGLE_STAIRS);
                        entries.add(HCBlocks.YELLOW_SHINGLE_SLAB);
                        entries.add(HCBlocks.YELLOW_SHINGLE_WALL);
                        entries.add(HCBlocks.LIME_SHINGLES);
                        entries.add(HCBlocks.LIME_SHINGLE_STAIRS);
                        entries.add(HCBlocks.LIME_SHINGLE_SLAB);
                        entries.add(HCBlocks.LIME_SHINGLE_WALL);
                        entries.add(HCBlocks.GREEN_SHINGLES);
                        entries.add(HCBlocks.GREEN_SHINGLE_STAIRS);
                        entries.add(HCBlocks.GREEN_SHINGLE_SLAB);
                        entries.add(HCBlocks.GREEN_SHINGLE_WALL);
                        entries.add(HCBlocks.CYAN_SHINGLES);
                        entries.add(HCBlocks.CYAN_SHINGLE_STAIRS);
                        entries.add(HCBlocks.CYAN_SHINGLE_SLAB);
                        entries.add(HCBlocks.CYAN_SHINGLE_WALL);
                        entries.add(HCBlocks.LIGHT_BLUE_SHINGLES);
                        entries.add(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS);
                        entries.add(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB);
                        entries.add(HCBlocks.LIGHT_BLUE_SHINGLE_WALL);
                        entries.add(HCBlocks.BLUE_SHINGLES);
                        entries.add(HCBlocks.BLUE_SHINGLE_STAIRS);
                        entries.add(HCBlocks.BLUE_SHINGLE_SLAB);
                        entries.add(HCBlocks.BLUE_SHINGLE_WALL);
                        entries.add(HCBlocks.PURPLE_SHINGLES);
                        entries.add(HCBlocks.PURPLE_SHINGLE_STAIRS);
                        entries.add(HCBlocks.PURPLE_SHINGLE_SLAB);
                        entries.add(HCBlocks.PURPLE_SHINGLE_WALL);
                        entries.add(HCBlocks.MAGENTA_SHINGLES);
                        entries.add(HCBlocks.MAGENTA_SHINGLE_STAIRS);
                        entries.add(HCBlocks.MAGENTA_SHINGLE_SLAB);
                        entries.add(HCBlocks.MAGENTA_SHINGLE_WALL);
                        entries.add(HCBlocks.PINK_SHINGLES);
                        entries.add(HCBlocks.PINK_SHINGLE_STAIRS);
                        entries.add(HCBlocks.PINK_SHINGLE_SLAB);
                        entries.add(HCBlocks.PINK_SHINGLE_WALL);

                    }).build());

    public static final ItemGroup CONSUMABLES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "03-consumables"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.consumables"))
                    .icon(() -> new ItemStack(HCItems.BANANA)).entries((displayContext, entries) -> {
                        entries.add(HCItems.BANANA);
                        entries.add(HCItems.PUMPKIN_SOUP);
                        entries.add(HCItems.GOAT_MILK_BUCKET);
                        entries.add(HCItems.GOAT_CHEESE);
                        entries.add(HCItems.SIMPLE_SOUP);
                        entries.add(HCItems.GOOD_SOUP);
                        entries.add(HCItems.SUPERB_SOUP);
                        entries.add(HCItems.DUBIOUS_FOOD);

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
                        entries.add(HCItems.FARORE_FLAME);
                        entries.add(HCItems.NAYRU_FLAME);
                        entries.add(HCItems.DIN_FLAME);
                        entries.add(HCItems.GORON_SPICE);
                        //entries.add(HCItems.FAIRY_BOTTLE);

                    }).build());

    public static void registerHCItemGroups() {
        HyliaCraft.LOGGER.info("Registering Item Groups for " + HyliaCraft.MOD_ID);
    }
}