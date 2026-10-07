package net.nieadni.hyliacraft.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.race.HyliaCraftRace;

public record RaceS2CPayload(HyliaCraftRace race) implements CustomPayload {

    public static final CustomPayload.Id<RaceS2CPayload> ID = new Id<>(Identifier.of(HyliaCraft.MOD_ID, "race_s2c"));

    public static final PacketCodec<RegistryByteBuf, RaceS2CPayload> CODEC = PacketCodec.tuple(
            HyliaCraftRace.PACKET_CODEC,
            RaceS2CPayload::race,
            RaceS2CPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RaceS2CPayload(HyliaCraftRace otherRace) && race == otherRace;
    }
}
