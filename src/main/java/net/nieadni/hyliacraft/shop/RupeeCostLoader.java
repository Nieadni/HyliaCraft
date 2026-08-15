package net.nieadni.hyliacraft.shop;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.profiler.Profiler;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Loads what the Happy Mask Salesman sells from {@code data/<namespace>/rupee_costs/*.json}.
 *
 * <p>Every loaded datapack is scanned, so other mods ship prices in their own jar and modpacks override
 * them by reusing a file id. HyliaCraft's own prices arrive by the same route and get no special treatment.
 * Because this listens on server data, {@code /reload} picks up changes.
 */
public class RupeeCostLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {

    public static final Identifier ID = Identifier.of(HyliaCraft.MOD_ID, "rupee_costs");

    /** Matches {@code data/<namespace>/rupee_costs/}. */
    private static final String DIRECTORY = "rupee_costs";

    private static final Gson GSON = new Gson();

    /** Trades an offer allows before it locks until restock, when a file does not say. */
    public static final int DEFAULT_MAX_USES = 12;

    /** Who sells an entry that does not name a trader, so existing packs keep working untouched. */
    public static final Identifier DEFAULT_MERCHANT = Identifier.of(HyliaCraft.MOD_ID, "happy_mask_salesman");

    /**
     * The current price list, cheapest first.
     *
     * <p>Volatile because reloads happen off the server thread while the salesman reads this from it, both
     * when restocking each tick and when opening his shop. Replaced wholesale rather than mutated, so a
     * reader always sees a complete list.
     */
    private static volatile List<RupeeCost> entries = List.of();

    public RupeeCostLoader() {
        super(GSON, DIRECTORY);
    }

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    /** Traders load first, so an entry naming an unknown one can be reported rather than guessed at. */
    @Override
    public Collection<Identifier> getFabricDependencies() {
        return List.of(TraderLoader.ID);
    }

    /** The loaded price list, sorted by cost ascending then item id. Never null; empty before the first load. */
    public static List<RupeeCost> getSorted() {
        return entries;
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> prepared, ResourceManager manager, Profiler profiler) {
        List<RupeeCost> loaded = new ArrayList<>();

        for (Map.Entry<Identifier, JsonElement> file : prepared.entrySet()) {
            try {
                RupeeCost cost = parse(file.getValue());

                List<Identifier> unknown = cost.merchants().stream()
                        .filter(merchant -> !TraderLoader.isDefined(merchant))
                        .toList();
                if (!unknown.isEmpty()) {
                    // Loud, because the alternative is an item that silently nobody sells.
                    HyliaCraft.LOGGER.warn("Skipping rupee cost '{}': no trader defined for {}",
                            file.getKey(), unknown);
                    continue;
                }

                loaded.add(cost);
            } catch (RuntimeException e) {
                // One malformed file must not cost us the rest of the price list, so log and carry on.
                HyliaCraft.LOGGER.warn("Skipping rupee cost '{}': {}", file.getKey(), e.getMessage());
            }
        }

        // Cheapest first, as the salesman's trade list is meant to read. Item id breaks ties so that two
        // equally priced masks do not swap places between reloads.
        Comparator<RupeeCost> byCost = Comparator.comparingInt(RupeeCost::cost);
        loaded.sort(byCost.thenComparing(entry -> Registries.ITEM.getId(entry.item()).toString()));

        entries = List.copyOf(loaded);
        HyliaCraft.LOGGER.info("Loaded {} rupee cost entries", entries.size());
    }

    private static RupeeCost parse(JsonElement element) {
        JsonObject json = JsonHelper.asObject(element, "rupee cost");

        Item item = resolveItem(JsonHelper.getString(json, "item"));

        int cost = JsonHelper.getInt(json, "cost");
        if (cost < 0) {
            throw new IllegalArgumentException("cost must not be negative, was " + cost);
        }

        int maxUses = JsonHelper.getInt(json, "max_uses", DEFAULT_MAX_USES);
        if (maxUses <= 0) {
            throw new IllegalArgumentException("max_uses must be positive, was " + maxUses);
        }

        boolean restocks = JsonHelper.getBoolean(json, "restocks", true);

        List<Item> accepts = new ArrayList<>();
        JsonArray array = JsonHelper.getArray(json, "accepts", null);
        if (array != null) {
            for (JsonElement accepted : array) {
                accepts.add(resolveItem(accepted.getAsString()));
            }
        }

        return new RupeeCost(item, cost, List.copyOf(accepts), maxUses, restocks, parseMerchants(json));
    }

    /** Accepts a single trader id or a list of them, so one item can be stocked by several. */
    private static List<Identifier> parseMerchants(JsonObject json) {
        if (!json.has("merchant")) {
            return List.of(DEFAULT_MERCHANT);
        }
        if (JsonHelper.hasArray(json, "merchant")) {
            List<Identifier> merchants = new ArrayList<>();
            for (JsonElement merchant : JsonHelper.getArray(json, "merchant")) {
                merchants.add(resolveIdentifier(merchant.getAsString()));
            }
            if (merchants.isEmpty()) {
                throw new IllegalArgumentException("merchant list must not be empty");
            }
            return List.copyOf(merchants);
        }
        return List.of(resolveIdentifier(JsonHelper.getString(json, "merchant")));
    }

    private static Identifier resolveIdentifier(String raw) {
        Identifier id = Identifier.tryParse(raw);
        if (id == null) {
            throw new IllegalArgumentException("'" + raw + "' is not a valid id");
        }
        return id;
    }

    private static Item resolveItem(String raw) {
        Identifier id = Identifier.tryParse(raw);
        if (id == null) {
            throw new IllegalArgumentException("'" + raw + "' is not a valid item id");
        }
        return Registries.ITEM
                .getOrEmpty(id)
                .orElseThrow(() -> new IllegalArgumentException("unknown item '" + raw + "'"));
    }
}
