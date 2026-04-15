package net.nieadni.hyliacraft.mixin.race.rito;

import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow
    public abstract void startFallFlying();

    @Inject(method = "checkFallFlying()Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getEquippedStack(Lnet/minecraft/entity/EquipmentSlot;)Lnet/minecraft/item/ItemStack;"), cancellable = true)
    private void checkFallFlying(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity me = (PlayerEntity) (Object) this;
        if (HyliaCraftRace.getRace(me) == HyliaCraftRace.RITO) {
            startFallFlying();
            cir.setReturnValue(true);
        }
    }
}
