package net.nieadni.hyliacraft.item.armour;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import net.nieadni.hyliacraft.client.armour.MajorasMaskRenderer;

import org.jetbrains.annotations.*;

import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

// TODO: Make it so the mask makes hostile mobs neutral to player
// TODO: Make it so the mask makes Endermen not attack when you look at them
public class MajorasMaskItem extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public MajorasMaskItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, @NotNull World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {

            // Ensure the item is in the head slot
            if (player.getEquippedStack(EquipmentSlot.HEAD).isOf(this.asItem())) {

                // Remove blindness and darkness effects
                if (player.hasStatusEffect(StatusEffects.BLINDNESS)) {

                    player.removeStatusEffect(StatusEffects.BLINDNESS);

                }
                if (player.hasStatusEffect(StatusEffects.DARKNESS)) {

                    player.removeStatusEffect(StatusEffects.DARKNESS);

                }
            }
        }
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.majoras_mask1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.majoras_mask2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.majoras_mask3").formatted(Formatting.GRAY));
    }

    // Geckolib Stuff (:vomiting_face:)
    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public @Nullable <T extends LivingEntity> BipedEntityModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable BipedEntityModel<T> original) {

                if (this.renderer == null)
                    this.renderer = new MajorasMaskRenderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 0, state -> PlayState.STOP));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}