package net.nieadni.hyliacraft.entity.behaviours;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.nieadni.hyliacraft.entity.BokoblinEntity;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.util.BrainUtils;

public class TargetOrRetaliateAndHorn<E extends BokoblinEntity> extends TargetOrRetaliate<E> {

    @Override
    protected void start(E entity) {
        if (this.toTarget instanceof PlayerEntity && entity.canBlastHorn() && !BrainUtils.hasMemory(entity, MemoryModuleType.ATTACK_TARGET)) {
            entity.getWorld().playSoundFromEntity(entity,
                    SoundEvents.EVENT_RAID_HORN.value(),
                    SoundCategory.HOSTILE,
                    1f, 1f);
            entity.setHornTimer(600);
        }

        super.start(entity);
    }
}
