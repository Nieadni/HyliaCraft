package net.nieadni.hyliacraft.item;

import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.custom.RupeePouchItem;

/**
 * Custom data components for HyliaCraft.
 *
 * <p>Components live on the {@link net.minecraft.item.ItemStack}, not on the player, so a balance travels
 * with the pouch that holds it. That is what lets a player carry several pouches, each with its own money,
 * and have them survive dropping, trading and being stored in a shulker box without any extra work.
 */
public class HCDataComponents {

    /**
     * Rupees held in a Rupee Pouch.
     *
     * <p>Range-checked at the codec, so a hand-edited or corrupted stack cannot carry a negative or
     * over-cap balance into the game.
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
