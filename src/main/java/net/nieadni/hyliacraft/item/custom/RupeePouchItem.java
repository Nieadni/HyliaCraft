package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RupeePouchItem extends Item {

    public RupeePouchItem(Settings settings) {
        super(settings);
    }

    //TODO RupeePouchItem
    /**
     * Would automatically store Rupees you pick up, you can also click on the pouch to pick it up, then click it onto a rupee(s) to store it
     * Should display the amount of rupees in its tooltip, with a max of 9999
     * Just '<Number> Rupees' should be fine
     *
     * When you hold the rupee pouch in your hand, when you 'use', it should bring up the Rupee Pouch GUI,
     * and will let you take out individual amounts of rupees and types
     *
     * If you cannot take out a rupee, that slot would be greyscaled and darkened by 25%.
     * For example, if you have 5 Rupees stored in your pouch, you could take Green Rupees or a Blue Rupee, but everything above would be darkened.
     */

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }
}