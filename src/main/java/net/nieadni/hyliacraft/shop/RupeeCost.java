package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.List;

/**
 * One thing the Happy Mask Salesman sells, as loaded from a {@code rupee_costs} datapack file.
 *
 * @param item    what the player receives
 * @param cost    the price in rupees
 * @param accepts extra items accepted alongside the rupees. Each becomes its own shop row rather than all
 *                being required together, so "a pumpkin or a carved pumpkin" is offered as two rows
 * @param maxUses purchases from one trader before the entry shows as out of stock
 * @param restocks whether a spent entry comes back; false makes it a one-off for that trader
 * @param merchants which traders stock this. Filters an existing trader's list; it cannot make a mob
 *                  into one
 */
public record RupeeCost(Item item, int cost, List<Item> accepts, int maxUses, boolean restocks,
                        List<Identifier> merchants) {

    public boolean soldBy(Identifier trader) {
        return this.merchants.contains(trader);
    }
}
