package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Redirect(method = "isClimbing()Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean modifyIsClimbing(BlockState blockState, TagKey<Block> tag) {
        if (tag == BlockTags.CLIMBABLE) {
            LivingEntity livingEntity = (LivingEntity) ((Object) this);
            if (livingEntity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.MOGMA && blockState.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
                return true;
            }
        }
        return blockState.isIn(tag);
    }

    @Redirect(method = "applyClimbingSpeed(Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/Vec3d;", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean modifyIsOf(BlockState instance, Block block) {
        if (block == Blocks.SCAFFOLDING) {
            LivingEntity livingEntity = (LivingEntity) ((Object) this);
            if (livingEntity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.MOGMA && instance.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
                return true;
            }
        }
        return instance.isOf(block);
    }
}
