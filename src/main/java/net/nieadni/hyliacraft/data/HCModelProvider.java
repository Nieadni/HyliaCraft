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

        BlockStateModelGenerator.BlockTexturePool whiteBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.WHITE_BRICKS);
        whiteBrickBlockPool.stairs(HCColouredBlocks.WHITE_BRICK_STAIRS);
        whiteBrickBlockPool.slab(HCColouredBlocks.WHITE_BRICK_SLAB);
        whiteBrickBlockPool.wall(HCColouredBlocks.WHITE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool lightGrayBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_GRAY_BRICKS);
        lightGrayBrickBlockPool.stairs(HCColouredBlocks.LIGHT_GRAY_BRICK_STAIRS);
        lightGrayBrickBlockPool.slab(HCColouredBlocks.LIGHT_GRAY_BRICK_SLAB);
        lightGrayBrickBlockPool.wall(HCColouredBlocks.LIGHT_GRAY_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool grayBrickBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GRAY_BRICKS);
        grayBrickBlockPool.stairs(HCColouredBlocks.GRAY_BRICK_STAIRS);
        grayBrickBlockPool.slab(HCColouredBlocks.GRAY_BRICK_SLAB);
        grayBrickBlockPool.wall(HCColouredBlocks.GRAY_BRICK_WALL);
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
        
        //
        
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

        blockStateModelGenerator.registerLog(HCColouredBlocks.LIGHT_GRAY_STRIPPED_LOG)
                .log(HCColouredBlocks.LIGHT_GRAY_STRIPPED_LOG)
                .wood(HCColouredBlocks.LIGHT_GRAY_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool lightGrayPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_GRAY_PLANKS);
        lightGrayPlankBlockPool.stairs(HCColouredBlocks.LIGHT_GRAY_STAIRS);
        lightGrayPlankBlockPool.slab(HCColouredBlocks.LIGHT_GRAY_SLAB);
        lightGrayPlankBlockPool.fence(HCColouredBlocks.LIGHT_GRAY_FENCE);
        lightGrayPlankBlockPool.fenceGate(HCColouredBlocks.LIGHT_GRAY_FENCE_GATE);
        lightGrayPlankBlockPool.pressurePlate(HCColouredBlocks.LIGHT_GRAY_PRESSURE_PLATE);
        lightGrayPlankBlockPool.button(HCColouredBlocks.LIGHT_GRAY_BUTTON);

        blockStateModelGenerator.registerLog(HCColouredBlocks.GRAY_STRIPPED_LOG)
                .log(HCColouredBlocks.GRAY_STRIPPED_LOG)
                .wood(HCColouredBlocks.GRAY_STRIPPED_WOOD);
        BlockStateModelGenerator.BlockTexturePool grayPlankBlockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GRAY_PLANKS);
        grayPlankBlockPool.stairs(HCColouredBlocks.GRAY_STAIRS);
        grayPlankBlockPool.slab(HCColouredBlocks.GRAY_SLAB);
        grayPlankBlockPool.fence(HCColouredBlocks.GRAY_FENCE);
        grayPlankBlockPool.fenceGate(HCColouredBlocks.GRAY_FENCE_GATE);
        grayPlankBlockPool.pressurePlate(HCColouredBlocks.GRAY_PRESSURE_PLATE);
        grayPlankBlockPool.button(HCColouredBlocks.GRAY_BUTTON);

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

        //

        BlockStateModelGenerator.BlockTexturePool whiteShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.WHITE_SHINGLES);
        whiteShingleBlockPool.stairs(HCColouredBlocks.WHITE_SHINGLE_STAIRS);
        whiteShingleBlockPool.slab(HCColouredBlocks.WHITE_SHINGLE_SLAB);
        whiteShingleBlockPool.wall(HCColouredBlocks.WHITE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool lightGrayShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_GRAY_SHINGLES);
        lightGrayShingleBlockPool.stairs(HCColouredBlocks.LIGHT_GRAY_SHINGLE_STAIRS);
        lightGrayShingleBlockPool.slab(HCColouredBlocks.LIGHT_GRAY_SHINGLE_SLAB);
        lightGrayShingleBlockPool.wall(HCColouredBlocks.LIGHT_GRAY_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool grayShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GRAY_SHINGLES);
        grayShingleBlockPool.stairs(HCColouredBlocks.GRAY_SHINGLE_STAIRS);
        grayShingleBlockPool.slab(HCColouredBlocks.GRAY_SHINGLE_SLAB);
        grayShingleBlockPool.wall(HCColouredBlocks.GRAY_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool blackShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLACK_SHINGLES);
        blackShingleBlockPool.stairs(HCColouredBlocks.BLACK_SHINGLE_STAIRS);
        blackShingleBlockPool.slab(HCColouredBlocks.BLACK_SHINGLE_SLAB);
        blackShingleBlockPool.wall(HCColouredBlocks.BLACK_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool brownShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BROWN_SHINGLES);
        brownShingleBlockPool.stairs(HCColouredBlocks.BROWN_SHINGLE_STAIRS);
        brownShingleBlockPool.slab(HCColouredBlocks.BROWN_SHINGLE_SLAB);
        brownShingleBlockPool.wall(HCColouredBlocks.BROWN_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool redShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RED_SHINGLES);
        redShingleBlockPool.stairs(HCColouredBlocks.RED_SHINGLE_STAIRS);
        redShingleBlockPool.slab(HCColouredBlocks.RED_SHINGLE_SLAB);
        redShingleBlockPool.wall(HCColouredBlocks.RED_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool orangeShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.ORANGE_SHINGLES);
        orangeShingleBlockPool.stairs(HCColouredBlocks.ORANGE_SHINGLE_STAIRS);
        orangeShingleBlockPool.slab(HCColouredBlocks.ORANGE_SHINGLE_SLAB);
        orangeShingleBlockPool.wall(HCColouredBlocks.ORANGE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool yellowShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.YELLOW_SHINGLES);
        yellowShingleBlockPool.stairs(HCColouredBlocks.YELLOW_SHINGLE_STAIRS);
        yellowShingleBlockPool.slab(HCColouredBlocks.YELLOW_SHINGLE_SLAB);
        yellowShingleBlockPool.wall(HCColouredBlocks.YELLOW_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool limeShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIME_SHINGLES);
        limeShingleBlockPool.stairs(HCColouredBlocks.LIME_SHINGLE_STAIRS);
        limeShingleBlockPool.slab(HCColouredBlocks.LIME_SHINGLE_SLAB);
        limeShingleBlockPool.wall(HCColouredBlocks.LIME_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool greenShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.GREEN_SHINGLES);
        greenShingleBlockPool.stairs(HCColouredBlocks.GREEN_SHINGLE_STAIRS);
        greenShingleBlockPool.slab(HCColouredBlocks.GREEN_SHINGLE_SLAB);
        greenShingleBlockPool.wall(HCColouredBlocks.GREEN_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool cyanShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.CYAN_SHINGLES);
        cyanShingleBlockPool.stairs(HCColouredBlocks.CYAN_SHINGLE_STAIRS);
        cyanShingleBlockPool.slab(HCColouredBlocks.CYAN_SHINGLE_SLAB);
        cyanShingleBlockPool.wall(HCColouredBlocks.CYAN_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool lightBlueShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.LIGHT_BLUE_SHINGLES);
        lightBlueShingleBlockPool.stairs(HCColouredBlocks.LIGHT_BLUE_SHINGLE_STAIRS);
        lightBlueShingleBlockPool.slab(HCColouredBlocks.LIGHT_BLUE_SHINGLE_SLAB);
        lightBlueShingleBlockPool.wall(HCColouredBlocks.LIGHT_BLUE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool blueShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.BLUE_SHINGLES);
        blueShingleBlockPool.stairs(HCColouredBlocks.BLUE_SHINGLE_STAIRS);
        blueShingleBlockPool.slab(HCColouredBlocks.BLUE_SHINGLE_SLAB);
        blueShingleBlockPool.wall(HCColouredBlocks.BLUE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool purpleShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PURPLE_SHINGLES);
        purpleShingleBlockPool.stairs(HCColouredBlocks.PURPLE_SHINGLE_STAIRS);
        purpleShingleBlockPool.slab(HCColouredBlocks.PURPLE_SHINGLE_SLAB);
        purpleShingleBlockPool.wall(HCColouredBlocks.PURPLE_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool magentaShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.MAGENTA_SHINGLES);
        magentaShingleBlockPool.stairs(HCColouredBlocks.MAGENTA_SHINGLE_STAIRS);
        magentaShingleBlockPool.slab(HCColouredBlocks.MAGENTA_SHINGLE_SLAB);
        magentaShingleBlockPool.wall(HCColouredBlocks.MAGENTA_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool pinkShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.PINK_SHINGLES);
        pinkShingleBlockPool.stairs(HCColouredBlocks.PINK_SHINGLE_STAIRS);
        pinkShingleBlockPool.slab(HCColouredBlocks.PINK_SHINGLE_SLAB);
        pinkShingleBlockPool.wall(HCColouredBlocks.PINK_SHINGLE_WALL);
        BlockStateModelGenerator.BlockTexturePool rainbowShingleBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(HCColouredBlocks.RAINBOW_SHINGLES);
        rainbowShingleBlockPool.stairs(HCColouredBlocks.RAINBOW_SHINGLE_STAIRS);
        rainbowShingleBlockPool.slab(HCColouredBlocks.RAINBOW_SHINGLE_SLAB);
        rainbowShingleBlockPool.wall(HCColouredBlocks.RAINBOW_SHINGLE_WALL);
    }

}
