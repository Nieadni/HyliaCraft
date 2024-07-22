package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class PumpkinSoupItem extends Item {
    public PumpkinSoupItem(Settings settings) {
        super(settings);
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<net.minecraft.text.Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.pumpkin_soup").formatted(Formatting.GRAY));
    }

}
