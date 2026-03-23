package net.nieadni.hyliacraft.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCItemTags {

    public static final TagKey<Item> ENDERMASK = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "endermask"));

    public static final TagKey<Item> SICKLES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "sickles"));

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


    public static void registerHCItemTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its item tags.");
    }
}