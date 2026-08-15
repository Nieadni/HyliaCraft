package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * One concrete thing a player can buy: a price entry paired with the specific extra item this offer wants.
 *
 * <p>A {@link RupeeCost} that accepts several items is not one offer but several. A trade takes a single
 * item, not a tag, so collapsing them would leave a player unable to see that a carved pumpkin works too.
 *
 * @param accepted the required extra item, or {@link Items#AIR} when the price is rupees alone
 */
public record ShopRow(RupeeCost cost, Item accepted) {

    /** Expands price entries into the rows a player actually sees, preserving the cheapest-first order. */
    public static List<ShopRow> expand(List<RupeeCost> costs) {
        List<ShopRow> rows = new ArrayList<>();
        for (RupeeCost cost : costs) {
            if (cost.accepts().isEmpty()) {
                rows.add(new ShopRow(cost, Items.AIR));
            } else {
                for (Item accepted : cost.accepts()) {
                    rows.add(new ShopRow(cost, accepted));
                }
            }
        }
        return List.copyOf(rows);
    }

    public ShopEntry toEntry() {
        return new ShopEntry(this.cost.item(), this.cost.cost(), this.accepted);
    }

    public boolean hasAccepted() {
        return this.accepted != Items.AIR;
    }
}
