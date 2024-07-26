package net.nieadni.hyliacraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.nieadni.hyliacraft.block.HCBlocks;

public class HyliaCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // For adding RenderLayers to custom blocks
        BlockRenderLayerMap.INSTANCE.putBlock(HCBlocks.CLAY_POT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HCBlocks.CLAY_POT_WRITING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HCBlocks.BLUE_CLAY_POT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HCBlocks.NATURAL_CLAY_POT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HCBlocks.NATURAL_CLAY_POT_WRITING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HCBlocks.NATURAL_BLUE_CLAY_POT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), HCBlocks.ARMORANTH, HCBlocks.ARMORANTH_POT);
    }

}
