package net.nieadni.hyliacraft.mixin.race.kokiri.invisibility;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.HyliaCraftPersistentState;
import net.nieadni.hyliacraft.network.NetworkUtils;
import net.nieadni.hyliacraft.network.InvisibleS2CPayload;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import net.nieadni.hyliacraft.worldgen.HCBiomeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(method = "remove(Lnet/minecraft/entity/Entity$RemovalReason;)V", at = @At("HEAD"))
    private void remove(Entity.RemovalReason reason, CallbackInfo ci) {
        Entity me = (Entity) (Object) this;
        if (me instanceof MobEntity mob) {
            World world = me.getEntityWorld();
            if (world instanceof ServerWorld) {
                LivingEntity target = mob.getTarget();
                if (target instanceof ServerPlayerEntity player) {
                    UUID uuid = target.getUuid();
                    MinecraftServer server = world.getServer();
                    HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(server);
                    Integer numTargeters = state.numTargeters.get(uuid);
                    if (numTargeters == null) {
                        HyliaCraft.LOGGER.warn("Something wrong with target tracking? In Entity.remove");
                    } else {
                        if (numTargeters == 1) {
                            state.numTargeters.remove(uuid);
                            if (HyliaCraftRace.checkKokiriInvisible(false, true, true, true, player)) {
                                NetworkUtils.broadcast(server, new InvisibleS2CPayload(target.getId(), true));
                            }
                        } else {
                            state.numTargeters.put(uuid, numTargeters - 1);
                        }
                    }
                }
            }
        }
    }
    
    @Inject(method = "setSneaking(Z)V", at = @At("HEAD"))
    private void setSneaking(boolean sneaking, CallbackInfo ci) {
        Entity me = (Entity) (Object) this;
        if (me instanceof ServerPlayerEntity player && me.isSneaking() != sneaking) {
            boolean isInvisible = sneaking && HyliaCraftRace.checkKokiriInvisible(true, true, false, true, player);
            NetworkUtils.broadcast(me.getServer(), new InvisibleS2CPayload(me.getId(), isInvisible));
        }
    }
}
