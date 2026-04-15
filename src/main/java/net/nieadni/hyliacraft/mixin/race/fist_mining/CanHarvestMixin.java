package net.nieadni.hyliacraft.mixin.race.fist_mining;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        if (mainHandStack.isEmpty()) {
            HyliaCraftRace race = HyliaCraftRace.getRace(player);
            if (race == HyliaCraftRace.GORON) {
                return new ItemStack(Items.STONE_PICKAXE);
            } else if (race == HyliaCraftRace.MOGMA) {
                return new ItemStack(Items.STONE_SHOVEL);
            }
        }
        return mainHandStack;
    }
}
