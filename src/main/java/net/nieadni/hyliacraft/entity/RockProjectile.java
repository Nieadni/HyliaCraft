package net.nieadni.hyliacraft.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.Random;

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
