package net.nieadni.hyliacraft.mixin.race.rito.shader;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Shadow
    public abstract void loadPostProcessor(Identifier id);

    @Inject(method = "onCameraEntitySet(Lnet/minecraft/entity/Entity;)V", at = @At("TAIL"))
    private void onCameraEntitySet(Entity entity, CallbackInfo ci) {
        boolean isNotSpectating = entity == null || entity == MinecraftClient.getInstance().player;
        if (isNotSpectating && HyliaCraftRace.getRace(MinecraftClient.getInstance().player) == HyliaCraftRace.RITO) {
            loadPostProcessor(Identifier.of(HyliaCraft.MOD_ID, "shaders/post/rito.json"));
        }
    }
}
