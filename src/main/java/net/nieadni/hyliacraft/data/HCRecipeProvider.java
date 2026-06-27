package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class HCRecipeProvider extends FabricRecipeProvider {
    public HCRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        /** ARMOUR & TOOLS **/

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.PARAGLIDER, 1)
                .pattern("GWY")
                .pattern("IRI")
                .pattern("ISI")
                .input('I', Items.STICK)
                .input('S', Items.STRING)
                .input('R', Items.RED_WOOL)
                .input('W', Items.WHITE_DYE)
                .input('G', Items.GREEN_DYE)
                .input('Y', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_WOOL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.FAIRY_BOW, 1)
                .pattern("LR")
                .pattern("GB")
                .pattern("LR")
                .input('B', Items.BOW)
                .input('L', Items.LAPIS_LAZULI)
                .input('R', Items.REDSTONE)
                .input('G', Items.GOLD_INGOT)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BOW))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.BOULDER_BREAKER, 1)
                .pattern("FFF")
                .pattern(" N ")
                .pattern("FDF")
                .input('F', Items.FLINT)
                .input('N', Items.NETHERITE_PICKAXE)
                .input('D', Items.DIAMOND)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.NETHERITE_PICKAXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.DIGGING_MITT, 1)
                .pattern("NIN")
                .pattern("LWL")
                .pattern("LRL")
                .input('L', Items.LEATHER)
                .input('N', Items.IRON_NUGGET)
                .input('I', Items.IRON_INGOT)
                .input('W', Items.WHITE_DYE)
                .input('R', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.MOGMA_MITT, 1)
                .pattern("III")
                .pattern("GDR")
                .pattern("LWL")
                .input('L', Items.LEATHER)
                .input('I', Items.IRON_INGOT)
                .input('W', Items.WHITE_DYE)
                .input('R', Items.RED_DYE)
                .input('G', Items.GREEN_DYE)
                .input('D', HCItems.DIGGING_MITT)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .offerTo(exporter);

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(HCItems.GODDESS_SWORD),
                        Ingredient.ofItems(HCItems.FARORE_FLAME),
                        RecipeCategory.TOOLS, HCItems.GODDESS_LONGSWORD)
                .criterion("has_upgrade_template", conditionsFromItem(Items.AIR))
                .offerTo(exporter, new Identifier(HyliaCraft.MOD_ID, getRecipeName(HCItems.GODDESS_LONGSWORD)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(HCItems.GODDESS_LONGSWORD),
                        Ingredient.ofItems(HCItems.NAYRU_FLAME),
                        RecipeCategory.TOOLS, HCItems.GODDESS_WHITE_SWORD)
                .criterion("has_upgrade_template", conditionsFromItem(Items.AIR))
                .offerTo(exporter, new Identifier(HyliaCraft.MOD_ID, getRecipeName(HCItems.GODDESS_WHITE_SWORD)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(HCItems.GODDESS_WHITE_SWORD),
                        Ingredient.ofItems(HCItems.DIN_FLAME),
                        RecipeCategory.TOOLS, HCItems.MASTER_SWORD)
                .criterion("has_upgrade_template", conditionsFromItem(Items.AIR))
                .offerTo(exporter, new Identifier(HyliaCraft.MOD_ID, getRecipeName(HCItems.MASTER_SWORD)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.MIDNA_HELM, 1)
                .pattern("S S")
                .pattern("ONO")
                .pattern(" Y ")
                .input('N', Items.NETHERITE_HELMET)
                .input('S', Items.NETHERITE_SCRAP)
                .input('O', Items.ORANGE_WOOL)
                .input('Y', Items.YELLOW_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.ZANT_HELM, 1)
                .pattern(" S ")
                .pattern("BSB")
                .pattern("SNS")
                .input('N', Items.NETHERITE_HELMET)
                .input('S', Items.NETHERITE_SCRAP)
                .input('B', Items.BLUE_ICE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.HERO_CAP, 1)
                .input(Items.LEATHER_HELMET)
                .input(Items.YELLOW_DYE).input(Items.LIME_DYE).input(Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_HELMET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.HERO_TUNIC, 1)
                .input(Items.LEATHER_CHESTPLATE)
                .input(Items.LIME_DYE).input(Items.GREEN_DYE).input(Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter);
                ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.HERO_TROUSERS, 1)
                .input(Items.LEATHER_LEGGINGS)
                .input(Items.LIME_DYE).input(Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_LEGGINGS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.HERO_BOOTS, 1)
                .input(Items.LEATHER_BOOTS)
                .input(Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_BOOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.SKY_CAP, 1)
                .input(Items.LEATHER_HELMET)
                .input(Items.LIME_DYE)
                .input(Items.FEATHER)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_HELMET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.SKY_TUNIC, 1)
                .input(Items.LEATHER_CHESTPLATE)
                .input(Items.LIME_DYE).input(Items.WHITE_DYE).input(Items.BLACK_DYE)
                .input(Items.FEATHER)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.SKY_TROUSERS, 1)
                .input(Items.LEATHER_LEGGINGS)
                .input(Items.LIME_DYE)
                .input(Items.FEATHER)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_LEGGINGS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.SKY_BOOTS, 1)
                .input(Items.LEATHER_BOOTS)
                .input(Items.BROWN_DYE)
                .input(Items.FEATHER)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_BOOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TIME_CAP, 1)
                .input(Items.LEATHER_HELMET)
                .input(Items.GREEN_DYE)
                .input(Items.CLOCK)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_HELMET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TIME_TUNIC, 1)
                .input(Items.LEATHER_CHESTPLATE)
                .input(Items.GREEN_DYE).input(Items.BROWN_DYE).input(Items.WHITE_DYE).input(Items.MAGENTA_DYE)
                .input(Items.CLOCK)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TIME_TROUSERS, 1)
                .input(Items.LEATHER_LEGGINGS)
                .input(Items.GREEN_DYE).input(Items.WHITE_DYE)
                .input(Items.CLOCK)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_LEGGINGS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TIME_BOOTS, 1)
                .input(Items.LEATHER_BOOTS)
                .input(Items.BROWN_DYE).input(Items.MAGENTA_DYE).input(Items.ORANGE_DYE)
                .input(Items.CLOCK)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_BOOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TWILIGHT_CAP, 1)
                .input(Items.LEATHER_HELMET)
                .input(Items.GREEN_DYE)
                .input(Items.BONE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_HELMET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TWILIGHT_TUNIC, 1)
                .input(Items.LEATHER_CHESTPLATE)
                .input(Items.GREEN_DYE).input(Items.BROWN_DYE).input(Items.BLUE_DYE).input(Items.WHITE_DYE)
                .input(Items.BONE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TWILIGHT_TROUSERS, 1)
                .input(Items.LEATHER_LEGGINGS)
                .input(Items.GREEN_DYE).input(Items.WHITE_DYE).input(Items.BROWN_DYE)
                .input(Items.BONE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_LEGGINGS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.TWILIGHT_BOOTS, 1)
                .input(Items.LEATHER_BOOTS)
                .input(Items.BROWN_DYE)
                .input(Items.BONE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_BOOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WILD_CAP, 1)
                .input(Items.LEATHER_HELMET)
                .input(Items.LIME_DYE)
                .input(Items.OAK_SAPLING).input(Items.HONEY_BOTTLE).input(HCBlocks.SILENT_PRINCESS)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_HELMET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WILD_TUNIC, 1)
                .input(Items.LEATHER_CHESTPLATE)
                .input(Items.LIME_DYE).input(Items.WHITE_DYE).input(Items.BROWN_DYE)
                .input(Items.OAK_SAPLING).input(Items.HONEY_BOTTLE).input(HCBlocks.SILENT_PRINCESS)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WILD_TROUSERS, 1)
                .input(Items.LEATHER_LEGGINGS)
                .input(Items.LIME_DYE).input(Items.BROWN_DYE)
                .input(Items.OAK_SAPLING).input(Items.HONEY_BOTTLE).input(HCBlocks.SILENT_PRINCESS)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_LEGGINGS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WILD_BOOTS, 1)
                .input(Items.LEATHER_BOOTS)
                .input(Items.BROWN_DYE)
                .input(Items.OAK_SAPLING).input(Items.HONEY_BOTTLE).input(HCBlocks.SILENT_PRINCESS)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_BOOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WIND_CAP, 1)
                .input(Items.LEATHER_HELMET)
                .input(Items.LIME_DYE)
                .input(Items.WIND_CHARGE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_HELMET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WIND_TUNIC, 1)
                .input(Items.LEATHER_CHESTPLATE)
                .input(Items.LIME_DYE)
                .input(Items.WIND_CHARGE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WIND_TROUSERS, 1)
                .input(Items.LEATHER_LEGGINGS)
                .input(Items.LIME_DYE).input(Items.WHITE_DYE)
                .input(Items.WIND_CHARGE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_LEGGINGS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.WIND_BOOTS, 1)
                .input(Items.LEATHER_BOOTS)
                .input(Items.BROWN_DYE)
                .input(Items.WIND_CHARGE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER_BOOTS))
                .offerTo(exporter);

        /// /// ///

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.CLAY_POT, 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("CCC")
                .input('C', Items.CLAY_BALL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY_BALL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.CLAY_POT_WRITING, 1)
                .input(HCBlocks.CLAY_POT)
                .input(Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.CLAY_POT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.BLUE_CLAY_POT, 1)
                .input(HCBlocks.CLAY_POT)
                .input(Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.CLAY_POT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.HATENO_CLAY_POT, 1)
                .input(HCBlocks.CLAY_POT)
                .input(Items.LIGHT_BLUE_DYE)
                .input(Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.CLAY_POT))
                .offerTo(exporter);

        //

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.DUBIOUS_FOOD, 1)
                .input(Items.CHICKEN)
                .input(Items.PUFFERFISH)
                .input(Items.ROTTEN_FLESH)
                .input(Items.POISONOUS_POTATO)
                .input(Items.DRIED_KELP)
                .input(Items.SPIDER_EYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CHICKEN))
                .offerTo(exporter);

        //

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.PUMPKIN_SOUP, 1)
                .input(Items.GLASS_BOTTLE)
                .input(HCItemTags.MILK_BUCKETS)
                .input(Blocks.PUMPKIN)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.SIMPLE_SOUP, 1)
                .input(Items.GLASS_BOTTLE)
                .input(HCItemTags.MILK_BUCKETS)
                .input(Items.SALMON)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.SALMON))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.GOOD_SOUP, 1)
                .input(Items.GLASS_BOTTLE)
                .input(HCItemTags.MILK_BUCKETS)
                .input(Items.SALMON)
                .input(Blocks.PUMPKIN)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.PUMPKIN))
                .offerTo(exporter, getItemId(HCItems.GOOD_SOUP) + "_main");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.GOOD_SOUP, 1)
                .input(HCItems.SIMPLE_SOUP)
                .input(Blocks.PUMPKIN)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.PUMPKIN))
                .offerTo(exporter, getItemId(HCItems.GOOD_SOUP) + "_from_simple_soup");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.SUPERB_SOUP, 1)
                .input(Items.GLASS_BOTTLE)
                .input(HCItemTags.MILK_BUCKETS)
                .input(Items.SALMON)
                .input(Blocks.PUMPKIN)
                .input(HCItems.GOAT_CHEESE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.GOAT_CHEESE))
                .offerTo(exporter, getItemId(HCItems.SUPERB_SOUP) + "_main");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.SUPERB_SOUP, 1)
                .input(HCItems.GOOD_SOUP)
                .input(HCItems.GOAT_CHEESE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.GOAT_CHEESE))
                .offerTo(exporter, getItemId(HCItems.SUPERB_SOUP) + "_from_good_soup");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.SUPERB_SOUP, 1)
                .input(HCItems.SIMPLE_SOUP)
                .input(Blocks.PUMPKIN)
                .input(HCItems.GOAT_CHEESE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.GOAT_CHEESE))
                .offerTo(exporter, getItemId(HCItems.SUPERB_SOUP) + "_from_simple_soup");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.GOAT_CHEESE, 1)
                .input(HCItems.GOAT_MILK_BUCKET)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE, 1)
                .input(HCItemTags.WHITE_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.SILENT_PRINCESS))
                .offerTo(exporter, getItemId(Items.WHITE_DYE) + "_single");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE, 2)
                .input(HCItemTags.DOUBLE_WHITE_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.TOWN_FLOWER))
                .offerTo(exporter, getItemId(Items.WHITE_DYE) + "_double");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, 2)
                .input(HCItemTags.DOUBLE_LIGHT_BLUE_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.SEA_FLOWER))
                .offerTo(exporter, getItemId(Items.LIGHT_BLUE_DYE) + "_double");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_DYE, 1)
                .input(HCItemTags.BLUE_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.BLUE_NIGHTSHADE))
                .offerTo(exporter, getItemId(Items.BLUE_DYE) + "_single");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .input(HCItemTags.PURPLE_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.SWIFT_VIOLETS))
                .offerTo(exporter, getItemId(Items.PURPLE_DYE) + "_single");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 1)
                .input(HCItemTags.MAGENTA_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.ARMORANTH))
                .offerTo(exporter, getItemId(Items.MAGENTA_DYE) + "_single");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 2)
                .input(HCItemTags.DOUBLE_MAGENTA_DYES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.EXOTIC_FLOWER))
                .offerTo(exporter, getItemId(Items.MAGENTA_DYE) + "_double");

        /** SHINGLES **/

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_GRAY_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_GRAY_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_GRAY_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GRAY_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GRAY_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GRAY_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GRAY_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLACK_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLACK_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLACK_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLACK_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BROWN_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BROWN_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BROWN_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BROWN_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.RED_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.RED_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.RED_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.RED_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.ORANGE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.ORANGE_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.ORANGE_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.ORANGE_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.YELLOW_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.YELLOW_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.YELLOW_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.YELLOW_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIME_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIME_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIME_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIME_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GREEN_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GREEN_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GREEN_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GREEN_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.CYAN_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.CYAN_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.CYAN_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.CYAN_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_BLUE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_BLUE_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_BLUE_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLUE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLUE_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLUE_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLUE_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PURPLE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PURPLE_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PURPLE_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PURPLE_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.MAGENTA_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.MAGENTA_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.MAGENTA_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.MAGENTA_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PINK_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PINK_SHINGLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PINK_SHINGLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PINK_SHINGLE_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        //

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.WHITE_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_GRAY_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.LIGHT_GRAY_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GRAY_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.GRAY_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLACK_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.BLACK_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BROWN_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.BROWN_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.RED_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.RED_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.ORANGE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.ORANGE_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.YELLOW_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.YELLOW_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIME_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.LIME_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.GREEN_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.GREEN_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.CYAN_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.CYAN_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.LIGHT_BLUE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.LIGHT_BLUE_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.BLUE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.BLUE_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PURPLE_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.PURPLE_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.MAGENTA_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.MAGENTA_SHINGLES) + "_main");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.PINK_SHINGLES, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', Items.CLAY_BALL).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter, getItemId(HCBlocks.PINK_SHINGLES) + "_main");


        /** MOD COMPAT STUFF **/
        // This is only really needed if people have other zelda mods installed alongside this one. Idk why they would but its just incase.

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.GREEN_RUPEE, 1)
                .input(HCItemTags.GREEN_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.GREEN_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.BLUE_RUPEE, 1)
                .input(HCItemTags.BLUE_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.BLUE_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.YELLOW_RUPEE, 1)
                .input(HCItemTags.YELLOW_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.YELLOW_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.RED_RUPEE, 1)
                .input(HCItemTags.RED_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.RED_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.PURPLE_RUPEE, 1)
                .input(HCItemTags.PURPLE_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.PURPLE_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.ORANGE_RUPEE, 1)
                .input(HCItemTags.ORANGE_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.ORANGE_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.SILVER_RUPEE, 1)
                .input(HCItemTags.SILVER_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.SILVER_RUPEE))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, HCItems.GOLD_RUPEE, 1)
                .input(HCItemTags.GOLD_RUPEES)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.GOLD_RUPEE))
                .offerTo(exporter);

    }
}
