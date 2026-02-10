package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class HCBlockLootProvider extends FabricBlockLootTableProvider {
    protected HCBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(Blocks.SHORT_GRASS, (block -> LootTable.builder()
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,1)))
                                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.SWORDS)))
                                .conditionally(RandomChanceLootCondition.builder(0.015f))
                                .with(ItemEntry.builder(HCItems.GREEN_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,1)))
                                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(HCItemTags.SICKLES)))
                                .conditionally(RandomChanceLootCondition.builder(0.1f))
                                .with(ItemEntry.builder(Items.WHEAT)))));
        addDrop(Blocks.TALL_GRASS, (block -> LootTable.builder()
                .pool(LootPool.builder()
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,1)))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.SWORDS)))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(HCItems.GREEN_RUPEE)))
                .pool(LootPool.builder()
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,1)))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(HCItemTags.SICKLES)))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(Items.WHEAT)))));
        addDrop(Blocks.JUNGLE_LEAVES, (block -> LootTable.builder()
                .pool(LootPool.builder()
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(HCItems.BANANA)))));

        // HC Non-Coloured Blocks

        addDrop(HCBlocks.CLAY_POT);
        addDrop(HCBlocks.NATURAL_CLAY_POT, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))
                                .with(ItemEntry.builder(HCBlocks.CLAY_POT)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,4)))
                                .conditionally(RandomChanceLootCondition.builder(50))
                                .with(ItemEntry.builder(HCItems.GREEN_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,2)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(HCItems.BLUE_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,3)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(Items.STICK)))));
        addDrop(HCBlocks.CLAY_POT_WRITING);
        addDrop(HCBlocks.NATURAL_CLAY_POT_WRITING, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))
                                .with(ItemEntry.builder(HCBlocks.CLAY_POT_WRITING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,4)))
                                .conditionally(RandomChanceLootCondition.builder(50))
                                .with(ItemEntry.builder(HCItems.GREEN_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,2)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(HCItems.BLUE_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,3)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(Items.STICK)))));
        addDrop(HCBlocks.BLUE_CLAY_POT);
        addDrop(HCBlocks.NATURAL_BLUE_CLAY_POT, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))
                                .with(ItemEntry.builder(HCBlocks.BLUE_CLAY_POT)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,1)))))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,8)))
                                .conditionally(RandomChanceLootCondition.builder(50))
                                .with(ItemEntry.builder(HCItems.GREEN_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,4)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(HCItems.BLUE_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,2)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(HCItems.YELLOW_RUPEE)))
                        .pool(LootPool.builder()
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0,3)))
                                .conditionally(RandomChanceLootCondition.builder(25))
                                .with(ItemEntry.builder(Items.ARROW)))));
        addDrop(HCBlocks.HATENO_CLAY_POT);

        addDrop(HCBlocks.ARMORANTH);
        addPottedPlantDrops(HCBlocks.ARMORANTH_POT);
        addDrop(HCBlocks.BLUE_NIGHTSHADE);
        addPottedPlantDrops(HCBlocks.BLUE_NIGHTSHADE_POT);
        addDrop(HCBlocks.SILENT_PRINCESS);
        addPottedPlantDrops(HCBlocks.SILENT_PRINCESS_POT);
        addDrop(HCBlocks.SWIFT_VIOLETS);
        addPottedPlantDrops(HCBlocks.SWIFT_VIOLETS_POT);

        // Coloured Blocks

        addDrop(HCColouredBlocks.WHITE_BRICKS);
        addDrop(HCColouredBlocks.WHITE_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.WHITE_BRICK_SLAB);
        addDrop(HCColouredBlocks.WHITE_BRICK_WALL);
        addDrop(HCColouredBlocks.LIGHT_GREY_BRICKS);
        addDrop(HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.LIGHT_GREY_BRICK_SLAB);
        addDrop(HCColouredBlocks.LIGHT_GREY_BRICK_WALL);
        addDrop(HCColouredBlocks.GREY_BRICKS);
        addDrop(HCColouredBlocks.GREY_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.GREY_BRICK_SLAB);
        addDrop(HCColouredBlocks.GREY_BRICK_WALL);
        addDrop(HCColouredBlocks.BLACK_BRICKS);
        addDrop(HCColouredBlocks.BLACK_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.BLACK_BRICK_SLAB);
        addDrop(HCColouredBlocks.BLACK_BRICK_WALL);
        addDrop(HCColouredBlocks.BROWN_BRICKS);
        addDrop(HCColouredBlocks.BROWN_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.BROWN_BRICK_SLAB);
        addDrop(HCColouredBlocks.BROWN_BRICK_WALL);
        addDrop(HCColouredBlocks.RED_BRICKS);
        addDrop(HCColouredBlocks.RED_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.RED_BRICK_SLAB);
        addDrop(HCColouredBlocks.RED_BRICK_WALL);
        addDrop(HCColouredBlocks.ORANGE_BRICKS);
        addDrop(HCColouredBlocks.ORANGE_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.ORANGE_BRICK_SLAB);
        addDrop(HCColouredBlocks.ORANGE_BRICK_WALL);
        addDrop(HCColouredBlocks.YELLOW_BRICKS);
        addDrop(HCColouredBlocks.YELLOW_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.YELLOW_BRICK_SLAB);
        addDrop(HCColouredBlocks.YELLOW_BRICK_WALL);
        addDrop(HCColouredBlocks.LIME_BRICKS);
        addDrop(HCColouredBlocks.LIME_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.LIME_BRICK_SLAB);
        addDrop(HCColouredBlocks.LIME_BRICK_WALL);
        addDrop(HCColouredBlocks.GREEN_BRICKS);
        addDrop(HCColouredBlocks.GREEN_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.GREEN_BRICK_SLAB);
        addDrop(HCColouredBlocks.GREEN_BRICK_WALL);
        addDrop(HCColouredBlocks.CYAN_BRICKS);
        addDrop(HCColouredBlocks.CYAN_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.CYAN_BRICK_SLAB);
        addDrop(HCColouredBlocks.CYAN_BRICK_WALL);
        addDrop(HCColouredBlocks.LIGHT_BLUE_BRICKS);
        addDrop(HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB);
        addDrop(HCColouredBlocks.LIGHT_BLUE_BRICK_WALL);
        addDrop(HCColouredBlocks.BLUE_BRICKS);
        addDrop(HCColouredBlocks.BLUE_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.BLUE_BRICK_SLAB);
        addDrop(HCColouredBlocks.BLUE_BRICK_WALL);
        addDrop(HCColouredBlocks.PURPLE_BRICKS);
        addDrop(HCColouredBlocks.PURPLE_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.PURPLE_BRICK_SLAB);
        addDrop(HCColouredBlocks.PURPLE_BRICK_WALL);
        addDrop(HCColouredBlocks.MAGENTA_BRICKS);
        addDrop(HCColouredBlocks.MAGENTA_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.MAGENTA_BRICK_SLAB);
        addDrop(HCColouredBlocks.MAGENTA_BRICK_WALL);
        addDrop(HCColouredBlocks.PINK_BRICKS);
        addDrop(HCColouredBlocks.PINK_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.PINK_BRICK_SLAB);
        addDrop(HCColouredBlocks.PINK_BRICK_WALL);
        addDrop(HCColouredBlocks.RAINBOW_BRICKS);
        addDrop(HCColouredBlocks.RAINBOW_BRICK_STAIRS);
        slabDrops(HCColouredBlocks.RAINBOW_BRICK_SLAB);
        addDrop(HCColouredBlocks.RAINBOW_BRICK_WALL);
        
        //
        
        
        addDrop(HCColouredBlocks.WHITE_STRIPPED_LOG);
        addDrop(HCColouredBlocks.WHITE_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.WHITE_PLANKS);
        addDrop(HCColouredBlocks.WHITE_STAIRS);
        slabDrops(HCColouredBlocks.WHITE_SLAB);
        addDrop(HCColouredBlocks.WHITE_FENCE);
        addDrop(HCColouredBlocks.WHITE_FENCE_GATE);
        addDrop(HCColouredBlocks.WHITE_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.WHITE_BUTTON);
        addDrop(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG);
        addDrop(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.LIGHT_GREY_PLANKS);
        addDrop(HCColouredBlocks.LIGHT_GREY_STAIRS);
        slabDrops(HCColouredBlocks.LIGHT_GREY_SLAB);
        addDrop(HCColouredBlocks.LIGHT_GREY_FENCE);
        addDrop(HCColouredBlocks.LIGHT_GREY_FENCE_GATE);
        addDrop(HCColouredBlocks.LIGHT_GREY_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.LIGHT_GREY_BUTTON);
        addDrop(HCColouredBlocks.GREY_STRIPPED_LOG);
        addDrop(HCColouredBlocks.GREY_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.GREY_PLANKS);
        addDrop(HCColouredBlocks.GREY_STAIRS);
        slabDrops(HCColouredBlocks.GREY_SLAB);
        addDrop(HCColouredBlocks.GREY_FENCE);
        addDrop(HCColouredBlocks.GREY_FENCE_GATE);
        addDrop(HCColouredBlocks.GREY_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.GREY_BUTTON);
        addDrop(HCColouredBlocks.BLACK_STRIPPED_LOG);
        addDrop(HCColouredBlocks.BLACK_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.BLACK_PLANKS);
        addDrop(HCColouredBlocks.BLACK_STAIRS);
        slabDrops(HCColouredBlocks.BLACK_SLAB);
        addDrop(HCColouredBlocks.BLACK_FENCE);
        addDrop(HCColouredBlocks.BLACK_FENCE_GATE);
        addDrop(HCColouredBlocks.BLACK_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.BLACK_BUTTON);
        addDrop(HCColouredBlocks.BROWN_STRIPPED_LOG);
        addDrop(HCColouredBlocks.BROWN_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.BROWN_PLANKS);
        addDrop(HCColouredBlocks.BROWN_STAIRS);
        slabDrops(HCColouredBlocks.BROWN_SLAB);
        addDrop(HCColouredBlocks.BROWN_FENCE);
        addDrop(HCColouredBlocks.BROWN_FENCE_GATE);
        addDrop(HCColouredBlocks.BROWN_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.BROWN_BUTTON);
        addDrop(HCColouredBlocks.RED_STRIPPED_LOG);
        addDrop(HCColouredBlocks.RED_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.RED_PLANKS);
        addDrop(HCColouredBlocks.RED_STAIRS);
        slabDrops(HCColouredBlocks.RED_SLAB);
        addDrop(HCColouredBlocks.RED_FENCE);
        addDrop(HCColouredBlocks.RED_FENCE_GATE);
        addDrop(HCColouredBlocks.RED_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.RED_BUTTON);
        addDrop(HCColouredBlocks.ORANGE_STRIPPED_LOG);
        addDrop(HCColouredBlocks.ORANGE_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.ORANGE_PLANKS);
        addDrop(HCColouredBlocks.ORANGE_STAIRS);
        slabDrops(HCColouredBlocks.ORANGE_SLAB);
        addDrop(HCColouredBlocks.ORANGE_FENCE);
        addDrop(HCColouredBlocks.ORANGE_FENCE_GATE);
        addDrop(HCColouredBlocks.ORANGE_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.ORANGE_BUTTON);
        addDrop(HCColouredBlocks.YELLOW_STRIPPED_LOG);
        addDrop(HCColouredBlocks.YELLOW_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.YELLOW_PLANKS);
        addDrop(HCColouredBlocks.YELLOW_STAIRS);
        slabDrops(HCColouredBlocks.YELLOW_SLAB);
        addDrop(HCColouredBlocks.YELLOW_FENCE);
        addDrop(HCColouredBlocks.YELLOW_FENCE_GATE);
        addDrop(HCColouredBlocks.YELLOW_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.YELLOW_BUTTON);
        addDrop(HCColouredBlocks.LIME_STRIPPED_LOG);
        addDrop(HCColouredBlocks.LIME_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.LIME_PLANKS);
        addDrop(HCColouredBlocks.LIME_STAIRS);
        slabDrops(HCColouredBlocks.LIME_SLAB);
        addDrop(HCColouredBlocks.LIME_FENCE);
        addDrop(HCColouredBlocks.LIME_FENCE_GATE);
        addDrop(HCColouredBlocks.LIME_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.LIME_BUTTON);
        addDrop(HCColouredBlocks.GREEN_STRIPPED_LOG);
        addDrop(HCColouredBlocks.GREEN_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.GREEN_PLANKS);
        addDrop(HCColouredBlocks.GREEN_STAIRS);
        slabDrops(HCColouredBlocks.GREEN_SLAB);
        addDrop(HCColouredBlocks.GREEN_FENCE);
        addDrop(HCColouredBlocks.GREEN_FENCE_GATE);
        addDrop(HCColouredBlocks.GREEN_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.GREEN_BUTTON);
        addDrop(HCColouredBlocks.CYAN_STRIPPED_LOG);
        addDrop(HCColouredBlocks.CYAN_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.CYAN_PLANKS);
        addDrop(HCColouredBlocks.CYAN_STAIRS);
        slabDrops(HCColouredBlocks.CYAN_SLAB);
        addDrop(HCColouredBlocks.CYAN_FENCE);
        addDrop(HCColouredBlocks.CYAN_FENCE_GATE);
        addDrop(HCColouredBlocks.CYAN_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.CYAN_BUTTON);
        addDrop(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG);
        addDrop(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.LIGHT_BLUE_PLANKS);
        addDrop(HCColouredBlocks.LIGHT_BLUE_STAIRS);
        slabDrops(HCColouredBlocks.LIGHT_BLUE_SLAB);
        addDrop(HCColouredBlocks.LIGHT_BLUE_FENCE);
        addDrop(HCColouredBlocks.LIGHT_BLUE_FENCE_GATE);
        addDrop(HCColouredBlocks.LIGHT_BLUE_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.LIGHT_BLUE_BUTTON);
        addDrop(HCColouredBlocks.BLUE_STRIPPED_LOG);
        addDrop(HCColouredBlocks.BLUE_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.BLUE_PLANKS);
        addDrop(HCColouredBlocks.BLUE_STAIRS);
        slabDrops(HCColouredBlocks.BLUE_SLAB);
        addDrop(HCColouredBlocks.BLUE_FENCE);
        addDrop(HCColouredBlocks.BLUE_FENCE_GATE);
        addDrop(HCColouredBlocks.BLUE_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.BLUE_BUTTON);
        addDrop(HCColouredBlocks.PURPLE_STRIPPED_LOG);
        addDrop(HCColouredBlocks.PURPLE_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.PURPLE_PLANKS);
        addDrop(HCColouredBlocks.PURPLE_STAIRS);
        slabDrops(HCColouredBlocks.PURPLE_SLAB);
        addDrop(HCColouredBlocks.PURPLE_FENCE);
        addDrop(HCColouredBlocks.PURPLE_FENCE_GATE);
        addDrop(HCColouredBlocks.PURPLE_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.PURPLE_BUTTON);
        addDrop(HCColouredBlocks.MAGENTA_STRIPPED_LOG);
        addDrop(HCColouredBlocks.MAGENTA_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.MAGENTA_PLANKS);
        addDrop(HCColouredBlocks.MAGENTA_STAIRS);
        slabDrops(HCColouredBlocks.MAGENTA_SLAB);
        addDrop(HCColouredBlocks.MAGENTA_FENCE);
        addDrop(HCColouredBlocks.MAGENTA_FENCE_GATE);
        addDrop(HCColouredBlocks.MAGENTA_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.MAGENTA_BUTTON);
        addDrop(HCColouredBlocks.PINK_STRIPPED_LOG);
        addDrop(HCColouredBlocks.PINK_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.PINK_PLANKS);
        addDrop(HCColouredBlocks.PINK_STAIRS);
        slabDrops(HCColouredBlocks.PINK_SLAB);
        addDrop(HCColouredBlocks.PINK_FENCE);
        addDrop(HCColouredBlocks.PINK_FENCE_GATE);
        addDrop(HCColouredBlocks.PINK_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.PINK_BUTTON);
        addDrop(HCColouredBlocks.RAINBOW_STRIPPED_LOG);
        addDrop(HCColouredBlocks.RAINBOW_STRIPPED_WOOD);
        addDrop(HCColouredBlocks.RAINBOW_PLANKS);
        addDrop(HCColouredBlocks.RAINBOW_STAIRS);
        slabDrops(HCColouredBlocks.RAINBOW_SLAB);
        addDrop(HCColouredBlocks.RAINBOW_FENCE);
        addDrop(HCColouredBlocks.RAINBOW_FENCE_GATE);
        addDrop(HCColouredBlocks.RAINBOW_PRESSURE_PLATE);
        addDrop(HCColouredBlocks.RAINBOW_BUTTON);

        //

        addDrop(HCColouredBlocks.WHITE_SHINGLES);
        addDrop(HCColouredBlocks.WHITE_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.WHITE_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.WHITE_SHINGLE_WALL);
        addDrop(HCColouredBlocks.LIGHT_GREY_SHINGLES);
        addDrop(HCColouredBlocks.LIGHT_GREY_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.LIGHT_GREY_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.LIGHT_GREY_SHINGLE_WALL);
        addDrop(HCColouredBlocks.GREY_SHINGLES);
        addDrop(HCColouredBlocks.GREY_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.GREY_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.GREY_SHINGLE_WALL);
        addDrop(HCColouredBlocks.BLACK_SHINGLES);
        addDrop(HCColouredBlocks.BLACK_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.BLACK_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.BLACK_SHINGLE_WALL);
        addDrop(HCColouredBlocks.BROWN_SHINGLES);
        addDrop(HCColouredBlocks.BROWN_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.BROWN_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.BROWN_SHINGLE_WALL);
        addDrop(HCColouredBlocks.RED_SHINGLES);
        addDrop(HCColouredBlocks.RED_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.RED_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.RED_SHINGLE_WALL);
        addDrop(HCColouredBlocks.ORANGE_SHINGLES);
        addDrop(HCColouredBlocks.ORANGE_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.ORANGE_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.ORANGE_SHINGLE_WALL);
        addDrop(HCColouredBlocks.YELLOW_SHINGLES);
        addDrop(HCColouredBlocks.YELLOW_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.YELLOW_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.YELLOW_SHINGLE_WALL);
        addDrop(HCColouredBlocks.LIME_SHINGLES);
        addDrop(HCColouredBlocks.LIME_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.LIME_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.LIME_SHINGLE_WALL);
        addDrop(HCColouredBlocks.GREEN_SHINGLES);
        addDrop(HCColouredBlocks.GREEN_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.GREEN_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.GREEN_SHINGLE_WALL);
        addDrop(HCColouredBlocks.CYAN_SHINGLES);
        addDrop(HCColouredBlocks.CYAN_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.CYAN_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.CYAN_SHINGLE_WALL);
        addDrop(HCColouredBlocks.LIGHT_BLUE_SHINGLES);
        addDrop(HCColouredBlocks.LIGHT_BLUE_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.LIGHT_BLUE_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.LIGHT_BLUE_SHINGLE_WALL);
        addDrop(HCColouredBlocks.BLUE_SHINGLES);
        addDrop(HCColouredBlocks.BLUE_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.BLUE_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.BLUE_SHINGLE_WALL);
        addDrop(HCColouredBlocks.PURPLE_SHINGLES);
        addDrop(HCColouredBlocks.PURPLE_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.PURPLE_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.PURPLE_SHINGLE_WALL);
        addDrop(HCColouredBlocks.MAGENTA_SHINGLES);
        addDrop(HCColouredBlocks.MAGENTA_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.MAGENTA_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.MAGENTA_SHINGLE_WALL);
        addDrop(HCColouredBlocks.PINK_SHINGLES);
        addDrop(HCColouredBlocks.PINK_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.PINK_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.PINK_SHINGLE_WALL);
        addDrop(HCColouredBlocks.RAINBOW_SHINGLES);
        addDrop(HCColouredBlocks.RAINBOW_SHINGLE_STAIRS);
        slabDrops(HCColouredBlocks.RAINBOW_SHINGLE_SLAB);
        addDrop(HCColouredBlocks.RAINBOW_SHINGLE_WALL);
    }

    @Override
    public BlockLootTableGenerator withConditions(ResourceCondition... conditions) {
        return super.withConditions(conditions);
    }

    @Override
    public BiConsumer<RegistryKey<LootTable>, LootTable.Builder> withConditions(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> exporter, ResourceCondition... conditions) {
        return super.withConditions(exporter, conditions);
    }
}
