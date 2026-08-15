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
 * <p>Prices come from server-side datapacks, which are never sent to clients, so the list has to travel
 * with the screen when it opens. Only what the client draws is included: {@code restocks} and
 * {@code maxUses} stay on the server, since the client only needs to know whether a row is available now,
 * which arrives separately and changes as things are bought.
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

    public static ShopEntry of(RupeeCost cost) {
        return new ShopEntry(cost.item(), cost.cost(), cost.accepts());
    }
}
