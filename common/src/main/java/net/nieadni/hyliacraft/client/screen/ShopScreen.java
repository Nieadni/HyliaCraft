package net.nieadni.hyliacraft.client.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.screen.ShopScreenHandler;
import net.nieadni.hyliacraft.shop.Accepted;
import net.nieadni.hyliacraft.shop.Rupees;
import net.nieadni.hyliacraft.shop.ShopEntry;

import java.util.List;

/**
 * The salesman's shop, drawn on vanilla's villager background.
 *
 * <p>Each row of the offer list is a real {@link ButtonWidget}, which is how vanilla's own trade list
 * works. Hand-drawing the contents alone leaves rows with no frame and no hover feedback, and makes an
 * unaffordable row look identical to an affordable one.
 *
 * <p>The trading area is not drawn here at all any more. Those three positions are real slots owned by
 * {@link ShopScreenHandler}, so the player puts a pouch in and takes the goods out; the background texture
 * already carries the slot frames they line up with.
 *
 * <p>What still cannot be borrowed from vanilla is the price display: a villager shows cost as a stack,
 * which stops at 64, while rupee prices run to four figures. Each row shows one coin as an icon, the
 * largest denomination the price reaches, with the real number written beside it.
 */
public class ShopScreen extends HandledScreen<ShopScreenHandler> {

    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/gui/container/villager.png");
    private static final Identifier OUT_OF_STOCK = Identifier.ofVanilla("container/villager/out_of_stock");
    private static final Identifier TRADE_ARROW = Identifier.ofVanilla("container/villager/trade_arrow");
    private static final Identifier TRADE_ARROW_OUT_OF_STOCK =
            Identifier.ofVanilla("container/villager/trade_arrow_out_of_stock");
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

    private static final int SLOT_SIZE = 16;

    // Vanilla's barrier is 28x21 and sits over the arrow between the inputs and the result, not over the
    // result itself. Drawing it at slot size squashes it into something unrecognisable.
    private static final int OUT_OF_STOCK_X = 182;
    private static final int OUT_OF_STOCK_Y = 35;
    private static final int OUT_OF_STOCK_WIDTH = 28;
    private static final int OUT_OF_STOCK_HEIGHT = 21;

    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_HEIGHT = 9;

    private static final int SCROLLBAR_X = 94;
    private static final int SCROLLBAR_Y = 18;
    private static final int SCROLLBAR_AREA_HEIGHT = 139;
    private static final int SCROLLER_WIDTH = 6;
    private static final int SCROLLER_HEIGHT = 27;

    /** How long each alternative trade-in item is shown for, when a row offers a choice of them. */
    private static final int CYCLE_TICKS = 20;

    /** Vanilla's own key, so the heading is translated everywhere without a lang entry of ours. */
    private static final Text TRADES_TEXT = Text.translatable("merchant.trades");

