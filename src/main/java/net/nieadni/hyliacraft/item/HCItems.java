package net.nieadni.hyliacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.custom.GoddessSwordItem;
import net.nieadni.hyliacraft.item.custom.PumpkinSoupItem;
import net.nieadni.hyliacraft.item.materials.GoddessSwordMaterial;

public class HCItems extends Items {

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(HyliaCraft.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }

    /** Weapons and Tools **/

    public static final Item GODDESS_SWORD = register(new GoddessSwordItem(GoddessSwordMaterial.INSTANCE, new Item.Settings().attributeModifiers(GoddessSwordItem.createAttributeModifiers(GoddessSwordMaterial.INSTANCE,0, -2.4F)).fireproof().rarity(Rarity.UNCOMMON)),"goddess_sword");

    /** Consumables **/

    public static final Item PUMPKIN_SOUP = register(new PumpkinSoupItem(new Item.Settings().food(HCFoodComponents.PUMPKIN_SOUP).maxCount(1)), "pumpkin_soup");


    public static void registerHCItems() {
        HyliaCraft.LOGGER.info("Registering Mod Items for " + HyliaCraft.MOD_ID);
    }
    public static void initialize() {
    }
}
