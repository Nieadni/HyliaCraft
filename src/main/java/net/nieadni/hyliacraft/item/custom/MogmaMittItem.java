package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.HyliaCraft;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MogmaMittItem extends Item {

    private static final Identifier ATTACK_DAMAGE_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "mogma_mitt_attack_damage_modifier");
    private static final Identifier ATTACK_SPEED_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "mogma_mitt_speed_damage_modifier");
    private static final Identifier ENTITY_INTERACTION_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "mogma_mitt_entity_interaction_modifier");

    public MogmaMittItem() {
        super(new Settings().maxCount(1).rarity(Rarity.UNCOMMON).maxDamage(1561).component(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(
                List.of(
                        new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER, 3, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND),
                        new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED,
                                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER, -1, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND),
                        new AttributeModifiersComponent.Entry(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                new EntityAttributeModifier(ENTITY_INTERACTION_MODIFIER, -2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                ), true))
                .component(DataComponentTypes.TOOL, new ToolComponent(List.of(
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

}