    private final ButtonWidget[] rowButtons = new ButtonWidget[VISIBLE_ROWS];
    private int scrollOffset;

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
                    ButtonWidget.builder(Text.empty(), button -> select(row + this.scrollOffset))
                            .dimensions(originX + ROW_X, originY + ROW_Y + slot * ROW_HEIGHT, ROW_WIDTH, ROW_HEIGHT)
                            .build());
        }
        refreshButtons();
    }

    /**
     * Chooses a row.
     *
     * <p>Set locally as well as sent, because {@code clickButton} only puts a packet on the wire. Waiting
     * for the server to echo the choice back would leave the trading area a tick behind every click, which
     * reads as the shop being unresponsive.
     */
    private void select(int index) {
        this.handler.selectLocally(index);
        if (this.client != null && this.client.interactionManager != null) {
            this.client.interactionManager.clickButton(this.handler.syncId, index);
        }
    }

    /**
     * Hides buttons past the end of the list.
     *
     * <p>Every existing row stays selectable even when it cannot be bought. Disabling them would stop a
     * player inspecting what something costs, which is most of the reason to look at a shop you cannot
     * yet afford.
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

    /** The largest coin the price reaches, as a hint at how dear something is. */
    private static ItemStack coinFor(int cost) {
        for (Rupees.Denomination denomination : Rupees.DENOMINATIONS) {
            if (cost >= denomination.value()) {
                return new ItemStack(denomination.item());
            }
        }
        return new ItemStack(Rupees.DENOMINATIONS.get(Rupees.DENOMINATIONS.size() - 1).item());
    }

    /**
     * Which trade-in item to show for a row that offers a choice of several.
     *
     * <p>Cycling rather than listing them: a row is 20 pixels tall and has space for one icon, and the
     * slot accepts any of them regardless of which is on screen at the moment.
     */
    private Accepted cyclingAccepted(ShopEntry entry) {
        List<Accepted> accepts = entry.accepts();
        if (accepts.size() == 1 || this.client == null || this.client.world == null) {
            return accepts.get(0);
        }
        return accepts.get((int) (this.client.world.getTime() / CYCLE_TICKS % accepts.size()));
    }

    /**
     * An item with its stack count written on it.
     *
     * <p>{@code drawItem} alone renders no count, so a trade wanting two of something would look exactly
     * like one wanting one. {@code drawItemInSlot} is what paints the number, and it has to follow the
     * icon rather than replace it.
     */
    private void drawCounted(DrawContext context, ItemStack stack, int x, int y) {
        context.drawItem(stack, x, y);
        context.drawItemInSlot(this.textRenderer, stack, x, y);
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

        // Over the arrow between the inputs and the result, where vanilla puts it. It does not overlap any
        // slot, so drawing it with the background rather than over the top is safe.
        int selected = this.handler.getSelectedIndex();
        if (selected >= 0 && selected < rowCount() && !this.handler.isInStock(selected)) {
            context.drawGuiTexture(OUT_OF_STOCK, originX + OUT_OF_STOCK_X, originY + OUT_OF_STOCK_Y,
                    OUT_OF_STOCK_WIDTH, OUT_OF_STOCK_HEIGHT);
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
                drawCounted(context, cyclingAccepted(entry).toStack(), x + ACCEPTED_X, y + 2);
            }
            // A spent row is marked by crossing out its arrow, which is how vanilla shows a locked trade.
            context.drawGuiTexture(inStock ? TRADE_ARROW : TRADE_ARROW_OUT_OF_STOCK,
                    x + ARROW_X, y + 5, ARROW_WIDTH, ARROW_HEIGHT);
            drawCounted(context, entry.toStack(), x + RESULT_X, y + 2);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        refreshButtons();
        super.render(context, mouseX, mouseY, delta);
        drawRows(context);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
        drawRowTooltip(context, mouseX, mouseY);
    }

    /**
     * The two headings, laid out the way vanilla's merchant screen lays out its own.
     *
     * <p>{@code super} is deliberately not called: {@link HandledScreen} draws the title at {@code titleX},
     * hard against the left edge, which is where "Trades" belongs.
     *
     * <p>{@code merchant.trades} is vanilla's own translation key, so the heading is already translated
     * into every language the game ships. Coining a HyliaCraft key would put an English-only string into
     * five otherwise translated lang files.
     *
     * <p>The balance is gone from here. The HUD counter shows the same number without a screen open, and
     * two copies of it on screen at once invite the two to disagree.
     */
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, TRADES_TEXT,
                5 - this.textRenderer.getWidth(TRADES_TEXT) / 2 + 48, 6, 0x404040, false);
        context.drawText(this.textRenderer, this.title,
                49 + this.backgroundWidth / 2 - this.textRenderer.getWidth(this.title) / 2, 6, 0x404040, false);
        context.drawText(this.textRenderer, this.playerInventoryTitle,
                this.playerInventoryTitleX, this.playerInventoryTitleY, 0x404040, false);
    }

    private static boolean isOver(int x, int y, double mouseX, double mouseY) {
        return mouseX >= x && mouseX < x + SLOT_SIZE && mouseY >= y && mouseY < y + SLOT_SIZE;
    }

    /**
     * Tooltips for the offer list.
     *
     * <p>Those icons are drawn rather than being slots, so nothing gives them tooltips for free. Each is
     * hit-tested individually: hovering a row should name the thing under the cursor, not whatever the row
     * happens to sell. The trading area needs none of this now that it is made of real slots.
     *
     * <p>The price icon gets the real total rather than the coin's own tooltip. A 666 rupee price is drawn
     * with a gold rupee, and "Worth 300 Rupees" would be an actively misleading thing to read there.
     */
    private void drawRowTooltip(DrawContext context, int mouseX, int mouseY) {
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;

        for (int slot = 0; slot < Math.min(VISIBLE_ROWS, rowCount() - this.scrollOffset); slot++) {
            ShopEntry entry = this.handler.getEntries().get(slot + this.scrollOffset);
            int x = originX + ROW_X;
            int y = originY + ROW_Y + slot * ROW_HEIGHT + 2;

            if (isOver(x + COIN_X, y, mouseX, mouseY)) {
                context.drawTooltip(this.textRenderer,
                        Text.translatable("tooltip.hyliacraft.rupee_pouch.balance", entry.cost()), mouseX, mouseY);
                return;
            }
            if (entry.hasAccepted() && isOver(x + ACCEPTED_X, y, mouseX, mouseY)) {
                context.drawItemTooltip(this.textRenderer, cyclingAccepted(entry).toStack(), mouseX, mouseY);
                return;
            }
            if (isOver(x + RESULT_X, y, mouseX, mouseY)) {
                context.drawItemTooltip(this.textRenderer, entry.toStack(), mouseX, mouseY);
                return;
            }
        }
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
