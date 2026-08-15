package net.nieadni.hyliacraft.client.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.screen.ShopScreenHandler;
import net.nieadni.hyliacraft.shop.RupeeChange;
import net.nieadni.hyliacraft.shop.ShopEntry;

/**
 * The salesman's shop, drawn on vanilla's villager background.
 *
 * <p>Reusing vanilla art means no new textures are needed and the screen looks native. What it cannot
 * reuse is the price display: a villager shows cost as a stack, which stops at 64, and rupee prices run to
 * four figures. Each row therefore shows one coin as an icon, the largest denomination the price reaches,
 * with the real number written beside it.
 */
public class ShopScreen extends HandledScreen<ShopScreenHandler> {

    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/gui/container/villager.png");
    private static final Identifier OUT_OF_STOCK = Identifier.ofVanilla("container/villager/out_of_stock");
    private static final Identifier TRADE_ARROW = Identifier.ofVanilla("container/villager/trade_arrow");
    private static final Identifier SCROLLER = Identifier.ofVanilla("container/villager/scroller");
    private static final Identifier SCROLLER_DISABLED = Identifier.ofVanilla("container/villager/scroller_disabled");

    private static final int TEXTURE_WIDTH = 512;
    private static final int TEXTURE_HEIGHT = 256;

    /** Rows visible at once, matching vanilla's list. */
    private static final int VISIBLE_ROWS = 7;
    private static final int ROW_HEIGHT = 20;
    private static final int ROW_X = 5;
    private static final int ROW_Y = 16;
    private static final int ROW_WIDTH = 89;

    private static final int SCROLLBAR_X = 94;
    private static final int SCROLLBAR_Y = 18;
    private static final int SCROLLBAR_AREA_HEIGHT = 139;
    private static final int SCROLLER_WIDTH = 6;
    private static final int SCROLLER_HEIGHT = 27;

    /** Drawn in front of an item icon, which renders at z 150. */
    private static final int OVERLAY_Z = 200;
    private static final int UNAFFORDABLE_TINT = 0xA0181818;

    private int scrollOffset;

    public ShopScreen(ShopScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 276;
        this.backgroundHeight = 166;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    private int rowCount() {
        return this.handler.getEntries().size();
    }

    private int maxScroll() {
        return Math.max(0, rowCount() - VISIBLE_ROWS);
    }

    /** Which entry a point is over, or -1. */
    private int rowAt(double mouseX, double mouseY) {
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;
        for (int visible = 0; visible < Math.min(VISIBLE_ROWS, rowCount()); visible++) {
            int x = originX + ROW_X;
            int y = originY + ROW_Y + visible * ROW_HEIGHT;
            if (mouseX >= x && mouseX < x + ROW_WIDTH && mouseY >= y && mouseY < y + ROW_HEIGHT) {
                return visible + this.scrollOffset;
            }
        }
        return -1;
    }

    /** The largest coin the price reaches, as a visual hint at how dear something is. */
    private static ItemStack coinFor(int cost) {
        for (RupeeChange.Denomination denomination : RupeeChange.DENOMINATIONS) {
            if (cost >= denomination.value()) {
                return new ItemStack(denomination.item());
            }
        }
        return new ItemStack(RupeeChange.DENOMINATIONS.get(RupeeChange.DENOMINATIONS.size() - 1).item());
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, originX, originY, 0, 0.0F, 0.0F,
                this.backgroundWidth, this.backgroundHeight, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        int rows = Math.min(VISIBLE_ROWS, rowCount());
        for (int visible = 0; visible < rows; visible++) {
            int index = visible + this.scrollOffset;
            ShopEntry entry = this.handler.getEntries().get(index);
            int x = originX + ROW_X;
            int y = originY + ROW_Y + visible * ROW_HEIGHT;

            boolean affordable = this.handler.canAfford(index);
            boolean inStock = this.handler.isInStock(index);

            context.drawItem(coinFor(entry.cost()), x, y + 2);
            context.drawText(this.textRenderer, Text.literal(String.valueOf(entry.cost())),
                    x + 18, y + 6, affordable ? 0x404040 : 0xAA0000, false);

            if (!entry.accepts().isEmpty()) {
                context.drawItem(new ItemStack(entry.accepts().get(0)), x + 40, y + 2);
            }
            context.drawGuiTexture(TRADE_ARROW, x + 56, y + 4, 10, 9);
            context.drawItem(new ItemStack(entry.item()), x + 68, y + 2);

            if (!inStock) {
                context.drawGuiTexture(OUT_OF_STOCK, x + 68, y + 2, 16, 16);
            } else if (!affordable) {
                context.fill(x, y, x + ROW_WIDTH, y + ROW_HEIGHT, OVERLAY_Z, UNAFFORDABLE_TINT);
            }
        }

        if (maxScroll() > 0) {
            int travel = SCROLLBAR_AREA_HEIGHT - SCROLLER_HEIGHT;
            int offset = travel * this.scrollOffset / maxScroll();
            context.drawGuiTexture(SCROLLER, originX + SCROLLBAR_X, originY + SCROLLBAR_Y + offset,
                    SCROLLER_WIDTH, SCROLLER_HEIGHT);
        } else {
            context.drawGuiTexture(SCROLLER_DISABLED, originX + SCROLLBAR_X, originY + SCROLLBAR_Y,
                    SCROLLER_WIDTH, SCROLLER_HEIGHT);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);

        Text balance = Text.translatable("tooltip.hyliacraft.rupee_pouch.balance", this.handler.getBalance())
                .formatted(Formatting.DARK_GRAY);
        context.drawText(this.textRenderer, balance,
                this.backgroundWidth - this.textRenderer.getWidth(balance) - 8, 6, 0x404040, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);

        int index = rowAt(mouseX, mouseY);
        if (index >= 0 && index < rowCount()) {
            context.drawItemTooltip(this.textRenderer,
                    new ItemStack(this.handler.getEntries().get(index).item()), mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontal, double vertical) {
        if (maxScroll() > 0) {
            this.scrollOffset = Math.clamp(this.scrollOffset - (int) Math.signum(vertical), 0, maxScroll());
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontal, vertical);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0) {
            int index = rowAt(mouseX, mouseY);
            if (index >= 0 && this.handler.isInStock(index) && this.handler.canAfford(index)
                    && this.client != null && this.client.interactionManager != null) {
                this.client.interactionManager.clickButton(this.handler.syncId, index);
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
