package net.nieadni.hyliacraft.entity;

import net.minecraft.entity.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import net.nieadni.hyliacraft.HyliaCraft;

public class HCEntities {

    public static final EntityType<MasterSwordBeamEntity> MASTER_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(MasterSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );

    public static void registerHyliaCraftEntities() {
        HyliaCraft.LOGGER.info(HyliaCraft.MOD_ID + " has registered its entities.");
    }
}