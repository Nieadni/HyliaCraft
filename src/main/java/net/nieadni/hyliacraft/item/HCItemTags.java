package net.nieadni.hyliacraft.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCItemTags {

    public static final TagKey<Item> ENDERMASK = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "endermask"));

    public static final TagKey<Item> SICKLES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "sickles"));
    public static final TagKey<Item> SHORT_WEAPON = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "short_weapon"));

    public static final TagKey<Item> SLINGSHOT_AMMO = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "slingshot_ammo"));

    public static final TagKey<Item> MILK_BUCKETS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "milk_buckets"));

    public static final TagKey<Item> SHINGLES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "shingles"));
    public static final TagKey<Item> SHINGLE_STAIRS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "shingle_stairs"));
    public static final TagKey<Item> SHINGLE_SLABS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "shingle_slabs"));
    public static final TagKey<Item> SHINGLE_WALLS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "shingle_walls"));

    // These are only really for if someone has another Zelda mod installed alongside HC.
    public static final TagKey<Item> GREEN_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "green_rupees"));
    public static final TagKey<Item> BLUE_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "blue_rupees"));
    public static final TagKey<Item> YELLOW_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "yellow_rupees"));
    public static final TagKey<Item> RED_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "red_rupees"));
    public static final TagKey<Item> PURPLE_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "purple_rupees"));
    public static final TagKey<Item> ORANGE_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "orange_rupees"));
    public static final TagKey<Item> SILVER_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "silver_rupees"));
    public static final TagKey<Item> GOLD_RUPEES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "gold_rupees"));

    // For Dye Stuff. I did these so I dont need to add them as I go incase I ever add an item which also make another dye
    public static final TagKey<Item> WHITE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "white_dyes"));
    public static final TagKey<Item> LIGHT_GRAY_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "light_gray_dyes"));
    public static final TagKey<Item> GRAY_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "gray_dyes"));
    public static final TagKey<Item> BLACK_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "black_dyes"));
    public static final TagKey<Item> BROWN_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "brown_dyes"));
    public static final TagKey<Item> RED_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "red_dyes"));
    public static final TagKey<Item> ORANGE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "orange_dyes"));
    public static final TagKey<Item> YELLOW_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "yellow_dyes"));
    public static final TagKey<Item> LIME_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "lime_dyes"));
    public static final TagKey<Item> GREEN_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "green_dyes"));
    public static final TagKey<Item> CYAN_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "cyan_dyes"));
    public static final TagKey<Item> LIGHT_BLUE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "light_blue_dyes"));
    public static final TagKey<Item> BLUE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "blue_dyes"));
    public static final TagKey<Item> PURPLE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "purple_dyes"));
    public static final TagKey<Item> MAGENTA_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "magenta_dyes"));
    public static final TagKey<Item> PINK_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "pink_dyes"));

    public static final TagKey<Item> DOUBLE_WHITE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_white_dyes"));
    public static final TagKey<Item> DOUBLE_LIGHT_GRAY_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_light_gray_dyes"));
    public static final TagKey<Item> DOUBLE_GRAY_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_gray_dyes"));
    public static final TagKey<Item> DOUBLE_BLACK_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_black_dyes"));
    public static final TagKey<Item> DOUBLE_BROWN_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_brown_dyes"));
    public static final TagKey<Item> DOUBLE_RED_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_red_dyes"));
    public static final TagKey<Item> DOUBLE_ORANGE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_orange_dyes"));
    public static final TagKey<Item> DOUBLE_YELLOW_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_yellow_dyes"));
    public static final TagKey<Item> DOUBLE_LIME_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_lime_dyes"));
    public static final TagKey<Item> DOUBLE_GREEN_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_green_dyes"));
    public static final TagKey<Item> DOUBLE_CYAN_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_cyan_dyes"));
    public static final TagKey<Item> DOUBLE_LIGHT_BLUE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_light_blue_dyes"));
    public static final TagKey<Item> DOUBLE_BLUE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_blue_dyes"));
    public static final TagKey<Item> DOUBLE_PURPLE_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_purple_dyes"));
    public static final TagKey<Item> DOUBLE_MAGENTA_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_magenta_dyes"));
    public static final TagKey<Item> DOUBLE_PINK_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "double_pink_dyes"));

    public static void registerHCItemTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its item tags.");
    }
}