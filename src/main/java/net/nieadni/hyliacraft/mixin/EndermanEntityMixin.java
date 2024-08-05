package net.nieadni.hyliacraft.mixin;

import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;

import net.nieadni.hyliacraft.item.HCItemTags;

import org.jetbrains.annotations.NotNull;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

    @ModifyReturnValue(method = "isPlayerStaring", at = @At("RETURN"))
    public boolean isPlayerStaring(boolean original, @Local(argsOnly = true) @NotNull PlayerEntity player) {
        return !player.getInventory().armor.get(3).isIn(HCItemTags.ENDERMASK) && original;
    }
}