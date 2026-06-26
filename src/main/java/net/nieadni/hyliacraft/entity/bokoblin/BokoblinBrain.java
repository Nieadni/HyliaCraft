package net.nieadni.hyliacraft.entity.bokoblin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.*;
import net.minecraft.item.Items;

public class BokoblinBrain {

    protected static Brain<BokoblinEntity> create(BokoblinEntity owner, Brain<BokoblinEntity> brain) {
        // Fighting
        brain.setTaskList(
                Activity.FIGHT,
                10,
                ImmutableList.of(
                        ForgetAttackTargetTask.create(),
                        RangedApproachTask.create(1.0f),
                        MeleeAttackTask.create(20),

                ),
                MemoryModuleType.ATTACK_TARGET
        );
        // Idle

        return brain;
    }
}
