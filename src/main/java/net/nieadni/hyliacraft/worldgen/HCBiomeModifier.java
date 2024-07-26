package net.nieadni.hyliacraft.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class HCBiomeModifier {

    public static void load() {

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                HCPlacedFeatures.ARMORANTH_PATCH_KEY
        );

    }
}
