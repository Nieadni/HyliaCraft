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

        blockStateModelGenerator.registerLog(HCColouredBlocks.WHITE_STRIPPED_LOG).log(HCColouredBlocks.WHITE_STRIPPED_LOG).wood(HCColouredBlocks.WHITE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool whitePlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.WHITE_PLANKS);
        whitePlankBlockPool.stairs(HCColouredBlocks.WHITE_STAIRS);
        whitePlankBlockPool.slab(HCColouredBlocks.WHITE_SLAB);
        whitePlankBlockPool.fence(HCColouredBlocks.WHITE_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG).log(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG).wood(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool lightGreyPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_GREY_PLANKS);
        lightGreyPlankBlockPool.stairs(HCColouredBlocks.LIGHT_GREY_STAIRS);
        lightGreyPlankBlockPool.slab(HCColouredBlocks.LIGHT_GREY_SLAB);
        lightGreyPlankBlockPool.fence(HCColouredBlocks.LIGHT_GREY_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.GREY_STRIPPED_LOG).log(HCColouredBlocks.GREY_STRIPPED_LOG).wood(HCColouredBlocks.GREY_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool greyPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREY_PLANKS);
        greyPlankBlockPool.stairs(HCColouredBlocks.GREY_STAIRS);
        greyPlankBlockPool.slab(HCColouredBlocks.GREY_SLAB);
        greyPlankBlockPool.fence(HCColouredBlocks.GREY_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.BLACK_STRIPPED_LOG).log(HCColouredBlocks.BLACK_STRIPPED_LOG).wood(HCColouredBlocks.BLACK_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool blackPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLACK_PLANKS);
        blackPlankBlockPool.stairs(HCColouredBlocks.BLACK_STAIRS);
        blackPlankBlockPool.slab(HCColouredBlocks.BLACK_SLAB);
        blackPlankBlockPool.fence(HCColouredBlocks.BLACK_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.BROWN_STRIPPED_LOG).log(HCColouredBlocks.BROWN_STRIPPED_LOG).wood(HCColouredBlocks.BROWN_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool brownPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BROWN_PLANKS);
        brownPlankBlockPool.stairs(HCColouredBlocks.BROWN_STAIRS);
        brownPlankBlockPool.slab(HCColouredBlocks.BROWN_SLAB);
        brownPlankBlockPool.fence(HCColouredBlocks.BROWN_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.RED_STRIPPED_LOG).log(HCColouredBlocks.RED_STRIPPED_LOG).wood(HCColouredBlocks.RED_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool redPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RED_PLANKS);
        redPlankBlockPool.stairs(HCColouredBlocks.RED_STAIRS);
        redPlankBlockPool.slab(HCColouredBlocks.RED_SLAB);
        redPlankBlockPool.fence(HCColouredBlocks.RED_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.ORANGE_STRIPPED_LOG).log(HCColouredBlocks.ORANGE_STRIPPED_LOG).wood(HCColouredBlocks.ORANGE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool orangePlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.ORANGE_PLANKS);
        orangePlankBlockPool.stairs(HCColouredBlocks.ORANGE_STAIRS);
        orangePlankBlockPool.slab(HCColouredBlocks.ORANGE_SLAB);
        orangePlankBlockPool.fence(HCColouredBlocks.ORANGE_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.YELLOW_STRIPPED_LOG).log(HCColouredBlocks.YELLOW_STRIPPED_LOG).wood(HCColouredBlocks.YELLOW_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool yellowPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.YELLOW_PLANKS);
        yellowPlankBlockPool.stairs(HCColouredBlocks.YELLOW_STAIRS);
        yellowPlankBlockPool.slab(HCColouredBlocks.YELLOW_SLAB);
        yellowPlankBlockPool.fence(HCColouredBlocks.YELLOW_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.LIME_STRIPPED_LOG).log(HCColouredBlocks.LIME_STRIPPED_LOG).wood(HCColouredBlocks.LIME_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool limePlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIME_PLANKS);
        limePlankBlockPool.stairs(HCColouredBlocks.LIME_STAIRS);
        limePlankBlockPool.slab(HCColouredBlocks.LIME_SLAB);
        limePlankBlockPool.fence(HCColouredBlocks.LIME_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.GREEN_STRIPPED_LOG).log(HCColouredBlocks.GREEN_STRIPPED_LOG).wood(HCColouredBlocks.GREEN_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool greenPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREEN_PLANKS);
        greenPlankBlockPool.stairs(HCColouredBlocks.GREEN_STAIRS);
        greenPlankBlockPool.slab(HCColouredBlocks.GREEN_SLAB);
        greenPlankBlockPool.fence(HCColouredBlocks.GREEN_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.CYAN_STRIPPED_LOG).log(HCColouredBlocks.CYAN_STRIPPED_LOG).wood(HCColouredBlocks.CYAN_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool cyanPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.CYAN_PLANKS);
        cyanPlankBlockPool.stairs(HCColouredBlocks.CYAN_STAIRS);
        cyanPlankBlockPool.slab(HCColouredBlocks.CYAN_SLAB);
        cyanPlankBlockPool.fence(HCColouredBlocks.CYAN_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG).log(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG).wood(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool lightBluePlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_BLUE_PLANKS);
        lightBluePlankBlockPool.stairs(HCColouredBlocks.LIGHT_BLUE_STAIRS);
        lightBluePlankBlockPool.slab(HCColouredBlocks.LIGHT_BLUE_SLAB);
        lightBluePlankBlockPool.fence(HCColouredBlocks.LIGHT_BLUE_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.BLUE_STRIPPED_LOG).log(HCColouredBlocks.BLUE_STRIPPED_LOG).wood(HCColouredBlocks.BLUE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool bluePlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLUE_PLANKS);
        bluePlankBlockPool.stairs(HCColouredBlocks.BLUE_STAIRS);
        bluePlankBlockPool.slab(HCColouredBlocks.BLUE_SLAB);
        bluePlankBlockPool.fence(HCColouredBlocks.BLUE_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.PURPLE_STRIPPED_LOG).log(HCColouredBlocks.PURPLE_STRIPPED_LOG).wood(HCColouredBlocks.PURPLE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool purplePlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PURPLE_PLANKS);
        purplePlankBlockPool.stairs(HCColouredBlocks.PURPLE_STAIRS);
        purplePlankBlockPool.slab(HCColouredBlocks.PURPLE_SLAB);
        purplePlankBlockPool.fence(HCColouredBlocks.PURPLE_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.MAGENTA_STRIPPED_LOG).log(HCColouredBlocks.MAGENTA_STRIPPED_LOG).wood(HCColouredBlocks.MAGENTA_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool magentaPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.MAGENTA_PLANKS);
        magentaPlankBlockPool.stairs(HCColouredBlocks.MAGENTA_STAIRS);
        magentaPlankBlockPool.slab(HCColouredBlocks.MAGENTA_SLAB);
        magentaPlankBlockPool.fence(HCColouredBlocks.MAGENTA_FENCE);
        blockStateModelGenerator.registerLog(HCColouredBlocks.PINK_STRIPPED_LOG).log(HCColouredBlocks.PINK_STRIPPED_LOG).wood(HCColouredBlocks.PINK_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool pinkPlankBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PINK_PLANKS);
        pinkPlankBlockPool.stairs(HCColouredBlocks.PINK_STAIRS);
        pinkPlankBlockPool.slab(HCColouredBlocks.PINK_SLAB);
        pinkPlankBlockPool.fence(HCColouredBlocks.PINK_FENCE);

    }
}
