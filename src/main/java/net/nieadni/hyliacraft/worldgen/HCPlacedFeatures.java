package net.nieadni.hyliacraft.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.List;

public class HCPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ARMORANTH_KEY = registerKey("armoranth");
    public static final RegistryKey<PlacedFeature> ARMORANTH_PATCH_KEY = registerKey("armoranth_patch");
    public static final RegistryKey<PlacedFeature> BLUE_NIGHTSHADE_KEY = registerKey("blue_nightshade");
    public static final RegistryKey<PlacedFeature> BLUE_NIGHTSHADE_PATCH_KEY = registerKey("blue_nightshade_patch");
    public static final RegistryKey<PlacedFeature> SILENT_PRINCESS_KEY = registerKey("silent_princess");
    public static final RegistryKey<PlacedFeature> SILENT_PRINCESS_PATCH_KEY = registerKey("silent_princess_patch");
    public static final RegistryKey<PlacedFeature> SWIFT_VIOLETS_KEY = registerKey("swift_violets");
    public static final RegistryKey<PlacedFeature> SWIFT_VIOLETS_PATCH_KEY = registerKey("swift_violets_patch");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ARMORANTH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.ARMORANTH_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));
        register(context, BLUE_NIGHTSHADE_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.BLUE_NIGHTSHADE_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));
        register(context, SILENT_PRINCESS_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.SILENT_PRINCESS_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));
        register(context, SWIFT_VIOLETS_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.SWIFT_VIOLETS_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, ARMORANTH_PATCH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.ARMORANTH_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(64),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));
        register(context, BLUE_NIGHTSHADE_PATCH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.BLUE_NIGHTSHADE_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(64),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));
        register(context, SILENT_PRINCESS_PATCH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.SILENT_PRINCESS_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(64),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));
        register(context, SWIFT_VIOLETS_PATCH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.SWIFT_VIOLETS_PATCH_KEY),
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

}