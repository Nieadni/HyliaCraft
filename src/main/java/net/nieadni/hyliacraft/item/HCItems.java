package net.nieadni.hyliacraft.item;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.*;
import net.nieadni.hyliacraft.item.custom.*;

public class HCItems extends Items {

    public static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Identifier.of(HyliaCraft.MOD_ID, id), item);
    }

    /** Weapons and Tools **/

    // Equipment
    public static final Item MAJORAS_MASK = register(new MajorasMaskItem(HCArmourMaterials.MAJORAS_MASK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.MAJORAS_MASK_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "majoras_mask");
    public static final Item PUMPKIN_MASK = register(new PumpkinMaskItem(HCArmourMaterials.PUMPKIN_MASK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.PUMPKIN_MASK_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.UNCOMMON)), "pumpkin_mask");
    public static final Item PHRYGIAN_CAP_SS = register(new PhrygianCapSSItem(HCArmourMaterials.PHRYGIAN_CAP, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.PHRYGIAN_CAP_DURABILITY_MULTIPLIER))), "phrygian_cap_ss");
    public static final Item PHRYGIAN_CAP_TP = register(new PhrygianCapTPItem(HCArmourMaterials.PHRYGIAN_CAP, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.PHRYGIAN_CAP_DURABILITY_MULTIPLIER))), "phrygian_cap_tp");
    public static final Item PHRYGIAN_CAP_CLASSIC = register(new PhrygianCapClassicItem(HCArmourMaterials.PHRYGIAN_CAP, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.PHRYGIAN_CAP_DURABILITY_MULTIPLIER))), "phrygian_cap_classic");
    public static final Item FIRESHIELD_EARRING = register(new FireshieldEarringItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)),"fireshield_earring");
    public static final Item WATER_DRAGON_SCALE = register(new WaterDragonScaleItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)),"water_dragon_scale");
    public static final Item SHADOW_CRYSTAL = register(new ShadowCrystalItem(new Item.Settings().rarity(Rarity.RARE).maxCount(1)),"shadow_crystal");

    // Ranged Weapons
    public static final Item SLINGSHOT = register(new SlingshotItem(new Item.Settings().maxCount(1)),"slingshot");
    public static final Item IRON_BOW = register(new IronBowItem((new Item.Settings().maxDamage(576))),"iron_bow");
    public static final Item FAIRY_BOW = register(new FairyBowItem((new Item.Settings().maxDamage(385))),"fairy_bow");
    public static final Item BOOMERANG = register(new BoomerangItem(new Item.Settings().maxCount(1)),"boomerang");
    public static final Item GALE_BOOMERANG = register(new BoomerangItem(new Item.Settings().maxCount(1)),"gale_boomerang");

    // Melee Weapons
    public static final Item GODDESS_SWORD = register(new GoddessSwordItem(),"goddess_sword");
    public static final Item GODDESS_LONGSWORD = register(new GoddessLongswordItem(),"goddess_longsword");
    public static final Item GODDESS_WHITE_SWORD = register(new GoddessWhiteSwordItem(),"goddess_white_sword");
    public static final Item MASTER_SWORD = register(new MasterSwordItem(),"master_sword");
    public static final Item TRUE_MASTER_SWORD = register(new TrueMasterSwordItem(),"true_master_sword");

    // Tools
    public static final Item DIGGING_MITT = register(new DiggingMittItem(),"digging_mitt");
    public static final Item MOGMA_MITT = register(new MogmaMittItem(),"mogma_mitt");

    // Misc Gear
    public static final Item HORSE_CALL = register(new HorseCallItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)),"horse_call");
    public static final Item PARAGLIDER = register(new ParagliderItem(new Item.Settings().maxCount(1).maxDamage(0)),"paraglider");

    // Consumables
    public static final Item PUMPKIN_SOUP = register(new PumpkinSoupItem(new Item.Settings().food(HCFoodComponents.PUMPKIN_SOUP).maxCount(1)), "pumpkin_soup");

    // Rupees
    public static final Item RUPEE_POUCH = register(new RupeePouchItem(new Item.Settings().maxCount(1)),"rupee_pouch");
    public static final Item GREEN_RUPEE = register(new RupeeItem("tooltip.green_rupee"), "green_rupee");
    public static final Item BLUE_RUPEE = register(new RupeeItem("tooltip.blue_rupee"), "blue_rupee");
    public static final Item YELLOW_RUPEE = register(new RupeeItem("tooltip.yellow_rupee"), "yellow_rupee");
    public static final Item RED_RUPEE = register(new RupeeItem("tooltip.red_rupee"), "red_rupee");
    public static final Item PURPLE_RUPEE = register(new RupeeItem("tooltip.purple_rupee"), "purple_rupee");
    public static final Item ORANGE_RUPEE = register(new RupeeItem("tooltip.orange_rupee"), "orange_rupee");
    public static final Item SILVER_RUPEE = register(new RupeeItem("tooltip.silver_rupee"), "silver_rupee");
    public static final Item GOLD_RUPEE = register(new RupeeItem("tooltip.gold_rupee"), "gold_rupee");

    // Misc
    public static final Item NAYRU_FLAME = register(new Item(new Item.Settings().maxCount(1)),"nayru_flame");
    public static final Item DIN_FLAME = register(new Item(new Item.Settings().maxCount(1)),"din_flame");
    public static final Item FARORE_FLAME = register(new Item(new Item.Settings().maxCount(1)),"farore_flame");


    public static void registerHCItems() {
        HyliaCraft.LOGGER.info("Registering Mod Items for " + HyliaCraft.MOD_ID);
    }
}