package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
}
