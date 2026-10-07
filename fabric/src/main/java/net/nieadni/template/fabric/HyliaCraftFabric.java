package io.github.manasmods.template.fabric;

import io.github.manasmods.template.HyliaCraft;
import net.fabricmc.api.ModInitializer;

public final class HyliaCraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        HyliaCraft.init();
    }
}
