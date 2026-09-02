package net.nieadni.hyliacraft.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.HappyMaskSalesmanEntity;

/**
 * Draws the Happy Mask Salesman on the vanilla player model.
 *
 * <p>{@link PlayerEntityModel} is generic over {@link net.minecraft.entity.LivingEntity} rather than over
 * players, so it takes a mob directly with no adapter. The model is built slim, which is the Alex shape the
 * skin is drawn for, and the texture is an ordinary 64x64 player skin.
 */
public class HappyMaskSalesmanRenderer
        extends MobEntityRenderer<HappyMaskSalesmanEntity, PlayerEntityModel<HappyMaskSalesmanEntity>> {

    public static final EntityModelLayer MODEL_LAYER =
            new EntityModelLayer(Identifier.of(HyliaCraft.MOD_ID, "happy_mask_salesman"), "main");

    private static final Identifier TEXTURE =
            Identifier.of(HyliaCraft.MOD_ID, "textures/entity/happy_mask_salesman.png");

    public HappyMaskSalesmanRenderer(EntityRendererFactory.Context context) {
        super(context, new PlayerEntityModel<>(context.getPart(MODEL_LAYER), true), 0.5F);
    }

    @Override
    public Identifier getTexture(HappyMaskSalesmanEntity entity) {
        return TEXTURE;
    }
}
