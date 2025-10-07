package net.nieadni.hyliacraft;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.UUID;

public class HyliaCraftPersistentState extends PersistentState {

    public HashMap<UUID, PlayerData> playerData = new HashMap<>();

    private static final Type<HyliaCraftPersistentState> type = new Type<>(
            HyliaCraftPersistentState::new,
            HyliaCraftPersistentState::readFromNbt,
            null
    );

    public PlayerData getOrCreatePlayerData(UUID uuid) {
        return playerData.computeIfAbsent(uuid, (u) -> new PlayerData());
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        // Inner NbtCompound for the player data
        NbtCompound playerDataNbt = new NbtCompound();

        // Add each player's data to the compound
        playerData.forEach((uuid, data) -> {
            String key = uuid.toString();
            NbtCompound value = new NbtCompound();
            data.writeNbt(value);
            playerDataNbt.put(key, value);
        });

        nbt.put("playerData", playerDataNbt);
        return nbt;
    }

    public static HyliaCraftPersistentState readFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        HyliaCraftPersistentState state = new HyliaCraftPersistentState();

        NbtCompound playerDataNbt = nbt.getCompound("playerData");
        for (String key : playerDataNbt.getKeys()) {
            UUID uuid = UUID.fromString(key);
            NbtCompound value = playerDataNbt.getCompound(key);
            PlayerData data = PlayerData.readFromNbt(value);
            state.playerData.put(uuid, data);
        }

        return state;
    }

    public static HyliaCraftPersistentState getServerState(MinecraftServer server) {
        PersistentStateManager stateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        return stateManager.getOrCreate(type, HyliaCraft.MOD_ID);
    }

    public static class PlayerData {

        public HyliaCraftRace race;

        public PlayerData(HyliaCraftRace race) {
            this.race = race;
        }

        public PlayerData() {
            this.race = null;
        }

        public void writeNbt(NbtCompound nbt) {
            nbt.putInt("race", race.ordinal());
        }

        public static PlayerData readFromNbt(NbtCompound nbt) {
            int ordinal = nbt.getInt("race");
            HyliaCraftRace race = HyliaCraftRace.values()[ordinal];
            return new PlayerData(race);
        }
    }
}