package net.nieadni.hyliacraft.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.bokoblin.BokoblinEntity;

@Environment(EnvType.CLIENT)
public class BokoblinEntityRenderer extends BipedEntityRenderer<BokoblinEntity, PiglinEntityModel<BokoblinEntity>> {

    private static final float HORIZONTAL_SCALE = 1.0019531F;

    public BokoblinEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PiglinEntityModel<>(ctx.getModelLoader().getModelPart(EntityModelLayers.PIGLIN)), 0.5F, HORIZONTAL_SCALE, 1.0F, HORIZONTAL_SCALE);
        this.addFeature(new ArmorFeatureRenderer<>(
                this,
                new ArmorEntityModel<>(ctx.getPart(EntityModelLayers.PIGLIN_INNER_ARMOR)),
                new ArmorEntityModel<>(ctx.getPart(EntityModelLayers.PIGLIN_OUTER_ARMOR)),
                ctx.getModelManager()
        ));
    }

    public Identifier getTexture(BokoblinEntity entity) {
        return entity.getColour().texture;
    }
}

