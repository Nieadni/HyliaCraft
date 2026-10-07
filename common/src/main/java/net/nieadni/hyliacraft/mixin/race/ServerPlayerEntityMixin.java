package net.nieadni.hyliacraft.mixin.race;

import net.minecraft.server.network.ServerPlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    // When players die, they should retain their race-given attribute modifiers
    @Inject(method = "onSpawn()V", at = @At("HEAD"))
    private void onSpawn(CallbackInfo ci) {
        ServerPlayerEntity me = (ServerPlayerEntity) (Object) this;
        HyliaCraftRace race = HyliaCraftRace.getRace(me);
        if (race != null) race.addAttributes(me.getAttributes());
    }
}
