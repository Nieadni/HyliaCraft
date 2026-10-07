package net.nieadni.hyliacraft.mixin.race.fist_mining;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Block.class)
public class DropsMixin {

    @ModifyArgs(method = "afterBreak(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/item/ItemStack;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V"))
    private void modifyTool(Args args) {
        PlayerEntity player = args.get(4);
        ItemStack tool = args.get(5);
        if (tool.isEmpty()) {
            HyliaCraftRace race = HyliaCraftRace.getRace(player);
            if (race == HyliaCraftRace.GORON) {
                args.set(5, new ItemStack(Items.STONE_PICKAXE));
            } else if (race == HyliaCraftRace.MOGMA) {
                args.set(5, new ItemStack(Items.STONE_SHOVEL));
            }
        }
    }
}
