package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.item.materials.GoddessSwordMaterial;

public class GoddessSwordItem extends SwordItem {
    public GoddessSwordItem() {
        super(GoddessSwordMaterial.INSTANCE, new Item.Settings().fireproof().rarity(Rarity.RARE).attributeModifiers(createAttributeModifiers(GoddessSwordMaterial.INSTANCE, 1, -2.4F).with(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                new EntityAttributeModifier(SWORD_RANGE_MODIFIER_ID, -1, EntityAttributeModifier.Operation.ADD_VALUE),
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
            timer = 600;    // every X ticks (1 second = 20 ticks)
        } else timer--;
        nbt.putInt(DURABILITY_KEY, timer);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }

    public static final Identifier SWORD_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "sword_entity_reach");
    public static final int DURABILITY_TIMER = 600;
    public static final String DURABILITY_KEY = "durabilityHealTimer";

    // Somehow exclude the Sweeping Edge enchantment from being put onto the sword

    @Override
    public boolean allowComponentsUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return false;
    }

    /**
     * Sword Beam Attack Needed
     * + Right Click = Vertical Attack
     * + Crouch + Right Click = Horizontal Attack
     * + 3/4's Normal Attack Damage
     * + 6 Second Cooldown
     */
}
