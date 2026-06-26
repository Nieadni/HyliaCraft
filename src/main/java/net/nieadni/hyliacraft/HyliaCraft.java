package net.nieadni.hyliacraft;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.util.TriState;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantments;
import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.serialize.ConstantArgumentSerializer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.data.HCLootTables;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.item.*;
import net.nieadni.hyliacraft.util.VanillaLootTableModifiers;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.network.*;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import net.nieadni.hyliacraft.race.RaceArgumentType;
import net.nieadni.hyliacraft.worldgen.HCBiomeModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.nieadni.hyliacraft.worldgen.HCBiomeTags;
import org.slf4j.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HyliaCraft implements ModInitializer {

	public static final String MOD_ID = "hyliacraft";
	//public static final String VERSION = "alpha-1.0.4";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		HyliaCraft.LOGGER.info("HyliaCraft has been initialised!");
		HCFoodComponents.registerHCFoodComponents();
		HCItemGroups.registerHCItemGroups();
		HCItems.registerHCItems();
		HCBlocks.registerHCBlocks();
		HCArmourMaterials.registerHCArmourMaterials();
		HCItemTags.registerHCItemTags();
		HCBlockTags.registerHCBlockTags();
		HCEntities.registerHyliaCraftEntities();
		HCLootTables.registerHyliaCraftLootTables();
		HCBiomeModifier.load();
        VanillaLootTableModifiers.modifyLootTables();

        // Register custom payloads
        PayloadTypeRegistry.playS2C().register(RaceS2CPayload.ID, RaceS2CPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(RaceC2SPayload.ID, RaceC2SPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(RaceAbilityC2SPayload.ID, RaceAbilityC2SPayload.CODEC);
		PayloadTypeRegistry.playS2C().register(InvisibleS2CPayload.ID, InvisibleS2CPayload.CODEC);

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

        // Register packet receiver for the race ability payload
        ServerPlayNetworking.registerGlobalReceiver(RaceAbilityC2SPayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            HyliaCraftRace race = HyliaCraftRace.getRace(player);
            if (race != null) {
                race.useRaceAbility(player);
            }
        });
		
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(server);
			ServerPlayerEntity joiner = handler.getPlayer();
			UUID uuid = joiner.getUuid();
			// Send the player's current race (null if they haven't chosen one yet)
            HyliaCraftRace race = state.getOrCreateRace(uuid);
            ServerPlayNetworking.send(joiner, new RaceS2CPayload(race));
			if (race == HyliaCraftRace.MOGMA) HyliaCraftRace.MOGMA_DIRT_WALKING_ENABLED.put(uuid, false);
			// Send the invisibility overrides to this player
            Map<Integer, Boolean> isInvisible = new HashMap<>();
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				isInvisible.put(player.getId(), !state.numTargeters.containsKey(player.getUuid()) && HyliaCraftRace.getRace(player) == HyliaCraftRace.KOKIRI);
			}
			boolean isJoinerInvisible = !state.numTargeters.containsKey(uuid) && HyliaCraftRace.getRace(joiner) == HyliaCraftRace.KOKIRI;
	        isInvisible.put(joiner.getId(), isJoinerInvisible);
			ServerPlayNetworking.send(joiner, new InvisibleS2CPayload(isInvisible));
			// Send this player's invisibility status to other players
			NetworkUtils.broadcast(server, new InvisibleS2CPayload(joiner.getId(), isJoinerInvisible));
        });
		
		ServerTickEvents.END_SERVER_TICK.register(server -> {
            // Check which biomes everyone's in
			Map<Integer, Boolean> updates = new HashMap<>();
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				int id = player.getId();
				boolean isInBiome = player.getWorld().getBiome(player.getBlockPos()).isIn(HCBiomeTags.KOKIRI_INVISIBLE);
				if (isInBiome != HyliaCraftRace.WAS_IN_INVISIBLE_BIOME.getOrDefault(id, false)) {
					updates.put(id, isInBiome && HyliaCraftRace.checkKokiriInvisible(true, false, true, true, player));
				}
				HyliaCraftRace.WAS_IN_INVISIBLE_BIOME.put(id, isInBiome);
			}
			if (!updates.isEmpty()) {
				NetworkUtils.broadcast(server, new InvisibleS2CPayload(updates));
			}
        });

        // Register race argument type
        ArgumentTypeRegistry.registerArgumentType(
                Identifier.of(HyliaCraft.MOD_ID, "race"),
                RaceArgumentType.class,
                ConstantArgumentSerializer.of(RaceArgumentType::new)
        );

        // Command
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("hyliacraft").requires(source -> source.hasPermissionLevel(2)).then(
							CommandManager.literal("race").then(
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
					)
            );
        }));

		EnchantmentEvents.ALLOW_ENCHANTING.register((enchantment, target, context) -> {
			if (target.isIn(HCItemTags.SHORT_WEAPON) && enchantment.matchesKey(Enchantments.SWEEPING_EDGE)) {return TriState.FALSE;}
			if (target.isOf(HCItems.ONE_HIT_OBLITERATOR) && enchantment.matchesKey(Enchantments.WIND_BURST)) {return TriState.TRUE;}
			return TriState.DEFAULT;
		});
		// Thank you TurtyWurty for the code above
		// This only works in Survival. If you want to test it, you need to be in Survival Mode lol as Creative overrides this.

	}

	public static boolean isClientPlayerSpectator() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			MinecraftClient client = MinecraftClient.getInstance();
			if (client != null) {
				ClientPlayerEntity player = client.player;
				if (player != null && player.isSpectator()) {
                    return true;
                }
			}
		}
		return false;
	}
}