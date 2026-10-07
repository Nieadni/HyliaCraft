package net.nieadni.hyliacraft.item;

import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;

/** Custom data components for HyliaCraft. */
public class HCDataComponents {

    /**
     * Rupees held in a Rupee Pouch. Lives on the stack, so the balance belongs to the pouch and survives
     * dropping or being stored. Range-checked at the codec, so a corrupted stack cannot carry a negative
     * or over-cap balance into the game.
     */
    public static final ComponentType<Integer> RUPEES = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(HyliaCraft.MOD_ID, "rupees"),
            ComponentType.<Integer>builder()
                    .codec(Codecs.rangedInt(0, RupeePouchItem.MAX_BALANCE))
                    .packetCodec(PacketCodecs.VAR_INT)
                    .build());

    public static void registerHCDataComponents() {
        HyliaCraft.LOGGER.info("Registering Data Components for " + HyliaCraft.MOD_ID);
    }
}
