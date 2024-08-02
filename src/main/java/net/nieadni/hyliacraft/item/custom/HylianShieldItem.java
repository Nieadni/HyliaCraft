package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;

import java.util.List;

public class HylianShieldItem extends ShieldItem {
    public HylianShieldItem(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.hylian_shield1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.hylian_shield2").formatted(Formatting.GRAY));
    }
}
