package net.nieadni.hyliacraft.block.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.function.Function;

public class IronChestModel extends Model {
    public IronChestModel(Function<Identifier, RenderLayer> layerFactory) {
        super(layerFactory);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
    }

    //TODO

}