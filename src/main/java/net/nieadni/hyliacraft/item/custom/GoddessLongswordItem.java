package net.nieadni.hyliacraft.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.entity.sword_beam_entities.GoddessLongswordBeamEntity;
import net.nieadni.hyliacraft.item.materials.GoddessLongswordMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;

//TODO: Item Combining (main hand sword, off hand nayru_flame) to make Goddess White Sword
public class GoddessLongswordItem extends MasterSwordItem {

    public static final int DURABILITY_TIMER = 400;
    public static final String DURABILITY_KEY = "durabilityHealTimer";

    public GoddessLongswordItem() {
        super(GoddessLongswordMaterial.INSTANCE, new Item.Settings().attributeModifiers(createAttributeModifiers(GoddessLongswordMaterial.INSTANCE,1, -2.4F)).fireproof().rarity(Rarity.RARE));
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
            timer = 400;    // every X ticks (1 second = 20 ticks)
        } else timer--;
        nbt.putInt(DURABILITY_KEY, timer);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }

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

    /*
    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, @NotNull Hand hand) {

        ItemStack stack = user.getMainHandStack();
        if (user.isSneaking()) {

            GoddessLongswordBeamEntity swordBeamEntity = HCEntities.GODDESS_LONGSWORD_BEAM.create(world);
            swordBeamEntity.setOwner(user);
            swordBeamEntity.setPosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
            Vec3d vec3d = user.getRotationVec(1.0f);
            swordBeamEntity.setVelocity(vec3d.x, vec3d.y, vec3d.z, 1f, 0.0f);
            swordBeamEntity.setYaw(user.getHeadYaw());
            world.spawnEntity(swordBeamEntity);

        }

        else {

            GoddessLongswordBeamEntity swordBeamEntity = HCEntities.GODDESS_LONGSWORD_BEAM.create(world);
            swordBeamEntity.setOwner(user);
            swordBeamEntity.setPosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
            Vec3d vec3d = user.getRotationVec(1.0f);
            swordBeamEntity.setVelocity(vec3d.x, vec3d.y, vec3d.z, 1f, 0.0f);
            swordBeamEntity.setYaw(user.getHeadYaw());
            world.spawnEntity(swordBeamEntity);
            // Need to make this else part, a vertical beam

        }

        user.getItemCooldownManager().set(this, 30);
        stack.damage(20, user, EquipmentSlot.MAINHAND);

        return TypedActionResult.fail(stack);
    }
     */

    // REMOVE WIP HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("tooltip.hyliacraft.goddess_longsword"));
    }

}