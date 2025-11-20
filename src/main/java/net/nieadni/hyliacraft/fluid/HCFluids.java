package net.nieadni.hyliacraft.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCFluids extends Fluids {

    public static final FlowableFluid FLOWING_SPRING_WATER = register("flowing_spring_water", new SpringWaterFluid.Flowing());
    public static final FlowableFluid SPRING_WATER = register("spring_water", new SpringWaterFluid.Still());
    public static final FlowableFluid FLOWING_TOXIC_WATER = register("flowing_toxic_water", new ToxicWaterFluid.Flowing());
    public static final FlowableFluid TOXIC_WATER = register("toxic_water", new ToxicWaterFluid.Still());
    public static final FlowableFluid FLOWING_MUDDY_WATER = register("flowing_muddy_water", new MuddyWaterFluid.Flowing());
    public static final FlowableFluid MUDDY_WATER = register("muddy_water", new MuddyWaterFluid.Still());

    public static void registerHCFluids() {
        HyliaCraft.LOGGER.info("Registering Mod Fluids for " + HyliaCraft.MOD_ID);
    }

    private static <T extends Fluid> T register(String id, T value) {
        return (T)(Registry.register(Registries.FLUID, Identifier.of(HyliaCraft.MOD_ID, id), value));
    }

}
