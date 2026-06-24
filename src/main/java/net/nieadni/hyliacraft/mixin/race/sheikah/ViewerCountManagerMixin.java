package net.nieadni.hyliacraft.mixin.race.sheikah;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ViewerCountManager.class)
public class ViewerCountManagerMixin {
    // In Vanilla, containers only keep track of the *number* of players looking at them.
    // However, we also need to know who those players are, to determine whether we should play a
    // sound: Sheikahs should not cause a sound to be played.
    
    @Unique
    private List<PlayerEntity> viewingPlayers = new ArrayList<>();
    
    @Inject(method = "openContainer(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At("HEAD"))
    private void ocUpdateViewers(PlayerEntity player, World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        viewingPlayers.add(player);
    }

    @Inject(method = "closeContainer(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At("HEAD"))
    private void ccUpdateViewers(PlayerEntity player, World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        viewingPlayers.remove(player);
    }
    
    @Inject(method = "updateViewerCount(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At("TAIL"))
    private void uvcUpdateViewers(World world, BlockPos pos, BlockState state, CallbackInfo ci, @Local(name = "list") List<PlayerEntity> list) {
        viewingPlayers = list;
    }

    @Inject(method = "openContainer(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/ViewerCountManager;onContainerOpen(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"))
    private void ocSoundCheck(PlayerEntity player, World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        // If the opener is a Sheikah, we shouldn't play a sound
        boolean isSheikah = HyliaCraftRace.getRace(player) == HyliaCraftRace.SHEIKAH;
        HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.set(isSheikah);
    }

    @Inject(method = "closeContainer(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/ViewerCountManager;onContainerClose(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"))
    private void ccSoundCheck(PlayerEntity player, World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        // If the closer is a Sheikah, we shouldn't play a sound
        boolean isSheikah = HyliaCraftRace.getRace(player) == HyliaCraftRace.SHEIKAH;
        HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.set(isSheikah);
    }
    
    @Inject(method = "updateViewerCount(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/ViewerCountManager;onContainerOpen(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"))
    private void uvcOpenSoundCheck(World world, BlockPos pos, BlockState state, CallbackInfo ci, @Local(name = "list") List<PlayerEntity> list) {
        // If all the new viewers are Sheikahs, we shouldn't play a sound
        boolean allSheikah = true;
        for (PlayerEntity player : list) {
            if (HyliaCraftRace.getRace(player) != HyliaCraftRace.SHEIKAH) allSheikah = false;
        }
        HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.set(allSheikah);
    }

    @Inject(method = "updateViewerCount(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/ViewerCountManager;onContainerClose(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"))
    private void uvcCloseSoundCheck(World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        // If all the old viewers are Sheikahs, we shouldn't play a sound
        boolean allSheikah = true;
        for (PlayerEntity player : viewingPlayers) {
            if (HyliaCraftRace.getRace(player) != HyliaCraftRace.SHEIKAH) allSheikah = false;
        }
        HyliaCraftRace.SHEIKAH_IS_CONTAINER_SILENCED.set(allSheikah);
    }
}
