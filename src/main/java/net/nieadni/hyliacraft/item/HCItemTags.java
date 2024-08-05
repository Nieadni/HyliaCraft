package net.nieadni.hyliacraft.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import net.nieadni.hyliacraft.HyliaCraft;

public class HCItemTags {

    public static final TagKey<Item> ENDERMASK = TagKey.of(RegistryKeys.ITEM, new Identifier(HyliaCraft.MOD_ID, "endermask"));

    public static void registerHCItemTags() {
        HyliaCraft.LOGGER.info("HyliaCraft has registered its item tags.");
    }
}