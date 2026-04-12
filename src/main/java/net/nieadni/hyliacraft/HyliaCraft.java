package net.nieadni.hyliacraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.enchantment.Enchantments;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import net.nieadni.hyliacraft.data.HCLootTables;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.item.*;
import net.nieadni.hyliacraft.util.VanillaLootTableModifiers;
import net.nieadni.hyliacraft.worldgen.HCBiomeModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		HCBlockEntityType.registerHCBlockEntities();
		HCEntities.registerHyliaCraftEntities();
		HCLootTables.registerHyliaCraftLootTables();
		HCBiomeModifier.load();
        VanillaLootTableModifiers.modifyLootTables();

		EnchantmentEvents.ALLOW_ENCHANTING.register((enchantment, target, context) -> {
			if (target.isIn(HCItemTags.SHORT_SWORD) && enchantment.matchesKey(Enchantments.SWEEPING_EDGE)) {
				return TriState.FALSE;
			}
			return TriState.DEFAULT;
		});
		// Thank you TurtyWurty for the code above
		// This only works in Survival. If you want to test it, you need to be in Survival Mode lol as Creative overrides this.

	}
}