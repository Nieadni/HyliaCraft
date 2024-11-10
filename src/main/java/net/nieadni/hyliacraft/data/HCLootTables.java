package net.nieadni.hyliacraft.data;

import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCLootTables extends LootTables {

    public static RegistryKey<LootTable> MORSHU_SHOP;

    public static RegistryKey<LootTable> register(String name) {
        return LootTables.registerLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, (Identifier.of(HyliaCraft.MOD_ID,(name)))));
    }

    static {
        MORSHU_SHOP = register("chests/morshu_shop");
    }

    public static void registerHyliaCraftLootTables() {
        HyliaCraft.LOGGER.info(HyliaCraft.MOD_ID + " has registered its Chest Loot Tables");
    }

}