package net.nieadni.hyliacraft.client;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.item.HCItems;
import net.nieadni.hyliacraft.item.custom.HylianShieldItem;

public class HCItemProperties {

    public static void addCustomItemProperties() {
        bowPulling(HCItems.IRON_BOW);

        shieldBlocking(HCItems.HYLIAN_SHIELD);
    }

    private static void bowPulling(Item bow) {
        ModelPredicateProviderRegistry.register(bow, Identifier.of("pull"), (itemStack, level, entity, i) -> {
            if (entity == null) return 0.0F;
            if (entity.getActiveItem() != itemStack) return 0.0F;
            float chargeTicks = BowItem.TICKS_PER_SECOND;

            return (itemStack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / chargeTicks;
        });
        ModelPredicateProviderRegistry.register(bow, Identifier.of("pulling"), (itemStack, level, entity, i) ->
                entity != null && entity.isUsingItem() && entity.getActiveItem() == itemStack ? 1.0F : 0.0F);
    }

    private static void shieldBlocking(Item shield) {
        ModelPredicateProviderRegistry.register(shield, Identifier.of("blocking"), (itemStack, level, livingEntity, i) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
    }

}
