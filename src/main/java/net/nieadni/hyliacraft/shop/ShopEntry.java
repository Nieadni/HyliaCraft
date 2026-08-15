package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
 * @param accepted the extra item this row wants alongside the rupees, or {@link Items#AIR} for none. A
 *                 price entry that accepts several items becomes one row per item, so "a pumpkin or a
 *                 carved pumpkin" reads as two offers rather than hiding one of them.
 */
public record ShopEntry(Item item, int cost, Item accepted) {

    private static final PacketCodec<RegistryByteBuf, Item> ITEM =
            PacketCodecs.registryValue(RegistryKeys.ITEM);

    public static final PacketCodec<RegistryByteBuf, ShopEntry> PACKET_CODEC = PacketCodec.tuple(
            ITEM, ShopEntry::item,
            PacketCodecs.VAR_INT, ShopEntry::cost,
            ITEM, ShopEntry::accepted,
            ShopEntry::new);

    public static final PacketCodec<RegistryByteBuf, List<ShopEntry>> LIST_PACKET_CODEC =
            PACKET_CODEC.collect(PacketCodecs.toList());

    public boolean hasAccepted() {
        return this.accepted != Items.AIR;
    }
}
