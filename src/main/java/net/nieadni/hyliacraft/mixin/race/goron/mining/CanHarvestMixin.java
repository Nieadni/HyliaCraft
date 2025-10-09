package net.nieadni.hyliacraft.mixin.race.goron.mining;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class CanHarvestMixin {

    @Redirect(method = "canHarvest(Lnet/minecraft/block/BlockState;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;getMainHandStack()Lnet/minecraft/item/ItemStack;"))
    private ItemStack getMainHandStack(PlayerInventory inventory) {
        PlayerEntity player = (PlayerEntity) ((Object) this);
        ItemStack mainHandStack = inventory.getMainHandStack();
        if (HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON && mainHandStack.isEmpty()) {
            return HyliaCraftRace.GORON_FIST_MINING_STACK;
        }
        return mainHandStack;
    }
}
