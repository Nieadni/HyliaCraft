package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.ArrayList;
import java.util.List;

/** The rupee denominations and what each is worth. */
public final class Rupees {

    public record Denomination(Item item, int value) {}

    /**
     * Denominations in descending value order.
     *
     * <p>The order is load-bearing twice over. The shop picks a coin to illustrate a price by walking this
     * list until one fits, which only works descending. The pouch screen sends a denomination's index to
     * the server as the id of a withdrawal, so reordering changes what a player is handed.
     */
    public static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination(HCItems.GOLD_RUPEE, 300),
            new Denomination(HCItems.SILVER_RUPEE, 200),
            new Denomination(HCItems.ORANGE_RUPEE, 100),
            new Denomination(HCItems.PURPLE_RUPEE, 50),
            new Denomination(HCItems.RED_RUPEE, 20),
            new Denomination(HCItems.YELLOW_RUPEE, 10),
            new Denomination(HCItems.BLUE_RUPEE, 5),
            new Denomination(HCItems.GREEN_RUPEE, 1)
    );

    private Rupees() {
    }

    /**
     * What one of these coins is worth, or 0 if it is not a rupee.
     *
     * <p>This table is the only place in code that knows rupee values. The tooltips players read are
     * separate lang strings that nothing parses, so the two can drift apart silently.
     */
    public static int valueOf(Item item) {
        for (Denomination denomination : DENOMINATIONS) {
            if (denomination.item() == item) {
                return denomination.value();
            }
        }
        return 0;
    }

    /**
     * The coins to hand back for an amount of rupees.
     *
     * <p>Greedy from the largest denomination down. That is exact rather than merely close only because
     * the smallest denomination is worth one: whatever the larger coins leave over can always be made up
     * in green rupees, so the loop cannot end holding a remainder it has no coin for.
     *
     * <p>Greedy is not guaranteed to be the fewest coins for an arbitrary set of denominations, but the
     * most change this can ever produce is 299 rupees, which comes to nine coins across five stacks.
     *
     * @param amount rupees to return; zero or less yields an empty list
     */
    public static List<ItemStack> change(int amount) {
        List<ItemStack> coins = new ArrayList<>();
        int remaining = amount;
        for (Denomination denomination : DENOMINATIONS) {
            int count = remaining / denomination.value();
            remaining -= count * denomination.value();
            while (count > 0) {
                int stackSize = Math.min(count, denomination.item().getMaxCount());
                coins.add(new ItemStack(denomination.item(), stackSize));
                count -= stackSize;
            }
        }
        return coins;
    }
}
