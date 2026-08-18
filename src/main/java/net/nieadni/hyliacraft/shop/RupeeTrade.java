package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.List;

/**
 * @param item    what the player receives
 * @param count   how many of it per purchase
 * @param cost    the price in rupees
 * @param accepts extra items accepted alongside the rupees, any one of which will do rather than all of
 *                them being required together, each with its own count. They share a single shop row, so
 *                "a pumpkin or a carved pumpkin" is one offer whose trade-in slot takes either
 * @param maxUses purchases from one trader before the entry shows as out of stock
 * @param restocks whether a spent entry comes back; false makes it a one-off for that trader
 * @param merchants which traders stock this. Filters an existing trader's list; it cannot make a mob into one
 */
public record RupeeTrade(Item item, int count, int cost, List<Accepted> accepts, int maxUses,
                         boolean restocks, List<Identifier> merchants) {

    public boolean soldBy(Identifier trader) {
        return this.merchants.contains(trader);
    }

    public int requiredCount(Item item) {
        for (Accepted accepted : this.accepts) {
            if (accepted.item() == item) {
                return accepted.count();
            }
        }
        return 0;
    }
}
