package net.nieadni.hyliacraft.mixin.race.goron.eating;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Redirect(method = "spawnConsumptionEffects(Lnet/minecraft/item/ItemStack;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getUseAction()Lnet/minecraft/util/UseAction;"))
    private UseAction getUseAction(ItemStack instance) {
        LivingEntity user = (LivingEntity) ((Object) this);
        if (user instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON && instance.isIn(HCItemTags.GORON_EDIBLE)) {
            return UseAction.EAT;
        }
        return instance.getUseAction();
    }
}
