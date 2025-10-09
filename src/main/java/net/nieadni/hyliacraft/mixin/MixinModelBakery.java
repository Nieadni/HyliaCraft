package net.nieadni.hyliacraft.mixin;

import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelLoader.class)
public abstract class MixinModelBakery {
    @Shadow protected abstract void loadInventoryVariantItemModel(Identifier resourceLocation);
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        for (Item item : HyliaCraftClient.CUSTOM_GUI_MODEL_ITEMS) {
            Identifier location = Registries.ITEM.getId(item);
            this.loadInventoryVariantItemModel(Identifier.of(location.getNamespace(), location.getPath() + "_gui"));
        }
    }
}