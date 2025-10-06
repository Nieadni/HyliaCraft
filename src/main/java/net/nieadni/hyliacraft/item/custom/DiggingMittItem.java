package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.item.materials.DiggingMittMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    // REMOVE WIP HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("tooltip.hyliacraft.digging_mitt"));
    }
}
