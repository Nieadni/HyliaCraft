package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.Properties;

public class RupeeItem extends Item {
    private final String tooltip;

    public RupeeItem(String tooltip) {
        super(new Item.Settings().maxCount(64));
        this.tooltip = tooltip;
    }

    public RupeeItem(Settings settings, String tooltip) {
        super(settings);
        this.tooltip = tooltip;
    }

    @Override
    public void appendTooltip(ItemStack pStack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(this.tooltip).formatted(Formatting.GRAY));
    }
}