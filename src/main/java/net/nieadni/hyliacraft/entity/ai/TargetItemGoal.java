package net.nieadni.hyliacraft.entity.ai;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;

import java.util.List;
import java.util.function.Predicate;

public class TargetItemGoal extends Goal {

    private static final int SEARCH_INTERVAL = 10;

    protected final MobEntity owner;
    protected final Predicate<ItemStack> isWanted;
    protected int sinceLastSearch = 0;
    protected ItemEntity target = null;

    public TargetItemGoal(MobEntity owner, Predicate<ItemStack> isWanted) {
        this.owner = owner;
        this.isWanted = isWanted;
    }

    protected void searchForTarget() {
        double followRange = this.owner.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
        Box searchBox = this.owner.getBoundingBox().expand(followRange, 4.0, followRange);
        List<ItemEntity> candidates = this.owner.getWorld().getEntitiesByClass(ItemEntity.class, searchBox, itemEntity -> itemEntity.getStack().isIn());
        target = null;
        double bestSquaredDistance = Double.MAX_VALUE;
        for (ItemEntity entity : candidates) {
            double d = this.owner.squaredDistanceTo(entity);
            if (d < bestSquaredDistance) {
                target = entity;
                bestSquaredDistance = d;
            }
        }
    }

    @Override
    public boolean canStart() {
        sinceLastSearch++;
        if (sinceLastSearch >= SEARCH_INTERVAL) {
            sinceLastSearch = 0;
            searchForTarget();
            return target != null;
        }
        return false;
    }

    @Override
    public void start() {
        super.start();
        this.owner.setTarget();
    }
}
