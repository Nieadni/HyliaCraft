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
        
        //

        addDrop(HCBlocks.WHITE_SHINGLES);
        addDrop(HCBlocks.WHITE_SHINGLE_STAIRS);
        slabDrops(HCBlocks.WHITE_SHINGLE_SLAB);
        addDrop(HCBlocks.WHITE_SHINGLE_WALL);
        addDrop(HCBlocks.LIGHT_GRAY_SHINGLES);
        addDrop(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS);
        slabDrops(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB);
        addDrop(HCBlocks.LIGHT_GRAY_SHINGLE_WALL);
        addDrop(HCBlocks.GRAY_SHINGLES);
        addDrop(HCBlocks.GRAY_SHINGLE_STAIRS);
        slabDrops(HCBlocks.GRAY_SHINGLE_SLAB);
        addDrop(HCBlocks.GRAY_SHINGLE_WALL);
        addDrop(HCBlocks.BLACK_SHINGLES);
        addDrop(HCBlocks.BLACK_SHINGLE_STAIRS);
        slabDrops(HCBlocks.BLACK_SHINGLE_SLAB);
        addDrop(HCBlocks.BLACK_SHINGLE_WALL);
        addDrop(HCBlocks.BROWN_SHINGLES);
        addDrop(HCBlocks.BROWN_SHINGLE_STAIRS);
        slabDrops(HCBlocks.BROWN_SHINGLE_SLAB);
        addDrop(HCBlocks.BROWN_SHINGLE_WALL);
        addDrop(HCBlocks.RED_SHINGLES);
        addDrop(HCBlocks.RED_SHINGLE_STAIRS);
        slabDrops(HCBlocks.RED_SHINGLE_SLAB);
        addDrop(HCBlocks.RED_SHINGLE_WALL);
        addDrop(HCBlocks.ORANGE_SHINGLES);
        addDrop(HCBlocks.ORANGE_SHINGLE_STAIRS);
        slabDrops(HCBlocks.ORANGE_SHINGLE_SLAB);
        addDrop(HCBlocks.ORANGE_SHINGLE_WALL);
        addDrop(HCBlocks.YELLOW_SHINGLES);
        addDrop(HCBlocks.YELLOW_SHINGLE_STAIRS);
        slabDrops(HCBlocks.YELLOW_SHINGLE_SLAB);
        addDrop(HCBlocks.YELLOW_SHINGLE_WALL);
        addDrop(HCBlocks.LIME_SHINGLES);
        addDrop(HCBlocks.LIME_SHINGLE_STAIRS);
        slabDrops(HCBlocks.LIME_SHINGLE_SLAB);
        addDrop(HCBlocks.LIME_SHINGLE_WALL);
        addDrop(HCBlocks.GREEN_SHINGLES);
        addDrop(HCBlocks.GREEN_SHINGLE_STAIRS);
        slabDrops(HCBlocks.GREEN_SHINGLE_SLAB);
        addDrop(HCBlocks.GREEN_SHINGLE_WALL);
        addDrop(HCBlocks.CYAN_SHINGLES);
        addDrop(HCBlocks.CYAN_SHINGLE_STAIRS);
        slabDrops(HCBlocks.CYAN_SHINGLE_SLAB);
        addDrop(HCBlocks.CYAN_SHINGLE_WALL);
        addDrop(HCBlocks.LIGHT_BLUE_SHINGLES);
        addDrop(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS);
        slabDrops(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB);
        addDrop(HCBlocks.LIGHT_BLUE_SHINGLE_WALL);
        addDrop(HCBlocks.BLUE_SHINGLES);
        addDrop(HCBlocks.BLUE_SHINGLE_STAIRS);
        slabDrops(HCBlocks.BLUE_SHINGLE_SLAB);
        addDrop(HCBlocks.BLUE_SHINGLE_WALL);
        addDrop(HCBlocks.PURPLE_SHINGLES);
        addDrop(HCBlocks.PURPLE_SHINGLE_STAIRS);
        slabDrops(HCBlocks.PURPLE_SHINGLE_SLAB);
        addDrop(HCBlocks.PURPLE_SHINGLE_WALL);
        addDrop(HCBlocks.MAGENTA_SHINGLES);
        addDrop(HCBlocks.MAGENTA_SHINGLE_STAIRS);
        slabDrops(HCBlocks.MAGENTA_SHINGLE_SLAB);
        addDrop(HCBlocks.MAGENTA_SHINGLE_WALL);
        addDrop(HCBlocks.PINK_SHINGLES);
        addDrop(HCBlocks.PINK_SHINGLE_STAIRS);
        slabDrops(HCBlocks.PINK_SHINGLE_SLAB);
        addDrop(HCBlocks.PINK_SHINGLE_WALL);
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
