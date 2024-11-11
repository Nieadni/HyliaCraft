package net.nieadni.hyliacraft.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class HCBiomeModifier {

    public static void load() {

        BiomeModifications.addFeature(
                BiomeSelectors.tag(HCBiomeTags.ARMORANTH),
                GenerationStep.Feature.VEGETAL_DECORATION,
                HCPlacedFeatures.ARMORANTH_PATCH_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(HCBiomeTags.BLUE_NIGHTSHADE),
                GenerationStep.Feature.VEGETAL_DECORATION,
                HCPlacedFeatures.BLUE_NIGHTSHADE_PATCH_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(HCBiomeTags.SILENT_PRINCESS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                HCPlacedFeatures.SILENT_PRINCESS_PATCH_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(HCBiomeTags.SWIFT_VIOLETS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                HCPlacedFeatures.SWIFT_VIOLETS_PATCH_KEY
        );

    }


}
