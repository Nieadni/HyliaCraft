package net.nieadni.hyliacraft.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.nieadni.hyliacraft.item.HCItems;
import net.nieadni.hyliacraft.item.RupeePouches;

/**
 * The rupee count, in the bottom right corner.
 *
 * <p>No packet backs this. A player's own inventory, data components included, is already synced to their
 * client, so the balance across every pouch they carry can simply be read on the client each frame. Adding
 * a payload for it would be a second source of truth that could disagree with the pouch tooltips.
 *
 * <p>Drawn whether or not the player owns a pouch, reading zero when they do not, because a counter that
 * appears and disappears reads as a bug rather than as an empty wallet.
 */
public final class RupeeHud implements HudRenderCallback {

    private static final int MARGIN = 4;
    private static final int ICON_SIZE = 16;

    /** Between the icon and the number. */
    private static final int GAP = 2;

    private final ItemStack icon;

    /**
     * The stack is built once here rather than in a static initialiser. {@link HCItems} is populated by the
     * main mod initialiser, and a static field would capture whatever the registry held at class load,
     * which is not guaranteed to be after that.
     */
    private RupeeHud() {
        this.icon = new ItemStack(HCItems.GREEN_RUPEE);
    }

    public static void register() {
        HudRenderCallback.EVENT.register(new RupeeHud());
    }

    /**
     * <p>The bottom right corner is clear of vanilla's own HUD: the hotbar and the off hand slot are
     * centred, and the status effect icons sit top right. The one case the two can meet is a scaled window
     * narrower than about 226 pixels, where the hotbar's right edge reaches this far over. That needs a
     * very high GUI scale in a small window, and is left alone rather than solved with a special case.
     */
    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || player.isSpectator() || client.options.hudHidden) {
            return;
        }

        TextRenderer textRenderer = client.textRenderer;
        Text balance = Text.literal(String.valueOf(RupeePouches.totalBalance(player)));

        int textX = context.getScaledWindowWidth() - MARGIN - textRenderer.getWidth(balance);
        int iconX = textX - GAP - ICON_SIZE;
        int iconY = context.getScaledWindowHeight() - MARGIN - ICON_SIZE;

        // Text is 8 pixels tall against a 16 pixel icon, so it is centred on the icon rather than sharing
        // its top edge, which would leave the number floating above the coin.
        int textY = iconY + (ICON_SIZE - textRenderer.fontHeight) / 2 + 1;

        context.drawItem(this.icon, iconX, iconY);
        context.drawText(textRenderer, balance, textX, textY, 0xFFFFFF, true);
    }
}
