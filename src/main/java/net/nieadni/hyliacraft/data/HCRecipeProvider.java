package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP,1)
                .pattern("H")
                .pattern("L")
                .input('H', Items.LEATHER_HELMET)
                .input('L', Items.LEATHER)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP_SS,1)
                .pattern("FWF")
                .pattern("LHG")
                .input('H', HCItems.PHRYGIAN_CAP)
                .input('G', Items.GREEN_DYE)
                .input('L', Items.LIME_DYE)
                .input('F', Items.FEATHER)
                .input('W', Items.GREEN_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP_TP,1)
                .pattern("BWB")
                .pattern("GHG")
                .input('H', HCItems.PHRYGIAN_CAP)
                .input('G', Items.GREEN_DYE)
                .input('B', Items.BONE)
                .input('W', Items.GREEN_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP_CLASSIC,1)
                .pattern("LHL")
                .pattern("YWY")
                .input('H', HCItems.PHRYGIAN_CAP)
                .input('L', Items.LIME_DYE)
                .input('Y', Items.YELLOW_DYE)
                .input('W', Items.GREEN_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);

        //

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.CLAY_POT,1)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.PARAGLIDER,1)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HCItems.FAIRY_BOW,1)
                .pattern("LR")
                .pattern("GB")
                .pattern("LR")
                .input('B', Items.BOW)
                .input('L', Items.LAPIS_LAZULI)
                .input('R', Items.REDSTONE)
                .input('G', Items.GOLD_INGOT)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BOW))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.DUBIOUS_FOOD, 1)
                .input(Items.CHICKEN)
                .input(Items.PUFFERFISH)
                .input(Items.ROTTEN_FLESH)
                .input(Items.POISONOUS_POTATO)
                .input(Items.DRIED_KELP)
                .input(Items.SPIDER_EYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.ARMORANTH))
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
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.SUPERB_SOUP, 1)
                .input(Items.GLASS_BOTTLE)
                .input(HCItemTags.MILK_BUCKETS)
                .input(Items.SALMON)
                .input(Blocks.PUMPKIN)
                .input(HCItems.GOAT_CHEESE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCItems.GOAT_CHEESE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HCItems.GOAT_CHEESE, 1)
                .input(HCItems.GOAT_MILK_BUCKET)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.PUMPKIN))
                .offerTo(exporter);

        //

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 1)
                .input(HCBlocks.ARMORANTH)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.ARMORANTH))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_DYE, 1)
                .input(HCBlocks.BLUE_NIGHTSHADE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.BLUE_NIGHTSHADE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE, 1)
                .input(HCBlocks.SILENT_PRINCESS)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.SILENT_PRINCESS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .input(HCBlocks.SWIFT_VIOLETS)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.SWIFT_VIOLETS))
                .offerTo(exporter);

                                            /** SHINGLES **/

        //

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLES,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLE_STAIRS,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLE_SLAB,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.SHINGLES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLE_WALL,8)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCBlocks.WHITE_SHINGLES,8)
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

    }

}
