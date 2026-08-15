package net.nieadni.hyliacraft.item.armour;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.client.armour.MajorasMaskRenderer;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class MajorasMaskItem extends ArmorItem implements GeoItem {

    /**
     * How long striking a hostile mob leaves the wearer visible to them.
     *
     * <p>The same range every neutral mob in vanilla uses once provoked: zombified piglins, endermen,
     * wolves, iron golems, polar bears and bees all anger for 20 to 39 seconds.
     */
    private static final UniformIntProvider PROVOKED_TIME = TimeHelper.betweenSeconds(20, 39);

    /**
     * Wearers who have attacked recently, and the world time their reprieve ends.
     *
     * <p>Deliberately not persisted. Half a minute of anger is not worth surviving a restart, and a
     * player who logs out mid-fight has arguably escaped.
     */
    private static final Map<UUID, Long> PROVOKED_UNTIL = new ConcurrentHashMap<>();

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

    // REMOVE WIP ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.majoras_mask1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.hyliacraft.majoras_mask2").formatted(Formatting.GRAY));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("tooltip.hyliacraft.rare_item").formatted(Formatting.GRAY));
    }

    /** Whether this entity is wearing the mask on its head. Carrying one in a bag does nothing. */
    public static boolean isWorn(LivingEntity entity) {
        return entity.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof MajorasMaskItem;
    }

    /**
     * Whether hostile mobs should overlook this entity.
     *
     * <p>True while the mask is worn and its wearer has not recently attacked one of them.
     */
    public static boolean hidesFrom(LivingEntity entity) {
        return isWorn(entity) && !isProvoked(entity);
    }

    /** Called when a wearer strikes a hostile mob. Each hit restarts the reprieve. */
    public static void provoke(LivingEntity wearer) {
        PROVOKED_UNTIL.put(wearer.getUuid(),
                wearer.getWorld().getTime() + PROVOKED_TIME.get(wearer.getRandom()));
    }

    private static boolean isProvoked(LivingEntity entity) {
        Long until = PROVOKED_UNTIL.get(entity.getUuid());
        if (until == null) {
            return false;
        }
        if (entity.getWorld().getTime() >= until) {
            PROVOKED_UNTIL.remove(entity.getUuid());
            return false;
        }
        return true;
    }

    @Override
    public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> consumer) {
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
    public void registerControllers(AnimatableManager.@NotNull ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 0, state -> PlayState.STOP));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

}