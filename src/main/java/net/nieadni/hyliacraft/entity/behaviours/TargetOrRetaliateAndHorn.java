package net.nieadni.hyliacraft.entity.behaviours;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.nieadni.hyliacraft.entity.bokoblins.RedBokoblinEntity;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.util.BrainUtils;

public class TargetOrRetaliateAndHorn<E extends RedBokoblinEntity> extends TargetOrRetaliate<E> {

    //TODO: Get this horn to alert both Red Bokoblins and Blue

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
