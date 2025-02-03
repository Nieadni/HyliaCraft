package net.nieadni.hyliacraft.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.sword_beam_entities.GoddessLongswordBeamEntity;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class RockProjectileRenderer extends ProjectileEntityRenderer {
    public RockProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return Identifier.of(HyliaCraft.MOD_ID,"textures/entity/projectiles/rock.png");
    }

    /**
    @Override
    public void render(@NotNull GoddessLongswordBeamEntity rockProjectile, float yaw, float tickDelta, @NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        matrices.scale(2.0f, 2.0f, 2.0f);

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(getTexture(rockProjectile)));
        MatrixStack.Entry matrixEntry = matrices.peek();
        Matrix4f modelMatrix = matrixEntry.getPositionMatrix();
        vertexConsumer.vertex(modelMatrix, -0.25f,  0.25f, 0.0f).color(255, 255, 255, 255).texture(0.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);
        vertexConsumer.vertex(modelMatrix,  0.25f,  0.25f, 0.0f).color(255, 255, 255, 255).texture(1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);
        vertexConsumer.vertex(modelMatrix,  0.25f, -0.25f, 0.0f).color(255, 255, 255, 255).texture(1.0f, 0.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);
        vertexConsumer.vertex(modelMatrix, -0.25f, -0.25f, 0.0f).color(255, 255, 255, 255).texture(0.0f, 0.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);

        matrices.pop();
        super.render(rockProjectile, yaw, tickDelta, matrices, vertexConsumers, light);
    }
    **/
}