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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.screen.ShopScreenFactory;
import net.nieadni.hyliacraft.shop.RupeeCost;
import net.nieadni.hyliacraft.shop.RupeeCostLoader;
import net.nieadni.hyliacraft.shop.ShopRow;
import net.nieadni.hyliacraft.shop.TraderLoader;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A merchant who sells masks for rupees.
 *
 * <p>His stock is not written here. It comes from {@code rupee_costs} datapack files via
 * {@link RupeeCostLoader}, so adding an item to sell needs no code.
 */
public class HappyMaskSalesmanEntity extends MerchantEntity {

    private static final int TICKS_PER_DAY = 24000;

    /**
     * Purchases already made from this salesman, so a second salesman is a second supply.
     *
     * <p>Keyed by item id rather than by the entry object: the price list is reloadable and every entry
     * instance is replaced on {@code /reload}, which would otherwise reset everyone's stock.
     */
    private final Map<Identifier, Integer> usesSpent = new HashMap<>();

    /** Which daily cycle this trader last restocked in. See {@link #tick()}. */
    private long lastRestockCycle = Long.MIN_VALUE;

    public HappyMaskSalesmanEntity(EntityType<? extends HappyMaskSalesmanEntity> entityType, World world) {
        super(entityType, world);
    }

    private static Identifier keyOf(RupeeCost entry) {
        return Registries.ITEM.getId(entry.item());
    }

    /** This trader's id, which is its entity type id. */
    public Identifier traderId() {
        return Registries.ENTITY_TYPE.getId(this.getType());
    }

    /** The price entries this trader stocks, cheapest first. */
    public List<RupeeCost> stock() {
        Identifier trader = traderId();
        return RupeeCostLoader.getSorted().stream().filter(entry -> entry.soldBy(trader)).toList();
    }

    /** Whether this salesman will still sell that entry. */
    public boolean isInStock(RupeeCost entry) {
        return this.usesSpent.getOrDefault(keyOf(entry), 0) < entry.maxUses();
    }

    public void recordPurchase(RupeeCost entry) {
        this.usesSpent.merge(keyOf(entry), 1, Integer::sum);
    }

    /**
     * Restocks at a time of day rather than on a private countdown.
     *
     * <p>Every trader in the world therefore refreshes together, at a moment a player can learn, and one
     * sitting in an unloaded chunk is not quietly frozen: the cycle number will have moved on by the time
     * it loads, so it catches up with a single restock rather than one per missed day.
     *
     * <p>{@code floorDiv}, not {@code /}: the expression is negative before the world's first restock
     * point, and integer division truncates toward zero, which would make cycle 0 last twice as long as
     * every other.
     */
    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            return;
        }

        long cycle = Math.floorDiv(this.getWorld().getTimeOfDay() - TraderLoader.restockAt(traderId()),
                TICKS_PER_DAY);
        if (this.lastRestockCycle == Long.MIN_VALUE) {
            this.lastRestockCycle = cycle;
            return;
        }
        if (cycle > this.lastRestockCycle) {
            // Only entries that opted into restocking come back. The rest stay spent for good, which is
            // what makes a one-off worth travelling for.
            for (RupeeCost entry : stock()) {
                if (entry.restocks()) {
                    this.usesSpent.remove(keyOf(entry));
                }
            }
            this.lastRestockCycle = cycle;
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        NbtCompound uses = new NbtCompound();
        this.usesSpent.forEach((id, spent) -> uses.putInt(id.toString(), spent));
        nbt.put("ShopUses", uses);
        nbt.putLong("LastRestockCycle", this.lastRestockCycle);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.usesSpent.clear();
        NbtCompound uses = nbt.getCompound("ShopUses");
        for (String key : uses.getKeys()) {
            Identifier id = Identifier.tryParse(key);
            if (id != null) {
                this.usesSpent.put(id, uses.getInt(key));
            }
        }
        // An entity saved before restocking moved to a time of day has neither field. Long.MIN_VALUE makes
        // tick() adopt the current cycle rather than treat the gap as many missed days.
        this.lastRestockCycle = nbt.contains("LastRestockCycle") ? nbt.getLong("LastRestockCycle")
                : Long.MIN_VALUE;
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
            List<ShopRow> rows = ShopRow.expand(stock());
            if (rows.isEmpty()) {
                return ActionResult.CONSUME;
            }
            // Marking him busy is what makes LookAtCustomerGoal and StopFollowingCustomerGoal able to
            // start at all: both return false immediately when there is no customer. Without it he keeps
            // wandering while someone has his shop open, and walking past 8 blocks closes it on them.
            this.setCustomer(player);
            player.openHandledScreen(new ShopScreenFactory(this, rows));
        }

        return ActionResult.success(this.getWorld().isClient);
    }

    /**
     * Permanently empty, by design.
     *
     * <p>He sells through his own shop screen, paid from a Rupee Pouch, so nothing goes through vanilla's
     * offer list. Filling it would cap what he can sell: a vanilla trade holds two input stacks, which
     * makes any price needing three denominations, 6666 among them, unbuyable however rich the player is.
     *
     * <p>{@link MerchantEntity} is still the base class because its goals are wanted; only the trading is
     * replaced. Stock comes from {@code rupee_costs} datapack files through {@link RupeeCostLoader}.
     */
    @Override
    protected void fillRecipes() {
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        // Deliberately empty. He grants no experience and his prices do not drift with use.
    }
}
