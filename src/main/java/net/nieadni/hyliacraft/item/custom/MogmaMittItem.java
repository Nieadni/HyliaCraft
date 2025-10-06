package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.item.materials.MogmaMittMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MogmaMittItem extends Item {
    public static final Identifier TOOL_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "tool_entity_reach");
    public MogmaMittItem() {
        super(new Settings().maxCount(1).rarity(Rarity.UNCOMMON).maxDamage(1561).attributeModifiers(MiningToolItem.createAttributeModifiers(MogmaMittMaterial.INSTANCE, 3, -1)
                .with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(TOOL_RANGE_MODIFIER_ID, -2, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )).component(DataComponentTypes.TOOL, new ToolComponent(List.of(
                ToolComponent.Rule.ofNeverDropping(BlockTags.INCORRECT_FOR_IRON_TOOL),
                ToolComponent.Rule.ofAlwaysDropping(BlockTags.PICKAXE_MINEABLE, 6.0f),
                ToolComponent.Rule.ofNeverDropping(BlockTags.INCORRECT_FOR_NETHERITE_TOOL),
                ToolComponent.Rule.ofAlwaysDropping(BlockTags.SHOVEL_MINEABLE, 9.0f)
        ), 1.0f, 1)));
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }

    //TODO: Use on block = path, crouch + use on block = till

}
