package net.nieadni.hyliacraft.entity;

import net.fabricmc.api.*;

import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import net.nieadni.hyliacraft.HyliaCraft;

import org.jetbrains.annotations.NotNull;

import org.joml.*;

@Environment(EnvType.CLIENT)
public class MasterSwordBeamEntityRenderer extends EntityRenderer<MasterSwordBeamEntity> {

    public MasterSwordBeamEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(@NotNull MasterSwordBeamEntity beam, float yaw, float tickDelta, @NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        matrices.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(-90f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-beam.getYaw()));
        matrices.scale(2.0f, 2.0f, 2.0f);

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(getTexture(beam)));
        MatrixStack.Entry matrixEntry = matrices.peek();
        Matrix4f modelMatrix = matrixEntry.getPositionMatrix();
        vertexConsumer.vertex(modelMatrix, -0.25f,  0.25f, 0.0f).color(255, 255, 255, 255).texture(0.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);
        vertexConsumer.vertex(modelMatrix,  0.25f,  0.25f, 0.0f).color(255, 255, 255, 255).texture(1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);
        vertexConsumer.vertex(modelMatrix,  0.25f, -0.25f, 0.0f).color(255, 255, 255, 255).texture(1.0f, 0.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);
        vertexConsumer.vertex(modelMatrix, -0.25f, -0.25f, 0.0f).color(255, 255, 255, 255).texture(0.0f, 0.0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrixEntry, 0f, 1f, 0f);

        matrices.pop();
        super.render(beam, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(@NotNull MasterSwordBeamEntity beam) {
        return new Identifier(HyliaCraft.MOD_ID, "textures/entity/master_sword_beam/master_sword_beam_0.png");
    }
}