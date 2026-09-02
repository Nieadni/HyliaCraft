package net.nieadni.hyliacraft.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.ArrayList;
import java.util.List;

public final class Rupees {

    public record Denomination(Item item, int value) {}

    /** Shop chooses highest denomination to show a trade cost (smth costing 400 would show Gold, smth costing 250 would show Silver) */
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

    public static int valueOf(Item item) {
        for (Denomination denomination : DENOMINATIONS) {
            if (denomination.item() == item) {
                return denomination.value();
            }
        }
        return 0;
    }

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
