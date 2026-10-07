package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.RegistryKeys;

import java.util.List;

public record Accepted(Item item, int count) {

    private static final PacketCodec<RegistryByteBuf, Item> ITEM =
            PacketCodecs.registryValue(RegistryKeys.ITEM);

    public static final PacketCodec<RegistryByteBuf, Accepted> PACKET_CODEC = PacketCodec.tuple(
            ITEM, Accepted::item,
            PacketCodecs.VAR_INT, Accepted::count,
            Accepted::new);

    public static final PacketCodec<RegistryByteBuf, List<Accepted>> LIST_PACKET_CODEC =
            PACKET_CODEC.collect(PacketCodecs.toList());

    public ItemStack toStack() {
        return new ItemStack(this.item, this.count);
    }
}
