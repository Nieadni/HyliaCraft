package net.nieadni.hyliacraft.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.hit.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class SwordBeamEntity extends ProjectileEntity {

    private final float damage;

    public SwordBeamEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.damage = 10.0f;  // Somehow need to get this to be something I can reference and change in the 5 different sword classes
    }

    private SwordBeamEntity(World world, float damage) {
        super(HCEntities.MASTER_SWORD_BEAM, world);
        this.damage = damage;
    }

    public static SwordBeamEntity create(World world, float damage) {
        return new SwordBeamEntity(world, damage);
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