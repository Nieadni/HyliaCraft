package net.nieadni.hyliacraft.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.nieadni.hyliacraft.item.HCItems;

public class VanillaLootTableModifiers {

    /**
    private static final Identifier ELDER_GUARDIAN_ID
            = Identifier.of("minecraft", "entities/elder_guardian");
    private static final Identifier WITHER_ID
            = Identifier.of("minecraft", "entities/wither");
    */

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, idfk) -> {

            if (source.isBuiltin() && LootTables.TRIAL_CHAMBER_ITEMS_TO_DROP_WHEN_OMINOUS_SPAWNER.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(HCItems.FARORE_FLAME).weight(1).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1))));
                tableBuilder.pool(poolBuilder);
            }

            //TODO: Need to find a way to get these to work
            // ^ Elder Guardian should drop 1 Nayru Flame when killed with the Goddess Longsword
            // ^ Wither should drop 1 Din Flame when killed with the Goddess White Sword

            /**
            if (source.isBuiltin() && ELDER_GUARDIAN_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(HCItems.GODDESS_LONGSWORD)))
                        .with(ItemEntry.builder(HCItems.NAYRU_FLAME).weight(1).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && WITHER_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(HCItems.GODDESS_WHITE_SWORD)))
                        .with(ItemEntry.builder(HCItems.DIN_FLAME).weight(1).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1))));
                tableBuilder.pool(poolBuilder);
            }
             */

            if (source.isBuiltin() && LootTables.ABANDONED_MINESHAFT_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(8).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.BURIED_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(8).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
                        .with(ItemEntry.builder(HCItems.SILVER_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))))
                        .with(ItemEntry.builder(HCItems.GOLD_RUPEE).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.SHIPWRECK_MAP_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.SHIPWRECK_SUPPLY_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.SHIPWRECK_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.UNDERWATER_RUIN_BIG_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.UNDERWATER_RUIN_SMALL_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.DESERT_PYRAMID_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.JUNGLE_TEMPLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.IGLOO_CHEST_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.PILLAGER_OUTPOST_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.WOODLAND_MANSION_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.SIMPLE_DUNGEON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.STRONGHOLD_CORRIDOR_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.STRONGHOLD_CROSSING_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.STRONGHOLD_LIBRARY_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.ANCIENT_CITY_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.ANCIENT_CITY_ICE_BOX_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 20))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.NETHER_BRIDGE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.BASTION_BRIDGE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 16))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 12))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.BASTION_HOGLIN_STABLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 16))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 12))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.BASTION_OTHER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.RED_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 16))))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 12))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.BASTION_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 12))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))))
                        .with(ItemEntry.builder(HCItems.SILVER_RUPEE).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.GOLD_RUPEE).weight(1).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.END_CITY_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.PURPLE_RUPEE).weight(10).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 8))))
                        .with(ItemEntry.builder(HCItems.ORANGE_RUPEE).weight(6).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_ARMORER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_BUTCHER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_CARTOGRAPHER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_DESERT_HOUSE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_FISHER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_FLETCHER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_MASON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_PLAINS_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_SHEPARD_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_SNOWY_HOUSE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_TAIGA_HOUSE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_TANNERY_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_TEMPLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_TOOLSMITH_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && LootTables.VILLAGE_WEAPONSMITH_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE).weight(24).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 20))))
                        .with(ItemEntry.builder(HCItems.BLUE_RUPEE).weight(16).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(HCItems.YELLOW_RUPEE).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))));
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
