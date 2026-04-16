package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {

    @ModifyExpressionValue(method = "renderOverlays(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/util/math/MatrixStack;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameOverlayRenderer;getInWallBlockState(Lnet/minecraft/entity/player/PlayerEntity;)Lnet/minecraft/block/BlockState;"))
    private static BlockState modifyWallBlockState(BlockState original) {
        if (original != null && HyliaCraftClient.race == HyliaCraftRace.MOGMA && original.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            return null;
        }
        return original;
    }
}
