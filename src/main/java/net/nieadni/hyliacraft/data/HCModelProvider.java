package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.item.HCItems;

public class HCModelProvider extends FabricModelProvider {

    public HCModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // Equipment
        itemModelGenerator.register(HCItems.MAJORAS_MASK, Models.GENERATED);
        itemModelGenerator.register(HCItems.MIDNA_HELM, Models.GENERATED);
        itemModelGenerator.register(HCItems.PUMPKIN_MASK, Models.GENERATED);
        itemModelGenerator.register(HCItems.PHRYGIAN_CAP_SS, Models.GENERATED);
        itemModelGenerator.register(HCItems.PHRYGIAN_CAP_TP, Models.GENERATED);
        itemModelGenerator.register(HCItems.PHRYGIAN_CAP_CLASSIC, Models.GENERATED);
        itemModelGenerator.register(HCItems.BUNNY_HOOD, Models.GENERATED);
        itemModelGenerator.register(HCItems.FIRESHIELD_EARRING, Models.GENERATED);
        itemModelGenerator.register(HCItems.WATER_DRAGON_SCALE, Models.GENERATED);
        itemModelGenerator.register(HCItems.SHADOW_CRYSTAL, Models.GENERATED);

        // Ranged Weapons
        itemModelGenerator.register(HCItems.SLINGSHOT, Models.HANDHELD);
        itemModelGenerator.register(HCItems.BOOMERANG, Models.HANDHELD);
        //itemModelGenerator.register(HCItems.GALE_BOOMERANG, Models.HANDHELD);

        // Melee Weapons
        itemModelGenerator.register(HCItems.GODDESS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GODDESS_LONGSWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GODDESS_WHITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.MASTER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.TRUE_MASTER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.ONE_HIT_OBLITERATOR, Models.HANDHELD);

        // Tools
        itemModelGenerator.register(HCItems.VICIOUS_SICKLE, Models.HANDHELD);

        // Misc Gear
        itemModelGenerator.register(HCItems.HORSE_CALL, Models.HANDHELD);

