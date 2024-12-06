package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nieadni.hyliacraft.block.HCColouredBlocks;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public HCItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(HCItems.MAJORAS_MASK);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(HCItems.MAJORAS_MASK);
        getOrCreateTagBuilder(HCItemTags.ENDERMASK).add(HCItems.MAJORAS_MASK);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(HCItems.PUMPKIN_MASK);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(HCItems.PUMPKIN_MASK);
        getOrCreateTagBuilder(HCItemTags.ENDERMASK).add(HCItems.PUMPKIN_MASK);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.GODDESS_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.GODDESS_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.GODDESS_LONGSWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.GODDESS_LONGSWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.GODDESS_WHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.GODDESS_WHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.TRUE_MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.TRUE_MASTER_SWORD);

        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(HCItems.IRON_BOW);
        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(HCItems.FAIRY_BOW);

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(HCItems.DIGGING_MITT);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(HCItems.DIGGING_MITT);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.HYLIAN_SHIELD);

        // Vanilla

        getOrCreateTagBuilder(HCItemTags.BOKOBLIN_FOOD)
                .add(Items.BEEF).add(Items.COOKED_BEEF)
                .add(Items.CHICKEN).add(Items.COOKED_CHICKEN)
                .add(Items.COD).add(Items.COOKED_COD)
                .add(Items.MUTTON).add(Items.COOKED_MUTTON)
                .add(Items.RABBIT).add(Items.COOKED_RABBIT)
                .add(Items.PORKCHOP).add(Items.COOKED_PORKCHOP)
                .add(Items.SALMON).add(Items.COOKED_SALMON);

        getOrCreateTagBuilder(HCItemTags.ENDERMASK).add(Items.CARVED_PUMPKIN);

        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(Blocks.BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(Blocks.BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(Blocks.BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(Blocks.BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.OAK_PLANKS));

        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_OAK_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_OAK_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.OAK_PLANKS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.OAK_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.OAK_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.OAK_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.OAK_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.OAK_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.SPRUCE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_SPRUCE_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_SPRUCE_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.SPRUCE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.SPRUCE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.SPRUCE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.SPRUCE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.SPRUCE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.SPRUCE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.BIRCH_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_BIRCH_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_BIRCH_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.BIRCH_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.BIRCH_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.BIRCH_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.BIRCH_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.BIRCH_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.BIRCH_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.JUNGLE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_JUNGLE_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_JUNGLE_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.JUNGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.JUNGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.JUNGLE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.JUNGLE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.JUNGLE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.JUNGLE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.ACACIA_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_ACACIA_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_ACACIA_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.ACACIA_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.ACACIA_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.ACACIA_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.ACACIA_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.ACACIA_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.ACACIA_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.DARK_OAK_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_DARK_OAK_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_DARK_OAK_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.DARK_OAK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.DARK_OAK_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.DARK_OAK_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.DARK_OAK_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.DARK_OAK_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.DARK_OAK_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.MANGROVE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_MANGROVE_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_MANGROVE_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.MANGROVE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.MANGROVE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.MANGROVE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.MANGROVE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.MANGROVE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.MANGROVE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.CHERRY_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_CHERRY_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(Blocks.STRIPPED_CHERRY_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.CHERRY_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.CHERRY_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.CHERRY_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.CHERRY_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.CHERRY_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.CHERRY_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(Blocks.BAMBOO_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(Blocks.STRIPPED_BAMBOO_BLOCK));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(Blocks.BAMBOO_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(Blocks.BAMBOO_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(Blocks.BAMBOO_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(Blocks.BAMBOO_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(Blocks.BAMBOO_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(Blocks.BAMBOO_BUTTON));

        // Blocks

        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.WHITE_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.WHITE_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.WHITE_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.WHITE_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.GREY_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.GREY_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.GREY_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.GREY_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.BLACK_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.BLACK_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.BLACK_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.BLACK_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.BROWN_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.BROWN_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.BROWN_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.BROWN_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.RED_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.RED_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.RED_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.RED_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.ORANGE_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.ORANGE_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.ORANGE_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.ORANGE_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.YELLOW_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.YELLOW_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.YELLOW_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.YELLOW_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.LIME_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.LIME_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.LIME_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.LIME_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.GREEN_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.GREEN_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.GREEN_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.GREEN_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.CYAN_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.CYAN_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.CYAN_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.CYAN_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.BLUE_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.BLUE_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.BLUE_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.BLUE_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.PURPLE_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.PURPLE_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.PURPLE_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.PURPLE_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.PINK_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.PINK_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.PINK_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.PINK_BRICK_WALL));
        getOrCreateTagBuilder(HCItemTags.BRICKS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_BRICKS));
        getOrCreateTagBuilder(HCItemTags.BRICK_STAIRS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_BRICK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.BRICK_SLABS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_BRICK_SLAB));
        getOrCreateTagBuilder(HCItemTags.BRICK_WALLS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_BRICK_WALL));

        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.WHITE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.WHITE_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.WHITE_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.WHITE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.WHITE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.WHITE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.WHITE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.WHITE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.WHITE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.LIGHT_GREY_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.GREY_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.GREY_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.GREY_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.GREY_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.GREY_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.GREY_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.GREY_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.GREY_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.GREY_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.BLACK_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.BLACK_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.BLACK_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.BLACK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.BLACK_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.BLACK_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.BLACK_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.BLACK_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.BLACK_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.BROWN_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.BROWN_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.BROWN_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.BROWN_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.BROWN_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.BROWN_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.BROWN_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.BROWN_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.BROWN_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.RED_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.RED_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.RED_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.RED_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.RED_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.RED_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.RED_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.RED_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.RED_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.ORANGE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.ORANGE_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.ORANGE_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.ORANGE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.ORANGE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.ORANGE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.ORANGE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.ORANGE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.ORANGE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.YELLOW_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.YELLOW_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.YELLOW_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.YELLOW_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.YELLOW_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.YELLOW_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.YELLOW_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.YELLOW_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.YELLOW_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.LIME_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.LIME_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.LIME_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.LIME_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.LIME_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.LIME_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.LIME_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.LIME_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.LIME_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.GREEN_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.GREEN_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.GREEN_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.GREEN_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.GREEN_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.GREEN_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.GREEN_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.GREEN_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.GREEN_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.CYAN_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.CYAN_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.CYAN_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.CYAN_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.CYAN_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.CYAN_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.CYAN_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.CYAN_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.CYAN_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.LIGHT_BLUE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.BLUE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.BLUE_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.BLUE_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.BLUE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.BLUE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.BLUE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.BLUE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.BLUE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.BLUE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.PURPLE_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.PURPLE_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.PURPLE_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.PURPLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.PURPLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.PURPLE_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.PURPLE_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.PURPLE_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.PURPLE_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.MAGENTA_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.MAGENTA_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.MAGENTA_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.MAGENTA_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.PINK_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.PINK_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.PINK_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.PINK_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.PINK_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.PINK_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.PINK_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.PINK_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.PINK_BUTTON));
        getOrCreateTagBuilder(HCItemTags.PLANKS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_PLANKS));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_LOGS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_STRIPPED_LOG));
        getOrCreateTagBuilder(HCItemTags.STRIPPED_WOODS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_STRIPPED_WOOD));
        getOrCreateTagBuilder(HCItemTags.PLANK_STAIRS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_STAIRS));
        getOrCreateTagBuilder(HCItemTags.PLANK_SLABS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_SLAB));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCES).add(Item.fromBlock(HCColouredBlocks.RAINBOW_FENCE));
        getOrCreateTagBuilder(HCItemTags.PLANK_FENCE_GATES).add(Item.fromBlock(HCColouredBlocks.RAINBOW_FENCE_GATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_PRESSURE_PLATES).add(Item.fromBlock(HCColouredBlocks.RAINBOW_PRESSURE_PLATE));
        getOrCreateTagBuilder(HCItemTags.PLANK_BUTTONS).add(Item.fromBlock(HCColouredBlocks.RAINBOW_BUTTON));

    }
}