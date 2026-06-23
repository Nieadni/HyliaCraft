package net.nieadni.hyliacraft.race;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.HyliaCraftPersistentState;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import net.nieadni.hyliacraft.network.InvisibleS2CPayload;
import net.nieadni.hyliacraft.network.NetworkUtils;
import net.nieadni.hyliacraft.network.RaceS2CPayload;
import net.nieadni.hyliacraft.worldgen.HCBiomeTags;

import java.util.*;

public enum HyliaCraftRace {
    HUMAN("human", 20, 0),
    HYLIAN("hylian", 24, 0),
    SKYLOFTIAN("skyloftian", 24, 0),
    ZORA("zora", 20, 60) {
        @Override
        public void applyRaceServer(ServerPlayerEntity player) {
            super.applyRaceServer(player);
            AttributeContainer attributes = player.getAttributes();
            attributes.getCustomInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY).setBaseValue(1.0);
            attributes.getCustomInstance(EntityAttributes.PLAYER_SUBMERGED_MINING_SPEED).setBaseValue(1.0);
        }

        @Override
        public void removeRaceServer(ServerPlayerEntity player) {
            super.removeRaceServer(player);
            AttributeContainer attributes = player.getAttributes();
            attributes.getCustomInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY).setBaseValue(0.0);
            attributes.getCustomInstance(EntityAttributes.PLAYER_SUBMERGED_MINING_SPEED).setBaseValue(0.2);
        }

        @Override
        public boolean useRaceAbility(PlayerEntity player) {
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
                return true;
            }
            return false;
        }
    },
    GORON("goron", 40, 0) {
        public static final Identifier MOVEMENT_SPEED_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "goron_movement_speed");

        @Override
        public void applyRaceServer(ServerPlayerEntity player) {
            super.applyRaceServer(player);
            AttributeContainer attributes = player.getAttributes();
            EntityAttributeInstance instance = attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            instance.addPersistentModifier(new EntityAttributeModifier(MOVEMENT_SPEED_MODIFIER, -0.05, EntityAttributeModifier.Operation.ADD_VALUE));
        }

        @Override
        public void removeRaceServer(ServerPlayerEntity player) {
            super.removeRaceServer(player);
            AttributeContainer attributes = player.getAttributes();
            EntityAttributeInstance instance = attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            instance.removeModifier(MOVEMENT_SPEED_MODIFIER);
        }
    },
    MOGMA("mogma", 16, 10) {
        @Override
        public void applyRaceServer(ServerPlayerEntity player) {
            super.applyRaceServer(player);
            MOGMA_DIRT_WALKING_ENABLED.put(player.getUuid(), false);
        }

        @Override
        public void applyRaceClient(PlayerEntity player) {
            super.applyRaceClient(player);
            HyliaCraftClient.mogmaDirtWalkingEnabled = false;
        }

        @Override
        public boolean useRaceAbility(PlayerEntity player) {
            super.useRaceAbility(player);
            switch (FabricLoader.getInstance().getEnvironmentType()) {
                case CLIENT -> {
                    HyliaCraftClient.mogmaDirtWalkingEnabled = !HyliaCraftClient.mogmaDirtWalkingEnabled;
                    Text message = HyliaCraftClient.mogmaDirtWalkingEnabled ? Text.translatable("hyliacraft.race.mogma.ability_on").formatted(Formatting.GREEN) : Text.translatable("hyliacraft.race.mogma.ability_off").formatted(Formatting.RED);
                    player.sendMessage(message, true);
                }
                case SERVER -> {
                    UUID uuid = player.getUuid();
                    MOGMA_DIRT_WALKING_ENABLED.put(uuid, !MOGMA_DIRT_WALKING_ENABLED.getOrDefault(uuid, false));
                }
            }
            return true;
        }
    },
    SHEIKAH("sheikah", 28, 0),
    RITO("rito", 18, 60) {
        @Override
        public void applyRaceClient(PlayerEntity player) {
            super.applyRaceClient(player);
            MinecraftClient client = MinecraftClient.getInstance();
            Entity cameraEntity = client.cameraEntity;
            if (cameraEntity == null || cameraEntity == client.player) {
                client.gameRenderer.loadPostProcessor(Identifier.of(HyliaCraft.MOD_ID, "shaders/post/rito.json"));
            }
        }

        @Override
        public void removeRaceClient(PlayerEntity player) {
            super.removeRaceClient(player);
            MinecraftClient client = MinecraftClient.getInstance();
            Entity cameraEntity = client.cameraEntity;
            if (cameraEntity == null || cameraEntity == client.player) {
                client.gameRenderer.disablePostProcessor();
            }
        }

        @Override
        public boolean useRaceAbility(PlayerEntity player) {
            if (player.isFallFlying()) {
                player.addVelocity(0.0, 0.8, 0.0);
                return true;
            }
            return false;
        }
    },
    KOKIRI("kokiri", 12, 0) {
        public static final Identifier SCALE_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "kokiri_scale");

        @Override
        public void applyRaceServer(ServerPlayerEntity player) {
            super.applyRaceServer(player);
            // Scale modifier
            AttributeContainer attributes = player.getAttributes();
            EntityAttributeInstance instance = attributes.getCustomInstance(EntityAttributes.GENERIC_SCALE);
            instance.addPersistentModifier(new EntityAttributeModifier(SCALE_MODIFIER, -0.34, EntityAttributeModifier.Operation.ADD_VALUE));
            // Invisibility
            if (checkKokiriInvisible(true, true, true, false, player)) {
                NetworkUtils.broadcast(player.getServer(), new InvisibleS2CPayload(player.getId(), true));
            }
        }

        @Override
        public void removeRaceServer(ServerPlayerEntity player) {
            super.removeRaceServer(player);
            // Scale modifier
            AttributeContainer attributes = player.getAttributes();
            EntityAttributeInstance instance = attributes.getCustomInstance(EntityAttributes.GENERIC_SCALE);
            instance.removeModifier(SCALE_MODIFIER);
            // Invisibility
            if (checkKokiriInvisible(true, true, true, false, player)) {
                NetworkUtils.broadcast(player.getServer(), new InvisibleS2CPayload(player.getId(), false));
            }
        }
    },
    GERUDO("gerudo", 26, 0);

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
    
    public static final FoodComponent GORON_EATING_COMPONENT = new FoodComponent(2, 0.3f, false, 1.6f, Optional.empty(), List.of());
    
    public static final ThreadLocal<Boolean> SHEIKAH_IS_CONTAINER_SILENCED = new ThreadLocal<>();
    
    public static final Map<Integer, Boolean> WAS_IN_INVISIBLE_BIOME = new HashMap<>();

    public static final Identifier GERUDO_MOVEMENT_SPEED_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "gerudo");
    
    public static final Map<UUID, Boolean> MOGMA_DIRT_WALKING_ENABLED = new HashMap<>();
    
    public static boolean checkKokiriInvisible(boolean targeted, boolean biome, boolean sneaking, boolean race, ServerPlayerEntity player) {
        if (sneaking && !player.isSneaking()) return false;
        if (targeted && HyliaCraftPersistentState.getServerState(player.getServer()).numTargeters.containsKey(player.getUuid())) return false;
        if (race && HyliaCraftRace.getRace(player) != HyliaCraftRace.KOKIRI) return false;
        if (biome && !player.getWorld().getBiome(player.getBlockPos()).isIn(HCBiomeTags.KOKIRI_INVISIBLE)) return false;
        return true;
    }

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

    public void applyRaceServer(ServerPlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
            player.setHealth(maxHealth);
        }
    }
    
    public void applyRaceClient(PlayerEntity player) {}

    public void removeRaceServer(ServerPlayerEntity player) {}
    
    public void removeRaceClient(PlayerEntity player) {}

    // Called on client and server
    public boolean useRaceAbility(PlayerEntity player) {
        return false;
    }

    public static HyliaCraftRace getRace(ServerPlayerEntity player) {
        UUID uuid = player.getUuid();
        HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(player.getServer());
        return state.races.get(uuid);
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
    
    public static boolean shouldDirtWalk(PlayerEntity player) {
        if (getRace(player) != MOGMA) return false;
        return switch (FabricLoader.getInstance().getEnvironmentType()) {
            case SERVER -> MOGMA_DIRT_WALKING_ENABLED.getOrDefault(player.getUuid(), false);
            case CLIENT -> HyliaCraftClient.mogmaDirtWalkingEnabled;
        };
    }

    public static void setRace(ServerPlayerEntity player, HyliaCraftRace race, boolean notifyClient) {
        MinecraftServer server = player.getServer();
        HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(server);
        UUID uuid = player.getUuid();
        HyliaCraftRace oldRace = state.getOrCreateRace(uuid);

        // Check that we even need to change the race
        if (oldRace != race) {
            // Maybe remove the old race
            if (oldRace != null) {
                oldRace.removeRaceServer(player);
            }

            // Set the race
            state.races.put(uuid, race);
            state.markDirty();

            // Apply the new race
            race.applyRaceServer(player);

            // Notify the client
            if (notifyClient) ServerPlayNetworking.send(player, new RaceS2CPayload(race));
        }
    }
}
