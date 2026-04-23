package net.nieadni.hyliacraft.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.*;
import net.nieadni.hyliacraft.item.custom.*;
import net.nieadni.hyliacraft.item.custom.consumables.*;

public class HCItems extends Items {

    public static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Identifier.of(HyliaCraft.MOD_ID, id), item);
    }

    /** Weapons and Tools **/

    // Equipment
    public static final Item MAJORAS_MASK = register(new MajorasMaskItem(HCArmourMaterials.MAJORAS_MASK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.MAJORAS_MASK_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "majoras_mask");
    public static final Item MIDNA_HELM = register(new MidnaHelmItem(HCArmourMaterials.MIDNA_HELM, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.MIDNA_HELM_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.EPIC)), "midna_helm");
    public static final Item PUMPKIN_MASK = register(new PumpkinMaskItem(HCArmourMaterials.PUMPKIN_MASK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.PUMPKIN_MASK_DURABILITY_MULTIPLIER)).fireproof().rarity(Rarity.UNCOMMON)), "pumpkin_mask");
    public static final Item BUNNY_HOOD = register(new BunnyHoodItem(HCArmourMaterials.BUNNY_HOOD, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.BUNNY_HOOD_DURABILITY_MULTIPLIER))), "bunny_hood");

    public static final Item FIERCE_CAP = register(new FierceArmorItem(HCArmourMaterials.FIERCE_ARMOR, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.FIERCE_ARMOR_DURABILITY_MULTIPLIER))), "fierce_cap");
    public static final Item FIERCE_TUNIC = register(new FierceArmorItem(HCArmourMaterials.FIERCE_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.FIERCE_ARMOR_DURABILITY_MULTIPLIER))), "fierce_tunic");
    public static final Item FIERCE_TROUSERS = register(new FierceArmorItem(HCArmourMaterials.FIERCE_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.FIERCE_ARMOR_DURABILITY_MULTIPLIER))), "fierce_trousers");
    public static final Item FIERCE_BOOTS = register(new FierceArmorItem(HCArmourMaterials.FIERCE_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.FIERCE_ARMOR_DURABILITY_MULTIPLIER))), "fierce_boots");
    public static final Item HERO_CAP = register(new HeroClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "hero_cap");
    public static final Item HERO_TUNIC = register(new HeroClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "hero_tunic");
    public static final Item HERO_TROUSERS = register(new HeroClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "hero_trousers");
    public static final Item HERO_BOOTS = register(new HeroClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "hero_boots");
    public static final Item SKY_CAP = register(new SkyClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "sky_cap");
    public static final Item SKY_TUNIC = register(new SkyClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "sky_tunic");
    public static final Item SKY_TROUSERS = register(new SkyClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "sky_trousers");
    public static final Item SKY_BOOTS = register(new SkyClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "sky_boots");
    public static final Item TIME_CAP = register(new TimeClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "time_cap");
    public static final Item TIME_TUNIC = register(new TimeClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "time_tunic");
    public static final Item TIME_TROUSERS = register(new TimeClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "time_trousers");
    public static final Item TIME_BOOTS = register(new TimeClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "time_boots");
    public static final Item TWILIGHT_CAP = register(new TwilightClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "twilight_cap");
    public static final Item TWILIGHT_TUNIC = register(new TwilightClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "twilight_tunic");
    public static final Item TWILIGHT_TROUSERS = register(new TwilightClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "twilight_trousers");
    public static final Item TWILIGHT_BOOTS = register(new TwilightClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "twilight_boots");
    public static final Item WILD_CAP = register(new WildClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wild_cap");
    public static final Item WILD_TUNIC = register(new WildClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wild_tunic");
    public static final Item WILD_TROUSERS = register(new WildClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wild_trousers");
    public static final Item WILD_BOOTS = register(new WildClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wild_boots");
    public static final Item WIND_CAP = register(new WindClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wind_cap");
    public static final Item WIND_TUNIC = register(new WindClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wind_tunic");
    public static final Item WIND_TROUSERS = register(new WindClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wind_trousers");
    public static final Item WIND_BOOTS = register(new WindClothingItem(HCArmourMaterials.HEROES_ClOTHES, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(HCArmourMaterials.HEROES_ClOTHES_DURABILITY_MULTIPLIER))), "wind_boots");


    public static final Item FIRESHIELD_EARRING = register(new FireshieldEarringItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)),"fireshield_earring");
    public static final Item WATER_DRAGON_SCALE = register(new WaterDragonScaleItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)),"water_dragon_scale");
    public static final Item SHADOW_CRYSTAL = register(new ShadowCrystalItem(new Item.Settings().rarity(Rarity.RARE).maxCount(1)),"shadow_crystal");

    // Ranged Weapons
    public static final Item SLINGSHOT = register(new SlingshotItem(new Item.Settings().maxCount(1)),"slingshot");
    public static final Item IRON_BOW = register(new IronBowItem((new Item.Settings().maxDamage(576))),"iron_bow");
    public static final Item FAIRY_BOW = register(new FairyBowItem((new Item.Settings().maxDamage(385))),"fairy_bow");
    public static final Item BOOMERANG = register(new BoomerangItem(new Item.Settings().maxCount(1)),"boomerang");
    //public static final Item GALE_BOOMERANG = register(new BoomerangItem(new Item.Settings().maxCount(1)),"gale_boomerang");

    // Melee Weapons
    public static final Item GODDESS_SWORD = register(new GoddessSwordItem(),"goddess_sword");
    public static final Item GODDESS_LONGSWORD = register(new GoddessLongswordItem(),"goddess_longsword");
    public static final Item GODDESS_WHITE_SWORD = register(new GoddessWhiteSwordItem(),"goddess_white_sword");
    public static final Item MASTER_SWORD = register(new MasterSwordItem(),"master_sword");
    public static final Item TRUE_MASTER_SWORD = register(new TrueMasterSwordItem(),"true_master_sword");

    public static final Item BOULDER_BREAKER = register(new BoulderBreakerItem(),"boulder_breaker");
    public static final Item DOUBLE_HELIX_SWORD = register(new DoubleHelixSwordItem(),"double_helix_sword");
    public static final Item ONE_HIT_OBLITERATOR = register(new OneHitObliteratorItem(),"one_hit_obliterator");

    // Tools
    public static final Item DIGGING_MITT = register(new DiggingMittItem(),"digging_mitt");
    public static final Item MOGMA_MITT = register(new MogmaMittItem(),"mogma_mitt");
    public static final Item VICIOUS_SICKLE = register(new SickleToolItem(),"vicious_sickle");

    // Misc Gear
    public static final Item HORSE_CALL = register(new HorseCallItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)),"horse_call");
    public static final Item PARAGLIDER = register(new ParagliderItem(new Item.Settings().maxCount(1).maxDamage(0)),"paraglider");

    // Consumables
    public static final Item BANANA = register(new Item(new Item.Settings().food(HCFoodComponents.BANANA).maxCount(64)), "banana");
    public static final Item PUMPKIN_SOUP = register(new PumpkinSoupItem(new Item.Settings().food(HCFoodComponents.PUMPKIN_SOUP).recipeRemainder(GLASS_BOTTLE).maxCount(1)), "pumpkin_soup");
    public static final Item GOAT_MILK_BUCKET = register(new GoatMilkBucketItem(new Item.Settings().recipeRemainder(BUCKET).maxCount(1)), "goat_milk_bucket");
    public static final Item GOAT_CHEESE = register(new Item(new Item.Settings().food(HCFoodComponents.GOAT_CHEESE).maxCount(16)), "goat_cheese");
    public static final Item SIMPLE_SOUP = register(new SimpleSoupItem(new Item.Settings().food(HCFoodComponents.SIMPLE_SOUP).recipeRemainder(GLASS_BOTTLE).maxCount(1)), "simple_soup");
    public static final Item GOOD_SOUP = register(new GoodSoupItem(new Item.Settings().food(HCFoodComponents.GOOD_SOUP).recipeRemainder(GLASS_BOTTLE).maxCount(1)), "good_soup");
    public static final Item SUPERB_SOUP = register(new SuperbSoupItem(new Item.Settings().food(HCFoodComponents.SUPERB_SOUP).recipeRemainder(GLASS_BOTTLE).maxCount(1)), "superb_soup");
    public static final Item DUBIOUS_FOOD = register(new DubiousFoodItem(new Item.Settings().food(HCFoodComponents.DUBIOUS_FOOD)), "dubious_food");

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

    public static final Item GORON_SPICE = register(new Item(new Item.Settings().maxCount(16)),"goron_spice");
    //public static final Item FAIRY_BOTTLE = register(new FairyBottleItem(new Item.Settings().maxCount(1)),"fairy_bottle");



    public static void registerHCItems() {
        HyliaCraft.LOGGER.info("Registering Mod Items for " + HyliaCraft.MOD_ID);
    }
}