package net.nieadni.hyliacraft;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.UUID;

public enum HyliaCraftRace {
    HUMAN("human", 20),
    HYLIAN("hylian", 24),
    SKYLOFTIAN("skyloftian", 24),
    ZORA("zora", 20) {
        private static final Identifier WATER_MOVEMENT_EFFICIENCY_MODIFIER = Identifier.of(HyliaCraft.MOD_ID, "zora_water_movement_efficiency");

        @Override
        public void applyRace(PlayerEntity player) {
            super.applyRace(player);
            AttributeContainer attributes = player.getAttributes();
            attributes.getCustomInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY).addPersistentModifier(new EntityAttributeModifier(
                    WATER_MOVEMENT_EFFICIENCY_MODIFIER,
                    1.0,
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        }

        @Override
        public void removeRace(PlayerEntity player) {
            super.removeRace(player);
            AttributeContainer attributes = player.getAttributes();
            attributes.getCustomInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY).removeModifier(WATER_MOVEMENT_EFFICIENCY_MODIFIER);
        }
    },
    GORON("goron", 40),
    MOGMA("mogma", 16),
    SHEIKAH("sheikah", 28),
    RITO("rito", 18),
    KOKIRI("kokiri", 12);

    public final String id;
    public final int maxHealth;

    public static final PacketCodec<RegistryByteBuf, HyliaCraftRace> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public HyliaCraftRace decode(RegistryByteBuf buf) {
            return fromOrdinal(buf.readInt());
        }

        @Override
        public void encode(RegistryByteBuf buf, HyliaCraftRace value) {
            buf.writeInt(value.ordinal());
        }
    };

    public static HyliaCraftRace fromOrdinal(int ordinal) {
        return HyliaCraftRace.values()[ordinal];
    }

    HyliaCraftRace(String id, int maxHealth) {
        this.id = id;
        this.maxHealth = maxHealth;
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

    public static HyliaCraftRace getRace(ServerPlayerEntity player) {
        UUID uuid = player.getUuid();
        HyliaCraftPersistentState state = HyliaCraftPersistentState.getServerState(player.getServer());
        HyliaCraftPersistentState.PlayerData playerData = state.playerData.get(uuid);
        return playerData != null ? playerData.race : null;
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
                race.removeRace(player);
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
