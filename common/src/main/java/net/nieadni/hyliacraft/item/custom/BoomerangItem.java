package net.nieadni.hyliacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BoomerangItem extends Item {

    public BoomerangItem(Settings settings) {
        super(settings);
    }

    //TODO: BoomerangItem
    /**
     * The Boomerang should go out 32 blocks then come back to the player.
     * Should deal around 6hp per hit?
     * Will pick up items its hitbox intersects and when the player gets it back, it will give them the items.
     * 484 Durability
     */

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }

}