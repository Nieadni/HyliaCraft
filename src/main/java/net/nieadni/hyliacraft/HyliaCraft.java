package net.nieadni.hyliacraft;

import net.fabricmc.api.ModInitializer;

import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.*;

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
		HCArmourMaterials.registerHCArmourMaterials();
	}
}