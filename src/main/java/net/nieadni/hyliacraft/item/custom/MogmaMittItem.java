package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

//TODO: Make it Netherite Level Shovel, but Iron Level Pickaxe
//TODO: Short Sword Range
public class MogmaMittItem extends Item {
    public MogmaMittItem(Settings settings) {
        super(new Settings().maxCount(1).rarity(Rarity.UNCOMMON));
    }

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }
}
