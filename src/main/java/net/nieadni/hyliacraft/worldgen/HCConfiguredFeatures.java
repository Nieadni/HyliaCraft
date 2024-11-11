package net.nieadni.hyliacraft.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;

public class HCConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ARMORANTH_KEY = registerKey("armoranth");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARMORANTH_PATCH_KEY = registerKey("armoranth_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_NIGHTSHADE_KEY = registerKey("blue_nightshade");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_NIGHTSHADE_PATCH_KEY = registerKey("blue_nightshade_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILENT_PRINCESS_KEY = registerKey("silent_princess");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILENT_PRINCESS_PATCH_KEY = registerKey("silent_princess_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWIFT_VIOLETS_KEY = registerKey("swift_violets");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWIFT_VIOLETS_PATCH_KEY = registerKey("swift_violets_patch");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        register(context, ARMORANTH_PATCH_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(HCBlocks.ARMORANTH)));
        register(context, BLUE_NIGHTSHADE_PATCH_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(HCBlocks.BLUE_NIGHTSHADE)));
        register(context, SILENT_PRINCESS_PATCH_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(HCBlocks.SILENT_PRINCESS)));
        register(context, SWIFT_VIOLETS_PATCH_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(HCBlocks.SWIFT_VIOLETS)));

        register(context, ARMORANTH_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        48,  // Number of tries
                        10,    // X and Z Spread
                        4,     // Y Spread
                        registryLookup.getOrThrow(HCPlacedFeatures.ARMORANTH_KEY)));
        register(context, BLUE_NIGHTSHADE_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        48,  // Number of tries
                        10,    // X and Z Spread
                        4,     // Y Spread
                        registryLookup.getOrThrow(HCPlacedFeatures.ARMORANTH_KEY)));
        register(context, SILENT_PRINCESS_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        32,  // Number of tries
                        4,    // X and Z Spread
                        4,     // Y Spread
                        registryLookup.getOrThrow(HCPlacedFeatures.ARMORANTH_KEY)));
        register(context, SWIFT_VIOLETS_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        48,  // Number of tries
                        8,    // X and Z Spread
                        4,     // Y Spread
                        registryLookup.getOrThrow(HCPlacedFeatures.ARMORANTH_KEY)));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(HyliaCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature,
                                                                                   FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }

}