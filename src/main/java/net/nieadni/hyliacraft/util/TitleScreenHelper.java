package net.nieadni.hyliacraft.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class TitleScreenHelper {
    private static final Identifier TITLE = Identifier.of(HyliaCraft.MOD_ID, "textures/title.png");
    private static final TextRenderer font = MinecraftClient.getInstance().textRenderer;

    //TODO: Idfk. I want to render my own title instead of the 'Minecraft, Java Edition' one

    /**
    public static void renderTitle(DrawContext guiGraphics, int i, float f, int j, boolean keepTitleThroughFade) {
        guiGraphics.setShaderColor(1.0F, 1.0F, 1.0F, keepTitleThroughFade ? 1.0F : f);
        RenderSystem.enableBlend();
        int k = i / 2 - 128;
        guiGraphics.drawSprite(TITLE,k,j,10,0,0.0F,256,93,256,93);
        guiGraphics.setShaderColor(1.0F, 1.0F,1.0F,1.0F);
        RenderSystem.disableBlend();
    }

    public static void drawVersion(int alphaFormatted) {
        int textColor = 16777215 | alphaFormatted;
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.enableBlend();
        DrawContext.drawText(font, "HyliaCraft - " + HyliaCraft.VERSION, 2, 2, textColor, false);
    }
     **/
}