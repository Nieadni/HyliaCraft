package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

    @Shadow private static float red;
    @Shadow private static float green;
    @Shadow private static float blue;

    @Shadow
    private static long lastWaterFogColorUpdateTime;

    @Inject(method = "render(Lnet/minecraft/client/render/Camera;FLnet/minecraft/client/world/ClientWorld;IF)V", at = @At(value = "FIELD", target = "Lnet/minecraft/block/enums/CameraSubmersionType;WATER:Lnet/minecraft/block/enums/CameraSubmersionType;", ordinal = 0, opcode = Opcodes.GETSTATIC), cancellable = true)
    private static void render(Camera camera, float tickDelta, ClientWorld world, int viewDistance, float skyDarkness, CallbackInfo ci, @Local CameraSubmersionType submersionType, @Local Entity entity) {
        if (submersionType == CameraSubmersionType.HYLIACRAFT_DIRT_WALKING) {
            red = 51F / 255F;
            green = 30F / 255F;
            blue = 7F / 255F;
            lastWaterFogColorUpdateTime = -1L;
            RenderSystem.clearColor(red, green, blue, 0.0F);

            if (skyDarkness > 0.0F) {
                red = red * (1.0F - skyDarkness) + red * 0.7F * skyDarkness;
                green = green * (1.0F - skyDarkness) + green * 0.6F * skyDarkness;
                blue = blue * (1.0F - skyDarkness) + blue * 0.6F * skyDarkness;
            }

            float s;
            if (entity instanceof LivingEntity living
                    && living.hasStatusEffect(StatusEffects.NIGHT_VISION)
                    && !living.hasStatusEffect(StatusEffects.DARKNESS)) {
                s = GameRenderer.getNightVisionStrength(living, tickDelta);
            } else {
                s = 0.0F;
            }

            if (red != 0.0F && green != 0.0F && blue != 0.0F) {
                float t = Math.min(1.0F / red, Math.min(1.0F / green, 1.0F / blue));
                red = red * (1.0F - s) + red * t * s;
                green = green * (1.0F - s) + green * t * s;
                blue = blue * (1.0F - s) + blue * t * s;
            }

            RenderSystem.clearColor(red, green, blue, 0.0F);
            
            ci.cancel();
        }
    }
    
    @Inject(method = "applyFog(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/BackgroundRenderer$FogType;FZF)V", at = @At(value = "FIELD", target = "Lnet/minecraft/block/enums/CameraSubmersionType;LAVA:Lnet/minecraft/block/enums/CameraSubmersionType;", ordinal = 0, opcode = Opcodes.GETSTATIC), cancellable = true)
    private static void applyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci, @Local CameraSubmersionType submersionType, @Local Entity entity, @Local BackgroundRenderer.FogData fogData) {
        if (submersionType == CameraSubmersionType.HYLIACRAFT_DIRT_WALKING) {
            if (entity.isSpectator()) {
                fogData.fogStart = -8.0F;
                fogData.fogEnd = viewDistance * 0.5F;
            } else {
                fogData.fogStart = 0.0F;
                fogData.fogEnd = 10.0F;
            }

            RenderSystem.setShaderFogStart(fogData.fogStart);
            RenderSystem.setShaderFogEnd(fogData.fogEnd);
            RenderSystem.setShaderFogShape(fogData.fogShape);
            
            ci.cancel();
        }
    }
}
