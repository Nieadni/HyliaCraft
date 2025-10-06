package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.item.materials.DiggingMittMaterial;

public class DiggingMittItem extends Item {
    public static final Identifier TOOL_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "tool_entity_reach");
    public DiggingMittItem() {
        super(new Settings().maxCount(1).rarity(Rarity.UNCOMMON).attributeModifiers(MiningToolItem.createAttributeModifiers(DiggingMittMaterial.INSTANCE,1,-1.0F).with(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                new EntityAttributeModifier(TOOL_RANGE_MODIFIER_ID, -2, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        )));
    }

    //TODO: Use on block = path, crouch + use on block = till
}
