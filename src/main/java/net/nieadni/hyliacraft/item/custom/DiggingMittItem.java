package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.item.materials.DiggingMittMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DiggingMittItem extends ShovelItem {
    public DiggingMittItem(Settings settings) {
        super(DiggingMittMaterial.INSTANCE, new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).attributeModifiers(ShovelItem.createAttributeModifiers(DiggingMittMaterial.INSTANCE,1,-1.0F).with(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                new EntityAttributeModifier(SWORD_RANGE_MODIFIER_ID, -2, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        )));
    }

    public static final Identifier SWORD_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "sword_entity_reach");

}
