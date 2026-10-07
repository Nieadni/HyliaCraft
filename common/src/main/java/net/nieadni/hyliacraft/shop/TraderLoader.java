package net.nieadni.hyliacraft.shop;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.profiler.Profiler;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Loads per-trader settings from {@code data/<namespace>/rupee_traders/<entity path>.json}.
 *
 * <p>The file id is the entity id, so {@code rupee_traders/happy_mask_salesman.json} in the
 * {@code hyliacraft} namespace configures {@code hyliacraft:happy_mask_salesman}. There is no
 * {@code entity} field, because two places naming the same thing can disagree.
 *
 * <p>These files configure traders; they cannot create one. Whether a mob trades is decided by its code,
 * which must open the shop, persist its stock and run its restock. A file naming anything else loads
 * harmlessly and is warned about, so a typo surfaces instead of doing nothing quietly.
 */
public class TraderLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {

    public static final Identifier ID = Identifier.of(HyliaCraft.MOD_ID, "rupee_traders");

    private static final String DIRECTORY = "rupee_traders";
    private static final Gson GSON = new Gson();

    /**
     * When a trader restocks if its file does not say, as a time of day in ticks.
     *
     * <p>World time runs 0 to 23999 and wraps. Useful positions:
     * <ul>
     *   <li>0 dawn, the cycle starts, sun on the horizon</li>
     *   <li>1000 day ({@code /time set day})</li>
     *   <li>6000 noon, sun at its peak ({@code /time set noon})</li>
     *   <li>12000 sunset begins</li>
     *   <li>13000 night ({@code /time set night})</li>
     *   <li>18000 midnight ({@code /time set midnight})</li>
     *   <li>23000 sunrise begins</li>
     * </ul>
     *
     * <p>Sunrise, so stock refreshes before a player's day starts.
     */
    public static final int DEFAULT_RESTOCK_AT = 23000;

    private static final int TICKS_PER_DAY = 24000;

    /** Entity types with shop code, registered at startup. Only these can meaningfully be configured. */
    private static final Set<Identifier> TRADER_TYPES = new HashSet<>();

    private static volatile Map<Identifier, TraderDefinition> definitions = Map.of();

    public TraderLoader() {
        super(GSON, DIRECTORY);
    }

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    /** Declares an entity type as able to trade, so its file is recognised rather than warned about. */
    public static void registerTraderType(Identifier entityType) {
        TRADER_TYPES.add(entityType);
    }

    /**
     * Whether this id names something that can actually trade.
     *
     * <p>Deliberately asks the code, not the datapack. A config file only sets a trader's options and is
     * optional, exactly as {@link #restockAt} treats it. Answering from the files instead would mean
     * deleting or overriding one JSON silently emptied every shop, and a file naming a mob that does not
     * exist would validate entries nobody can ever sell.
     */
    public static boolean isTrader(Identifier trader) {
        return TRADER_TYPES.contains(trader);
    }

    /** When this trader restocks, falling back to the default for a trader with no file. */
    public static int restockAt(Identifier trader) {
        TraderDefinition definition = definitions.get(trader);
        return definition != null ? definition.restockAt() : DEFAULT_RESTOCK_AT;
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> prepared, ResourceManager manager, Profiler profiler) {
        Map<Identifier, TraderDefinition> loaded = new HashMap<>();

        for (Map.Entry<Identifier, JsonElement> file : prepared.entrySet()) {
            if (!TRADER_TYPES.contains(file.getKey())) {
                HyliaCraft.LOGGER.warn(
                        "Skipping trader '{}': it does not name an entity that can trade", file.getKey());
                continue;
            }
            try {
                loaded.put(file.getKey(), parse(file.getValue()));
            } catch (RuntimeException e) {
                HyliaCraft.LOGGER.warn("Skipping trader '{}': {}", file.getKey(), e.getMessage());
            }
        }

        definitions = Map.copyOf(loaded);
        HyliaCraft.LOGGER.info("Loaded {} trader definitions", definitions.size());
    }

    private static TraderDefinition parse(JsonElement element) {
        JsonObject json = JsonHelper.asObject(element, "trader");

        int restockAt = JsonHelper.getInt(json, "restock_at", DEFAULT_RESTOCK_AT);
        if (restockAt < 0 || restockAt >= TICKS_PER_DAY) {
            throw new IllegalArgumentException(
                    "restock_at must be a time of day from 0 to " + (TICKS_PER_DAY - 1) + ", was " + restockAt);
        }

        return new TraderDefinition(restockAt);
    }
}
