package net.nieadni.hyliacraft.race;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.HyliaCraftPersistentState;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import net.nieadni.hyliacraft.network.RaceS2CPayload;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public enum HyliaCraftRace {
    HUMAN("human", 20, 0),
    HYLIAN("hylian", 24, 0),
    SKYLOFTIAN("skyloftian", 24, 0),
    ZORA("zora", 20, 60) {
        @Override
        public void applyRace(PlayerEntity player) {
            super.applyRace(player);
            AttributeContainer attributes = player.getAttributes();
            attributes.getCustomInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY).setBaseValue(1.0);
            attributes.getCustomInstance(EntityAttributes.PLAYER_SUBMERGED_MINING_SPEED).setBaseValue(1.0);
        }

        @Override
        public void removeRace(PlayerEntity player) {
            super.removeRace(player);
            AttributeContainer attributes = player.getAttributes();
            attributes.getCustomInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY).setBaseValue(0.0);
            attributes.getCustomInstance(EntityAttributes.PLAYER_SUBMERGED_MINING_SPEED).setBaseValue(0.2);
        }

        @Override
        public void useRaceAbility(PlayerEntity player) {
            super.useRaceAbility(player);
            if (player.isTouchingWaterOrRain()) {
                // Do the spin attack
                float yaw = player.getYaw();
                float pitch = player.getPitch();
                float x = -MathHelper.sin(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));
                float y = -MathHelper.sin(pitch * (float) (Math.PI / 180.0));
                float z = MathHelper.cos(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));

                float length = MathHelper.sqrt(x * x + y * y + z * z);
                float strength = 3.0f;
                x *= strength / length;
                y *= strength / length;
                z *= strength / length;
                player.addVelocity(x, y, z);

                player.useRiptide(20, 8.0F, player.getMainHandStack());

                if (player.isOnGround()) {
                    player.move(MovementType.SELF, new Vec3d(0.0, 1.1999999F, 0.0));
                }

                World world = player.getWorld();
                world.playSoundFromEntity(null, player, SoundEvents.ITEM_TRIDENT_RIPTIDE_3.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }
    },
    GORON("goron", 40, 0) {
        public static final Identifier MOVEMENT_SPEED_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "goron_movement_speed");

        @Override
        public void applyRace(PlayerEntity player) {
            super.applyRace(player);
            AttributeContainer attributes = player.getAttributes();
            EntityAttributeInstance instance = attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            instance.addPersistentModifier(new EntityAttributeModifier(MOVEMENT_SPEED_MODIFIER, -0.05, EntityAttributeModifier.Operation.ADD_VALUE));
        }

        @Override
        public void removeRace(PlayerEntity player) {
            super.removeRace(player);
            AttributeContainer attributes = player.getAttributes();
            EntityAttributeInstance instance = attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            instance.removeModifier(MOVEMENT_SPEED_MODIFIER);
        }
    },
    MOGMA("mogma", 16, 0),
    SHEIKAH("sheikah", 28, 0),
    RITO("rito", 18, 0),
    KOKIRI("kokiri", 12, 0);

    public final String id;
    public final int maxHealth;
    public final int abilityCooldown;

    public static final PacketCodec<RegistryByteBuf, HyliaCraftRace> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public HyliaCraftRace decode(RegistryByteBuf buf) {
            int ordinal = buf.readInt();
            return ordinal == -1 ? null : fromOrdinal(ordinal);
        }

        @Override
        public void encode(RegistryByteBuf buf, HyliaCraftRace value) {
            int ordinal = value == null ? -1 : value.ordinal();
            buf.writeInt(ordinal);
        }
    };

    public static final ItemStack GORON_FIST_MINING_STACK = new ItemStack(Items.STONE_PICKAXE);

    public static final FoodComponent GORON_EATING_COMPONENT = new FoodComponent(2, 0.3f, false, 1.6f, Optional.empty(), List.of());

    public static HyliaCraftRace fromOrdinal(int ordinal) {
        return HyliaCraftRace.values()[ordinal];
    }

    HyliaCraftRace(String id, int maxHealth, int abilityCooldown) {
        this.id = id;
        this.maxHealth = maxHealth;
        this.abilityCooldown = abilityCooldown;
    }

    public Text getName() {
        return Text.translatable("hyliacraft.race.%s.name".formatted(this.id));
    }

    public Text getDescription() {
        return Text.translatable("hyliacraft.race.%s.description".formatted(this.id));
    }

    public Text getAbilities() {
        return Text.translatable("hyliacraft.race.%s.abilities".formatted(this.id));
    }

    public void applyRace(PlayerEntity player) {
        player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    }

    public void removeRace(PlayerEntity player) {}

    // Called on client and server
    public void useRaceAbility(PlayerEntity player) {}

    public static HyliaCraftRace getRace(ServerPlayerEntity player) {
        UUID uuid = player.getUuid();
        HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(player.getServer());
        HyliaCraftPersistentState.PlayerData playerData = state.playerData.get(uuid);
        return playerData != null ? playerData.race : null;
    }

    public static HyliaCraftRace getRace(PlayerEntity player) {
        switch (FabricLoader.getInstance().getEnvironmentType()) {
            case SERVER -> {
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    return HyliaCraftRace.getRace(serverPlayer);
                }
            }
            case CLIENT -> {
                ClientPlayerEntity myPlayer = MinecraftClient.getInstance().player;
                if (myPlayer != null && myPlayer.getUuid().equals(player.getUuid())) {
                    return HyliaCraftClient.race;
                }
            }
        }
        return null;
    }

    public static void setRace(ServerPlayerEntity player, HyliaCraftRace race, boolean notifyClient) {
        MinecraftServer server = player.getServer();
        HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(server);
        UUID uuid = player.getUuid();
        HyliaCraftPersistentState.PlayerData playerData = state.getOrCreatePlayerData(uuid);

        // Check that we even need to change the race
        if (playerData.race != race) {
            // Maybe remove the old race
            if (playerData.race != null) {
                playerData.race.removeRace(player);
            }

            // Set the race
            playerData.race = race;
            state.markDirty();

            // Apply the new race
            race.applyRace(player);

            // Notify the client
            if (notifyClient) ServerPlayNetworking.send(player, new RaceS2CPayload(race));
        }
    }
}
