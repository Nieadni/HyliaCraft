package net.nieadni.hyliacraft.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Entity.class)
public class GoronLavaDamageMixin {

    @ModifyConstant(method = "setOnFireFromLava()V", constant = @Constant(floatValue = 4.0f))
    private float getLavaDamage(float damage) {
        Object t = this;
        if (t instanceof PlayerEntity player) {
            if (HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON) {
                return damage / 2;
            }
        }
        return damage;
    }
}
