package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCLanguageProvider extends FabricLanguageProvider {

    protected HCLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        /** ITEMS **/

        translationBuilder.add(HCItems.GODDESS_SWORD, "Goddess Sword");

        translationBuilder.add(HCItems.PUMPKIN_SOUP, "Pumpkin Soup");

        translationBuilder.add(HCItems.GREEN_RUPEE, "Green Rupee");
        translationBuilder.add(HCItems.BLUE_RUPEE, "Blue Rupee");
        translationBuilder.add(HCItems.YELLOW_RUPEE, "Yellow Rupee");
        translationBuilder.add(HCItems.RED_RUPEE, "Red Rupee");
        translationBuilder.add(HCItems.PURPLE_RUPEE, "Purple Rupee");
        translationBuilder.add(HCItems.ORANGE_RUPEE, "Orange Rupee");
        translationBuilder.add(HCItems.SILVER_RUPEE, "Silver Rupee");
        translationBuilder.add(HCItems.GOLD_RUPEE, "Gold Rupee");


        /** BLOCKS **/

        //a

        /** Components **/

        translationBuilder.add("tooltip.green_rupee", "Worth 1 Rupee");
        translationBuilder.add("tooltip.blue_rupee", "Worth 5 Rupees");
        translationBuilder.add("tooltip.yellow_rupee", "Worth 10 Rupees");
        translationBuilder.add("tooltip.red_rupee", "Worth 20 Rupees");
        translationBuilder.add("tooltip.purple_rupee", "Worth 50 Rupees");
        translationBuilder.add("tooltip.orange_rupee", "Worth 100 Rupees");
        translationBuilder.add("tooltip.silver_rupee", "Worth 200 Rupees");
        translationBuilder.add("tooltip.gold_rupee", "Worth 300 Rupees");
        translationBuilder.add("tooltip.hyliacraft.pumpkin_soup","Popular in Skyloft for its nutrient content and revitalising properties");

        translationBuilder.add("itemGroup.hyliacraft.gear", "HC Gear");
        translationBuilder.add("itemGroup.hyliacraft.consumables", "HC Consumables");
        translationBuilder.add("itemGroup.hyliacraft.misc", "HC Misc");
    }
}
