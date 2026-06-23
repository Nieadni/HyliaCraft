package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Definition(id = "state", local = @Local(type = BlockState.class))
    @Definition(id = "isIn", method = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z")
    @Definition(id = "CLIMBABLE", field = "Lnet/minecraft/registry/tag/BlockTags;CLIMBABLE:Lnet/minecraft/registry/tag/TagKey;")
    @Expression("state.isIn(CLIMBABLE)")
    @ModifyExpressionValue(method = "isClimbing()Z", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean isClimbable(boolean original, @Local BlockState state) {
        if (original) return true;
        LivingEntity livingEntity = (LivingEntity) ((Object) this);
        return livingEntity instanceof PlayerEntity player 
                && HyliaCraftRace.shouldDirtWalk(player) 
                && state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH);
    }

    @Redirect(method = "applyClimbingSpeed(Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/Vec3d;", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean modifyIsOf(BlockState instance, Block block) {
        if (block == Blocks.SCAFFOLDING) {
            LivingEntity livingEntity = (LivingEntity) ((Object) this);
            if (livingEntity instanceof PlayerEntity player && HyliaCraftRace.shouldDirtWalk(player) && instance.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
                return true;
            }
        }
        return instance.isOf(block);
    }
}
