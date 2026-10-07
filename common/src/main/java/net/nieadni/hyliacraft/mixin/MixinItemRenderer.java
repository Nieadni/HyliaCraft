package net.nieadni.hyliacraft.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer {
    @Shadow @Final private ItemModels models;
    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at=@At("HEAD"), argsOnly = true)
    public BakedModel renderItem(BakedModel model, @Local(argsOnly = true) ItemStack itemStack, @Local(argsOnly = true) ModelTransformationMode context) {
        if (context == ModelTransformationMode.GUI || context == ModelTransformationMode.GROUND || context == ModelTransformationMode.FIXED) {
            if (HyliaCraftClient.CUSTOM_GUI_MODEL_ITEMS.contains(itemStack.getItem())) {
                Identifier location = Registries.ITEM.getId(itemStack.getItem());
                return models.getModelManager().getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(location.getNamespace(), location.getPath() + "_gui")));
            }
        }
        return model;
    }
}