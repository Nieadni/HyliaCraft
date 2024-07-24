package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public HCItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
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

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(HCItems.DIGGING_MITT);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(HCItems.DIGGING_MITT);
    }
}