        // Consumables
        itemModelGenerator.register(HCItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(HCItems.PUMPKIN_SOUP, Models.GENERATED);
        itemModelGenerator.register(HCItems.GOAT_MILK_BUCKET, Models.GENERATED);
        itemModelGenerator.register(HCItems.GOAT_CHEESE, Models.GENERATED);
        itemModelGenerator.register(HCItems.SIMPLE_SOUP, Models.GENERATED);
        itemModelGenerator.register(HCItems.GOOD_SOUP, Models.GENERATED);
        itemModelGenerator.register(HCItems.SUPERB_SOUP, Models.GENERATED);
        itemModelGenerator.register(HCItems.DUBIOUS_FOOD, Models.GENERATED);

        // Rupees
        itemModelGenerator.register(HCItems.RUPEE_POUCH, Models.GENERATED);
        itemModelGenerator.register(HCItems.GREEN_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.BLUE_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.YELLOW_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.RED_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.PURPLE_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.ORANGE_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.SILVER_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.GOLD_RUPEE, Models.GENERATED);

        // Misc
        itemModelGenerator.register(HCItems.NAYRU_FLAME, Models.GENERATED);
        itemModelGenerator.register(HCItems.DIN_FLAME, Models.GENERATED);
        itemModelGenerator.register(HCItems.FARORE_FLAME, Models.GENERATED);

        itemModelGenerator.register(HCItems.GORON_SPICE, Models.GENERATED);
        //itemModelGenerator.register(HCItems.FAIRY_BOTTLE, Models.GENERATED);


    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.ARMORANTH, HCBlocks.ARMORANTH_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.BLUE_NIGHTSHADE, HCBlocks.BLUE_NIGHTSHADE_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.SILENT_PRINCESS, HCBlocks.SILENT_PRINCESS_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.SWIFT_VIOLETS, HCBlocks.SWIFT_VIOLETS_POT, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerBuiltin(Identifier.of(HyliaCraft.MOD_ID, "block/iron_chest"), Blocks.OAK_PLANKS).includeWithoutItem(Blocks.CHEST);

        //

        BlockStateModelGenerator.BlockTexturePool whiteShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.WHITE_SHINGLES);
        whiteShingleBlockPool.stairs(HCBlocks.WHITE_SHINGLE_STAIRS);
        whiteShingleBlockPool.slab(HCBlocks.WHITE_SHINGLE_SLAB);
        whiteShingleBlockPool.wall(HCBlocks.WHITE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool lightGrayShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.LIGHT_GRAY_SHINGLES);
        lightGrayShingleBlockPool.stairs(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS);
        lightGrayShingleBlockPool.slab(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB);
        lightGrayShingleBlockPool.wall(HCBlocks.LIGHT_GRAY_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool grayShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.GRAY_SHINGLES);
        grayShingleBlockPool.stairs(HCBlocks.GRAY_SHINGLE_STAIRS);
        grayShingleBlockPool.slab(HCBlocks.GRAY_SHINGLE_SLAB);
        grayShingleBlockPool.wall(HCBlocks.GRAY_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool blackShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.BLACK_SHINGLES);
        blackShingleBlockPool.stairs(HCBlocks.BLACK_SHINGLE_STAIRS);
        blackShingleBlockPool.slab(HCBlocks.BLACK_SHINGLE_SLAB);
        blackShingleBlockPool.wall(HCBlocks.BLACK_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool brownShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.BROWN_SHINGLES);
        brownShingleBlockPool.stairs(HCBlocks.BROWN_SHINGLE_STAIRS);
        brownShingleBlockPool.slab(HCBlocks.BROWN_SHINGLE_SLAB);
        brownShingleBlockPool.wall(HCBlocks.BROWN_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool redShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.RED_SHINGLES);
        redShingleBlockPool.stairs(HCBlocks.RED_SHINGLE_STAIRS);
        redShingleBlockPool.slab(HCBlocks.RED_SHINGLE_SLAB);
        redShingleBlockPool.wall(HCBlocks.RED_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool orangeShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.ORANGE_SHINGLES);
        orangeShingleBlockPool.stairs(HCBlocks.ORANGE_SHINGLE_STAIRS);
        orangeShingleBlockPool.slab(HCBlocks.ORANGE_SHINGLE_SLAB);
        orangeShingleBlockPool.wall(HCBlocks.ORANGE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool yellowShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.YELLOW_SHINGLES);
        yellowShingleBlockPool.stairs(HCBlocks.YELLOW_SHINGLE_STAIRS);
        yellowShingleBlockPool.slab(HCBlocks.YELLOW_SHINGLE_SLAB);
        yellowShingleBlockPool.wall(HCBlocks.YELLOW_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool limeShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.LIME_SHINGLES);
        limeShingleBlockPool.stairs(HCBlocks.LIME_SHINGLE_STAIRS);
        limeShingleBlockPool.slab(HCBlocks.LIME_SHINGLE_SLAB);
        limeShingleBlockPool.wall(HCBlocks.LIME_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool greenShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.GREEN_SHINGLES);
        greenShingleBlockPool.stairs(HCBlocks.GREEN_SHINGLE_STAIRS);
        greenShingleBlockPool.slab(HCBlocks.GREEN_SHINGLE_SLAB);
        greenShingleBlockPool.wall(HCBlocks.GREEN_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool cyanShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.CYAN_SHINGLES);
        cyanShingleBlockPool.stairs(HCBlocks.CYAN_SHINGLE_STAIRS);
        cyanShingleBlockPool.slab(HCBlocks.CYAN_SHINGLE_SLAB);
        cyanShingleBlockPool.wall(HCBlocks.CYAN_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool lightBlueShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.LIGHT_BLUE_SHINGLES);
        lightBlueShingleBlockPool.stairs(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS);
        lightBlueShingleBlockPool.slab(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB);
        lightBlueShingleBlockPool.wall(HCBlocks.LIGHT_BLUE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool blueShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.BLUE_SHINGLES);
        blueShingleBlockPool.stairs(HCBlocks.BLUE_SHINGLE_STAIRS);
        blueShingleBlockPool.slab(HCBlocks.BLUE_SHINGLE_SLAB);
        blueShingleBlockPool.wall(HCBlocks.BLUE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool purpleShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.PURPLE_SHINGLES);
        purpleShingleBlockPool.stairs(HCBlocks.PURPLE_SHINGLE_STAIRS);
        purpleShingleBlockPool.slab(HCBlocks.PURPLE_SHINGLE_SLAB);
        purpleShingleBlockPool.wall(HCBlocks.PURPLE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool magentaShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.MAGENTA_SHINGLES);
        magentaShingleBlockPool.stairs(HCBlocks.MAGENTA_SHINGLE_STAIRS);
        magentaShingleBlockPool.slab(HCBlocks.MAGENTA_SHINGLE_SLAB);
        magentaShingleBlockPool.wall(HCBlocks.MAGENTA_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool pinkShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCBlocks.PINK_SHINGLES);
        pinkShingleBlockPool.stairs(HCBlocks.PINK_SHINGLE_STAIRS);
        pinkShingleBlockPool.slab(HCBlocks.PINK_SHINGLE_SLAB);
        pinkShingleBlockPool.wall(HCBlocks.PINK_SHINGLE_WALL);

    }

}
