package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShapes;
import net.nieadni.hyliacraft.block.HCBlockTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Shadow
    private EntityDimensions dimensions;

    @Inject(method = "canClimb(Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
    private void canClimb(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity) ((Object) this);
        if (entity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.MOGMA && state.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "isInsideWall()Z", at = @At(value = "HEAD"), cancellable = true)
    private void shouldSuffocate(CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity) ((Object) this);
        if (entity instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.MOGMA && !player.noClip) {
            float f = this.dimensions.width() * 0.8F;
            Box box = Box.of(player.getEyePos(), f, 1.0E-6, f);
            cir.setReturnValue(BlockPos.stream(box).anyMatch(pos -> {
                BlockState blockState = player.getWorld().getBlockState(pos);
                return !blockState.isAir() && blockState.shouldSuffocate(player.getWorld(), pos) && !blockState.isIn(HCBlockTags.MOGMA_CAN_WALK_THROUGH) && VoxelShapes.matchesAnywhere(
                        blockState
                                .getCollisionShape(player.getWorld(), pos)
                                .offset(pos.getX(), pos.getY(), pos.getZ()),
                        VoxelShapes.cuboid(box),
                        BooleanBiFunction.AND
                );
            }));
        }
    }
}
