package net.nieadni.hyliacraft.mixin.race.goron;

import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class SwimmingMixin {

    @Inject(method = "isSwimming()Z", at = @At("HEAD"), cancellable = true)
    private void isSwimming(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) ((Object) this);
        if (HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON) {
            cir.setReturnValue(false);
        }
    }
}
