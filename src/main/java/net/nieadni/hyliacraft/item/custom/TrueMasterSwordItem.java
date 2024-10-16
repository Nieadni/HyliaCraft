package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.*;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

import net.nieadni.hyliacraft.item.materials.TrueMasterSwordMaterial;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TrueMasterSwordItem extends MasterSwordItem {

    public TrueMasterSwordItem() {
        super(TrueMasterSwordMaterial.INSTANCE, new Item.Settings().fireproof().rarity(Rarity.EPIC).attributeModifiers(TrueMasterSwordItem.createAttributeModifiers(TrueMasterSwordMaterial.INSTANCE,1, -2.4F).with(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                new EntityAttributeModifier(SWORD_RANGE_MODIFIER_ID, 2, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        )));
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        int timer = nbt.contains(DURABILITY_KEY) ? nbt.getInt("durabilityHealTimer") : DURABILITY_TIMER;
        if (timer == 0) {
            if (stack.isDamaged()) {
                stack.setDamage(stack.getDamage() - 1);    // Durability fixed
            }
            timer = 40;    // every X ticks (1 second = 20 ticks)
        } else timer--;
        nbt.putInt(DURABILITY_KEY, timer);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }

    public static final Identifier SWORD_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "sword_entity_reach");
    public static final int DURABILITY_TIMER = 40;
    public static final String DURABILITY_KEY = "durabilityHealTimer";

    /**
     * Sword Beam Attack Needed
     * + Right Click = Vertical Attack
     * + Crouch + Right Click = Horizontal Attack
     * + 3/4's Normal Attack Damage
     * + 6 Second Cooldown
     */

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }
}