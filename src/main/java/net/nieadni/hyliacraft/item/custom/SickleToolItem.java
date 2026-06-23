package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.item.materials.MogmaMittMaterial;

public class SickleToolItem extends Item {
    public static final Identifier TOOL_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "tool_entity_reach");
    public SickleToolItem() {
        super(new Settings().maxCount(1).maxDamage(250).attributeModifiers(MiningToolItem.createAttributeModifiers(MogmaMittMaterial.INSTANCE, 1, -2.4f)
                .with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(TOOL_RANGE_MODIFIER_ID, -1, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )));
    }

    @Override
    public int getEnchantability() {
        return 14;
    }


}
