package net.nieadni.hyliacraft.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.nieadni.hyliacraft.HyliaCraftRace;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class ZoraWaterBreathingMixin {

    @Inject(method = "canBreatheInWater()Z", at = @At("HEAD"), cancellable = true)
    public void canBreatheInWater(CallbackInfoReturnable<Boolean> cir) {
        Object t = this;
        if (t instanceof PlayerEntity player) {
            switch (FabricLoader.getInstance().getEnvironmentType()) {
                case SERVER -> {
                    if (player instanceof ServerPlayerEntity serverPlayer && HyliaCraftRace.getRace(serverPlayer) == HyliaCraftRace.ZORA) {
                        cir.setReturnValue(true);
                    }
                }
                case CLIENT -> {
                    ClientPlayerEntity myPlayer = MinecraftClient.getInstance().player;
                    if (myPlayer != null && myPlayer.getUuid().equals(player.getUuid()) && HyliaCraftClient.race == HyliaCraftRace.ZORA) {
                        cir.setReturnValue(true);
                    }
                }
            }
        }
    }
}
