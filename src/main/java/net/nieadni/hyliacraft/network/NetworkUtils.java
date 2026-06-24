package net.nieadni.hyliacraft.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class NetworkUtils {
    
    public static void broadcast(MinecraftServer server, CustomPayload payload) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            ServerPlayNetworking.send(player, payload);
        }
    }
}
