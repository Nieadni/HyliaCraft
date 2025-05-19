package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
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

        // Equipment
        itemModelGenerator.register(HCItems.MAJORAS_MASK, Models.GENERATED);
        itemModelGenerator.register(HCItems.PUMPKIN_MASK, Models.GENERATED);
        itemModelGenerator.register(HCItems.PHRYGIAN_CAP_SS, Models.GENERATED);
        itemModelGenerator.register(HCItems.PHRYGIAN_CAP_TP, Models.GENERATED);
        itemModelGenerator.register(HCItems.PHRYGIAN_CAP_CLASSIC, Models.GENERATED);
        itemModelGenerator.register(HCItems.FIRESHIELD_EARRING, Models.GENERATED);
        itemModelGenerator.register(HCItems.WATER_DRAGON_SCALE, Models.GENERATED);
        itemModelGenerator.register(HCItems.SHADOW_CRYSTAL, Models.GENERATED);

        // Ranged Weapons
        itemModelGenerator.register(HCItems.SLINGSHOT, Models.HANDHELD);
        itemModelGenerator.register(HCItems.BOOMERANG, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GALE_BOOMERANG, Models.HANDHELD);

        // Melee Weapons
        itemModelGenerator.register(HCItems.GODDESS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GODDESS_LONGSWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.GODDESS_WHITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.MASTER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(HCItems.TRUE_MASTER_SWORD, Models.HANDHELD);

        // Tools
        //HYAH!

        // Misc Gear
        itemModelGenerator.register(HCItems.HORSE_CALL, Models.HANDHELD);

        // Consumables
        itemModelGenerator.register(HCItems.PUMPKIN_SOUP, Models.GENERATED);

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

    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.ARMORANTH, HCBlocks.ARMORANTH_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.BLUE_NIGHTSHADE, HCBlocks.BLUE_NIGHTSHADE_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.SILENT_PRINCESS, HCBlocks.SILENT_PRINCESS_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(HCBlocks.SWIFT_VIOLETS, HCBlocks.SWIFT_VIOLETS_POT, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerBuiltin(Identifier.of(HyliaCraft.MOD_ID, "block/iron_chest"), Blocks.OAK_PLANKS).includeWithoutItem(Blocks.CHEST);

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
        BlockStateModelGenerator.BlockTexturePool rainbowBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RAINBOW_BRICKS);
        rainbowBrickBlockPool.stairs(HCColouredBlocks.RAINBOW_BRICK_STAIRS);
        rainbowBrickBlockPool.slab(HCColouredBlocks.RAINBOW_BRICK_SLAB);
        rainbowBrickBlockPool.wall(HCColouredBlocks.RAINBOW_BRICK_WALL);
        blockStateModelGenerator.registerLog(HCColouredBlocks.WHITE_STRIPPED_LOG)
                .log(HCColouredBlocks.WHITE_STRIPPED_LOG)
                .wood(HCColouredBlocks.WHITE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool whitePlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.WHITE_PLANKS);
        whitePlankBlockPool.stairs(HCColouredBlocks.WHITE_STAIRS);
        whitePlankBlockPool.slab(HCColouredBlocks.WHITE_SLAB);
        whitePlankBlockPool.fence(HCColouredBlocks.WHITE_FENCE);
        whitePlankBlockPool.fenceGate(HCColouredBlocks.WHITE_FENCE_GATE);
        whitePlankBlockPool.pressurePlate(HCColouredBlocks.WHITE_PRESSURE_PLATE);
        whitePlankBlockPool.button(HCColouredBlocks.WHITE_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG)
                .log(HCColouredBlocks.LIGHT_GREY_STRIPPED_LOG)
                .wood(HCColouredBlocks.LIGHT_GREY_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool lightGreyPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_GREY_PLANKS);
        lightGreyPlankBlockPool.stairs(HCColouredBlocks.LIGHT_GREY_STAIRS);
        lightGreyPlankBlockPool.slab(HCColouredBlocks.LIGHT_GREY_SLAB);
        lightGreyPlankBlockPool.fence(HCColouredBlocks.LIGHT_GREY_FENCE);
        lightGreyPlankBlockPool.fenceGate(HCColouredBlocks.LIGHT_GREY_FENCE_GATE);
        lightGreyPlankBlockPool.pressurePlate(HCColouredBlocks.LIGHT_GREY_PRESSURE_PLATE);
        lightGreyPlankBlockPool.button(HCColouredBlocks.LIGHT_GREY_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.GREY_STRIPPED_LOG)
                .log(HCColouredBlocks.GREY_STRIPPED_LOG)
                .wood(HCColouredBlocks.GREY_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool greyPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREY_PLANKS);
        greyPlankBlockPool.stairs(HCColouredBlocks.GREY_STAIRS);
        greyPlankBlockPool.slab(HCColouredBlocks.GREY_SLAB);
        greyPlankBlockPool.fence(HCColouredBlocks.GREY_FENCE);
        greyPlankBlockPool.fenceGate(HCColouredBlocks.GREY_FENCE_GATE);
        greyPlankBlockPool.pressurePlate(HCColouredBlocks.GREY_PRESSURE_PLATE);
        greyPlankBlockPool.button(HCColouredBlocks.GREY_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.BLACK_STRIPPED_LOG)
                .log(HCColouredBlocks.BLACK_STRIPPED_LOG)
                .wood(HCColouredBlocks.BLACK_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool blackPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLACK_PLANKS);
        blackPlankBlockPool.stairs(HCColouredBlocks.BLACK_STAIRS);
        blackPlankBlockPool.slab(HCColouredBlocks.BLACK_SLAB);
        blackPlankBlockPool.fence(HCColouredBlocks.BLACK_FENCE);
        blackPlankBlockPool.fenceGate(HCColouredBlocks.BLACK_FENCE_GATE);
        blackPlankBlockPool.pressurePlate(HCColouredBlocks.BLACK_PRESSURE_PLATE);
        blackPlankBlockPool.button(HCColouredBlocks.BLACK_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.BROWN_STRIPPED_LOG)
                .log(HCColouredBlocks.BROWN_STRIPPED_LOG)
                .wood(HCColouredBlocks.BROWN_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool brownPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BROWN_PLANKS);
        brownPlankBlockPool.stairs(HCColouredBlocks.BROWN_STAIRS);
        brownPlankBlockPool.slab(HCColouredBlocks.BROWN_SLAB);
        brownPlankBlockPool.fence(HCColouredBlocks.BROWN_FENCE);
        brownPlankBlockPool.fenceGate(HCColouredBlocks.BROWN_FENCE_GATE);
        brownPlankBlockPool.pressurePlate(HCColouredBlocks.BROWN_PRESSURE_PLATE);
        brownPlankBlockPool.button(HCColouredBlocks.BROWN_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.RED_STRIPPED_LOG)
                .log(HCColouredBlocks.RED_STRIPPED_LOG)
                .wood(HCColouredBlocks.RED_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool redPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RED_PLANKS);
        redPlankBlockPool.stairs(HCColouredBlocks.RED_STAIRS);
        redPlankBlockPool.slab(HCColouredBlocks.RED_SLAB);
        redPlankBlockPool.fence(HCColouredBlocks.RED_FENCE);
        redPlankBlockPool.fenceGate(HCColouredBlocks.RED_FENCE_GATE);
        redPlankBlockPool.pressurePlate(HCColouredBlocks.RED_PRESSURE_PLATE);
        redPlankBlockPool.button(HCColouredBlocks.RED_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.ORANGE_STRIPPED_LOG)
                .log(HCColouredBlocks.ORANGE_STRIPPED_LOG)
                .wood(HCColouredBlocks.ORANGE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool orangePlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.ORANGE_PLANKS);
        orangePlankBlockPool.stairs(HCColouredBlocks.ORANGE_STAIRS);
        orangePlankBlockPool.slab(HCColouredBlocks.ORANGE_SLAB);
        orangePlankBlockPool.fence(HCColouredBlocks.ORANGE_FENCE);
        orangePlankBlockPool.fenceGate(HCColouredBlocks.ORANGE_FENCE_GATE);
        orangePlankBlockPool.pressurePlate(HCColouredBlocks.ORANGE_PRESSURE_PLATE);
        orangePlankBlockPool.button(HCColouredBlocks.ORANGE_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.YELLOW_STRIPPED_LOG)
                .log(HCColouredBlocks.YELLOW_STRIPPED_LOG)
                .wood(HCColouredBlocks.YELLOW_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool yellowPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.YELLOW_PLANKS);
        yellowPlankBlockPool.stairs(HCColouredBlocks.YELLOW_STAIRS);
        yellowPlankBlockPool.slab(HCColouredBlocks.YELLOW_SLAB);
        yellowPlankBlockPool.fence(HCColouredBlocks.YELLOW_FENCE);
        yellowPlankBlockPool.fenceGate(HCColouredBlocks.YELLOW_FENCE_GATE);
        yellowPlankBlockPool.pressurePlate(HCColouredBlocks.YELLOW_PRESSURE_PLATE);
        yellowPlankBlockPool.button(HCColouredBlocks.YELLOW_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.LIME_STRIPPED_LOG)
                .log(HCColouredBlocks.LIME_STRIPPED_LOG)
                .wood(HCColouredBlocks.LIME_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool limePlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIME_PLANKS);
        limePlankBlockPool.stairs(HCColouredBlocks.LIME_STAIRS);
        limePlankBlockPool.slab(HCColouredBlocks.LIME_SLAB);
        limePlankBlockPool.fence(HCColouredBlocks.LIME_FENCE);
        limePlankBlockPool.fenceGate(HCColouredBlocks.LIME_FENCE_GATE);
        limePlankBlockPool.pressurePlate(HCColouredBlocks.LIME_PRESSURE_PLATE);
        limePlankBlockPool.button(HCColouredBlocks.LIME_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.GREEN_STRIPPED_LOG)
                .log(HCColouredBlocks.GREEN_STRIPPED_LOG)
                .wood(HCColouredBlocks.GREEN_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool greenPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREEN_PLANKS);
        greenPlankBlockPool.stairs(HCColouredBlocks.GREEN_STAIRS);
        greenPlankBlockPool.slab(HCColouredBlocks.GREEN_SLAB);
        greenPlankBlockPool.fence(HCColouredBlocks.GREEN_FENCE);
        greenPlankBlockPool.fenceGate(HCColouredBlocks.GREEN_FENCE_GATE);
        greenPlankBlockPool.pressurePlate(HCColouredBlocks.GREEN_PRESSURE_PLATE);
        greenPlankBlockPool.button(HCColouredBlocks.GREEN_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.CYAN_STRIPPED_LOG)
                .log(HCColouredBlocks.CYAN_STRIPPED_LOG)
                .wood(HCColouredBlocks.CYAN_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool cyanPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.CYAN_PLANKS);
        cyanPlankBlockPool.stairs(HCColouredBlocks.CYAN_STAIRS);
        cyanPlankBlockPool.slab(HCColouredBlocks.CYAN_SLAB);
        cyanPlankBlockPool.fence(HCColouredBlocks.CYAN_FENCE);
        cyanPlankBlockPool.fenceGate(HCColouredBlocks.CYAN_FENCE_GATE);
        cyanPlankBlockPool.pressurePlate(HCColouredBlocks.CYAN_PRESSURE_PLATE);
        cyanPlankBlockPool.button(HCColouredBlocks.CYAN_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG)
                .log(HCColouredBlocks.LIGHT_BLUE_STRIPPED_LOG)
                .wood(HCColouredBlocks.LIGHT_BLUE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool lightBluePlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_BLUE_PLANKS);
        lightBluePlankBlockPool.stairs(HCColouredBlocks.LIGHT_BLUE_STAIRS);
        lightBluePlankBlockPool.slab(HCColouredBlocks.LIGHT_BLUE_SLAB);
        lightBluePlankBlockPool.fence(HCColouredBlocks.LIGHT_BLUE_FENCE);
        lightBluePlankBlockPool.fenceGate(HCColouredBlocks.LIGHT_BLUE_FENCE_GATE);
        lightBluePlankBlockPool.pressurePlate(HCColouredBlocks.LIGHT_BLUE_PRESSURE_PLATE);
        lightBluePlankBlockPool.button(HCColouredBlocks.LIGHT_BLUE_BUTTON);


        blockStateModelGenerator.registerLog(HCColouredBlocks.BLUE_STRIPPED_LOG)
                .log(HCColouredBlocks.BLUE_STRIPPED_LOG)
                .wood(HCColouredBlocks.BLUE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool bluePlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLUE_PLANKS);
        bluePlankBlockPool.stairs(HCColouredBlocks.BLUE_STAIRS);
        bluePlankBlockPool.slab(HCColouredBlocks.BLUE_SLAB);
        bluePlankBlockPool.fence(HCColouredBlocks.BLUE_FENCE);
        bluePlankBlockPool.fenceGate(HCColouredBlocks.BLUE_FENCE_GATE);
        bluePlankBlockPool.pressurePlate(HCColouredBlocks.BLUE_PRESSURE_PLATE);
        bluePlankBlockPool.button(HCColouredBlocks.BLUE_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.PURPLE_STRIPPED_LOG)
                .log(HCColouredBlocks.PURPLE_STRIPPED_LOG)
                .wood(HCColouredBlocks.PURPLE_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool purplePlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PURPLE_PLANKS);
        purplePlankBlockPool.stairs(HCColouredBlocks.PURPLE_STAIRS);
        purplePlankBlockPool.slab(HCColouredBlocks.PURPLE_SLAB);
        purplePlankBlockPool.fence(HCColouredBlocks.PURPLE_FENCE);
        purplePlankBlockPool.fenceGate(HCColouredBlocks.PURPLE_FENCE_GATE);
        purplePlankBlockPool.pressurePlate(HCColouredBlocks.PURPLE_PRESSURE_PLATE);
        purplePlankBlockPool.button(HCColouredBlocks.PURPLE_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.MAGENTA_STRIPPED_LOG)
                .log(HCColouredBlocks.MAGENTA_STRIPPED_LOG)
                .wood(HCColouredBlocks.MAGENTA_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool magentaPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.MAGENTA_PLANKS);
        magentaPlankBlockPool.stairs(HCColouredBlocks.MAGENTA_STAIRS);
        magentaPlankBlockPool.slab(HCColouredBlocks.MAGENTA_SLAB);
        magentaPlankBlockPool.fence(HCColouredBlocks.MAGENTA_FENCE);
        magentaPlankBlockPool.fenceGate(HCColouredBlocks.MAGENTA_FENCE_GATE);
        magentaPlankBlockPool.pressurePlate(HCColouredBlocks.MAGENTA_PRESSURE_PLATE);
        magentaPlankBlockPool.button(HCColouredBlocks.MAGENTA_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.PINK_STRIPPED_LOG)
                .log(HCColouredBlocks.PINK_STRIPPED_LOG)
                .wood(HCColouredBlocks.PINK_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool pinkPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PINK_PLANKS);
        pinkPlankBlockPool.stairs(HCColouredBlocks.PINK_STAIRS);
        pinkPlankBlockPool.slab(HCColouredBlocks.PINK_SLAB);
        pinkPlankBlockPool.fence(HCColouredBlocks.PINK_FENCE);
        pinkPlankBlockPool.fenceGate(HCColouredBlocks.PINK_FENCE_GATE);
        pinkPlankBlockPool.pressurePlate(HCColouredBlocks.PINK_PRESSURE_PLATE);
        pinkPlankBlockPool.button(HCColouredBlocks.PINK_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.RAINBOW_STRIPPED_LOG)
                .log(HCColouredBlocks.RAINBOW_STRIPPED_LOG)
                .wood(HCColouredBlocks.RAINBOW_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool rainbowPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RAINBOW_PLANKS);
        rainbowPlankBlockPool.stairs(HCColouredBlocks.RAINBOW_STAIRS);
        rainbowPlankBlockPool.slab(HCColouredBlocks.RAINBOW_SLAB);
        rainbowPlankBlockPool.fence(HCColouredBlocks.RAINBOW_FENCE);
        rainbowPlankBlockPool.fenceGate(HCColouredBlocks.RAINBOW_FENCE_GATE);
        rainbowPlankBlockPool.pressurePlate(HCColouredBlocks.RAINBOW_PRESSURE_PLATE);
        rainbowPlankBlockPool.button(HCColouredBlocks.RAINBOW_BUTTON);

    }
}
