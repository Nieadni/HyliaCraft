package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WaterDragonScaleItem extends Item {

    public WaterDragonScaleItem(Settings settings) {
        super(settings);
    }

    /**
     * Will go into Helmet Slot (possibly future compatibility with Trinkets & Curios)
     * This will allow the player to do the spin attack while in water. 3 second cooldown like Zora Race
     * Keybind could be called 'Helmet Ability' and the default could be 'V'
     */

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }

}