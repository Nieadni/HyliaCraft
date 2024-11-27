package net.nieadni.hyliacraft.entity.sword_beam_entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.entity.HCEntities;

public class GoddessSwordBeamEntity extends ProjectileEntity {

    //TODO: Make Beam destroy grass + flowers

    private final float damage;

    public GoddessSwordBeamEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
        damage = 2.5f;
    }

    private GoddessSwordBeamEntity(World world, float damage) {
        super(HCEntities.GODDESS_SWORD_BEAM, world);
        this.damage = damage;
    }

    public static GoddessSwordBeamEntity create(World world, float damage) {
        return new GoddessSwordBeamEntity(world, damage);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {}

    @Override
    public void tick() {
        super.tick();

        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);

        if (hitResult.getType() != HitResult.Type.MISS) {
            this.onCollision(hitResult);
        }
        this.checkBlockCollision();

        Vec3d vec3d = this.getVelocity();
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.setPosition(d, e, f);

        if (this.age > (20 * 15)) {
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity swordBeam = entityHitResult.getEntity();
        if (this.getOwner() instanceof PlayerEntity player) {
            swordBeam.damage(swordBeam.getDamageSources().playerAttack(player), damage);
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getWorld().isClient()) {
            this.discard();
        }
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }
}