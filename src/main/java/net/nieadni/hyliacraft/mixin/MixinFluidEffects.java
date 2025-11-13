package net.nieadni.hyliacraft.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.fluid.HCFluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinFluidEffects extends Entity {

    @Inject(at = @At("TAIL"), method = "baseTick")
	private void init(CallbackInfo info) {
        System.out.println("1");
        if (!this.firstUpdate && this.fluidHeight.getDouble(HCFluidTags.SPRING_WATER) > (double)0.0F) {
            System.out.println("2");
            if ((Entity) this instanceof LivingEntity livingEntity) {
                System.out.println("3");
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5, 2, false, false, false));
            }
        }
    }

    //TODO: Give [Regeneration 2] to any [LivingEntity] which is in [Spring Water]
    // It wont go past '1' so something in the first IF is stopping it. Idk what and its draining my will to live trying to figure this shit out

    // Random Bullshit I don't need but the class does
    public MixinFluidEffects(EntityType<?> type, World world) {
        super(type, world);
    }

}