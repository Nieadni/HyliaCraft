package net.nieadni.hyliacraft.entity;

import net.minecraft.entity.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.bokoblins.RedBokoblinEntity;
import net.nieadni.hyliacraft.entity.sword_beam_entities.*;

public class HCEntities {

    public static final EntityType<RedBokoblinEntity> RED_BOKOBLIN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "red_bokoblin"),
            EntityType.Builder.create(RedBokoblinEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<RedBokoblinEntity> BLUE_BOKOBLIN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(RedBokoblinEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );

    public static final EntityType<GoddessSwordBeamEntity> GODDESS_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(GoddessSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<GoddessLongswordBeamEntity> GODDESS_LONGSWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(GoddessLongswordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<GoddessWhiteSwordBeamEntity> GODDESS_WHITE_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(GoddessWhiteSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<MasterSwordBeamEntity> MASTER_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(MasterSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<TrueMasterSwordBeamEntity> TRUE_MASTER_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "master_sword_beam"),
            EntityType.Builder.create(TrueMasterSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );

    public static void registerHyliaCraftEntities() {
        HyliaCraft.LOGGER.info(HyliaCraft.MOD_ID + " has registered its entities.");
    }
}