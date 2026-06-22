package net.nieadni.hyliacraft.mixin.race.gerudo;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class MovementSpeedMixin {
    
    @Inject(method = "tick()V", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        ServerPlayerEntity me = (ServerPlayerEntity) (Object) this;
        if (HyliaCraftRace.getRace(me) == HyliaCraftRace.GERUDO) {
            EntityAttributeInstance attribute = me.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            BlockPos supportingBlockPos = me.supportingBlockPos.orElse(null);
            boolean isGerudo = HyliaCraftRace.getRace(me) == HyliaCraftRace.GERUDO;
            boolean shouldBeFast = isGerudo && supportingBlockPos != null && me.getWorld().getBlockState(supportingBlockPos).isIn(HCBlockTags.GERUDO_FAST);
            boolean isFast = attribute.hasModifier(HyliaCraftRace.GERUDO_MOVEMENT_SPEED_MODIFIER);
            if (shouldBeFast && !isFast) {
                EntityAttributeModifier modifier = new EntityAttributeModifier(HyliaCraftRace.GERUDO_MOVEMENT_SPEED_MODIFIER, 0.5, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
                attribute.addPersistentModifier(modifier);
            } else if (!shouldBeFast && isFast) {
                attribute.removeModifier(HyliaCraftRace.GERUDO_MOVEMENT_SPEED_MODIFIER);
            }
        }
    }
}
