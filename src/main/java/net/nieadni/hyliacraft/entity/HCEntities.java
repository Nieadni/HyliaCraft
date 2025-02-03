package net.nieadni.hyliacraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.sword_beam_entities.*;

public class HCEntities {

    /**
    public static final EntityType<RockProjectile> ROCK_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "rock"),
            EntityType.Builder.create(RockProjectile::new, SpawnGroup.MISC)
                    .dimensions(0.2f, 0.2f)
                    .build()
    );
     **/

    public static final EntityType<GoddessSwordBeamEntity> GODDESS_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "goddess_sword_beam"),
            EntityType.Builder.create(GoddessSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<GoddessLongswordBeamEntity> GODDESS_LONGSWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "goddess_longsword_beam"),
            EntityType.Builder.create(GoddessLongswordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );
    public static final EntityType<GoddessWhiteSwordBeamEntity> GODDESS_WHITE_SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(HyliaCraft.MOD_ID, "goddess_white_sword_beam"),
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
            new Identifier(HyliaCraft.MOD_ID, "true_master_sword_beam"),
            EntityType.Builder.create(TrueMasterSwordBeamEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 0.1f)
                    .build()
    );

    public static void registerHyliaCraftEntities() {
        HyliaCraft.LOGGER.info(HyliaCraft.MOD_ID + " has registered its entities.");
    }
}