package net.nieadni.hyliacraft.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

/** Container screens for HyliaCraft. The Rupee Pouch is the first, so this is where any others belong. */
public class HCScreenHandlers {

    public static final ScreenHandlerType<RupeePouchScreenHandler> RUPEE_POUCH = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(HyliaCraft.MOD_ID, "rupee_pouch"),
            new ScreenHandlerType<>(RupeePouchScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    public static void registerHCScreenHandlers() {
        HyliaCraft.LOGGER.info("Registering Screen Handlers for " + HyliaCraft.MOD_ID);
    }
}
