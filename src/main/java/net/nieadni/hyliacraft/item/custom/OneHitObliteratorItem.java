package net.nieadni.hyliacraft.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.item.materials.OneHitObliteratorMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.List;
//TODO: Figure out why this mf wont enchant in an enchanting table
public class OneHitObliteratorItem extends MaceItem {
    public OneHitObliteratorItem() {
        super(new Settings().maxCount(1).rarity(Rarity.RARE).attributeModifiers(MiningToolItem.createAttributeModifiers(OneHitObliteratorMaterial.INSTANCE, -1, -2.4f)));
    }

    @Override
    public void inventoryTick(ItemStack stack, @NotNull World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity) {
            livingEntity.setHealth(1);
        }
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            if (!player.getItemCooldownManager().isCoolingDown(this)) {
                target.kill();
                player.getItemCooldownManager().set(this, 60);
            }
            else
                player.playSound(SoundEvents.BLOCK_VAULT_INSERT_ITEM_FAIL, 1F, 1);
        }
        else target.kill();
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.one_hit_obliterator_0").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.one_hit_obliterator_1").formatted(Formatting.GRAY));
    }

}
