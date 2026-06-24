package net.nieadni.hyliacraft;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.race.HyliaCraftRace;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HyliaCraftPersistentState extends PersistentState {

    private static final String RACES_KEY = "race";
    private static final String NUM_TARGETERS_KEY = "numTargeters";

    public Map<UUID, HyliaCraftRace> races = new HashMap<>();
    public Map<UUID, Integer> numTargeters = new HashMap<>();

    private static final Type<HyliaCraftPersistentState> type = new Type<>(
            HyliaCraftPersistentState::new,
            HyliaCraftPersistentState::readFromNbt,
            null
    );

    public HyliaCraftRace getOrCreateRace(UUID uuid) {
        HyliaCraftRace value = races.get(uuid);
        if (value == null) {
            races.put(uuid, null);
            markDirty();
        }
        return value;
    }
    
    public int getOrCreateNumTargeters(UUID uuid) {
        Integer value = numTargeters.get(uuid);
        if (value == null) {
            value = 0;
            numTargeters.put(uuid, 0);
            markDirty();
        }
        return value;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        // Races
        NbtCompound racesNbt = new NbtCompound();
        races.forEach((uuid, race) -> {
            String key = uuid.toString();
            int value = race != null ? race.ordinal() : -1;
            racesNbt.putInt(key, value);
        });
        nbt.put(RACES_KEY, racesNbt);
        
        // Targeters
        NbtCompound numTargetersNbt = new NbtCompound();
        numTargeters.forEach((uuid, value) -> {
            String key = uuid.toString();
            numTargetersNbt.putInt(key, value);
        });
        nbt.put(NUM_TARGETERS_KEY, numTargetersNbt);
        
        return nbt;
    }

    public static HyliaCraftPersistentState readFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        HyliaCraftPersistentState state = new HyliaCraftPersistentState();

        // Races
        NbtCompound racesNbt = nbt.getCompound(RACES_KEY);
        for (String key : racesNbt.getKeys()) {
            UUID uuid = UUID.fromString(key);
            int value = racesNbt.getInt(key);
            HyliaCraftRace race = value == -1 ? null : HyliaCraftRace.fromOrdinal(value);
            state.races.put(uuid, race);
        }
        
        // Targeters
        NbtCompound numTargetersNbt = nbt.getCompound(NUM_TARGETERS_KEY);
        for (String key : numTargetersNbt.getKeys()) {
            UUID uuid = UUID.fromString(key);
            int numTargeters = numTargetersNbt.getInt(key);
            state.numTargeters.put(uuid, numTargeters);
        }

        return state;
    }

    public static HyliaCraftPersistentState getServerState(MinecraftServer server) {
        PersistentStateManager stateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        return stateManager.getOrCreate(type, HyliaCraft.MOD_ID);
    }
}