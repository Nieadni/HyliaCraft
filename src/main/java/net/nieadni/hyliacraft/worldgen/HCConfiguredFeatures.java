package net.nieadni.hyliacraft.worldgen;

public class HCConfiguredFeatures {

    /**

    public static final RegistryKey<ConfiguredFeature<?, ?>> ARMORANTH_KEY = registerKey("armoranth");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARMORANTH_PATCH_KEY = registerKey("armoranth_patch");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        register(context, ARMORANTH_PATCH_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(HCBlocks.ARMORANTH)));

        register(context, ARMORANTH_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        64,  // Number of tries
                        10,    // X and Z Spread
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
        //context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }

    **/
}