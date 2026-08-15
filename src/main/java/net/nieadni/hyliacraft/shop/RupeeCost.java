package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;

import java.util.List;

/**
 * One thing the Happy Mask Salesman sells, as loaded from a {@code rupee_costs} datapack file.
 *
 * @param item    what the player receives
 * @param cost    the price in rupees
 * @param accepts extra non-rupee items that may be handed over alongside the rupees. Each entry becomes its
 *                own trade offer, because a trade input accepts a single item and not a tag, so "a pumpkin
 *                or a carved pumpkin" cannot be one offer. Empty means the item is bought with rupees alone.
 * @param maxUses purchases allowed from one salesman before the entry shows as out of stock
 * @param restocks whether a spent entry comes back. False makes it a one-off for that salesman's
 *                 lifetime, which is how a pack author gates something rare
 */
public record RupeeCost(Item item, int cost, List<Item> accepts, int maxUses, boolean restocks) {
}
