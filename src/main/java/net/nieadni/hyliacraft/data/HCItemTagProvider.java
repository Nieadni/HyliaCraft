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
                .add(HCItems.MAJORAS_MASK, HCItems.MIDNA_HELM, HCItems.PUMPKIN_MASK, HCItems.FIERCE_CAP, HCItems.HERO_CAP, 
                        HCItems.SKY_CAP, HCItems.TIME_CAP, HCItems.TWILIGHT_CAP, HCItems.WILD_CAP, HCItems.WIND_CAP);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(HCItems.MAJORAS_MASK, HCItems.MIDNA_HELM, HCItems.PUMPKIN_MASK, HCItems.FIERCE_CAP, HCItems.HERO_CAP,
                        HCItems.SKY_CAP, HCItems.TIME_CAP, HCItems.TWILIGHT_CAP, HCItems.WILD_CAP, HCItems.WIND_CAP);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(HCItems.FIERCE_TUNIC, HCItems.HERO_TUNIC, HCItems.SKY_TUNIC, HCItems.TIME_TUNIC, HCItems.TWILIGHT_TUNIC, 
                        HCItems.WILD_TUNIC, HCItems.WIND_TUNIC);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(HCItems.FIERCE_TUNIC, HCItems.HERO_TUNIC, HCItems.SKY_TUNIC, HCItems.TIME_TUNIC, HCItems.TWILIGHT_TUNIC, 
                        HCItems.WILD_TUNIC, HCItems.WIND_TUNIC);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(HCItems.FIERCE_TROUSERS, HCItems.HERO_TROUSERS, HCItems.SKY_TROUSERS, HCItems.TIME_TROUSERS, HCItems.TWILIGHT_TROUSERS, 
                        HCItems.WILD_TROUSERS, HCItems.WIND_TROUSERS);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(HCItems.FIERCE_TROUSERS, HCItems.HERO_TROUSERS, HCItems.SKY_TROUSERS, HCItems.TIME_TROUSERS, HCItems.TWILIGHT_TROUSERS, 
                        HCItems.WILD_TROUSERS, HCItems.WIND_TROUSERS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(HCItems.FIERCE_BOOTS, HCItems.HERO_BOOTS, HCItems.SKY_BOOTS, HCItems.TIME_BOOTS, HCItems.TWILIGHT_BOOTS, 
                        HCItems.WILD_BOOTS, HCItems.WIND_BOOTS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(HCItems.FIERCE_BOOTS, HCItems.HERO_BOOTS, HCItems.SKY_BOOTS, HCItems.TIME_BOOTS, HCItems.TWILIGHT_BOOTS,
                        HCItems.WILD_BOOTS, HCItems.WIND_BOOTS);

        getOrCreateTagBuilder(HCItemTags.ENDERMASK)
                .add(HCItems.MAJORAS_MASK, HCItems.PUMPKIN_MASK);

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
                        HCItems.BOULDER_BREAKER, HCItems.VICIOUS_SICKLE, HCItems.DOUBLE_HELIX_SWORD, HCItems.TWILIGHT_CAP);

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

        getOrCreateTagBuilder(HCItemTags.GREEN_RUPEES).add(HCItems.GREEN_RUPEE).addOptional(Identifier.of("hyrule_terrors","rupee"));
        getOrCreateTagBuilder(HCItemTags.BLUE_RUPEES).add(HCItems.BLUE_RUPEE);
        getOrCreateTagBuilder(HCItemTags.YELLOW_RUPEES).add(HCItems.YELLOW_RUPEE);
        getOrCreateTagBuilder(HCItemTags.RED_RUPEES).add(HCItems.RED_RUPEE);
        getOrCreateTagBuilder(HCItemTags.PURPLE_RUPEES).add(HCItems.PURPLE_RUPEE);
        getOrCreateTagBuilder(HCItemTags.ORANGE_RUPEES).add(HCItems.ORANGE_RUPEE);
        getOrCreateTagBuilder(HCItemTags.SILVER_RUPEES).add(HCItems.SILVER_RUPEE);
        getOrCreateTagBuilder(HCItemTags.GOLD_RUPEES).add(HCItems.GOLD_RUPEE);
    }
}