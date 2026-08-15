package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.List;
import java.util.Optional;

/**
 * Turns a rupee price into the rupee stacks a player hands over.
 *
 * <p>A {@link net.minecraft.village.TradeOffer} has room for at most two input stacks, and
 * {@link net.nieadni.hyliacraft.item.custom.RupeeItem} stacks to 64, so a price is payable only if it can be
 * made from at most two denominations of at most 64 rupees each. That is a real limit and it is not simply
 * about large numbers: 2004 is payable (10 silver + 4 green) while 6666 is not, because 6666 is not a
 * multiple of five and so needs 66 green rupees, two more than a stack holds.
 *
 * <p>Prices from 1 to 3265 are always payable. Above that some are not, which is why {@link #solve} returns
 * an {@link Optional} rather than throwing: an unpayable price means "no offer", not "something went wrong".
 */
public final class RupeeChange {

    /** One rupee denomination and what it is worth. */
    public record Denomination(Item item, int value) {}

    /**
     * Denominations in descending value order.
     *
     * <p>The order is load-bearing. {@link #solve} keeps the first solution it finds at the winning item
     * count, so searching high-to-low makes it prefer fewer, larger coins and makes the result stable
     * across reloads. Reordering this list silently changes what players are asked to pay.
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

    /** A trade input slot shows one stack, and rupees stack to 64. */
    private static final int MAX_PER_SLOT = 64;

    private RupeeChange() {
    }

    /**
     * Finds the cheapest-to-carry way to pay {@code cost} using at most {@code slots} denominations.
     *
     * @param cost  the price in rupees; 0 yields an empty list, meaning "free"
     * @param slots how many trade input slots the rupees may occupy, 1 or 2
     * @return the stacks to hand over, or empty if this price cannot be paid within the limits
     */
    public static Optional<List<ItemStack>> solve(int cost, int slots) {
        if (cost < 0 || slots < 1) {
            return Optional.empty();
        }
        if (cost == 0) {
            return Optional.of(List.of());
        }

        List<ItemStack> best = null;
        int bestCount = Integer.MAX_VALUE;

        // One denomination.
        for (Denomination d : DENOMINATIONS) {
            if (cost % d.value() != 0) {
                continue;
            }
            int count = cost / d.value();
            if (count > MAX_PER_SLOT) {
                continue;
            }
            if (count < bestCount) {
                best = List.of(new ItemStack(d.item(), count));
                bestCount = count;
            }
        }

        // Two denominations. Every count is tried rather than stopping at the first that fits: for a given
        // pair, spending more of the larger coin usually needs fewer of the smaller one, so the first
        // solution found is rarely the smallest. 110 as purple plus yellow is 1+6 at one purple but 2+1 at
        // two, and stopping early would hand the player seven coins instead of three.
        if (slots >= 2) {
            for (int i = 0; i < DENOMINATIONS.size(); i++) {
                Denomination high = DENOMINATIONS.get(i);
                for (int j = i + 1; j < DENOMINATIONS.size(); j++) {
                    Denomination low = DENOMINATIONS.get(j);
                    for (int highCount = 1; highCount <= MAX_PER_SLOT; highCount++) {
                        int remainder = cost - highCount * high.value();
                        if (remainder <= 0) {
                            break;
                        }
                        if (remainder % low.value() != 0) {
                            continue;
                        }
                        int lowCount = remainder / low.value();
                        if (lowCount > MAX_PER_SLOT) {
                            continue;
                        }
                        if (highCount + lowCount < bestCount) {
                            best = List.of(new ItemStack(high.item(), highCount), new ItemStack(low.item(), lowCount));
                            bestCount = highCount + lowCount;
                        }
                    }
                }
            }
        }

        return Optional.ofNullable(best);
    }
}
