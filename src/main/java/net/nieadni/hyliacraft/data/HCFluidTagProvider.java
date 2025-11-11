package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import net.nieadni.hyliacraft.fluid.HCFluids;

import java.util.concurrent.CompletableFuture;

public class HCFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public HCFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(FluidTags.WATER).add(HCFluids.SPRING_WATER).add(HCFluids.FLOWING_SPRING_WATER);
    }
}
