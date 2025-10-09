package net.nieadni.hyliacraft.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCItemTags {

    public static final TagKey<Item> ENDERMASK = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "endermask"));

    public static final TagKey<Item> SLINGSHOT_AMMO = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "slingshot_ammo"));

    public static final TagKey<Item> BRICKS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "bricks"));
    public static final TagKey<Item> BRICK_STAIRS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "brick_stairs"));
    public static final TagKey<Item> BRICK_SLABS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "brick_slabs"));
    public static final TagKey<Item> BRICK_WALLS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "brick_walls"));
    public static final TagKey<Item> PLANKS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "planks"));
    public static final TagKey<Item> STRIPPED_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "stripped_logs"));
    public static final TagKey<Item> STRIPPED_WOODS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "stripped_woods"));
    public static final TagKey<Item> PLANK_STAIRS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "plank_stairs"));
    public static final TagKey<Item> PLANK_SLABS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "plank_slabs"));
    public static final TagKey<Item> PLANK_FENCES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "plank_fences"));
    public static final TagKey<Item> PLANK_FENCE_GATES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "plank_fence_gates"));
    public static final TagKey<Item> PLANK_PRESSURE_PLATES = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "plank_pressure_plates"));
    public static final TagKey<Item> PLANK_BUTTONS = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "plank_buttons"));

    public static final TagKey<Item> GORON_EDIBLE = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "goron_edible"));

    public static void registerHCItemTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its item tags.");
    }
}