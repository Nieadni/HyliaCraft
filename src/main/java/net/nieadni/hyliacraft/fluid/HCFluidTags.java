package net.nieadni.hyliacraft.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCFluidTags {

    public static final TagKey<Fluid> SPRING_WATER = TagKey.of(RegistryKeys.FLUID, new Identifier(HyliaCraft.MOD_ID, "spring_water"));

    public static void registerHCFluidTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its fluid tags.");
    }

}
