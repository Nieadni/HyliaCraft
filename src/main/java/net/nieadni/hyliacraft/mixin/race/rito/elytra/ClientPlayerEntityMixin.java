package net.nieadni.hyliacraft.mixin.race.rito.elytra;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Shadow
    @Final
    public ClientPlayNetworkHandler networkHandler;

    @Inject(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getEquippedStack(Lnet/minecraft/entity/EquipmentSlot;)Lnet/minecraft/item/ItemStack;"), cancellable = true)
    private void maybeFly(CallbackInfo ci) {
        ClientPlayerEntity me = (ClientPlayerEntity) (Object) this;
        if (me.checkFallFlying()) {
            networkHandler.sendPacket(new ClientCommandC2SPacket(me, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
        }
    }
}
