package net.nieadni.hyliacraft.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.shop.ShopEntry;

/** Container screens for HyliaCraft. The Rupee Pouch is the first, so this is where any others belong. */
public class HCScreenHandlers {

    public static final ScreenHandlerType<RupeePouchScreenHandler> RUPEE_POUCH = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(HyliaCraft.MOD_ID, "rupee_pouch"),
            new ScreenHandlerType<>(RupeePouchScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    /**
     * The salesman's shop.
     *
     * <p>Extended rather than plain because the row list has to be sent when the screen opens: prices come
     * from server-side datapacks, which clients never receive.
     */
    public static final ScreenHandlerType<ShopScreenHandler> SHOP = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(HyliaCraft.MOD_ID, "shop"),
            new ExtendedScreenHandlerType<>(
                    (syncId, inventory, entries) -> new ShopScreenHandler(syncId, inventory, entries),
                    ShopEntry.LIST_PACKET_CODEC));

    public static void registerHCScreenHandlers() {
        HyliaCraft.LOGGER.info("Registering Screen Handlers for " + HyliaCraft.MOD_ID);
    }
}
