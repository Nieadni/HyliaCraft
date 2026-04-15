package net.nieadni.hyliacraft.mixin.race.mogma;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;
import java.util.function.Predicate;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientFistRightClick {
    
    // We're targeting the "return ActionResult.PASS" near the bottom, hence ordinal = 5
    @Inject(method = "interactBlockInternal(Lnet/minecraft/client/network/ClientPlayerEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/util/hit/BlockHitResult;)Lnet/minecraft/util/ActionResult;", at = @At(value = "RETURN", ordinal = 4), cancellable = true)
    private void interactBlock(ClientPlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack stack = player.getStackInHand(hand);
        World world = player.getWorld();
        if (stack.isEmpty() && HyliaCraftRace.getRace(player) == HyliaCraftRace.MOGMA) {
            BlockPos blockPos = hitResult.getBlockPos();
            Block block = world.getBlockState(blockPos).getBlock();
            // Right-click = flatten; crouch + right-click = till
            if (player.isSneaking()) {
                // Maybe till the ground
                Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = HoeItem.TILLING_ACTIONS.get(block);
                if (pair != null) {
                    ItemUsageContext context = new ItemUsageContext(world, player, hand, stack, hitResult);
                    if (pair.getFirst().test(context)) {
                        world.playSound(player, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        cir.setReturnValue(ActionResult.success(true));
                    }
                }
            } else {
                // Maybe flatten the ground
                BlockState resultState = ShovelItem.PATH_STATES.get(block);
                if (resultState != null && world.getBlockState(blockPos.up()).isAir()) {
                    world.playSound(player, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    cir.setReturnValue(ActionResult.success(true));
                }
            }
        }
    }
}
