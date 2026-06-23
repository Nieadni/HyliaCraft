package net.nieadni.hyliacraft.mixin;

import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.HCItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public abstract class MixinPlayerEntityModel<T extends LivingEntity> {

    //TODO: Item Swaying needs fixed
    // Should probably also make it so it resets to 0 when youre not falling
    // Though youd also need to edit the view in first person for it to be down too

    @Inject(method = "setAngles", at = @At("TAIL"))
    private void onSetAngles(T entity, float limbAngle, float limbDistance,
                             float animationProgress, float headYaw, float headPitch,
                             CallbackInfo ci) {

        if (!(entity instanceof PlayerEntity player)) return;

        ItemStack mainHand = player.getMainHandStack();
        boolean holdingParaglider = mainHand.isOf(HCItems.PARAGLIDER);
        boolean hasSlowFalling = player.hasStatusEffect(StatusEffects.SLOW_FALLING);

        if (holdingParaglider && hasSlowFalling) {
            PlayerEntityModel<T> model = (PlayerEntityModel<T>) (Object) this;
            model.rightArm.pitch = -3.0F;
            model.leftArm.pitch  = -3.0F;
            model.rightSleeve.copyTransform(model.rightArm);
            model.leftSleeve.copyTransform(model.leftArm);
        }
    }
}