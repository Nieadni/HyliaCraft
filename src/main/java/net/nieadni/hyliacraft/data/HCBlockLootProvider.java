package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class HCBlockLootProvider extends FabricBlockLootTableProvider {
    protected HCBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
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
        addDrop(HCBlocks.ARMORANTH);
        addPottedPlantDrops(HCBlocks.ARMORANTH_POT);
        addDrop(HCBlocks.BLUE_NIGHTSHADE);
        addPottedPlantDrops(HCBlocks.BLUE_NIGHTSHADE_POT);
        addDrop(HCBlocks.SILENT_PRINCESS);
        addPottedPlantDrops(HCBlocks.SILENT_PRINCESS_POT);
        addDrop(HCBlocks.SWIFT_VIOLETS);
        addPottedPlantDrops(HCBlocks.SWIFT_VIOLETS_POT);
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
