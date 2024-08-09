package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.HCColouredBlocks;
import net.nieadni.hyliacraft.item.HCItems;

public class HCModelProvider extends FabricModelProvider {

    public HCModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(HCItems.MAJORAS_MASK, Models.GENERATED);
        itemModelGenerator.register(HCItems.PUMPKIN_MASK, Models.GENERATED);

        itemModelGenerator.register(HCItems.GODDESS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GODDESS_LONGSWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GODDESS_WHITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.MASTER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.TRUE_MASTER_SWORD, Models.HANDHELD);

        itemModelGenerator.register(HCItems.SLINGSHOT, Models.HANDHELD);
        itemModelGenerator.register(HCItems.BOOMERANG, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GALE_BOOMERANG, Models.HANDHELD);

        itemModelGenerator.register(HCItems.PUMPKIN_SOUP, Models.GENERATED);

        itemModelGenerator.register(HCItems.RUPEE_POUCH, Models.GENERATED);
        itemModelGenerator.register(HCItems.GREEN_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.BLUE_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.YELLOW_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.RED_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.PURPLE_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.ORANGE_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.SILVER_RUPEE, Models.GENERATED);
        itemModelGenerator.register(HCItems.GOLD_RUPEE, Models.GENERATED);

    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.ARMORANTH, HCBlocks.ARMORANTH_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.BLUE_NIGHTSHADE, HCBlocks.BLUE_NIGHTSHADE_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.SILENT_PRINCESS, HCBlocks.SILENT_PRINCESS_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.SWIFT_VIOLETS, HCBlocks.SWIFT_VIOLETS_POT, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool whiteBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.WHITE_BRICKS);
        whiteBrickBlockPool.stairs(HCColouredBlocks.WHITE_BRICK_STAIRS);
        whiteBrickBlockPool.slab(HCColouredBlocks.WHITE_BRICK_SLAB);
        whiteBrickBlockPool.wall(HCColouredBlocks.WHITE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool lightGreyBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_GREY_BRICKS);
        lightGreyBrickBlockPool.stairs(HCColouredBlocks.LIGHT_GREY_BRICK_STAIRS);
        lightGreyBrickBlockPool.slab(HCColouredBlocks.LIGHT_GREY_BRICK_SLAB);
        lightGreyBrickBlockPool.wall(HCColouredBlocks.LIGHT_GREY_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool greyBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREY_BRICKS);
        greyBrickBlockPool.stairs(HCColouredBlocks.GREY_BRICK_STAIRS);
        greyBrickBlockPool.slab(HCColouredBlocks.GREY_BRICK_SLAB);
        greyBrickBlockPool.wall(HCColouredBlocks.GREY_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool blackBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLACK_BRICKS);
        blackBrickBlockPool.stairs(HCColouredBlocks.BLACK_BRICK_STAIRS);
        blackBrickBlockPool.slab(HCColouredBlocks.BLACK_BRICK_SLAB);
        blackBrickBlockPool.wall(HCColouredBlocks.BLACK_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool brownBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BROWN_BRICKS);
        brownBrickBlockPool.stairs(HCColouredBlocks.BROWN_BRICK_STAIRS);
        brownBrickBlockPool.slab(HCColouredBlocks.BROWN_BRICK_SLAB);
        brownBrickBlockPool.wall(HCColouredBlocks.BROWN_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool redBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RED_BRICKS);
        redBrickBlockPool.stairs(HCColouredBlocks.RED_BRICK_STAIRS);
        redBrickBlockPool.slab(HCColouredBlocks.RED_BRICK_SLAB);
        redBrickBlockPool.wall(HCColouredBlocks.RED_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool orangeBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.ORANGE_BRICKS);
        orangeBrickBlockPool.stairs(HCColouredBlocks.ORANGE_BRICK_STAIRS);
        orangeBrickBlockPool.slab(HCColouredBlocks.ORANGE_BRICK_SLAB);
        orangeBrickBlockPool.wall(HCColouredBlocks.ORANGE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool yellowBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.YELLOW_BRICKS);
        yellowBrickBlockPool.stairs(HCColouredBlocks.YELLOW_BRICK_STAIRS);
        yellowBrickBlockPool.slab(HCColouredBlocks.YELLOW_BRICK_SLAB);
        yellowBrickBlockPool.wall(HCColouredBlocks.YELLOW_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool limeBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIME_BRICKS);
        limeBrickBlockPool.stairs(HCColouredBlocks.LIME_BRICK_STAIRS);
        limeBrickBlockPool.slab(HCColouredBlocks.LIME_BRICK_SLAB);
        limeBrickBlockPool.wall(HCColouredBlocks.LIME_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool greenBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREEN_BRICKS);
        greenBrickBlockPool.stairs(HCColouredBlocks.GREEN_BRICK_STAIRS);
        greenBrickBlockPool.slab(HCColouredBlocks.GREEN_BRICK_SLAB);
        greenBrickBlockPool.wall(HCColouredBlocks.GREEN_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool cyanBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.CYAN_BRICKS);
        cyanBrickBlockPool.stairs(HCColouredBlocks.CYAN_BRICK_STAIRS);
        cyanBrickBlockPool.slab(HCColouredBlocks.CYAN_BRICK_SLAB);
        cyanBrickBlockPool.wall(HCColouredBlocks.CYAN_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool lightBlueBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_BLUE_BRICKS);
        lightBlueBrickBlockPool.stairs(HCColouredBlocks.LIGHT_BLUE_BRICK_STAIRS);
        lightBlueBrickBlockPool.slab(HCColouredBlocks.LIGHT_BLUE_BRICK_SLAB);
        lightBlueBrickBlockPool.wall(HCColouredBlocks.LIGHT_BLUE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool blueBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLUE_BRICKS);
        blueBrickBlockPool.stairs(HCColouredBlocks.BLUE_BRICK_STAIRS);
        blueBrickBlockPool.slab(HCColouredBlocks.BLUE_BRICK_SLAB);
        blueBrickBlockPool.wall(HCColouredBlocks.BLUE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool purpleBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PURPLE_BRICKS);
        purpleBrickBlockPool.stairs(HCColouredBlocks.PURPLE_BRICK_STAIRS);
        purpleBrickBlockPool.slab(HCColouredBlocks.PURPLE_BRICK_SLAB);
        purpleBrickBlockPool.wall(HCColouredBlocks.PURPLE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool magentaBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.MAGENTA_BRICKS);
        magentaBrickBlockPool.stairs(HCColouredBlocks.MAGENTA_BRICK_STAIRS);
        magentaBrickBlockPool.slab(HCColouredBlocks.MAGENTA_BRICK_SLAB);
        magentaBrickBlockPool.wall(HCColouredBlocks.MAGENTA_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool pinkBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PINK_BRICKS);
        pinkBrickBlockPool.stairs(HCColouredBlocks.PINK_BRICK_STAIRS);
        pinkBrickBlockPool.slab(HCColouredBlocks.PINK_BRICK_SLAB);
        pinkBrickBlockPool.wall(HCColouredBlocks.PINK_BRICK_WALL);

    }
}
