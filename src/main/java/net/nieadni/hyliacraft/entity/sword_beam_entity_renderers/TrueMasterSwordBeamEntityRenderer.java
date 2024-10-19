package net.nieadni.hyliacraft.entity.sword_beam_entity_renderers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.sword_beam_entities.GoddessSwordBeamEntity;
import net.nieadni.hyliacraft.entity.sword_beam_entities.TrueMasterSwordBeamEntity;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.Arrays;

@Environment(EnvType.CLIENT)
public class TrueMasterSwordBeamEntityRenderer extends EntityRenderer<TrueMasterSwordBeamEntity> {

    protected static final Identifier[] TEXTURES = {
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_0.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_1.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_2.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_3.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_4.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_5.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_6.png"),
            new Identifier("hyliacraft","textures/entity/master_sword_beam/master_sword_beam_7.png")
    };

    public TrueMasterSwordBeamEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(@NotNull TrueMasterSwordBeamEntity beam, float yaw, float tickDelta, @NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light) {
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

    public Identifier getTexture(TrueMasterSwordBeamEntity instance) {
        Identifier[] beamTextures = TEXTURES;
        return Arrays.stream(beamTextures).toList().get((instance.age) % beamTextures.length);
    }
}