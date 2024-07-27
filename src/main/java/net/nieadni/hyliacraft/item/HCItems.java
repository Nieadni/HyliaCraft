package net.nieadni.hyliacraft.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import net.nieadni.hyliacraft.item.custom.*;
import net.nieadni.hyliacraft.item.materials.*;

public class HCItems extends Items {

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(HyliaCraft.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }

    /** Weapons and Tools **/

    public static final Item MAJORAS_MASK = register(new MajorasMaskItem(HCArmourMaterials.MAJORAS_MASK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.MAJORAS_MASK_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "majoras_mask");
    // Pumpkin Mask

    // Slingshot
    public static final Item IRON_BOW = register(new IronBowItem((new Item.Settings().maxDamage(576))),"iron_bow");
    // Boomerang
    // Gale Boomerang
    public static final Item GODDESS_SWORD = register(new GoddessSwordItem(),"goddess_sword");
    public static final Item GODDESS_LONGSWORD = register(new GoddessLongswordItem(),"goddess_longsword");
    public static final Item GODDESS_WHITE_SWORD = register(new GoddessWhiteSwordItem(),"goddess_white_sword");
    public static final Item MASTER_SWORD = register(new MasterSwordItem(),"master_sword");
    public static final Item TRUE_MASTER_SWORD = register(new TrueMasterSwordItem(),"true_master_sword");
    public static final Item DIGGING_MITT = register(new ShovelItem(DiggingMittMaterial.INSTANCE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(DiggingMittMaterial.INSTANCE,1,-3.0F))),"digging_mitt");

    // Paraglider
    public static final Item PARAGLIDER = register(new ParagliderItem(new Item.Settings().maxCount(1).maxDamage(0)),"paraglider");

    /** Consumables **/

    public static final Item PUMPKIN_SOUP = register(new PumpkinSoupItem(new Item.Settings().food(HCFoodComponents.PUMPKIN_SOUP).maxCount(1)), "pumpkin_soup");

    /** Misc Items **/

    // Rupee Pouch
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
