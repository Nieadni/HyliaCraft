package net.nieadni.hyliacraft.fluid;

import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCFluids extends Fluids {

    public static final FlowableFluid FLOWING_SPRING_WATER = register("flowing_spring_water", new SpringWaterFluid.Flowing());
    public static final FlowableFluid SPRING_WATER = register("spring_water", new SpringWaterFluid.Still());

    public static void registerHCFluids() {
        HyliaCraft.LOGGER.info("Registering Mod Fluids for " + HyliaCraft.MOD_ID);
    }

    private static <T extends Fluid> T register(String id, T value) {
        return (T)(Registry.register(Registries.FLUID, id, value));
    }

    static {
        for(Fluid fluid : Registries.FLUID) {
            UnmodifiableIterator var2 = fluid.getStateManager().getStates().iterator();

            while(var2.hasNext()) {
                FluidState fluidState = (FluidState)var2.next();
                Fluid.STATE_IDS.add(fluidState);
            }
        }

    }

}
