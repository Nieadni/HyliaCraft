package net.nieadni.hyliacraft.entity.behaviours;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.nieadni.hyliacraft.entity.BokoblinEntity;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;

public class CookFoodBehaviour<E extends BokoblinEntity> extends ExtendedBehaviour<E> {
    private static final List<Pair<MemoryModuleType<?>, MemoryModuleState>> MEMORY_REQS = ObjectArrayList.of(Pair.of(MemoryModuleType.ATTACK_TARGET, MemoryModuleState.VALUE_ABSENT), Pair.of(MemoryModuleType.WALK_TARGET, MemoryModuleState.REGISTERED));

    private BlockPos campfirePos;
    private Path path;

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryModuleState>> getMemoryRequirements() {
        return MEMORY_REQS;
    }

    @Override
    protected boolean shouldRun(ServerWorld level, E entity) {
        if (!entity.getInventory().containsAny(stack -> stack.isIn(HCItemTags.BOKOBLIN_FOOD))) return false;

        this.campfirePos = findCampfire(entity, 50d);

        return campfirePos != null && this.path != null;
    }

    @Override
    protected void start(E entity) {
        if (BrainUtils.hasMemory(entity, MemoryModuleType.ATTACK_TARGET)) return;

        
    }

    @Override
    protected void stop(E entity) {
        this.campfirePos = null;
        this.path = null;
    }

    private BlockPos findCampfire(E entity, double searchDistance) {
        BlockPos blockPos = entity.getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int i = 0; (double)i <= searchDistance; i = i > 0 ? -i : 1 - i) {
            for(int j = 0; (double)j < searchDistance; ++j) {
                for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                    for(int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                        mutable.set(blockPos, k, i - 1, l);
                        if (blockPos.isWithinDistance(mutable, searchDistance)
                                && entity.getWorld().getBlockEntity(blockPos) instanceof CampfireBlockEntity fire
                                && campfireHasSpace(fire)) {
                            this.path = entity.getNavigation().findPathTo(blockPos, 0);
                            if (this.path != null) return blockPos;
                        }
                    }
                }
            }
        }

        return null;
    }

    private boolean campfireHasSpace(CampfireBlockEntity entity) {
        for (int i = 0; i < entity.getItemsBeingCooked().size(); i++) {
            if (entity.getItemsBeingCooked().get(i).isEmpty()) return true;
        }
        return false;
    }
}
