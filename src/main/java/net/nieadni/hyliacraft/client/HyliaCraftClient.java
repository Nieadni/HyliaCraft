package net.nieadni.hyliacraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.render.RenderLayer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import net.nieadni.hyliacraft.block.entity.IronChestBlockEntityRenderer;

public class HyliaCraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), HCBlocks.ARMORANTH,
                HCBlocks.ARMORANTH_POT,
                HCBlocks.BLUE_NIGHTSHADE,
                HCBlocks.BLUE_NIGHTSHADE_POT,
                HCBlocks.SILENT_PRINCESS,
                HCBlocks.SILENT_PRINCESS_POT,
                HCBlocks.SWIFT_VIOLETS,
                HCBlocks.SWIFT_VIOLETS_POT,

                HCBlocks.NATURAL_BLUE_CLAY_POT,
                HCBlocks.NATURAL_CLAY_POT_WRITING,
                HCBlocks.NATURAL_CLAY_POT,
                HCBlocks.BLUE_CLAY_POT,
                HCBlocks.CLAY_POT_WRITING,
                HCBlocks.CLAY_POT,
                HCBlocks.HATENO_CLAY_POT
        );
        HCModelPredicates.registerHCModelPredicates();
        //BlockEntityRendererFactories.register(HCBlockEntityType.IRON_CHEST_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, IronChestBlockEntityRenderer::new);
        //TODO
    }
}