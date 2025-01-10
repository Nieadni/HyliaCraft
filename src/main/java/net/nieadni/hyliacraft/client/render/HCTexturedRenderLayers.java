package net.nieadni.hyliacraft.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.entity.IronChestBlockEntity;

@Environment(EnvType.CLIENT)
public class HCTexturedRenderLayers extends TexturedRenderLayers {

    public static final SpriteIdentifier IRON_CHEST = createChestTextureId("iron_chest");
    public static final SpriteIdentifier IRON_CHEST_LEFT = createChestTextureId("iron_chest_left");
    public static final SpriteIdentifier IRON_CHEST_RIGHT = createChestTextureId("iron_chest_right");


    private static SpriteIdentifier createChestTextureId(String variant) {
        return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, Identifier.of(HyliaCraft.MOD_ID,"entity/chest/" + variant));
    }

    public static SpriteIdentifier getChestTextureId(BlockEntity blockEntity, ChestType type) {
        if (blockEntity instanceof IronChestBlockEntity) {
            return getChestTextureId(type, IRON_CHEST, IRON_CHEST_LEFT, IRON_CHEST_RIGHT);
        } else {
            return null;
        }

    }

    private static SpriteIdentifier getChestTextureId(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
        switch (type) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case SINGLE:
            default:
                return single;
        }
    }

}
