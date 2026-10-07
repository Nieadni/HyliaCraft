package io.github.manasmods.template.neoforge;

import net.neoforged.fml.common.Mod;

import io.github.manasmods.template.HyliaCraft;

@Mod(HyliaCraft.MOD_ID)
public final class HyliaCraftNeoForge {
    public HyliaCraftNeoForge() {
        HyliaCraft.init();
    }
}
