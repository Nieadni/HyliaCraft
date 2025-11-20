package net.nieadni.hyliacraft;

import net.fabricmc.api.ModInitializer;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import net.nieadni.hyliacraft.data.HCLootTables;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.fluid.HCFluidTags;
import net.nieadni.hyliacraft.fluid.HCFluids;
import net.nieadni.hyliacraft.item.*;
import net.nieadni.hyliacraft.util.VanillaLootTableModifiers;
import net.nieadni.hyliacraft.worldgen.HCBiomeModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyliaCraft implements ModInitializer {

	public static final String MOD_ID = "hyliacraft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {

		HyliaCraft.LOGGER.info("HyliaCraft has been initialised!");
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
        VanillaLootTableModifiers.modifyLootTables();
        HCFluids.registerHCFluids();
        HCFluidTags.registerHCFluidTags();
	}
}