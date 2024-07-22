package net.nieadni.hyliacraft.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.item.materials.GoddessSwordMaterial;

public class GoddessSwordItem extends SwordItem {
    public GoddessSwordItem(GoddessSwordMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient && entity instanceof PlayerEntity player) {
            EntityAttributeInstance reachAttribute = player.getAttributeInstance(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE);
            assert reachAttribute != null;
            boolean isReachModified = reachAttribute.hasModifier(SWORD_RANGE_MODIFIER_ID);
            if (selected && !isReachModified) {
                reachAttribute.addTemporaryModifier(new EntityAttributeModifier(
                        SWORD_RANGE_MODIFIER_ID,
                        -1, // Sets the distance between you and the entity to be 1 block less
                        EntityAttributeModifier.Operation.ADD_VALUE)
                );
            } else if (!selected && isReachModified) {
                reachAttribute.removeModifier(SWORD_RANGE_MODIFIER_ID);
            }
        }
    }

    public static final Identifier SWORD_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "sword_entity_reach");

    // Somehow exclude the Sweeping Edge enchantment from being put onto the sword

    // Heal 1 Durability every X ticks
    // Remember to remove re-equip animation

    /**
     * Sword Beam Attack Needed
     * + Must be vertical
     * + 3/4 Normal Attack Damage
     * + 6 Second Cooldown
     */
}
