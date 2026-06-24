package net.nieadni.hyliacraft.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;

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
    public static final RegistryKey<PlacedFeature> BOMB_FLOWER_KEY = registerKey("bomb_flower");
    public static final RegistryKey<PlacedFeature> BOMB_FLOWER_PATCH_KEY = registerKey("bomb_flower_patch");

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
        register(context, BOMB_FLOWER_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.BOMB_FLOWER_KEY),
                List.of(
                        BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(HCBlocks.BOMB_FLOWER.getDefaultState(), BlockPos.ORIGIN)),
                        EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
                        RandomOffsetPlacementModifier.of(ConstantIntProvider.create(0), ConstantIntProvider.create(1))
                ));


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
        register(context, BOMB_FLOWER_PATCH_KEY, registryLookup.getOrThrow(HCConfiguredFeatures.BOMB_FLOWER_PATCH_KEY),
                List.of(
                        CountPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(48)),
                        BiomePlacementModifier.of()
                ));
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