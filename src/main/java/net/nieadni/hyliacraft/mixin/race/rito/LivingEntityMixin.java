package net.nieadni.hyliacraft.mixin.race.rito;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    
    @Redirect(method = "tickFallFlying()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getEquippedStack(Lnet/minecraft/entity/EquipmentSlot;)Lnet/minecraft/item/ItemStack;"))
    private ItemStack getEquippedStack(LivingEntity livingEntity, EquipmentSlot slot) {
        if (slot == EquipmentSlot.CHEST && livingEntity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.RITO) {
            return new ItemStack(Items.ELYTRA);
        }
        return livingEntity.getEquippedStack(slot);
    }
}
