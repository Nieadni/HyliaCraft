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
import net.nieadni.hyliacraft.block.HCColouredBlocks;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCRecipeProvider extends FabricRecipeProvider {
    public HCRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP_SS,1)
                .pattern("FWF")
                .pattern("LHG")
                .input('H', Items.LEATHER_HELMET)
                .input('G', Items.GREEN_DYE)
                .input('L', Items.LIME_DYE)
                .input('F', Items.FEATHER)
                .input('W', Items.GREEN_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP_TP,1)
                .pattern("BWB")
                .pattern("GHG")
                .input('H', Items.LEATHER_HELMET)
                .input('G', Items.GREEN_DYE)
                .input('B', Items.BONE)
                .input('W', Items.GREEN_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, HCItems.PHRYGIAN_CAP_CLASSIC,1)
                .pattern("LHL")
                .pattern("YWY")
                .input('H', Items.LEATHER_HELMET)
                .input('L', Items.LIME_DYE)
                .input('Y', Items.YELLOW_DYE)
                .input('W', Items.GREEN_WOOL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(exporter);

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

                                            /** COLOURED BLOCKS **/

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_BRICKS,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_BRICK_STAIRS,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_BRICK_SLAB,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_BRICK_WALL,8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREEN_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREEN_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREEN_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREEN_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.GREEN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_BLUE_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_BLUE_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.LIGHT_BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_BRICKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_BRICK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_BRICK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_BRICK_WALL, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.BRICKS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Blocks.BRICKS))
                .offerTo(exporter);



        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.WHITE_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.WHITE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.WHITE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIGHT_GREY_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.LIGHT_GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.GREY_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.GRAY_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.GRAY_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLACK_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BROWN_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.BROWN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BROWN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.RED_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.RED_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.RED_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.ORANGE_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.ORANGE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.ORANGE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.YELLOW_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.YELLOW_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.YELLOW_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.LIME_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.LIME_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.LIME_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.CYAN_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.CYAN_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CYAN_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.BLUE_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.BLUE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PURPLE_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.PURPLE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PURPLE_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.MAGENTA_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.MAGENTA_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.MAGENTA_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_PLANKS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANKS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_STRIPPED_LOG, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_LOGS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_STRIPPED_WOOD, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.STRIPPED_WOODS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_STAIRS, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_STAIRS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_SLAB, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_SLABS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_FENCE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_FENCE_GATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_FENCE_GATES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_PRESSURE_PLATE, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_PRESSURE_PLATES).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HCColouredBlocks.PINK_BUTTON, 8)
                .pattern("###").pattern("#@#").pattern("###")
                .input('#', HCItemTags.PLANK_BUTTONS).input('@', Items.PINK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.PINK_DYE))
                .offerTo(exporter);

    }
}
