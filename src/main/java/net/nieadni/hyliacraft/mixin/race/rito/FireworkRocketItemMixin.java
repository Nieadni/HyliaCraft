package net.nieadni.hyliacraft.mixin.race.rito;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.Items;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin {
    
    @ModifyExpressionValue(method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isFallFlying()Z"))
    private boolean isFallFlying(boolean original, @Local(argsOnly = true) PlayerEntity user) {
        return original && !(HyliaCraftRace.getRace(user) == HyliaCraftRace.RITO && !user.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.ELYTRA));
    }
}
