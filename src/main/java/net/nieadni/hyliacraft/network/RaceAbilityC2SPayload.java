package net.nieadni.hyliacraft.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class RaceAbilityC2SPayload implements CustomPayload {

    public static RaceAbilityC2SPayload INSTANCE = new RaceAbilityC2SPayload();

    public static final CustomPayload.Id<RaceAbilityC2SPayload> ID = new Id<>(Identifier.of(HyliaCraft.MOD_ID, "race_ability_c2s"));

    public static final PacketCodec<RegistryByteBuf, RaceAbilityC2SPayload> CODEC = new PacketCodec<>() {
        @Override
        public RaceAbilityC2SPayload decode(RegistryByteBuf buf) {
            return INSTANCE;
        }

        @Override
        public void encode(RegistryByteBuf buf, RaceAbilityC2SPayload value) {}
    };

    private RaceAbilityC2SPayload() {}

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
