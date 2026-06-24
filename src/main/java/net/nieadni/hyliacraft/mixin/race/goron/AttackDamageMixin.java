package net.nieadni.hyliacraft.mixin.race.goron;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class AttackDamageMixin {

    @Shadow
    public abstract AttributeContainer getAttributes();

    @Inject(method = "getAttributeValue(Lnet/minecraft/registry/entry/RegistryEntry;)D", at = @At("HEAD"), cancellable = true)
    private void getAttributeValue(RegistryEntry<EntityAttribute> attribute, CallbackInfoReturnable<Double> cir) {
        LivingEntity livingEntity = (LivingEntity) ((Object) this);
        if (attribute == EntityAttributes.GENERIC_ATTACK_DAMAGE && livingEntity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON) {
            cir.setReturnValue(getAttributes().getValue(attribute) * 2);
        }
    }
}
