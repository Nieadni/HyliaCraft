package net.nieadni.hyliacraft.mixin.race.zora;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class DoubleDamageMixin {
    
    @Unique
    private static final TagKey<DamageType> TAG = TagKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(HyliaCraft.MOD_ID, "zora_doubled"));
    
    @Inject(method = "damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", at = @At("HEAD"))
    private void damage(DamageSource source, float pAmount, CallbackInfoReturnable<Boolean> cir, @Local(argsOnly = true) LocalFloatRef amount) {
        if (source.isIn(TAG)) {
            if (HyliaCraftRace.getRace((PlayerEntity) (Object) this) == HyliaCraftRace.ZORA) {
                amount.set(amount.get() * 2);
            }
        }
    }
}
