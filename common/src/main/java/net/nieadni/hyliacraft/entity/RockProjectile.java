package net.nieadni.hyliacraft.entity;

public class RockProjectile {/**extends ProjectileEntity {
    private final float damage;


    public RockProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.damage = 5f; // The amount of damage the rock will deal
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {}

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity swordBeam = entityHitResult.getEntity();
        if (this.getOwner() instanceof PlayerEntity player) {
            swordBeam.damage(swordBeam.getDamageSources().playerAttack(player), damage);
        }
    }

    @Override
    protected void onBlockCollision(BlockState state) { // called on collision with a block
        super.onBlockCollision(state);
        if (!this.getWorld().isClient) { // checks if the world is client
            this.getWorld().sendEntityStatus(this, (byte)3); // particle?
            Random random = new Random();
            if (random.nextFloat() < 0.75) { // 75% chance to drop cobblestone
                this.dropItem(Items.COBBLESTONE);
            }
            this.kill(); // kills the projectile
        }

    }
    **/
}
