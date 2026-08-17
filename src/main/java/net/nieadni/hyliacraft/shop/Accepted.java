package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.RegistryKeys;

import java.util.List;

/**
 * One item an offer will take in trade, and how many of it.
 *
 * <p>Counts sit here, per alternative, rather than once on the offer. The case that calls for a count at
 * all is usually items of unequal worth: a gold block against nine ingots. A single count for the whole
 * offer would force those into separate entries and put the same reward in the list twice, which is the
 * duplication the one-row-per-item change exists to remove.
 *
 * <p>A record rather than an {@link ItemStack}. A stack is mutable, and these are shared by every open
 * shop screen reading the same loaded price list; one careless {@code decrement} would quietly reprice an
 * offer for everyone until the next reload.
 */
public record Accepted(Item item, int count) {

    private static final PacketCodec<RegistryByteBuf, Item> ITEM =
            PacketCodecs.registryValue(RegistryKeys.ITEM);

    public static final PacketCodec<RegistryByteBuf, Accepted> PACKET_CODEC = PacketCodec.tuple(
            ITEM, Accepted::item,
            PacketCodecs.VAR_INT, Accepted::count,
            Accepted::new);

    public static final PacketCodec<RegistryByteBuf, List<Accepted>> LIST_PACKET_CODEC =
            PACKET_CODEC.collect(PacketCodecs.toList());

    /** A fresh stack of what this asks for, for drawing and for tooltips. */
    public ItemStack toStack() {
        return new ItemStack(this.item, this.count);
    }
}
