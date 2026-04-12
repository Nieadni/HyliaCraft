package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.entity.sword_beam_entities.GoddessSwordBeamEntity;
import net.nieadni.hyliacraft.item.HCItems;
import net.nieadni.hyliacraft.item.materials.GoddessSwordMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;

//TODO: Somehow exclude the Sweeping Edge enchantment from being put onto the sword
public class GoddessSwordItem extends SwordItem {

    public static final Identifier SWORD_RANGE_MODIFIER_ID = Identifier.of("hyliacraft", "sword_entity_reach");
    public static final int DURABILITY_TIMER = 600;
    public static final String DURABILITY_KEY = "durabilityHealTimer";

    public GoddessSwordItem() {
        super(GoddessSwordMaterial.INSTANCE, new Item.Settings().fireproof().rarity(Rarity.RARE).attributeModifiers(createAttributeModifiers(GoddessSwordMaterial.INSTANCE, 1, -2.4F).with(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                new EntityAttributeModifier(SWORD_RANGE_MODIFIER_ID, -1, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
        )));
    }

    // Heal Sword Over Time
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

    @Override
    public boolean allowComponentsUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        //Combining
        ItemStack mainHand = user.getMainHandStack();
        ItemStack offHand = user.getOffHandStack();
        if (mainHand.isOf(HCItems.GODDESS_SWORD) && offHand.isOf(HCItems.FARORE_FLAME)) {
            // store components
            Text stored_custom_name = mainHand.get(DataComponentTypes.CUSTOM_NAME);
            ItemEnchantmentsComponent stored_enchantments = mainHand.get(DataComponentTypes.ENCHANTMENTS);
            // apply components to new sword
            ItemStack new_sword = HCItems.GODDESS_LONGSWORD.getDefaultStack();
            new_sword.set(DataComponentTypes.CUSTOM_NAME, stored_custom_name);
            new_sword.set(DataComponentTypes.ENCHANTMENTS, stored_enchantments);
            // replace old sword + off hand item
            user.setStackInHand(Hand.MAIN_HAND, new_sword);
            user.setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY);
            user.playSound(SoundEvents.BLOCK_ANVIL_USE, 1, 1);
            // nom
            return TypedActionResult.consume(new_sword);
        }

        //Beams
        ItemStack stack = user.getMainHandStack();
        if (user.isSneaking()) {
            GoddessSwordBeamEntity swordBeamEntity = HCEntities.GODDESS_SWORD_BEAM.create(world); //makes entity
            swordBeamEntity.setOwner(user); //makes player the owner
            swordBeamEntity.setPosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ()); //sets its position in the world
            Vec3d vec3d = user.getRotationVec(1.0f); //sets velocity
            swordBeamEntity.setVelocity(vec3d.x, vec3d.y, vec3d.z, 1f, 0.0f);
            swordBeamEntity.setVertical(true);
            world.spawnEntity(swordBeamEntity);

            user.swingHand(hand, true);
            user.playSound(SoundEvents.ITEM_TRIDENT_THROW.value(), 1F, 1);

        }
        else {
            GoddessSwordBeamEntity swordBeamEntity = HCEntities.GODDESS_SWORD_BEAM.create(world);
            swordBeamEntity.setOwner(user);
            swordBeamEntity.setPosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
            Vec3d vec3d = user.getRotationVec(1.0f);
            swordBeamEntity.setVelocity(vec3d.x, vec3d.y, vec3d.z, 1f, 0.0f);
            world.spawnEntity(swordBeamEntity);

            user.swingHand(hand, true);
            user.playSound(SoundEvents.ITEM_TRIDENT_THROW.value(), 1F, 1);
        }

        user.getItemCooldownManager().set(this, 30);
        stack.damage(20, user, EquipmentSlot.MAINHAND);

        return TypedActionResult.pass(mainHand);

    }

    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.hyliacraft.goddess_sword_0"));
    }
}
