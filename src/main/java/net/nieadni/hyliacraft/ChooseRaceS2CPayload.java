package net.nieadni.hyliacraft;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class ChooseRaceS2CPayload implements CustomPayload {

    public static final CustomPayload.Id<ChooseRaceS2CPayload> ID = new Id<>(Identifier.of(HyliaCraft.MOD_ID, "choose_race_s2c"));

    public static final ChooseRaceS2CPayload INSTANCE = new ChooseRaceS2CPayload();

    public static final PacketCodec<RegistryByteBuf, ChooseRaceS2CPayload> CODEC = PacketCodec.unit(INSTANCE);

    private ChooseRaceS2CPayload() {}

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ChooseRaceS2CPayload;
    }
}
