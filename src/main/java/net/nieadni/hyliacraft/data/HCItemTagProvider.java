package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
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
                .add(HCItems.MAJORAS_MASK, HCItems.MIDNA_HELM, HCItems.PUMPKIN_MASK, HCItems.PHRYGIAN_CAP, HCItems.PHRYGIAN_CAP_SS, HCItems.PHRYGIAN_CAP_TP,
                        HCItems.PHRYGIAN_CAP_CLASSIC);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(HCItems.MAJORAS_MASK, HCItems.MIDNA_HELM, HCItems.PUMPKIN_MASK, HCItems.PHRYGIAN_CAP, HCItems.PHRYGIAN_CAP_SS, HCItems.PHRYGIAN_CAP_TP,
                        HCItems.PHRYGIAN_CAP_CLASSIC);
        getOrCreateTagBuilder(HCItemTags.ENDERMASK)
                .add(HCItems.MAJORAS_MASK, HCItems.PUMPKIN_MASK);
        getOrCreateTagBuilder(ItemTags.DYEABLE)
                .add(HCItems.PHRYGIAN_CAP);
        getOrCreateTagBuilder(ItemTags.PIG_FOOD)
                .add(HCItems.BANANA);
        getOrCreateTagBuilder(HCItemTags.MILK_BUCKETS)
                .add(HCItems.GOAT_MILK_BUCKET, Items.MILK_BUCKET);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(HCItems.GODDESS_SWORD, HCItems.GODDESS_LONGSWORD, HCItems.GODDESS_WHITE_SWORD, HCItems.MASTER_SWORD, HCItems.TRUE_MASTER_SWORD,
                        HCItems.DOUBLE_HELIX_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(HCItems.GODDESS_SWORD, HCItems.GODDESS_LONGSWORD, HCItems.GODDESS_WHITE_SWORD, HCItems.MASTER_SWORD, HCItems.TRUE_MASTER_SWORD,
                        HCItems.VICIOUS_SICKLE, HCItems.DOUBLE_HELIX_SWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(HCItems.GODDESS_SWORD, HCItems.GODDESS_LONGSWORD, HCItems.GODDESS_WHITE_SWORD,
                        HCItems.MASTER_SWORD, HCItems.TRUE_MASTER_SWORD, HCItems.IRON_BOW, HCItems.FAIRY_BOW, HCItems.DIGGING_MITT, HCItems.MOGMA_MITT,
                        HCItems.BOULDER_BREAKER, HCItems.VICIOUS_SICKLE, HCItems.DOUBLE_HELIX_SWORD);
        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(HCItems.ONE_HIT_OBLITERATOR);

        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(HCItems.IRON_BOW, HCItems.FAIRY_BOW);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(HCItems.DIGGING_MITT, HCItems.MOGMA_MITT);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(HCItems.DIGGING_MITT, HCItems.MOGMA_MITT);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(HCItems.DIGGING_MITT, HCItems.MOGMA_MITT, HCItems.BOULDER_BREAKER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(HCItems.MOGMA_MITT, HCItems.BOULDER_BREAKER);
        getOrCreateTagBuilder(ItemTags.MACE_ENCHANTABLE)
                .add(HCItems.BOULDER_BREAKER);
        getOrCreateTagBuilder(HCItemTags.SICKLES)
                .add(HCItems.VICIOUS_SICKLE);
        getOrCreateTagBuilder(HCItemTags.SHORT_WEAPON)
                .add(HCItems.GODDESS_SWORD).add(HCItems.VICIOUS_SICKLE);



        // Vanilla

        getOrCreateTagBuilder(HCItemTags.ENDERMASK).add(Items.CARVED_PUMPKIN);
        getOrCreateTagBuilder(HCItemTags.SLINGSHOT_AMMO).add(Items.COBBLESTONE).add(Items.STONE);

        // Blocks

        getOrCreateTagBuilder(HCItemTags.SHINGLES).add(Item.fromBlock(HCBlocks.WHITE_SHINGLES), Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLES),
                Item.fromBlock(HCBlocks.GRAY_SHINGLES), Item.fromBlock(HCBlocks.BLACK_SHINGLES), Item.fromBlock(HCBlocks.BROWN_SHINGLES),
                Item.fromBlock(HCBlocks.RED_SHINGLES), Item.fromBlock(HCBlocks.ORANGE_SHINGLES), Item.fromBlock(HCBlocks.YELLOW_SHINGLES),
                Item.fromBlock(HCBlocks.LIME_SHINGLES), Item.fromBlock(HCBlocks.GREEN_SHINGLES), Item.fromBlock(HCBlocks.CYAN_SHINGLES),
                Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLES), Item.fromBlock(HCBlocks.BLUE_SHINGLES), Item.fromBlock(HCBlocks.PURPLE_SHINGLES),
                Item.fromBlock(HCBlocks.MAGENTA_SHINGLES), Item.fromBlock(HCBlocks.PINK_SHINGLES));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_STAIRS).add(Item.fromBlock(HCBlocks.WHITE_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS),
                Item.fromBlock(HCBlocks.GRAY_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.BLACK_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.BROWN_SHINGLE_STAIRS),
                Item.fromBlock(HCBlocks.RED_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.ORANGE_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.YELLOW_SHINGLE_STAIRS),
                Item.fromBlock(HCBlocks.LIME_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.GREEN_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.CYAN_SHINGLE_STAIRS),
                Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.BLUE_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.PURPLE_SHINGLE_STAIRS),
                Item.fromBlock(HCBlocks.MAGENTA_SHINGLE_STAIRS), Item.fromBlock(HCBlocks.PINK_SHINGLE_STAIRS));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_SLABS).add(Item.fromBlock(HCBlocks.WHITE_SHINGLE_SLAB), Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB),
                Item.fromBlock(HCBlocks.GRAY_SHINGLE_SLAB), Item.fromBlock(HCBlocks.BLACK_SHINGLE_SLAB), Item.fromBlock(HCBlocks.BROWN_SHINGLE_SLAB),
                Item.fromBlock(HCBlocks.RED_SHINGLE_SLAB), Item.fromBlock(HCBlocks.ORANGE_SHINGLE_SLAB), Item.fromBlock(HCBlocks.YELLOW_SHINGLE_SLAB),
                Item.fromBlock(HCBlocks.LIME_SHINGLE_SLAB), Item.fromBlock(HCBlocks.GREEN_SHINGLE_SLAB), Item.fromBlock(HCBlocks.CYAN_SHINGLE_SLAB),
                Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB), Item.fromBlock(HCBlocks.BLUE_SHINGLE_SLAB), Item.fromBlock(HCBlocks.PURPLE_SHINGLE_SLAB),
                Item.fromBlock(HCBlocks.MAGENTA_SHINGLE_SLAB), Item.fromBlock(HCBlocks.PINK_SHINGLE_SLAB));
        getOrCreateTagBuilder(HCItemTags.SHINGLE_WALLS).add(Item.fromBlock(HCBlocks.WHITE_SHINGLE_WALL), Item.fromBlock(HCBlocks.LIGHT_GRAY_SHINGLE_WALL),
                Item.fromBlock(HCBlocks.GRAY_SHINGLE_WALL), Item.fromBlock(HCBlocks.BLACK_SHINGLE_WALL), Item.fromBlock(HCBlocks.BROWN_SHINGLE_WALL),
                Item.fromBlock(HCBlocks.RED_SHINGLE_WALL), Item.fromBlock(HCBlocks.ORANGE_SHINGLE_WALL), Item.fromBlock(HCBlocks.YELLOW_SHINGLE_WALL),
                Item.fromBlock(HCBlocks.LIME_SHINGLE_WALL), Item.fromBlock(HCBlocks.GREEN_SHINGLE_WALL), Item.fromBlock(HCBlocks.CYAN_SHINGLE_WALL),
                Item.fromBlock(HCBlocks.LIGHT_BLUE_SHINGLE_WALL), Item.fromBlock(HCBlocks.BLUE_SHINGLE_WALL), Item.fromBlock(HCBlocks.PURPLE_SHINGLE_WALL),
                Item.fromBlock(HCBlocks.MAGENTA_SHINGLE_WALL), Item.fromBlock(HCBlocks.PINK_SHINGLE_WALL));

        // Compat Stuffs

        getOrCreateTagBuilder(HCItemTags.GREEN_RUPEES).add(HCItems.GREEN_RUPEE).add(Items.EMERALD).addOptional(Identifier.of("hyrule_terrors","rupee"));
        getOrCreateTagBuilder(HCItemTags.BLUE_RUPEES).add(HCItems.BLUE_RUPEE);
        getOrCreateTagBuilder(HCItemTags.YELLOW_RUPEES).add(HCItems.YELLOW_RUPEE);
        getOrCreateTagBuilder(HCItemTags.RED_RUPEES).add(HCItems.RED_RUPEE);
        getOrCreateTagBuilder(HCItemTags.PURPLE_RUPEES).add(HCItems.PURPLE_RUPEE);
        getOrCreateTagBuilder(HCItemTags.ORANGE_RUPEES).add(HCItems.ORANGE_RUPEE);
        getOrCreateTagBuilder(HCItemTags.SILVER_RUPEES).add(HCItems.SILVER_RUPEE);
        getOrCreateTagBuilder(HCItemTags.GOLD_RUPEES).add(HCItems.GOLD_RUPEE);

        // Dye Stuffs

        getOrCreateTagBuilder(HCItemTags.WHITE_DYES).add(Item.fromBlock(HCBlocks.SILENT_PRINCESS));
        getOrCreateTagBuilder(HCItemTags.LIGHT_GRAY_DYES);
        getOrCreateTagBuilder(HCItemTags.GRAY_DYES);
        getOrCreateTagBuilder(HCItemTags.BLACK_DYES);
        getOrCreateTagBuilder(HCItemTags.BROWN_DYES);
        getOrCreateTagBuilder(HCItemTags.RED_DYES);
        getOrCreateTagBuilder(HCItemTags.ORANGE_DYES);
        getOrCreateTagBuilder(HCItemTags.YELLOW_DYES);
        getOrCreateTagBuilder(HCItemTags.LIME_DYES);
        getOrCreateTagBuilder(HCItemTags.GREEN_DYES);
        getOrCreateTagBuilder(HCItemTags.CYAN_DYES);
        getOrCreateTagBuilder(HCItemTags.LIGHT_BLUE_DYES);
        getOrCreateTagBuilder(HCItemTags.BLUE_DYES).add(Item.fromBlock(HCBlocks.BLUE_NIGHTSHADE));
        getOrCreateTagBuilder(HCItemTags.PURPLE_DYES).add(Item.fromBlock(HCBlocks.SWIFT_VIOLETS));
        getOrCreateTagBuilder(HCItemTags.MAGENTA_DYES).add(Item.fromBlock(HCBlocks.ANCIENT_FLOWER)).add(Item.fromBlock(HCBlocks.ARMORANTH));
        getOrCreateTagBuilder(HCItemTags.PINK_DYES);

        getOrCreateTagBuilder(HCItemTags.DOUBLE_WHITE_DYES).add(Item.fromBlock(HCBlocks.TOWN_FLOWER));
        getOrCreateTagBuilder(HCItemTags.DOUBLE_LIGHT_GRAY_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_GRAY_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_BLACK_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_BROWN_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_RED_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_ORANGE_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_YELLOW_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_LIME_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_GREEN_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_CYAN_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_LIGHT_BLUE_DYES).add(Item.fromBlock(HCBlocks.SEA_FLOWER));
        getOrCreateTagBuilder(HCItemTags.DOUBLE_BLUE_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_PURPLE_DYES);
        getOrCreateTagBuilder(HCItemTags.DOUBLE_MAGENTA_DYES).add(Item.fromBlock(HCBlocks.EXOTIC_FLOWER));
        getOrCreateTagBuilder(HCItemTags.DOUBLE_PINK_DYES);
    }

}