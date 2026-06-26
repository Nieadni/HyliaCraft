package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public class CameraMixin {
    
    @Inject(method = "getSubmersionType()Lnet/minecraft/block/enums/CameraSubmersionType;", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"), cancellable = true)
    private void getSubmersionType(CallbackInfoReturnable<CameraSubmersionType> cir, @Local BlockState state) {
        if (HyliaCraft.isClientPlayerSpectator()) return;
        if (state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            cir.setReturnValue(CameraSubmersionType.HYLIACRAFT_DIRT_WALKING);
        }
    }
}
