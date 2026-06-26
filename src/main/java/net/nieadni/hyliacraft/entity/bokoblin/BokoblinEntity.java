package net.nieadni.hyliacraft.entity.bokoblin;

import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.instrument.HCInstrumentTags;
import org.jetbrains.annotations.Nullable;

public class BokoblinEntity extends HostileEntity implements InventoryOwner {

    private static final TrackedData<Integer> COLOUR = DataTracker.registerData(BokoblinEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final String COLOUR_KEY = "Colour";

    private final SimpleInventory inventory = new SimpleInventory(9);

    public BokoblinEntity(EntityType<? extends BokoblinEntity> entityType, World world) {
        super(entityType, world);
        this.setCanPickUpLoot(true);
    }

    public static DefaultAttributeContainer.Builder createBokoblinAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(COLOUR, Colour.RED.ordinal());
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(10, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(5, new ActiveTargetGoal<>(this, PigEntity.class, true));
        this.goalSelector.add(5, new ActiveTargetGoal<>(this, SheepEntity.class, true));
        this.goalSelector.add(5, new ActiveTargetGoal<>(this, CowEntity.class, true));
        this.goalSelector.add(2, new ActiveTargetGoal<>(this, ItemEntity.class, true, e -> e instanceof ItemEntity item && item.getStack().isIn()))
    }

    @Override
    public @Nullable EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        this.equipStack(EquipmentSlot.MAINHAND, makeMainhandStack());
        this.equipStack(EquipmentSlot.OFFHAND, makeOffhandStack());
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public Colour getColour() {
        return Colour.values()[this.dataTracker.get(COLOUR)];
    }

    public void setColour(Colour colour) {
        this.dataTracker.set(COLOUR, colour.ordinal());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains(COLOUR_KEY, NbtElement.INT_TYPE)) {
            this.dataTracker.set(COLOUR, nbt.getInt(COLOUR_KEY));
        }
        this.readInventory(nbt, this.getRegistryManager());
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt(COLOUR_KEY, this.dataTracker.get(COLOUR));
        this.writeInventory(nbt, this.getRegistryManager());
    }

    protected ItemStack makeMainhandStack() {
        return this.getColour().makeMainhandStack(this);
    }

    protected ItemStack makeOffhandStack() {
        return this.getColour().makeOffhandStack(this);
    }

    @Override
    public SimpleInventory getInventory() {
        return inventory;
    }

    @Override
    protected void loot(ItemEntity item) {
        InventoryOwner.pickUpItem(this, this, item);
    }

    public enum Colour {
        RED(Identifier.of(HyliaCraft.MOD_ID, "textures/entity/bokoblin/red.png")) {
            @Override
            public ItemStack makeMainhandStack(BokoblinEntity me) {
                Random random = me.getEntityWorld().getRandom();
                float f = random.nextFloat();
                if (f < 0.65f) return ItemStack.EMPTY;
                if (f < 0.75f) return new ItemStack(Items.BOW);
                if (f < 0.80f) return new ItemStack(Items.WOODEN_SWORD);
                if (f < 0.85f) return new ItemStack(Items.WOODEN_PICKAXE);
                if (f < 0.90f) return new ItemStack(Items.WOODEN_AXE);
                if (f < 0.95f) return new ItemStack(Items.WOODEN_SHOVEL);
                return new ItemStack(Items.WOODEN_HOE);
            }

            @Override
            public ItemStack makeOffhandStack(BokoblinEntity me) {
                Random random = me.getEntityWorld().getRandom();
                float f = random.nextFloat();
                if (f < 0.9f) return ItemStack.EMPTY;
                return makeGoatHorn(random);
            }
        },
        BLUE(Identifier.of(HyliaCraft.MOD_ID, "textures/entity/bokoblin/blue.png")) {
            @Override
            public ItemStack makeMainhandStack(BokoblinEntity me) {
                Random random = me.getEntityWorld().getRandom();
                float f = random.nextFloat();
                if (f < 0.40f) return ItemStack.EMPTY;
                if (f < 0.50f) return new ItemStack(Items.BOW);
                if (f < 0.55f) return new ItemStack(Items.STONE_SWORD);
                if (f < 0.60f) return new ItemStack(Items.STONE_PICKAXE);
                if (f < 0.65f) return new ItemStack(Items.STONE_AXE);
                if (f < 0.70f) return new ItemStack(Items.STONE_SHOVEL);
                if (f < 0.75f) return new ItemStack(Items.STONE_HOE);
                if (f < 0.80f) return new ItemStack(Items.WOODEN_SWORD);
                if (f < 0.85f) return new ItemStack(Items.WOODEN_PICKAXE);
                if (f < 0.90f) return new ItemStack(Items.WOODEN_AXE);
                if (f < 0.95f) return new ItemStack(Items.WOODEN_SHOVEL);
                return new ItemStack(Items.WOODEN_HOE);
            }

            @Override
            public ItemStack makeOffhandStack(BokoblinEntity me) {
                Random random = me.getEntityWorld().getRandom();
                float f = random.nextFloat();
                if (f < 0.8f) return ItemStack.EMPTY;
                return makeGoatHorn(random);
            }
        };

        public final Identifier texture;

        Colour(Identifier texture) {
            this.texture = texture;
        }

        private static ItemStack makeGoatHorn(Random random) {
            return new ItemStack(Items.GOAT_HORN.getRegistryEntry(), 1, ComponentChanges.builder().add(DataComponentTypes.INSTRUMENT, Registries.INSTRUMENT.getRandomEntry(HCInstrumentTags.BOKOBLIN_HORNS, random).orElseThrow()).build());
        }

        public ItemStack makeMainhandStack(BokoblinEntity me) {
            return ItemStack.EMPTY;
        }

        public ItemStack makeOffhandStack(BokoblinEntity me) {
            return ItemStack.EMPTY;
        }
    }
}
