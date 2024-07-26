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
import net.minecraft.registry.tag.ItemTags;
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 1)
                .input(HCBlocks.ARMORANTH)
                .criterion("get_item", InventoryChangedCriterion.Conditions.items(HCBlocks.ARMORANTH))
                .offerTo(exporter);
    }
}
