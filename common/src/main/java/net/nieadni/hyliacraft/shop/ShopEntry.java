package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
 * @param count   how many the player receives per purchase
 * @param accepts items this row will take alongside the rupees, any one of which will do at its own
 *                count. Empty when the price is rupees alone
 */
public record ShopEntry(Item item, int count, int cost, List<Accepted> accepts) {

    private static final PacketCodec<RegistryByteBuf, Item> ITEM =
            PacketCodecs.registryValue(RegistryKeys.ITEM);

    public static final PacketCodec<RegistryByteBuf, ShopEntry> PACKET_CODEC = PacketCodec.tuple(
            ITEM, ShopEntry::item,
            PacketCodecs.VAR_INT, ShopEntry::count,
            PacketCodecs.VAR_INT, ShopEntry::cost,
            Accepted.LIST_PACKET_CODEC, ShopEntry::accepts,
            ShopEntry::new);

    public static final PacketCodec<RegistryByteBuf, List<ShopEntry>> LIST_PACKET_CODEC =
            PACKET_CODEC.collect(PacketCodecs.toList());

    /** The client-facing view of a price entry. */
    public static ShopEntry of(RupeeTrade trade) {
        return new ShopEntry(trade.item(), trade.count(), trade.cost(), trade.accepts());
    }

    /** Whether this row wants an item handed over as well as rupees. */
    public boolean hasAccepted() {
        return !this.accepts.isEmpty();
    }

    /** How many of this item the row wants, or 0 if it will not take it at all. */
    public int requiredCount(Item item) {
        for (Accepted accepted : this.accepts) {
            if (accepted.item() == item) {
                return accepted.count();
            }
        }
        return 0;
    }

    /**
     * Whether this stack covers what the row asks for.
     *
     * <p>An empty stack reports {@code AIR}, which no entry ever lists, so this answers "nothing handed
     * over" and "not enough handed over" alike.
     */
    public boolean satisfiedBy(ItemStack stack) {
        int required = requiredCount(stack.getItem());
        return required > 0 && stack.getCount() >= required;
    }

    /** What the player receives, as a stack. */
    public ItemStack toStack() {
        return new ItemStack(this.item, this.count);
    }
}
