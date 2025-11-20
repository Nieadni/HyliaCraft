package net.nieadni.hyliacraft.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.fluid.HCFluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinFluidEffects extends Entity {

    @Inject(at = @At("TAIL"), method = "baseTick")
	private void init(CallbackInfo info) {
        if ((Entity) this instanceof LivingEntity livingEntity) {
            if (livingEntity.getBlockStateAtPos().isOf(HCBlocks.SPRING_WATER) || isSubmergedIn(HCFluidTags.SPRING_WATER)) {
                if (!livingEntity.hasStatusEffect(StatusEffects.REGENERATION)) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 2, false, false));
                }
            }
        }
        if ((Entity) this instanceof LivingEntity livingEntity) {
            if (livingEntity.getBlockStateAtPos().isOf(HCBlocks.TOXIC_WATER) || isSubmergedIn(HCFluidTags.TOXIC_WATER)) {
                if (!livingEntity.hasStatusEffect(StatusEffects.POISON)) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 5, false, false));
                }
            }
        }
        if ((Entity) this instanceof LivingEntity livingEntity) {
            if (livingEntity.isSubmergedIn(HCFluidTags.MUDDY_WATER)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 20, 255, false, false));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20, 255, false, false));
            }
        }
    }

    // Random Bullshit I don't need but the class does
    public MixinFluidEffects(EntityType<?> type, World world) {
        super(type, world);
    }

}