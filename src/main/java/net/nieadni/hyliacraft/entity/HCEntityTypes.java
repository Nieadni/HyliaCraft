package net.nieadni.hyliacraft.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.entity.bokoblins.BlueBokoblinEntity;
import net.nieadni.hyliacraft.entity.bokoblins.RedBokoblinEntity;

public class HCEntityTypes extends EntityType {
    public HCEntityTypes(EntityFactory factory, SpawnGroup spawnGroup, boolean saveable, boolean summonable, boolean fireImmune, boolean spawnableFarFromPlayer, ImmutableSet canSpawnInside, EntityDimensions dimensions, float spawnBoxScale, int maxTrackDistance, int trackTickInterval, FeatureSet requiredFeatures) {
        super(factory, spawnGroup, saveable, summonable, fireImmune, spawnableFarFromPlayer, canSpawnInside, dimensions, spawnBoxScale, maxTrackDistance, trackTickInterval, requiredFeatures);
    }

    public static EntityType register(String entityType, Builder<RedBokoblinEntity> id) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(HyliaCraft.MOD_ID, id), entityType);
    }

    public static final EntityType<RedBokoblinEntity> RED_BOKOBLIN;
    public static final EntityType<RedBokoblinEntity> BLUE_BOKOBLIN;


    static {
        RED_BOKOBLIN = register("red_bokoblin", EntityType.Builder.create(RedBokoblinEntity::new, SpawnGroup.MONSTER).dimensions(0.6F, 1.95F).eyeHeight(1.79F).passengerAttachments(2.0125F).vehicleAttachment(-0.7F).maxTrackingRange(8));
        BLUE_BOKOBLIN = register("blue_bokoblin", EntityType.Builder.create(BlueBokoblinEntity::new, SpawnGroup.MONSTER).dimensions(0.6F, 1.95F).eyeHeight(1.79F).passengerAttachments(2.0125F).vehicleAttachment(-0.7F).maxTrackingRange(8));
    }

}
