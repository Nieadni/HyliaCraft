package net.nieadni.hyliacraft.mixin.race.kokiri.invisibility;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.HyliaCraftPersistentState;
import net.nieadni.hyliacraft.network.InvisibleS2CPayload;
import net.nieadni.hyliacraft.network.NetworkUtils;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(MobEntity.class)
public class MobEntityMixin {
    
    @Inject(method = "setTarget(Lnet/minecraft/entity/LivingEntity;)V", at = @At("HEAD"))
    private void setTarget(LivingEntity target, CallbackInfo ci) {
        MobEntity me = (MobEntity) (Object) this;
        World world = me.getEntityWorld();
        if (world instanceof ServerWorld) {
            LivingEntity current = me.getTarget();
            // If the new target is the same as the current one, we don't need to change anything
            if (target == current) return;
            MinecraftServer server = world.getServer();
            HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(server);
            // Current target is no longer being targeted
            if (current instanceof ServerPlayerEntity player) {
                System.out.println("Removed targeter " + me.getDisplayName());
                UUID uuid = current.getUuid();
                Integer numTargeters = state.numTargeters.get(uuid);
                if (numTargeters == null) {
                    HyliaCraft.LOGGER.warn("Something wrong with target tracking? In MobEntity.setTarget");
                } else {
                    if (numTargeters == 1) {
                        state.numTargeters.remove(uuid);
                        if (HyliaCraftRace.checkKokiriInvisible(false, true, true, true, player)) {
                            NetworkUtils.broadcast(server, new InvisibleS2CPayload(current.getId(), true));
                        }
                    } else {
                        state.numTargeters.put(uuid, numTargeters - 1);
                    }
                }
            }
            // New target is being targeted
            if (target instanceof ServerPlayerEntity) {
                System.out.println("Added targeter " + me.getDisplayName());
                UUID uuid = target.getUuid();
                int numTargeters = state.getOrCreateNumTargeters(uuid);
                state.numTargeters.put(uuid, numTargeters + 1);
                if (numTargeters == 0) {
                    NetworkUtils.broadcast(server, new InvisibleS2CPayload(target.getId(), false));
                }
            }
        }
    }
}
