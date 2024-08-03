package net.nieadni.hyliacraft.worldgen;

public class HCPlacedFeatures {

    /**

    public static final RegistryKey<PlacedFeature> ARMORANTH_KEY = registerKey("armoranth");
    public static final RegistryKey<PlacedFeature> ARMORANTH_PATCH_KEY = registerKey("armoranth_patch");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ARMORANTH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.ARMORANTH_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, ARMORANTH_PATCH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.ARMORANTH_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(64),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(HyliaCraft.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    public static class Modifiers {
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        public static List<PlacementModifier> modifiersCount(int count, PlacementModifier heightModifier) {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        public static List<PlacementModifier> modifiersRarity(int chance, PlacementModifier heightModifier) {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
        }
    }

     **/
}