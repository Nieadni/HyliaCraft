package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RupeeItem extends Item {

    private final String tooltipTranslation;

    public RupeeItem(String tooltipTranslation) {
        super(new Item.Settings().maxCount(64));
        this.tooltipTranslation = tooltipTranslation;
    }

    @Override
    public void appendTooltip(ItemStack pStack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(this.tooltipTranslation).formatted(Formatting.GRAY));
    }
}