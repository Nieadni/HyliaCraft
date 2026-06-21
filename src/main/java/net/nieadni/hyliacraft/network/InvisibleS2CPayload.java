package net.nieadni.hyliacraft.network;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.HashMap;
import java.util.Map;

public record InvisibleS2CPayload(Map<Integer, Boolean> updates) implements CustomPayload {

    public static final Id<InvisibleS2CPayload> ID = new Id<>(Identifier.of(HyliaCraft.MOD_ID, "targeted_s2c"));

    public static final PacketCodec<RegistryByteBuf, InvisibleS2CPayload> CODEC = PacketCodec.of(InvisibleS2CPayload::write, InvisibleS2CPayload::new);

    private InvisibleS2CPayload(PacketByteBuf buf) {
        this(new HashMap<>());
        int count = buf.readInt();
        for (int i = 0; i < count; i++) {
            int id = buf.readInt();
            boolean isInvisible = buf.readBoolean();
            updates.put(id, isInvisible);
        }
    }
    
    public InvisibleS2CPayload(int id, boolean isInvisible) {
        this(Map.of(id, isInvisible));
    }
    
    private void write(PacketByteBuf buf) {
        buf.writeInt(updates.size());
        updates.forEach((id, isInvisible) -> {
            buf.writeInt(id);
            buf.writeBoolean(isInvisible);
        });
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
