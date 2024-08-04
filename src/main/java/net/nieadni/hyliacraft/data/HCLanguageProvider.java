package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCLanguageProvider extends FabricLanguageProvider {

    protected HCLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        /** ITEMS **/
        translationBuilder.add(HCItems.MAJORAS_MASK, "Majoras Mask");
        translationBuilder.add(HCItems.PUMPKIN_MASK, "Pumpkin Mask");

        translationBuilder.add(HCItems.GODDESS_SWORD, "Goddess Sword");
        translationBuilder.add(HCItems.GODDESS_LONGSWORD, "Goddess Longsword");
        translationBuilder.add(HCItems.GODDESS_WHITE_SWORD, "Goddess White Sword");
        translationBuilder.add(HCItems.MASTER_SWORD, "Master Sword");
        translationBuilder.add(HCItems.TRUE_MASTER_SWORD, "True Master Sword");
        translationBuilder.add(HCItems.IRON_BOW, "Iron Bow");
        translationBuilder.add(HCItems.FAIRY_BOW, "Fairy Bow");

        translationBuilder.add(HCItems.DIGGING_MITT, "Digging Mitt");
        translationBuilder.add(HCItems.MOGMA_MITT, "Mogma Mitt");
        translationBuilder.add(HCItems.PARAGLIDER, "Paraglider");
        translationBuilder.add(HCItems.HYLIAN_SHIELD, "Hylian Shield");

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

        translationBuilder.add(HCBlocks.CLAY_POT, "Clay Pot");
        translationBuilder.add(HCBlocks.NATURAL_CLAY_POT, "Natural Clay Pot");
        translationBuilder.add(HCBlocks.CLAY_POT_WRITING, "Clay Pot with Writing");
        translationBuilder.add(HCBlocks.NATURAL_CLAY_POT_WRITING, "Natural Clay Pot with Writing");
        translationBuilder.add(HCBlocks.BLUE_CLAY_POT, "Blue Clay Pot");
        translationBuilder.add(HCBlocks.NATURAL_BLUE_CLAY_POT, "Natural Blue Clay Pot");

        translationBuilder.add(HCBlocks.ARMORANTH, "Armoranth");
        translationBuilder.add(HCBlocks.BLUE_NIGHTSHADE, "Blue Nightshade");
        translationBuilder.add(HCBlocks.SILENT_PRINCESS, "Silent Princess");
        translationBuilder.add(HCBlocks.SWIFT_VIOLETS, "Swift Violets");

        /** Components **/

        translationBuilder.add("tooltip.hyliacraft.majoras_mask1", "An eerie mask passed down from ancient times.");
        translationBuilder.add("tooltip.hyliacraft.majoras_mask2", "Wearing it makes it harder for certain enemies to spot you.");
        translationBuilder.add("tooltip.hyliacraft.majoras_mask3", "It's a rather rare find.");

        translationBuilder.add("tooltip.hyliacraft.hylian_shield1", "A shield passed down through the Hyrulean royal family, along with the legend of the hero who wielded it.");
        translationBuilder.add("tooltip.hyliacraft.hylian_shield2", "Its defensive capabilities and durability outshine all other shields.");

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
        translationBuilder.add("itemGroup.hyliacraft.blocks", "HC Blocks");
        translationBuilder.add("itemGroup.hyliacraft.misc", "HC Misc");

    }
}
