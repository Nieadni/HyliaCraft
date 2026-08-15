package net.nieadni.hyliacraft.client.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.screen.ShopScreenHandler;
import net.nieadni.hyliacraft.shop.RupeeChange;
import net.nieadni.hyliacraft.shop.ShopEntry;

/**
 * The salesman's shop, drawn on vanilla's villager background.
 *
 * <p>Each row is a real {@link ButtonWidget}, which is how vanilla's own trade list works. Hand-drawing
 * the contents alone leaves rows with no frame and no hover feedback, and makes an unaffordable row look
 * identical to an affordable one. The button also grays itself out when disabled, which is exactly the
 * signal wanted for something the player cannot buy.
 *
 * <p>What cannot be borrowed from vanilla is the price display: a villager shows cost as a stack, which
 * stops at 64, while rupee prices run to four figures. Each row shows one coin as an icon, the largest
 * denomination the price reaches, with the real number written beside it.
 */
public class ShopScreen extends HandledScreen<ShopScreenHandler> {

    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/gui/container/villager.png");
    private static final Identifier OUT_OF_STOCK = Identifier.ofVanilla("container/villager/out_of_stock");
    private static final Identifier TRADE_ARROW = Identifier.ofVanilla("container/villager/trade_arrow");
    private static final Identifier SCROLLER = Identifier.ofVanilla("container/villager/scroller");
    private static final Identifier SCROLLER_DISABLED = Identifier.ofVanilla("container/villager/scroller_disabled");

    private static final int TEXTURE_WIDTH = 512;
    private static final int TEXTURE_HEIGHT = 256;

    private static final int VISIBLE_ROWS = 7;
    private static final int ROW_HEIGHT = 20;
    private static final int ROW_X = 5;
    private static final int ROW_Y = 16;
    private static final int ROW_WIDTH = 88;

    // Positions within a row.
    private static final int COIN_X = 5;
    private static final int COST_TEXT_X = 23;
    private static final int ACCEPTED_X = 40;
    private static final int ARROW_X = 58;
    private static final int RESULT_X = 70;

    // The trading area, at vanilla's own slot positions. None of these are real slots: rupees are paid
    // from the pouch rather than handed over, and the required item is taken from the inventory the way
    // vanilla auto-fills its ingredient slots. They show what a purchase will cost before it is made.
    private static final int TRADE_COST_X = 136;
    private static final int TRADE_INPUT_X = 162;
    private static final int TRADE_RESULT_X = 220;
    private static final int TRADE_Y = 37;
    private static final int SLOT_SIZE = 16;

    private static final int SCROLLBAR_X = 94;
    private static final int SCROLLBAR_Y = 18;
    private static final int SCROLLBAR_AREA_HEIGHT = 139;
    private static final int SCROLLER_WIDTH = 6;
    private static final int SCROLLER_HEIGHT = 27;

    /** Item icons render at z 150, so anything laid over one has to be pushed in front of it. */
    private static final int OVERLAY_Z = 200;
    private static final int UNAFFORDABLE_TINT = 0xA0181818;

    private final ButtonWidget[] rowButtons = new ButtonWidget[VISIBLE_ROWS];
    private int scrollOffset;

    /** The row laid out in the trading area. Selecting costs nothing; only the result click buys. */
    private int selectedIndex;

    public ShopScreen(ShopScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 276;
        this.backgroundHeight = 166;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
        this.playerInventoryTitleX = 107;
    }

    private int rowCount() {
        return this.handler.getEntries().size();
    }

    private int maxScroll() {
        return Math.max(0, rowCount() - VISIBLE_ROWS);
    }

    @Override
    protected void init() {
        super.init();
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;

        for (int slot = 0; slot < VISIBLE_ROWS; slot++) {
            int row = slot;
            // The index is read at press time rather than captured, because scrolling moves which entry a
            // button stands for without moving the button.
            this.rowButtons[slot] = this.addDrawableChild(
                    ButtonWidget.builder(Text.empty(), button -> this.selectedIndex = row + this.scrollOffset)
                            .dimensions(originX + ROW_X, originY + ROW_Y + slot * ROW_HEIGHT, ROW_WIDTH, ROW_HEIGHT)
                            .build());
        }
        refreshButtons();
    }

    private void buy(int index) {
        if (this.client != null && this.client.interactionManager != null) {
            this.client.interactionManager.clickButton(this.handler.syncId, index);
        }
    }

    /**
     * Hides buttons past the end of the list.
     *
     * <p>Every existing row stays selectable even when it cannot be bought. Disabling them would stop a
     * player inspecting what something costs, which is most of the reason to look at a shop you cannot
     * yet afford. Affordability is enforced at the result instead.
     */
    private void refreshButtons() {
        for (int slot = 0; slot < VISIBLE_ROWS; slot++) {
            ButtonWidget button = this.rowButtons[slot];
            if (button == null) {
                continue;
            }
            int index = slot + this.scrollOffset;
            boolean exists = index < rowCount();
            button.visible = exists;
            button.active = exists;
        }
    }

    /** Whether the selected row can actually be bought right now. */
    private boolean canBuySelected() {
        return this.selectedIndex >= 0 && this.selectedIndex < rowCount()
                && this.handler.isInStock(this.selectedIndex) && this.handler.canAfford(this.selectedIndex);
    }

