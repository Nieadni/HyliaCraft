package net.nieadni.hyliacraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtCustomerGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.StopAndLookAtEntityGoal;
import net.minecraft.entity.ai.goal.StopFollowingCustomerGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.shop.RupeeCostLoader;
import org.jetbrains.annotations.Nullable;

/**
 * A merchant who sells masks for rupees.
 *
 * <p>His stock is not written here. It comes from {@code rupee_costs} datapack files via
 * {@link RupeeCostLoader}, so adding an item to sell needs no code.
 */
public class HappyMaskSalesmanEntity extends MerchantEntity {

    public HappyMaskSalesmanEntity(EntityType<? extends HappyMaskSalesmanEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createHappyMaskSalesmanAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StopFollowingCustomerGoal(this));
        this.goalSelector.add(1, new LookAtCustomerGoal(this));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.35));
        this.goalSelector.add(9, new StopAndLookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public boolean isLeveledMerchant() {
        return false;
    }

    /**
     * Opens the trade screen.
     *
     * <p>{@link MerchantEntity} does not do this for us. Villagers and the wandering trader each override
     * this themselves, so a merchant without it is simply unclickable.
     */
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.isAlive() || this.hasCustomer() || this.isBaby()) {
            return super.interactMob(player, hand);
        }

        if (!this.getWorld().isClient) {
            if (this.getOffers().isEmpty()) {
                return ActionResult.CONSUME;
            }
            this.setCustomer(player);
            this.sendOffers(player, this.getDisplayName(), 1);
        }

        return ActionResult.success(this.getWorld().isClient);
    }

    /**
     * Deliberately empty while the pouch-based payment system is built.
     *
     * <p>He used to build vanilla {@link TradeOffer}s, paying in loose coins. That capped what he could
     * ever sell: a trade holds two input stacks, so any price needing three denominations, 6666 among them,
     * was unsellable no matter how rich the player was. Paying from a Rupee Pouch balance removes the cap
     * entirely, so the coin-based offers were removed rather than kept alongside.
     *
     * <p>His stock still comes from {@code rupee_costs} datapack files through {@link RupeeCostLoader};
     * only the way a player hands over the money is being replaced.
     */
    @Override
    protected void fillRecipes() {
        // No offers until pouch payment lands.
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        // Deliberately empty. He grants no experience and his prices do not drift with use.
    }
}
