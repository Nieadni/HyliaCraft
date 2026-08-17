package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.RegistryKeys;

import java.util.List;

/**
 * One row of the salesman's shop, as the client sees it.
 *
 * <p>Prices come from server-side datapacks, which are never sent to clients, so the list travels with the
 * screen when it opens. Only what the client draws is included; stock rules stay on the server.
 *
 * <p>One row per thing sold. An entry offering a choice of trade-in items is a single row that will take
 * any of them, not a row each: a shop listing the Pumpkin Mask twice reads as two different masks.
 *
 * @param accepts items this row will take alongside the rupees, any one of which will do. Empty when the
 *                price is rupees alone
 */
public record ShopEntry(Item item, int cost, List<Item> accepts) {

    private static final PacketCodec<RegistryByteBuf, Item> ITEM =
            PacketCodecs.registryValue(RegistryKeys.ITEM);

    public static final PacketCodec<RegistryByteBuf, ShopEntry> PACKET_CODEC = PacketCodec.tuple(
            ITEM, ShopEntry::item,
            PacketCodecs.VAR_INT, ShopEntry::cost,
            ITEM.collect(PacketCodecs.toList()), ShopEntry::accepts,
            ShopEntry::new);

    public static final PacketCodec<RegistryByteBuf, List<ShopEntry>> LIST_PACKET_CODEC =
            PACKET_CODEC.collect(PacketCodecs.toList());

    /** The client-facing view of a price entry. */
    public static ShopEntry of(RupeeTrade cost) {
        return new ShopEntry(cost.item(), cost.cost(), cost.accepts());
    }

    /** Whether this row wants an item handed over as well as rupees. */
    public boolean hasAccepted() {
        return !this.accepts.isEmpty();
    }

    public boolean accepts(Item item) {
        return this.accepts.contains(item);
    }
}
