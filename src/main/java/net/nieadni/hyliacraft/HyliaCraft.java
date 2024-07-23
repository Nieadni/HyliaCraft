package net.nieadni.hyliacraft;

import net.fabricmc.api.ModInitializer;

import net.nieadni.hyliacraft.data.HCLanguageProvider;
import net.nieadni.hyliacraft.data.HCModelProvider;
import net.nieadni.hyliacraft.item.HCFoodComponents;
import net.nieadni.hyliacraft.item.HCItemGroup;
import net.nieadni.hyliacraft.item.HCItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyliaCraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "hyliacraft";
	public static final Logger LOGGER = LoggerFactory.getLogger("hyliacraft");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		HCItems.initialize();

		// Loggers to make sure main classes are working.
		HCItemGroup.registerItemGroups();
		HCItems.registerHCItems();
		HCFoodComponents.registerFoodComponents();
	}
}