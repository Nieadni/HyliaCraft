package net.nieadni.hyliacraft.entity.sword_beam_entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.entity.HCEntities;

public class GoddessLongswordBeamEntity extends ProjectileEntity {

    //TODO: Make Beam destroy grass + flowers

    private final float damage;
    private static final TrackedData<Boolean> VERTICAL = DataTracker.registerData(GoddessLongswordBeamEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public boolean isVertical() { return this.dataTracker.get(VERTICAL); }
    public void setVertical(boolean i) { this.dataTracker.set(VERTICAL, i); }

    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(VERTICAL, false);
    }

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Vertical", this.isVertical());
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setVertical(nbt.getBoolean("Vertical"));
    }

    public GoddessLongswordBeamEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
        damage = 5.5f;
    }

    private GoddessLongswordBeamEntity(World world, float damage) {
        super(HCEntities.GODDESS_LONGSWORD_BEAM, world);
        this.damage = damage;
    }

    public static GoddessLongswordBeamEntity create(World world, float damage) {
        return new GoddessLongswordBeamEntity(world, damage);
    }

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

        this.updateRotation();
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