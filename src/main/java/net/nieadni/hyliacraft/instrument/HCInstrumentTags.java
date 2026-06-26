package net.nieadni.hyliacraft.instrument;

import net.minecraft.item.Instrument;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCInstrumentTags {

    public static final TagKey<Instrument> BOKOBLIN_HORNS = TagKey.of(RegistryKeys.INSTRUMENT, new Identifier(HyliaCraft.MOD_ID, "bokoblin_horns"));

    public static void registerHCInstrumentTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its Instrument tags.");
    }
}
