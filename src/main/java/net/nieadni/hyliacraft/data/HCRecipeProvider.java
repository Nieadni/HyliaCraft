package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCRecipeProvider extends FabricRecipeProvider {
    public HCRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        /**
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.CLAY_POT)
                .input(Items.CLAY_BALL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY_BALL))
                .offerTo(exporter);
         **/

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.CLAY_POT,1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("CCC")
                .input('C', Items.CLAY_BALL)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.CLAY_POT_WRITING,1)
                .pattern("CCC")
                .pattern("CDC")
                .pattern("CCC")
                .input('C', Items.CLAY_BALL)
                .input('D', Items.BLACK_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, HCBlocks.BLUE_CLAY_POT,1)
                .pattern("CCC")
                .pattern("CDC")
                .pattern("CCC")
                .input('C', Items.CLAY_BALL)
                .input('D', Items.BLUE_DYE)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(Items.CLAY_BALL))
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

    }
}
