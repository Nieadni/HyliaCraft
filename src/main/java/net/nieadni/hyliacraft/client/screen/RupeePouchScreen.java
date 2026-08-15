package net.nieadni.hyliacraft.client.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.screen.RupeePouchScreenHandler;
import net.nieadni.hyliacraft.shop.RupeeChange;

/**
 * The Rupee Pouch interface.
 *
 * <p>The eight denominations across the top are drawn by hand rather than being slots, because the pouch
 * holds a single balance and there is nothing for a slot to hold. Clicking one asks the server to withdraw;
 * the client never changes the balance itself.
 */
public class RupeePouchScreen extends HandledScreen<RupeePouchScreenHandler> {

    private static final Identifier TEXTURE = Identifier.of(HyliaCraft.MOD_ID, "textures/gui/rupee_pouch.png");

    // Measured from the texture rather than assumed.
    private static final int BUTTON_X = 17;
    private static final int BUTTON_Y = 18;
    private static final int BUTTON_PITCH = 18;
    private static final int BUTTON_SIZE = 16;

    /** Laid over a denomination the balance cannot reach. */
    private static final int UNAFFORDABLE_TINT = 0xB0202020;

    public RupeePouchScreen(RupeePouchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 130;
        this.playerInventoryTitleY = 36;
    }

    /**
     * Which denomination sits at a given button, left to right.
     *
     * <p>{@link RupeeChange#DENOMINATIONS} runs high to low because that suits the change solver, but the
     * row reads naturally cheapest first, so the display order is reversed.
     */
    private static RupeeChange.Denomination denominationAt(int button) {
        return RupeeChange.DENOMINATIONS.get(RupeeChange.DENOMINATIONS.size() - 1 - button);
    }

    private static int buttonId(int button, boolean bulk) {
        int index = RupeeChange.DENOMINATIONS.size() - 1 - button;
        return index * 2 + (bulk ? 1 : 0);
    }

    private int buttonAt(double mouseX, double mouseY) {
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;
        for (int button = 0; button < RupeeChange.DENOMINATIONS.size(); button++) {
            int x = originX + BUTTON_X + button * BUTTON_PITCH;
            int y = originY + BUTTON_Y;
            if (mouseX >= x && mouseX < x + BUTTON_SIZE && mouseY >= y && mouseY < y + BUTTON_SIZE) {
                return button;
            }
        }
        return -1;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int originX = (this.width - this.backgroundWidth) / 2;
        int originY = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, originX, originY, 0, 0, this.backgroundWidth, this.backgroundHeight);

        int balance = this.handler.getBalance();
        for (int button = 0; button < RupeeChange.DENOMINATIONS.size(); button++) {
            RupeeChange.Denomination denomination = denominationAt(button);
            int x = originX + BUTTON_X + button * BUTTON_PITCH;
            int y = originY + BUTTON_Y;

            context.drawItem(new ItemStack(denomination.item()), x, y);
            if (balance < denomination.value()) {
                context.fill(x, y, x + BUTTON_SIZE, y + BUTTON_SIZE, UNAFFORDABLE_TINT);
            }
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);

        Text balance = Text.translatable("tooltip.hyliacraft.rupee_pouch.balance", this.handler.getBalance());
        context.drawText(this.textRenderer, balance,
                this.backgroundWidth - this.textRenderer.getWidth(balance) - 8, this.titleY, 0x404040, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);

        int button = buttonAt(mouseX, mouseY);
        if (button >= 0) {
            context.drawItemTooltip(this.textRenderer, new ItemStack(denominationAt(button).item()), mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0) {
            int button = buttonAt(mouseX, mouseY);
            if (button >= 0) {
                if (this.client != null && this.client.interactionManager != null) {
                    this.client.interactionManager.clickButton(this.handler.syncId, buttonId(button, hasShiftDown()));
                }
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
