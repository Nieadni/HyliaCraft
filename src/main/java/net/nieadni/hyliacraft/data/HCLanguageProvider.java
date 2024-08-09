package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;
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
        translationBuilder.add(HCItems.SLINGSHOT, "Slingshot");
        translationBuilder.add(HCItems.BOOMERANG, "Boomerang");
        translationBuilder.add(HCItems.GALE_BOOMERANG, "Gale Boomerang");

        translationBuilder.add(HCItems.DIGGING_MITT, "Digging Mitt");
        translationBuilder.add(HCItems.MOGMA_MITT, "Mogma Mitt");
        translationBuilder.add(HCItems.PARAGLIDER, "Paraglider");
        translationBuilder.add(HCItems.HYLIAN_SHIELD, "Hylian Shield");

        translationBuilder.add(HCItems.PUMPKIN_SOUP, "Pumpkin Soup");

        translationBuilder.add(HCItems.RUPEE_POUCH, "Rupee Pouch");
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
        translationBuilder.add(HCBlocks.HATENO_CLAY_POT, "Hateno Clay Pot");

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
        translationBuilder.add("itemGroup.hyliacraft.coloured_blocks", "HC Coloured Blocks");
        translationBuilder.add("itemGroup.hyliacraft.misc", "HC Misc");

        translationBuilder.add("tooltip.hyliacraft.wip", "This feature has not been fully implemented so therefore it may not work fully or as intended");

        /** Coloured Blocks **/

        translationBuilder.add(HCColouredBlocks.WHITE_BRICKS, "White Bricks");
        translationBuilder.add(HCColouredBlocks.WHITE_BRICK_STAIRS, "White Brick Stairs");
        translationBuilder.add(HCColouredBlocks.WHITE_BRICK_SLAB, "White Brick Slab");
        translationBuilder.add(HCColouredBlocks.WHITE_BRICK_WALL, "White Brick Wall");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_BRICKS, "Light Grey Bricks");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS, "Light Grey Brick Stairs");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_BRICK_SLAB, "Light Grey Brick Slab");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_BRICK_WALL, "Light Grey Brick Wall");
        translationBuilder.add(HCColouredBlocks.GREY_BRICKS, "Grey Bricks");
        translationBuilder.add(HCColouredBlocks.GREY_BRICK_STAIRS, "Grey Brick Stairs");
        translationBuilder.add(HCColouredBlocks.GREY_BRICK_SLAB, "Grey Brick Slab");
        translationBuilder.add(HCColouredBlocks.GREY_BRICK_WALL, "Grey Brick Wall");
        translationBuilder.add(HCColouredBlocks.BLACK_BRICKS, "Black Bricks");
        translationBuilder.add(HCColouredBlocks.BLACK_BRICK_STAIRS, "Black Brick Stairs");
        translationBuilder.add(HCColouredBlocks.BLACK_BRICK_SLAB, "Black Brick Slab");
        translationBuilder.add(HCColouredBlocks.BLACK_BRICK_WALL, "Black Brick Wall");
        translationBuilder.add(HCColouredBlocks.BROWN_BRICKS, "Brown Bricks");
        translationBuilder.add(HCColouredBlocks.BROWN_BRICK_STAIRS, "Brown Brick Stairs");
        translationBuilder.add(HCColouredBlocks.BROWN_BRICK_SLAB, "Brown Brick Slab");
        translationBuilder.add(HCColouredBlocks.BROWN_BRICK_WALL, "Brown Brick Wall");
        translationBuilder.add(HCColouredBlocks.RED_BRICKS, "Red Bricks");
        translationBuilder.add(HCColouredBlocks.RED_BRICK_STAIRS, "Red Brick Stairs");
        translationBuilder.add(HCColouredBlocks.RED_BRICK_SLAB, "Red Brick Slab");
        translationBuilder.add(HCColouredBlocks.RED_BRICK_WALL, "Red Brick Wall");
        translationBuilder.add(HCColouredBlocks.ORANGE_BRICKS, "Orange Bricks");
        translationBuilder.add(HCColouredBlocks.ORANGE_BRICK_STAIRS, "Orange Brick Stairs");
        translationBuilder.add(HCColouredBlocks.ORANGE_BRICK_SLAB, "Orange Brick Slab");
        translationBuilder.add(HCColouredBlocks.ORANGE_BRICK_WALL, "Orange Brick Wall");
        translationBuilder.add(HCColouredBlocks.YELLOW_BRICKS, "Yellow Bricks");
        translationBuilder.add(HCColouredBlocks.YELLOW_BRICK_STAIRS, "Yellow Brick Stairs");
        translationBuilder.add(HCColouredBlocks.YELLOW_BRICK_SLAB, "Yellow Brick Slab");
        translationBuilder.add(HCColouredBlocks.YELLOW_BRICK_WALL, "Yellow Brick Wall");
        translationBuilder.add(HCColouredBlocks.LIME_BRICKS, "Lime Bricks");
        translationBuilder.add(HCColouredBlocks.LIME_BRICK_STAIRS, "Lime Brick Stairs");
        translationBuilder.add(HCColouredBlocks.LIME_BRICK_SLAB, "Lime Brick Slab");
        translationBuilder.add(HCColouredBlocks.LIME_BRICK_WALL, "Lime Brick Wall");
        translationBuilder.add(HCColouredBlocks.GREEN_BRICKS, "Green Bricks");
        translationBuilder.add(HCColouredBlocks.GREEN_BRICK_STAIRS, "Green Brick Stairs");
        translationBuilder.add(HCColouredBlocks.GREEN_BRICK_SLAB, "Green Brick Slab");
        translationBuilder.add(HCColouredBlocks.GREEN_BRICK_WALL, "Green Brick Wall");
        translationBuilder.add(HCColouredBlocks.CYAN_BRICKS, "Cyan Bricks");
        translationBuilder.add(HCColouredBlocks.CYAN_BRICK_STAIRS, "Cyan Brick Stairs");
        translationBuilder.add(HCColouredBlocks.CYAN_BRICK_SLAB, "Cyan Brick Slab");
        translationBuilder.add(HCColouredBlocks.CYAN_BRICK_WALL, "Cyan Brick Wall");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_BRICKS, "Light Blue Bricks");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS, "Light Blue Brick Stairs");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB, "Light Blue Brick Slab");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_BRICK_WALL, "Light Blue Brick Wall");
        translationBuilder.add(HCColouredBlocks.BLUE_BRICKS, "Blue Bricks");
        translationBuilder.add(HCColouredBlocks.BLUE_BRICK_STAIRS, "Blue Brick Stairs");
        translationBuilder.add(HCColouredBlocks.BLUE_BRICK_SLAB, "Blue Brick Slab");
        translationBuilder.add(HCColouredBlocks.BLUE_BRICK_WALL, "Blue Brick Wall");
        translationBuilder.add(HCColouredBlocks.PURPLE_BRICKS, "Purple Bricks");
        translationBuilder.add(HCColouredBlocks.PURPLE_BRICK_STAIRS, "Purple Brick Stairs");
        translationBuilder.add(HCColouredBlocks.PURPLE_BRICK_SLAB, "Purple Brick Slab");
        translationBuilder.add(HCColouredBlocks.PURPLE_BRICK_WALL, "Purple Brick Wall");
        translationBuilder.add(HCColouredBlocks.MAGENTA_BRICKS, "Magenta Bricks");
        translationBuilder.add(HCColouredBlocks.MAGENTA_BRICK_STAIRS, "Magenta Brick Stairs");
        translationBuilder.add(HCColouredBlocks.MAGENTA_BRICK_SLAB, "Magenta Brick Slab");
        translationBuilder.add(HCColouredBlocks.MAGENTA_BRICK_WALL, "Magenta Brick Wall");
        translationBuilder.add(HCColouredBlocks.PINK_BRICKS, "Pink Bricks");
        translationBuilder.add(HCColouredBlocks.PINK_BRICK_STAIRS, "Pink Brick Stairs");
        translationBuilder.add(HCColouredBlocks.PINK_BRICK_SLAB, "Pink Brick Slab");
        translationBuilder.add(HCColouredBlocks.PINK_BRICK_WALL, "Pink Brick Wall");

        translationBuilder.add(HCColouredBlocks.WHITE_STRIPPED_LOG, "White Stripped Log");
        translationBuilder.add(HCColouredBlocks.WHITE_STRIPPED_WOOD, "White Stripped Wood");
        translationBuilder.add(HCColouredBlocks.WHITE_PLANKS, "White Planks");
        translationBuilder.add(HCColouredBlocks.WHITE_STAIRS, "White Stairs");
        translationBuilder.add(HCColouredBlocks.WHITE_SLAB, "White Slab");
        translationBuilder.add(HCColouredBlocks.WHITE_FENCE, "White Fence");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG, "Light Grey Stripped Log");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD, "Light Grey Stripped Wood");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_PLANKS, "Light Grey Planks");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_STAIRS, "Light Grey Stairs");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_SLAB, "Light Grey Slab");
        translationBuilder.add(HCColouredBlocks.LIGHT_GREY_FENCE, "Light Grey Fence");
        translationBuilder.add(HCColouredBlocks.GREY_STRIPPED_LOG, "Grey Stripped Log");
        translationBuilder.add(HCColouredBlocks.GREY_STRIPPED_WOOD, "Grey Stripped Wood");
        translationBuilder.add(HCColouredBlocks.GREY_PLANKS, "Grey Planks");
        translationBuilder.add(HCColouredBlocks.GREY_STAIRS, "Grey Stairs");
        translationBuilder.add(HCColouredBlocks.GREY_SLAB, "Grey Slab");
        translationBuilder.add(HCColouredBlocks.GREY_FENCE, "Grey Fence");
        translationBuilder.add(HCColouredBlocks.BLACK_STRIPPED_LOG, "Black Stripped Log");
        translationBuilder.add(HCColouredBlocks.BLACK_STRIPPED_WOOD, "Black Stripped Wood");
        translationBuilder.add(HCColouredBlocks.BLACK_PLANKS, "Black Planks");
        translationBuilder.add(HCColouredBlocks.BLACK_STAIRS, "Black Stairs");
        translationBuilder.add(HCColouredBlocks.BLACK_SLAB, "Black Slab");
        translationBuilder.add(HCColouredBlocks.BLACK_FENCE, "Black Fence");
        translationBuilder.add(HCColouredBlocks.BROWN_STRIPPED_LOG, "Brown Stripped Log");
        translationBuilder.add(HCColouredBlocks.BROWN_STRIPPED_WOOD, "Brown Stripped Wood");
        translationBuilder.add(HCColouredBlocks.BROWN_PLANKS, "Brown Planks");
        translationBuilder.add(HCColouredBlocks.BROWN_STAIRS, "Brown Stairs");
        translationBuilder.add(HCColouredBlocks.BROWN_SLAB, "Brown Slab");
        translationBuilder.add(HCColouredBlocks.BROWN_FENCE, "Brown Fence");
        translationBuilder.add(HCColouredBlocks.RED_STRIPPED_LOG, "Red Stripped Log");
        translationBuilder.add(HCColouredBlocks.RED_STRIPPED_WOOD, "Red Stripped Wood");
        translationBuilder.add(HCColouredBlocks.RED_PLANKS, "Red Planks");
        translationBuilder.add(HCColouredBlocks.RED_STAIRS, "Red Stairs");
        translationBuilder.add(HCColouredBlocks.RED_SLAB, "Red Slab");
        translationBuilder.add(HCColouredBlocks.RED_FENCE, "Red Fence");
        translationBuilder.add(HCColouredBlocks.ORANGE_STRIPPED_LOG, "Orange Stripped Log");
        translationBuilder.add(HCColouredBlocks.ORANGE_STRIPPED_WOOD, "Orange Stripped Wood");
        translationBuilder.add(HCColouredBlocks.ORANGE_PLANKS, "Orange Planks");
        translationBuilder.add(HCColouredBlocks.ORANGE_STAIRS, "Orange Stairs");
        translationBuilder.add(HCColouredBlocks.ORANGE_SLAB, "Orange Slab");
        translationBuilder.add(HCColouredBlocks.ORANGE_FENCE, "Orange Fence");
        translationBuilder.add(HCColouredBlocks.YELLOW_STRIPPED_LOG, "Yellow Stripped Log");
        translationBuilder.add(HCColouredBlocks.YELLOW_STRIPPED_WOOD, "Yellow Stripped Wood");
        translationBuilder.add(HCColouredBlocks.YELLOW_PLANKS, "Yellow Planks");
        translationBuilder.add(HCColouredBlocks.YELLOW_STAIRS, "Yellow Stairs");
        translationBuilder.add(HCColouredBlocks.YELLOW_SLAB, "Yellow Slab");
        translationBuilder.add(HCColouredBlocks.YELLOW_FENCE, "Yellow Fence");
        translationBuilder.add(HCColouredBlocks.LIME_STRIPPED_LOG, "Lime Stripped Log");
        translationBuilder.add(HCColouredBlocks.LIME_STRIPPED_WOOD, "Lime Stripped Wood");
        translationBuilder.add(HCColouredBlocks.LIME_PLANKS, "Lime Planks");
        translationBuilder.add(HCColouredBlocks.LIME_STAIRS, "Lime Stairs");
        translationBuilder.add(HCColouredBlocks.LIME_SLAB, "Lime Slab");
        translationBuilder.add(HCColouredBlocks.LIME_FENCE, "Lime Fence");
        translationBuilder.add(HCColouredBlocks.GREEN_STRIPPED_LOG, "Green Stripped Log");
        translationBuilder.add(HCColouredBlocks.GREEN_STRIPPED_WOOD, "Green Stripped Wood");
        translationBuilder.add(HCColouredBlocks.GREEN_PLANKS, "Green Planks");
        translationBuilder.add(HCColouredBlocks.GREEN_STAIRS, "Green Stairs");
        translationBuilder.add(HCColouredBlocks.GREEN_SLAB, "Green Slab");
        translationBuilder.add(HCColouredBlocks.GREEN_FENCE, "Green Fence");
        translationBuilder.add(HCColouredBlocks.CYAN_STRIPPED_LOG, "Cyan Stripped Log");
        translationBuilder.add(HCColouredBlocks.CYAN_STRIPPED_WOOD, "Cyan Stripped Wood");
        translationBuilder.add(HCColouredBlocks.CYAN_PLANKS, "Cyan Planks");
        translationBuilder.add(HCColouredBlocks.CYAN_STAIRS, "Cyan Stairs");
        translationBuilder.add(HCColouredBlocks.CYAN_SLAB, "Cyan Slab");
        translationBuilder.add(HCColouredBlocks.CYAN_FENCE, "Cyan Fence");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG, "Light Blue Stripped Log");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD, "Light Blue Stripped Wood");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_PLANKS, "Light Blue Planks");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_STAIRS, "Light Blue Stairs");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_SLAB, "Light Blue Slab");
        translationBuilder.add(HCColouredBlocks.LIGHT_BLUE_FENCE, "Light Blue Fence");
        translationBuilder.add(HCColouredBlocks.BLUE_STRIPPED_LOG, "Blue Stripped Log");
        translationBuilder.add(HCColouredBlocks.BLUE_STRIPPED_WOOD, "Blue Stripped Wood");
        translationBuilder.add(HCColouredBlocks.BLUE_PLANKS, "Blue Planks");
        translationBuilder.add(HCColouredBlocks.BLUE_STAIRS, "Blue Stairs");
        translationBuilder.add(HCColouredBlocks.BLUE_SLAB, "Blue Slab");
        translationBuilder.add(HCColouredBlocks.BLUE_FENCE, "Blue Fence");
        translationBuilder.add(HCColouredBlocks.PURPLE_STRIPPED_LOG, "Purple Stripped Log");
        translationBuilder.add(HCColouredBlocks.PURPLE_STRIPPED_WOOD, "Purple Stripped Wood");
        translationBuilder.add(HCColouredBlocks.PURPLE_PLANKS, "Purple Planks");
        translationBuilder.add(HCColouredBlocks.PURPLE_STAIRS, "Purple Stairs");
        translationBuilder.add(HCColouredBlocks.PURPLE_SLAB, "Purple Slab");
        translationBuilder.add(HCColouredBlocks.PURPLE_FENCE, "Purple Fence");
        translationBuilder.add(HCColouredBlocks.MAGENTA_STRIPPED_LOG, "Magenta Stripped Log");
        translationBuilder.add(HCColouredBlocks.MAGENTA_STRIPPED_WOOD, "Magenta Stripped Wood");
        translationBuilder.add(HCColouredBlocks.MAGENTA_PLANKS, "Magenta Planks");
        translationBuilder.add(HCColouredBlocks.MAGENTA_STAIRS, "Magenta Stairs");
        translationBuilder.add(HCColouredBlocks.MAGENTA_SLAB, "Magenta Slab");
        translationBuilder.add(HCColouredBlocks.MAGENTA_FENCE, "Magenta Fence");
        translationBuilder.add(HCColouredBlocks.PINK_STRIPPED_LOG, "Pink Stripped Log");
        translationBuilder.add(HCColouredBlocks.PINK_STRIPPED_WOOD, "Pink Stripped Wood");
        translationBuilder.add(HCColouredBlocks.PINK_PLANKS, "Pink Planks");
        translationBuilder.add(HCColouredBlocks.PINK_STAIRS, "Pink Stairs");
        translationBuilder.add(HCColouredBlocks.PINK_SLAB, "Pink Slab");
        translationBuilder.add(HCColouredBlocks.PINK_FENCE, "Pink Fence");



    }
}
