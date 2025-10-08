package net.nieadni.hyliacraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.serialize.ConstantArgumentSerializer;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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

import java.util.UUID;

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
		HCBiomeModifier.load();

        // Register custom payloads race choosing
        PayloadTypeRegistry.playS2C().register(RaceS2CPayload.ID, RaceS2CPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(RaceC2SPayload.ID, RaceC2SPayload.CODEC);

        // Register packet receiver for the choose race payload
        ServerPlayNetworking.registerGlobalReceiver(RaceC2SPayload.ID, (payload, context) -> {
            HyliaCraftRace race = payload.chosenRace();
            ServerPlayerEntity player = context.player();
            if (HyliaCraftRace.getRace(player) == null) {
                HyliaCraftRace.setRace(player, race, false);
            } else {
                HyliaCraft.LOGGER.info("Rejected packet from {}; race already set", player.getUuidAsString());
            }
        });

        // When a player joins the server, we check whether they've already chosen a race.
        // If they haven't, we prompt them to choose one.
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(server);

            // Check if the player already has a race
            ServerPlayerEntity player = handler.getPlayer();
            UUID uuid = player.getUuid();
            HyliaCraftPersistentState.PlayerData data = state.getOrCreatePlayerData(uuid);
            ServerPlayNetworking.send(player, new RaceS2CPayload(data.race));
        });

        // Register race argument type
        ArgumentTypeRegistry.registerArgumentType(
                Identifier.of(HyliaCraft.MOD_ID, "race"),
                RaceArgumentType.class,
                ConstantArgumentSerializer.of(RaceArgumentType::new)
        );

        // Command to manage races
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("hc_race").then(
                            CommandManager.literal("get").then(
                                    CommandManager.argument("player", EntityArgumentType.player()).executes(
                                            context -> {
                                                ServerCommandSource source = context.getSource();
                                                ServerPlayerEntity player = context.getArgument("player", EntitySelector.class).getPlayer(source);
                                                HyliaCraftRace race = HyliaCraftRace.getRace(player);

                                                // Send feedback
                                                Text raceText = race != null
                                                        ? race.getName()
                                                        : Text.literal("null");
                                                source.sendFeedback(() -> Text.translatable(
                                                        "hyliacraft.race.query",
                                                        player.getName(),
                                                        raceText
                                                ), false);
                                                return 1;
                                            }
                                    )
                            )
                    ).then(
                            CommandManager.literal("set").then(
                                    CommandManager.argument("player", EntityArgumentType.player()).then(
                                            CommandManager.argument("race", new RaceArgumentType()).executes(
                                                    context -> {
                                                        ServerCommandSource source = context.getSource();
                                                        ServerPlayerEntity player = context.getArgument("player", EntitySelector.class).getPlayer(source);
                                                        HyliaCraftRace race = context.getArgument("race", HyliaCraftRace.class);
                                                        HyliaCraftRace.setRace(player, race, true);

                                                        // Send feedback
                                                        source.sendFeedback(() -> Text.translatable(
                                                                "hyliacraft.race.set",
                                                                player.getName(),
                                                                race.getName()
                                                        ), true);
                                                        return 1;
                                                    }
                                            )
                                    )
                            )
                    )
            );
        }));

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