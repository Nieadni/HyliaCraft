package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.WorldRenderer;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// This fixes a rendering issue for some blocks in chunks that the player is not in

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Redirect(method = "render(Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/GameRenderer;Lnet/minecraft/client/render/LightmapTextureManager;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isSpectator()Z"))
    private boolean modifyIsSpectator(ClientPlayerEntity player) {
        return player.isSpectator() || HyliaCraftClient.race == HyliaCraftRace.MOGMA && player.getBlockStateAtPos().isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH);
    }
}
