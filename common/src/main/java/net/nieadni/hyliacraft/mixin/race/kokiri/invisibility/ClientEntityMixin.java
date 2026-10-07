package net.nieadni.hyliacraft.mixin.race.kokiri.invisibility;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class ClientEntityMixin {
    
    @Inject(method = "isInvisible()Z", at = @At("HEAD"), cancellable = true)
    private void isInvisible(CallbackInfoReturnable<Boolean> cir) {
        Entity me = (Entity) (Object) this;
        if (me instanceof PlayerEntity && HyliaCraftClient.invisibilityOverride.get(me.getId()) == Boolean.TRUE) {
            cir.setReturnValue(true);
        }
    }
}
