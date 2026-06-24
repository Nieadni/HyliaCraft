package net.nieadni.hyliacraft.worldgen;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCBiomeTags {

    public static final TagKey<Biome> ARMORANTH = TagKey.of(RegistryKeys.BIOME, Identifier.of((HyliaCraft.MOD_ID), "armoranth"));
    public static final TagKey<Biome> BLUE_NIGHTSHADE = TagKey.of(RegistryKeys.BIOME, Identifier.of((HyliaCraft.MOD_ID), "blue_nightshade"));
    public static final TagKey<Biome> SILENT_PRINCESS = TagKey.of(RegistryKeys.BIOME, Identifier.of((HyliaCraft.MOD_ID), "silent_princess"));
    public static final TagKey<Biome> SWIFT_VIOLETS = TagKey.of(RegistryKeys.BIOME, Identifier.of((HyliaCraft.MOD_ID), "swift_violets"));


}
