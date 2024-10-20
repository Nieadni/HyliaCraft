package net.nieadni.hyliacraft.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;

public class ParagliderItem extends Item {

    //TODO: Make it so you cant use items while using Paraglider

    public ParagliderItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, @NotNull World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {

            ItemStack mainHandStack = player.getMainHandStack();
            if (mainHandStack.isOf(this.asItem())) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 5, 80, false, false, false));
            }
        }
    }
}