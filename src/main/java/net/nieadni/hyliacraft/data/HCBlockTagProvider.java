package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nieadni.hyliacraft.block.HCBlocks;

import java.util.concurrent.CompletableFuture;

public class HCBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public HCBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.ARMORANTH);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.ARMORANTH_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.BLUE_NIGHTSHADE);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.BLUE_NIGHTSHADE_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.SILENT_PRINCESS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.SILENT_PRINCESS_POT);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(HCBlocks.SWIFT_VIOLETS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HCBlocks.SWIFT_VIOLETS_POT);

    }
}
