package net.nieadni.hyliacraft;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ChooseRaceC2SPayload(HyliaCraftRace chosenRace) implements CustomPayload {

    public static final CustomPayload.Id<ChooseRaceC2SPayload> ID = new Id<>(Identifier.of(HyliaCraft.MOD_ID, "choose_race_c2s"));

    public static final PacketCodec<RegistryByteBuf, ChooseRaceC2SPayload> CODEC = PacketCodec.tuple(
            HyliaCraftRace.PACKET_CODEC,
            ChooseRaceC2SPayload::chosenRace,
            ChooseRaceC2SPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ChooseRaceC2SPayload(HyliaCraftRace otherRace) && chosenRace == otherRace;
    }
}