    private boolean isOverResult(double mouseX, double mouseY) {
        int x = (this.width - this.backgroundWidth) / 2 + TRADE_RESULT_X;
        int y = (this.height - this.backgroundHeight) / 2 + TRADE_Y;
        return mouseX >= x && mouseX < x + SLOT_SIZE && mouseY >= y && mouseY < y + SLOT_SIZE;
    }

    /** The largest coin the price reaches, as a hint at how dear something is. */
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

    /** Row contents, drawn over the buttons so the frame shows through around them. */
    private void drawRows(DrawContext context) {
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;

        for (int slot = 0; slot < Math.min(VISIBLE_ROWS, rowCount() - this.scrollOffset); slot++) {
            int index = slot + this.scrollOffset;
            ShopEntry entry = this.handler.getEntries().get(index);
            int x = originX + ROW_X;
            int y = originY + ROW_Y + slot * ROW_HEIGHT;

            boolean affordable = this.handler.canAfford(index);
            boolean inStock = this.handler.isInStock(index);

            context.drawItem(coinFor(entry.cost()), x + COIN_X, y + 2);
            context.drawText(this.textRenderer, Text.literal(String.valueOf(entry.cost())),
                    x + COST_TEXT_X, y + 6, affordable ? 0xFFFFFF : 0xFF5555, true);

            if (entry.hasAccepted()) {
                context.drawItem(new ItemStack(entry.accepted()), x + ACCEPTED_X, y + 2);
            }
            context.drawGuiTexture(TRADE_ARROW, x + ARROW_X, y + 5, 10, 9);
            context.drawItem(new ItemStack(entry.item()), x + RESULT_X, y + 2);

            if (!inStock) {
                context.drawGuiTexture(OUT_OF_STOCK, x + RESULT_X, y + 2, 16, 16);
            }
        }
    }

    /** Lays the selected purchase out in vanilla's trading area, so it can be read before it is bought. */
    private void drawTradingArea(DrawContext context, int mouseX, int mouseY) {
        if (this.selectedIndex < 0 || this.selectedIndex >= rowCount()) {
            return;
        }
        ShopEntry entry = this.handler.getEntries().get(this.selectedIndex);
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;
        int y = originY + TRADE_Y;

        boolean affordable = this.handler.canAfford(this.selectedIndex);

        context.drawItem(coinFor(entry.cost()), originX + TRADE_COST_X, y);
        context.drawText(this.textRenderer, Text.literal(String.valueOf(entry.cost())),
                originX + TRADE_COST_X, y + 12, affordable ? 0xFFFFFF : 0xFF5555, true);

        if (entry.hasAccepted()) {
            context.drawItem(new ItemStack(entry.accepted()), originX + TRADE_INPUT_X, y);
        }

        context.drawItem(new ItemStack(entry.item()), originX + TRADE_RESULT_X, y);
        if (!this.handler.isInStock(this.selectedIndex)) {
            context.drawGuiTexture(OUT_OF_STOCK, originX + TRADE_RESULT_X, y, SLOT_SIZE, SLOT_SIZE);
        } else if (!affordable) {
            context.fill(originX + TRADE_RESULT_X, y, originX + TRADE_RESULT_X + SLOT_SIZE, y + SLOT_SIZE,
                    OVERLAY_Z, UNAFFORDABLE_TINT);
        } else if (isOverResult(mouseX, mouseY)) {
            // The slot highlight vanilla gives a hovered slot, so the one clickable thing looks clickable.
            context.fill(originX + TRADE_RESULT_X, y, originX + TRADE_RESULT_X + SLOT_SIZE, y + SLOT_SIZE,
                    OVERLAY_Z, 0x80FFFFFF);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);

        Text balance = Text.translatable("tooltip.hyliacraft.rupee_pouch.balance", this.handler.getBalance());
        context.drawText(this.textRenderer, balance,
                this.backgroundWidth - this.textRenderer.getWidth(balance) - 8, 6, 0x404040, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        refreshButtons();
        super.render(context, mouseX, mouseY, delta);
        drawRows(context);
        drawTradingArea(context, mouseX, mouseY);
        this.drawMouseoverTooltip(context, mouseX, mouseY);

        if (isOverResult(mouseX, mouseY) && this.selectedIndex >= 0 && this.selectedIndex < rowCount()) {
            context.drawItemTooltip(this.textRenderer,
                    new ItemStack(this.handler.getEntries().get(this.selectedIndex).item()), mouseX, mouseY);
            return;
        }

        // Tooltip for whichever row the cursor is over.
        for (int slot = 0; slot < VISIBLE_ROWS; slot++) {
            ButtonWidget button = this.rowButtons[slot];
            if (button != null && button.visible && button.isMouseOver(mouseX, mouseY)) {
                int index = slot + this.scrollOffset;
                if (index < rowCount()) {
                    context.drawItemTooltip(this.textRenderer,
                            new ItemStack(this.handler.getEntries().get(index).item()), mouseX, mouseY);
                }
                break;
            }
        }
    }

    /** Buying happens here and nowhere else: clicking the result is the confirmation step. */
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0 && isOverResult(mouseX, mouseY)) {
            if (canBuySelected()) {
                buy(this.selectedIndex);
            }
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontal, double vertical) {
        if (maxScroll() > 0) {
            this.scrollOffset = Math.clamp(this.scrollOffset - (int) Math.signum(vertical), 0, maxScroll());
            refreshButtons();
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontal, vertical);
    }
}
