package net.nieadni.hyliacraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import net.minecraft.client.render.RenderLayer;

import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.entity.sword_beam_entity_renderers.*;

public class HyliaCraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                HCBlocks.ARMORANTH,
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
        // BlockEntityRendererFactories.register(HCBlockEntityType.IRON_CHEST_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, IronChestBlockEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.GODDESS_SWORD_BEAM, GoddessSwordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.GODDESS_LONGSWORD_BEAM, GoddessLongswordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.GODDESS_WHITE_SWORD_BEAM, GoddessWhiteSwordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.MASTER_SWORD_BEAM, MasterSwordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.TRUE_MASTER_SWORD_BEAM, TrueMasterSwordBeamEntityRenderer::new);
    }
}