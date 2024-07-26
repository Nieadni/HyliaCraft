package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.nieadni.hyliacraft.worldgen.HCConfiguredFeatures;
import net.nieadni.hyliacraft.worldgen.HCPlacedFeatures;

public class DataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(HCBlockLootProvider::new);
		pack.addProvider(HCItemTagProvider::new);
		pack.addProvider(HCLanguageProvider::new);
		pack.addProvider(HCModelProvider::new);
		pack.addProvider(HCRecipeProvider::new);
		pack.addProvider(HCBlockTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		//registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, HCConfiguredFeatures::bootstrap);
		//registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, HCPlacedFeatures::bootstrap);
	}
}
