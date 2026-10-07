package net.nieadni.hyliacraft.shop;

/**
 * Per-trader settings from a {@code rupee_traders} datapack file.
 *
 * @param restockAt time of day, in ticks, at which this trader's stock refreshes
 */
public record TraderDefinition(int restockAt) {
}
