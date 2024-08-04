package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HylianShieldItem extends ShieldItem {

    public HylianShieldItem(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.hylian_shield1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.hylian_shield2").formatted(Formatting.GRAY));
    }
}
