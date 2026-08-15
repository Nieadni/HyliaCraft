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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradedItem;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.shop.RupeeChange;
import net.nieadni.hyliacraft.shop.RupeeCost;
import net.nieadni.hyliacraft.shop.RupeeCostLoader;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

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

    @Override
    protected void fillRecipes() {
        TradeOfferList offers = this.getOffers();

        for (RupeeCost entry : RupeeCostLoader.getSorted()) {
            // An extra input item claims one of the two slots, leaving one for rupees.
            int rupeeSlots = entry.accepts().isEmpty() ? 2 : 1;
            Optional<List<ItemStack>> payment = RupeeChange.solve(entry.cost(), rupeeSlots);

            if (payment.isEmpty()) {
                // The price cannot be made from the rupees that fit. Majora's Mask at 6666 lands here, so
                // he simply does not offer it. That is the intended state until the Rupee Pouch exists.
                continue;
            }

            List<ItemStack> rupees = payment.get();

            if (entry.accepts().isEmpty()) {
                if (rupees.isEmpty()) {
                    // Free, with nothing at all to hand over. There is no trade to make.
                    continue;
                }
                TradedItem first = tradedItem(rupees.get(0));
                Optional<TradedItem> second = rupees.size() > 1
                        ? Optional.of(tradedItem(rupees.get(1)))
                        : Optional.<TradedItem>empty();
                offers.add(buildOffer(first, second, entry));
            } else {
                // One offer per accepted item: a trade input takes a single item, not a tag, so "a pumpkin
                // or a carved pumpkin" cannot be expressed as one offer.
                for (Item accepted : entry.accepts()) {
                    Optional<TradedItem> second = rupees.isEmpty()
                            ? Optional.<TradedItem>empty()
                            : Optional.of(tradedItem(rupees.get(0)));
                    offers.add(buildOffer(new TradedItem(accepted, 1), second, entry));
                }
            }
        }
    }

    private static TradedItem tradedItem(ItemStack stack) {
        return new TradedItem(stack.getItem(), stack.getCount());
    }

    private TradeOffer buildOffer(TradedItem first, Optional<TradedItem> second, RupeeCost entry) {
        // No merchant experience and no price multiplier: prices are set by datapack and should stay put.
        return new TradeOffer(first, second, new ItemStack(entry.item()), entry.maxUses(), 0, 1.0F);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        // Deliberately empty. He grants no experience and his prices do not drift with use.
    }
}
