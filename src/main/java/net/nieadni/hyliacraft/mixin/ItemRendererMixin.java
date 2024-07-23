package net.nieadni.hyliacraft.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.HCItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem",
            at=@At("HEAD"), argsOnly = true)
    private BakedModel itemRenderer(BakedModel model, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(HCItems.DIGGING_MITT) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).getModels().getModelManager().getModel(new ModelIdentifier(IdentifierAccessor.callConstructor(HyliaCraft.MOD_ID, "models/item/digging_mitt_3d"), "inventory"));
        }
        return model;
    }
}