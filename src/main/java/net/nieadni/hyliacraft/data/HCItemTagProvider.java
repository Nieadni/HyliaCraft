package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public HCItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(HCItems.MAJORAS_MASK).add(HCItems.MIDNA_HELM).add(HCItems.PUMPKIN_MASK).add(HCItems.PHRYGIAN_CAP)
                .add(HCItems.PHRYGIAN_CAP_SS).add(HCItems.PHRYGIAN_CAP_TP).add(HCItems.PHRYGIAN_CAP_CLASSIC);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(HCItems.MAJORAS_MASK).add(HCItems.MIDNA_HELM).add(HCItems.PUMPKIN_MASK).add(HCItems.PHRYGIAN_CAP)
                .add(HCItems.PHRYGIAN_CAP_SS).add(HCItems.PHRYGIAN_CAP_TP).add(HCItems.PHRYGIAN_CAP_CLASSIC);
        getOrCreateTagBuilder(HCItemTags.ENDERMASK)
                .add(HCItems.MAJORAS_MASK).add(HCItems.PUMPKIN_MASK);

        getOrCreateTagBuilder(ItemTags.DYEABLE).add(HCItems.PHRYGIAN_CAP);

        getOrCreateTagBuilder(ItemTags.PIG_FOOD).add(HCItems.BANANA);


        getOrCreateTagBuilder(HCItemTags.MILK_BUCKETS).add(HCItems.GOAT_MILK_BUCKET).add(Items.MILK_BUCKET);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.GODDESS_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.GODDESS_SWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.GODDESS_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.GODDESS_LONGSWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.GODDESS_LONGSWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.GODDESS_LONGSWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.GODDESS_WHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.GODDESS_WHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.GODDESS_WHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(HCItems.TRUE_MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.TRUE_MASTER_SWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.TRUE_MASTER_SWORD);

        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(HCItems.IRON_BOW);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.IRON_BOW);
        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(HCItems.FAIRY_BOW);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.FAIRY_BOW);

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(HCItems.DIGGING_MITT);
        getOrCreateTagBuilder(ItemTags.HOES).add(HCItems.DIGGING_MITT);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(HCItems.DIGGING_MITT);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.DIGGING_MITT);

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(HCItems.MOGMA_MITT);
        getOrCreateTagBuilder(ItemTags.HOES).add(HCItems.MOGMA_MITT);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(HCItems.MOGMA_MITT);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(HCItems.MOGMA_MITT);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.MOGMA_MITT);

        getOrCreateTagBuilder(ItemTags.MACE_ENCHANTABLE).add(HCItems.BOULDER_BREAKER);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(HCItems.BOULDER_BREAKER);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(HCItems.BOULDER_BREAKER);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.BOULDER_BREAKER);

        getOrCreateTagBuilder(HCItemTags.SICKLES).add(HCItems.VICIOUS_SICKLE);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(HCItems.VICIOUS_SICKLE);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(HCItems.VICIOUS_SICKLE);


        // Vanilla

        getOrCreateTagBuilder(HCItemTags.ENDERMASK).add(Items.CARVED_PUMPKIN);

        getOrCreateTagBuilder(HCItemTags.SLINGSHOT_AMMO).add(Items.COBBLESTONE);
        getOrCreateTagBuilder(HCItemTags.SLINGSHOT_AMMO).add(Items.STONE);

        // Blocks

        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.WHITE_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.WHITE_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.WHITE_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.WHITE_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.GRAY_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.GRAY_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.GRAY_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.GRAY_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.BLACK_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.BLACK_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.BLACK_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.BLACK_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.BROWN_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.BROWN_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.BROWN_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.BROWN_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.RED_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.RED_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.RED_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.RED_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.ORANGE_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.ORANGE_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.ORANGE_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.ORANGE_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.YELLOW_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.YELLOW_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.YELLOW_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.YELLOW_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.LIME_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.LIME_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.LIME_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.LIME_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.GREEN_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.GREEN_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.GREEN_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.GREEN_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.CYAN_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.CYAN_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.CYAN_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.CYAN_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.BLUE_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.BLUE_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.BLUE_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.BLUE_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.PURPLE_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.PURPLE_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.PURPLE_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.PURPLE_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.MAGENTA_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.MAGENTA_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.MAGENTA_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.MAGENTA_SHINGLE_WALL));
        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.PINK_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.PINK_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.PINK_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.PINK_SHINGLE_WALL));
    }
}