package net.nieadni.hyliacraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import net.nieadni.hyliacraft.data.HCLootTables;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.item.*;
import net.nieadni.hyliacraft.item.HCItemTags;

import net.nieadni.hyliacraft.worldgen.HCBiomeModifier;
import org.slf4j.*;

public class HyliaCraft implements ModInitializer {

	public static final String MOD_ID = "hyliacraft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {

		HyliaCraft.LOGGER.info("HyliaCraft has been initialized!");
		HCFoodComponents.registerHCFoodComponents();
		HCItemGroups.registerHCItemGroups();
		HCItems.registerHCItems();
		HCBlocks.registerHCBlocks();
		HCColouredBlocks.registerHCColouredBlocks();
		HCArmourMaterials.registerHCArmourMaterials();
		HCItemTags.registerHCItemTags();
		HCBlockTags.registerHCBlockTags();
		HCBlockEntityType.registerHCBlockEntities();
		HCEntities.registerHyliaCraftEntities();
		HCLootTables.registerHyliaCraftLootTables();
		//BlockEntityRendererFactories.register(IRON_CHEST_ENTITY, IronChestBlockEntityRenderer::new);
		HCBiomeModifier.load();

		// Loot Stuff

			LootTableEvents.MODIFY.register((key, tableBuilder, source, idfk) -> {
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