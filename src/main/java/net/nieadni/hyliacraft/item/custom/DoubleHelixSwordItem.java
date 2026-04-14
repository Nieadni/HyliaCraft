package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.item.materials.DoubleHelixSwordMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DoubleHelixSwordItem extends SwordItem {
    public static final Identifier SWORD_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "sword_entity_reach");
    public DoubleHelixSwordItem() {
        super(DoubleHelixSwordMaterial.INSTANCE, new Item.Settings().fireproof().rarity(Rarity.EPIC).attributeModifiers(DoubleHelixSwordItem.createAttributeModifiers(DoubleHelixSwordMaterial.INSTANCE,1, -3.5F).with(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                new EntityAttributeModifier(SWORD_RANGE_MODIFIER_ID, 3, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        )));
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    // TODO: Make Double Helix Sword require nothing in off hand
    // TODO: Make Double Helix Sword require non-Goron players to have the Strength Effect to use.
    // TODO: Make Double Helix Sword have permanent Sweeping Edge 3 (and I guess exclude it from its available enchants)
    // TODO: (once added) Make Double Helix Sword take no durability IF player has full set of Fierce Deity Armour equipped.

    // REMOVE WIP ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.two_handed_weapon"));
        tooltip.add(Text.translatable("tooltip.hyliacraft.double_helix_sword").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }

}
