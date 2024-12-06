package net.nieadni.hyliacraft.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InventoryOwner;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.entity.behaviours.TargetOrRetaliateAndHorn;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;

public class BokoblinEntity extends MobEntity implements SmartBrainOwner<BokoblinEntity>, InventoryOwner {
    private boolean hasHorn;
    private int hornTimer = 0;
    private SimpleInventory inventory = new SimpleInventory(9);

    protected BokoblinEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public SimpleInventory getInventory() {
        return inventory;
    }

    public boolean canBlastHorn() {
        return hasHorn && hornTimer <= 0;
    }

    public void setHornTimer(int ticks) {
        this.hornTimer = ticks;
    }

    @Override
    public List<? extends ExtendedSensor<? extends BokoblinEntity>> getSensors() {
        return List.of();
    }

    @Override
    public BrainActivityGroup<? extends BokoblinEntity> getCoreTasks() {
        return SmartBrainOwner.super.getCoreTasks();
    }

    @Override
    public BrainActivityGroup<? extends BokoblinEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
                new TargetOrRetaliateAndHorn<>()
                        .attackablePredicate(target -> target.isAlive() && !target.isInvulnerable()
                                && (target == BrainUtils.getTargetOfEntity((BokoblinEntity) this) || BokoblinEntity.isTargetableMob(target)))
                //Cook task
                //Eat task
        );
    }

    @Override
    public BrainActivityGroup<? extends BokoblinEntity> getFightTasks() {
        return SmartBrainOwner.super.getFightTasks();
    }

    public static boolean isTargetableMob(LivingEntity mob) {
        return mob instanceof PlayerEntity ||
                mob instanceof CowEntity ||
                mob instanceof SheepEntity ||
                mob instanceof PigEntity;
    }

    @Override
    protected Brain.Profile<?> createBrainProfile() {
        return new SmartBrainProvider<>(this);
    }
}
