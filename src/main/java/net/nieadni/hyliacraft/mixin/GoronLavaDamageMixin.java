package net.nieadni.hyliacraft.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.nieadni.hyliacraft.HyliaCraftRace;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Entity.class)
public class GoronLavaDamageMixin {

    @ModifyConstant(method = "setOnFireFromLava()V", constant = @Constant(floatValue = 4.0f))
    private float getLavaDamage(float damage) {
        Object t = this;
        if (t instanceof PlayerEntity player) {
            switch (FabricLoader.getInstance().getEnvironmentType()) {
                case SERVER -> {
                    if (player instanceof ServerPlayerEntity serverPlayer && HyliaCraftRace.getRace(serverPlayer) == HyliaCraftRace.GORON) {
                        return damage / 2;
                    }
                }
                case CLIENT -> {
                    ClientPlayerEntity myPlayer = MinecraftClient.getInstance().player;
                    if (myPlayer != null && myPlayer.getUuid().equals(player.getUuid()) && HyliaCraftClient.race == HyliaCraftRace.GORON) {
                        return damage / 2;
                    }
                }
            }
        }
        return damage;
    }
}
