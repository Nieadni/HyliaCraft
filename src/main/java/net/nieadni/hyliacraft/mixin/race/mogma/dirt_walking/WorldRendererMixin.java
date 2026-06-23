package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.WorldRenderer;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Redirect(method = "render(Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/GameRenderer;Lnet/minecraft/client/render/LightmapTextureManager;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isSpectator()Z"))
    private boolean modifyIsSpectator(ClientPlayerEntity player) {
        return player.isSpectator() || HyliaCraftClient.race == HyliaCraftRace.MOGMA && player.getBlockStateAtPos().isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH);
    }

    @Definition(id = "cameraSubmersionType", local = @Local(type = CameraSubmersionType.class))
    @Definition(id = "POWDER_SNOW", field = "Lnet/minecraft/block/enums/CameraSubmersionType;POWDER_SNOW:Lnet/minecraft/block/enums/CameraSubmersionType;")
    @Expression("cameraSubmersionType == POWDER_SNOW")
    @ModifyExpressionValue(method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean modifySubmersionCheck(boolean original, @Local CameraSubmersionType submersionType) {
        return original && submersionType != CameraSubmersionType.HYLIACRAFT_DIRT_WALKING;
    }
}
