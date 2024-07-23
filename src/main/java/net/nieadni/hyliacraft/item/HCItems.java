package net.nieadni.hyliacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.custom.*;
import net.nieadni.hyliacraft.item.materials.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HCItems extends Items {

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(HyliaCraft.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }

    /** Weapons and Tools **/

    public static final Item GODDESS_SWORD = register(new GoddessSwordItem(GoddessSwordMaterial.INSTANCE, new Item.Settings().attributeModifiers(GoddessSwordItem.createAttributeModifiers(GoddessSwordMaterial.INSTANCE,1, -2.4F)).fireproof().rarity(Rarity.RARE)),"goddess_sword");
    public static final Item GODDESS_LONGSWORD = register(new GoddessLongswordItem(GoddessLongswordMaterial.INSTANCE, new Item.Settings().attributeModifiers(GoddessLongswordItem.createAttributeModifiers(GoddessLongswordMaterial.INSTANCE,1, -2.4F)).fireproof().rarity(Rarity.RARE)),"goddess_longsword");
    public static final Item GODDESS_WHITE_SWORD = register(new GoddessWhiteSwordItem(GoddessWhiteSwordMaterial.INSTANCE, new Item.Settings().attributeModifiers(GoddessWhiteSwordItem.createAttributeModifiers(GoddessWhiteSwordMaterial.INSTANCE,1, -2.4F)).fireproof().rarity(Rarity.RARE)),"goddess_white_sword");
    public static final Item MASTER_SWORD = register(new MasterSwordItem(MasterSwordMaterial.INSTANCE, new Item.Settings().attributeModifiers(MasterSwordItem.createAttributeModifiers(MasterSwordMaterial.INSTANCE,1, -2.4F)).fireproof().rarity(Rarity.EPIC)),"master_sword");
    public static final Item TRUE_MASTER_SWORD = register(new TrueMasterSwordItem(TrueMasterSwordMaterial.INSTANCE, new Item.Settings().attributeModifiers(TrueMasterSwordItem.createAttributeModifiers(TrueMasterSwordMaterial.INSTANCE,1, -2.4F)).fireproof().rarity(Rarity.EPIC)),"true_master_sword");

    public static final Item DIGGING_MITT = register(new ShovelItem(DiggingMittMaterial.INSTANCE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(DiggingMittMaterial.INSTANCE,1,-3.0F))),"digging_mitt");

    /** Consumables **/

    public static final Item PUMPKIN_SOUP = register(new PumpkinSoupItem(new Item.Settings().food(HCFoodComponents.PUMPKIN_SOUP).maxCount(1)), "pumpkin_soup");

    /** Misc Items **/

    public static final Item GREEN_RUPEE = register(new RupeeItem("tooltip.green_rupee"), "green_rupee");
    public static final Item BLUE_RUPEE = register(new RupeeItem("tooltip.blue_rupee"), "blue_rupee");
    public static final Item YELLOW_RUPEE = register(new RupeeItem("tooltip.yellow_rupee"), "yellow_rupee");
    public static final Item RED_RUPEE = register(new RupeeItem("tooltip.red_rupee"), "red_rupee");
    public static final Item PURPLE_RUPEE = register(new RupeeItem("tooltip.purple_rupee"), "purple_rupee");
    public static final Item ORANGE_RUPEE = register(new RupeeItem("tooltip.orange_rupee"), "orange_rupee");
    public static final Item SILVER_RUPEE = register(new RupeeItem("tooltip.silver_rupee"), "silver_rupee");
    public static final Item GOLD_RUPEE = register(new RupeeItem("tooltip.gold_rupee"), "gold_rupee");


    public static void registerHCItems() {
        HyliaCraft.LOGGER.info("Registering Mod Items for " + HyliaCraft.MOD_ID);
    }
    public static void initialize() {
    }
}
