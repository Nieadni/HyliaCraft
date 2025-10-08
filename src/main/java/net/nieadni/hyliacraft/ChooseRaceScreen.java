package net.nieadni.hyliacraft;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class ChooseRaceScreen extends Screen {

    private static final Identifier BACKGROUND_TEXTURE = Identifier.of(HyliaCraft.MOD_ID, "textures/gui/race_selector.png");
    private static final int BACKGROUND_WIDTH = 162;
    private static final int BACKGROUND_HEIGHT = 221;

    private static final int DESCRIPTION_Y_START = 64;
    private static final int DESCRIPTION_Y_END = 96;
    private static final int ABILITIES_Y_START = 122;
    private static final int ABILITIES_Y_END = 181;

    private int currentRace = -1;
    private static final int NUM_RACES = HyliaCraftRace.values().length;

    private float descriptionSf = 0.0f;
    private final List<String> descriptionLines = new ArrayList<>();
    private float abilitiesSf = 0.0f;
    private final List<String> abilitiesLines = new ArrayList<>();

    public ChooseRaceScreen(Text title) {
        super(title);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (isMouseOverLeftArrow((int) mouseX, (int) mouseY)) {
            setCurrentRace((currentRace + NUM_RACES - 1) % NUM_RACES);
        } else if (isMouseOverRightArrow((int) mouseX, (int) mouseY)) {
            setCurrentRace((currentRace + 1) % NUM_RACES);
        } else if (isMouseOverConfirmButton((int) mouseX, (int) mouseY)) {
            MinecraftClient client = this.client;
            HyliaCraftRace race = HyliaCraftRace.fromOrdinal(currentRace);

            // Clear the screen
            client.setScreen(null);

            // Send a nice message
            client.player.sendMessage(Text.translatable("hyliacraft.race.on_select", race.getName()));

            // Let the server know
            ClientPlayNetworking.send(new RaceC2SPayload(race));

            // Update the client's saved value
            HyliaCraftClient.race = race;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private boolean isMouseOverLeftArrow(int x, int y) {
        int xMin = this.width / 2 - BACKGROUND_WIDTH / 2 + 5;
        int xMax = this.width / 2 - BACKGROUND_WIDTH / 2 + 25;
        int yMin = this.height / 2 - BACKGROUND_HEIGHT / 2 + 5;
        int yMax = this.height / 2 - BACKGROUND_HEIGHT / 2 + 22;
        return xMin < x && x < xMax && yMin < y && y < yMax;
    }

    private boolean isMouseOverRightArrow(int x, int y) {
        int xMin = this.width / 2 + BACKGROUND_WIDTH / 2 - 25;
        int xMax = this.width / 2 + BACKGROUND_WIDTH / 2 - 5;
        int yMin = this.height / 2 - BACKGROUND_HEIGHT / 2 + 5;
        int yMax = this.height / 2 - BACKGROUND_HEIGHT / 2 + 22;
        return xMin < x && x < xMax && yMin < y && y < yMax;
    }

    private boolean isMouseOverConfirmButton(int x, int y) {
        int xMin = this.width / 2 - BACKGROUND_WIDTH / 2 + 24;
        int xMax = this.width / 2 - BACKGROUND_WIDTH / 2 + 138;
        int yMin = this.height / 2 - BACKGROUND_HEIGHT / 2 + 193;
        int yMax = this.height / 2 - BACKGROUND_HEIGHT / 2 + 216;
        return xMin < x && x < xMax && yMin < y && y < yMax;
    }

    private void setCurrentRace(int race) {
        currentRace = race;
        HyliaCraftRace actualRace = HyliaCraftRace.fromOrdinal(race);

        // Find the right scale factors
        descriptionLines.clear();
        descriptionSf = prepareText(actualRace.getDescription(), DESCRIPTION_Y_END - DESCRIPTION_Y_START, descriptionLines);
        abilitiesLines.clear();
        abilitiesSf = prepareText(actualRace.getAbilities(), ABILITIES_Y_END - ABILITIES_Y_START, abilitiesLines);
    }

    // Returns an appropriate scale factor, and writes the line divisions to the provided list
    private float prepareText(Text text, int ySpace, List<String> lines) {
        float scaleFactor = 1.0f;
        while (true) {
            lines.clear();
            String fullString = text.getString();
            int y = 0;

            int maxWidth = (int) (138 / scaleFactor);
            while (!fullString.isEmpty()) {
                String line = textRenderer.trimToWidth(fullString, maxWidth);
                int lastSpace = StringUtils.lastIndexOf(line, ' ');
                if (lastSpace == -1 || line.length() == fullString.length() || line.length() < fullString.length() && fullString.charAt(line.length()) == ' ') {
                    lastSpace = line.length();
                }
                line = line.substring(0, lastSpace);
                y += (int) ((textRenderer.fontHeight + 1) * scaleFactor);
                fullString = fullString.substring(Math.min(lastSpace + 1, fullString.length()));
                lines.add(line);
            }

            if (y <= ySpace) return scaleFactor;
            scaleFactor -= 0.1f;
        }
    }

    private void renderBackground(DrawContext context) {
        int x = this.width / 2 - BACKGROUND_WIDTH / 2;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2;
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
    }

    private void renderRaceName(DrawContext context) {
        Text text = HyliaCraftRace.fromOrdinal(currentRace).getName();
        int textWidth = textRenderer.getWidth(text);
        int x = this.width / 2 - textWidth / 2;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + 10;
        context.drawText(textRenderer, text, x, y, Colors.BLACK, false);
    }

    private void renderScaledLines(DrawContext context, List<String> lines, float scaleFactor, int yStart) {
        MatrixStack matrices = context.getMatrices();
        matrices.push();
        matrices.scale(scaleFactor, scaleFactor, 1.0f);

        int x = this.width / 2 - BACKGROUND_WIDTH / 2 + 13;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + yStart;

        for (String line : lines) {
            context.drawText(textRenderer, line, (int) (x / scaleFactor), (int) (y / scaleFactor), Colors.BLACK, false);
            y += (int) ((textRenderer.fontHeight + 1) * scaleFactor);
        }

        matrices.pop();
    }

    private void renderMaxHealth(DrawContext context) {
        HyliaCraftRace race = HyliaCraftRace.fromOrdinal(currentRace);
        Text text = Text.literal(String.valueOf(race.maxHealth));
        int x = this.width / 2 - BACKGROUND_WIDTH / 2 + 91 - textRenderer.getWidth(text) / 2;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + 33;
        context.drawText(textRenderer, text, x, y, Colors.BLACK, false);
    }

    private void renderLeftArrow(DrawContext context, boolean highlighted) {
        int x = this.width / 2 - BACKGROUND_WIDTH / 2 + 5;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + 5;
        int v = highlighted ? 17 : 0;
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 162, v, 20, 17);
    }

    private void renderRightArrow(DrawContext context, boolean highlighted) {
        int x = this.width / 2 + BACKGROUND_WIDTH / 2 - 25;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + 5;
        int v = highlighted ? 17 : 0;
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 182, v, 20, 17);
    }

    private void renderConfirmButton(DrawContext context, boolean highlighted) {
        int x = this.width / 2 - BACKGROUND_WIDTH / 2 + 24;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + 193;
        int u = highlighted ? 114 : 0;
        context.drawTexture(BACKGROUND_TEXTURE, x, y, u, 221, 114, 23);
    }

    private void renderConfirmButtonText(DrawContext context) {
        Text text = Text.translatable("hyliacraft.race.selector.confirm");
        int x = this.width / 2 - textRenderer.getWidth(text) / 2;
        int y = this.height / 2 - BACKGROUND_HEIGHT / 2 + 201;
        context.drawText(textRenderer, text, x, y, Colors.BLACK, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        if (currentRace == -1) setCurrentRace(0);

        renderBackground(context);
        renderRaceName(context);
        renderMaxHealth(context);
        renderScaledLines(context, descriptionLines, descriptionSf, 64);
        renderScaledLines(context, abilitiesLines, abilitiesSf, 122);

        renderLeftArrow(context, isMouseOverLeftArrow(mouseX, mouseY));
        renderRightArrow(context, isMouseOverRightArrow(mouseX, mouseY));
        renderConfirmButton(context, isMouseOverConfirmButton(mouseX, mouseY));
        renderConfirmButtonText(context);
    }
}
