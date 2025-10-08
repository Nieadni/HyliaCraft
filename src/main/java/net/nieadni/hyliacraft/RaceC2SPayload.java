package net.nieadni.hyliacraft;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record RaceC2SPayload(HyliaCraftRace chosenRace) implements CustomPayload {

    public static final CustomPayload.Id<RaceC2SPayload> ID = new Id<>(Identifier.of(HyliaCraft.MOD_ID, "race_c2s"));

    public static final PacketCodec<RegistryByteBuf, RaceC2SPayload> CODEC = PacketCodec.tuple(
            HyliaCraftRace.PACKET_CODEC,
            RaceC2SPayload::chosenRace,
            RaceC2SPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RaceC2SPayload(HyliaCraftRace otherRace) && chosenRace == otherRace;
    }
}
