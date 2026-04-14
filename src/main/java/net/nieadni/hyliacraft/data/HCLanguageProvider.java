package net.nieadni.hyliacraft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.item.HCItems;

import java.util.concurrent.CompletableFuture;

public class HCLanguageProvider extends FabricLanguageProvider {

    protected HCLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        /** ITEMS **/
        translationBuilder.add(HCItems.MAJORAS_MASK, "Majoras Mask");
        translationBuilder.add("tooltip.hyliacraft.majoras_mask1", "An eerie mask passed down from ancient times.");
        translationBuilder.add("tooltip.hyliacraft.majoras_mask2", "Wearing it makes it harder for certain enemies to spot you.");
        translationBuilder.add(HCItems.MIDNA_HELM, "Midna's Helm");
        translationBuilder.add("tooltip.hyliacraft.midna_helm", "A helmet much like the one Midna wore when she fought alongside the Hero of Twilight.");
        translationBuilder.add(HCItems.PUMPKIN_MASK, "Pumpkin Mask");
        translationBuilder.add(HCItems.PHRYGIAN_CAP, "Phrygian Cap");
        translationBuilder.add(HCItems.PHRYGIAN_CAP_SS, "Phrygian Cap");
        translationBuilder.add("tooltip.hyliacraft.phrygian_cap_ss", "A Green Phrygian Cap worn by the Hero of the Sky");
        translationBuilder.add(HCItems.PHRYGIAN_CAP_TP, "Phrygian Cap");
        translationBuilder.add("tooltip.hyliacraft.phrygian_cap_tp", "A Green Phrygian Cap worn by the Hero of Twilight");
        translationBuilder.add(HCItems.PHRYGIAN_CAP_CLASSIC, "Phrygian Cap");
        translationBuilder.add("tooltip.hyliacraft.phrygian_cap_classic", "A Green and Yellow Phrygian Cap worn by the Hero of Legend");
        translationBuilder.add(HCItems.BUNNY_HOOD, "Bunny Hood");
        translationBuilder.add(HCItems.FIRESHIELD_EARRING, "§cFireshield Earring");
        translationBuilder.add(HCItems.WATER_DRAGON_SCALE, "§1Water Dragon's Scale");
        translationBuilder.add(HCItems.SHADOW_CRYSTAL, "§5Shadow Crystal");

        translationBuilder.add(HCItems.GODDESS_SWORD, "Goddess Sword");
        translationBuilder.add("tooltip.hyliacraft.goddess_sword_0", "Seek out the sacred flame of §aFarore§r to purify and upgrade your sword!");
        translationBuilder.add(HCItems.GODDESS_LONGSWORD, "Goddess Longsword");
        translationBuilder.add("tooltip.hyliacraft.goddess_longsword_0", "§aThe flames of Farore have improved your sword, making it longer and sharp enough to do twice as much damage!");
        translationBuilder.add("tooltip.hyliacraft.goddess_longsword_1", "Seek out the sacred flame of §9Nayru§r to purify and upgrade your sword!");
        translationBuilder.add(HCItems.GODDESS_WHITE_SWORD, "Goddess White Sword");
        translationBuilder.add("tooltip.hyliacraft.goddess_white_sword_0", "§9The flames of Nayru have transformed your blade!");
        translationBuilder.add("tooltip.hyliacraft.goddess_white_sword_1", "Seek out the sacred flame of §cDin§r to purify and upgrade your sword!");
        translationBuilder.add(HCItems.MASTER_SWORD, "Master Sword");
        translationBuilder.add("tooltip.hyliacraft.master_sword_0", "§cThe flames of Din have imbued your blade with a sacred white light that demons revile!");
        translationBuilder.add(HCItems.TRUE_MASTER_SWORD, "True Master Sword");
        translationBuilder.add("tooltip.hyliacraft.true_master_sword_0", "The goddess has blessed your blade, and the Master Sword has at last achieved its ultimate form! The sword is now imbued with the mythical power to drive back demons!");
        translationBuilder.add(HCItems.BOULDER_BREAKER, "Boulder Breaker");
        translationBuilder.add("tooltip.hyliacraft.boulder_breaker", "This two-handed weapon was once wielded by a Goron Champion. A Hylian would need an immense amount of strength to wield it!");
        translationBuilder.add(HCItems.DOUBLE_HELIX_SWORD, "Double Helix Sword");
        translationBuilder.add("tooltip.hyliacraft.double_helix_sword", "A peculiar greatsword allegedly used by a hero from a world in which the moon threatened to fall. It slashes wildly in battle as if possessed by a fierce deity.");
        translationBuilder.add(HCItems.ONE_HIT_OBLITERATOR, "One-Hit Obliterator");
        translationBuilder.add("tooltip.hyliacraft.one_hit_obliterator_0", "To undertake this task requires unwavering dedication. That weapon defeats foes with one hit.");
        translationBuilder.add("tooltip.hyliacraft.one_hit_obliterator_1", "However, the reverse is also true, as its wielder will also fall to a single strike.");

        translationBuilder.add("tooltip.hyliacraft.rare_item", "It's a rather rare find.");



        translationBuilder.add(HCItems.IRON_BOW, "Iron Bow");
        translationBuilder.add(HCItems.FAIRY_BOW, "Fairy Bow");
        translationBuilder.add(HCItems.SLINGSHOT, "Slingshot");
        translationBuilder.add(HCItems.BOOMERANG, "Boomerang");
        //translationBuilder.add(HCItems.GALE_BOOMERANG, "Gale Boomerang");

        translationBuilder.add(HCItems.DIGGING_MITT, "Digging Mitt");
        translationBuilder.add("tooltip.hyliacraft.digging_mitt", "§6Use these sharp claws to dig through patches of soft earth!");
        translationBuilder.add(HCItems.MOGMA_MITT, "Mogma Mitt");
        translationBuilder.add("tooltip.hyliacraft.mogma_mitt", "§6Use these sharp claws to dig through patches of stone and earth!");
        translationBuilder.add(HCItems.VICIOUS_SICKLE, "§cVicious Sickle");
        translationBuilder.add(HCItems.PARAGLIDER, "Paraglider");
        translationBuilder.add(HCItems.HORSE_CALL, "Horse Call");

        translationBuilder.add(HCItems.BANANA, "Banana");
        translationBuilder.add(HCItems.PUMPKIN_SOUP, "Pumpkin Soup");
        translationBuilder.add("tooltip.hyliacraft.pumpkin_soup","Popular in Skyloft for its nutrient content and revitalising properties");
        translationBuilder.add(HCItems.GOAT_MILK_BUCKET, "Goat Milk Bucket");
        translationBuilder.add(HCItems.GOAT_CHEESE, "Goat Cheese");
        translationBuilder.add(HCItems.SIMPLE_SOUP, "Simple Soup");
        translationBuilder.add(HCItems.GOOD_SOUP, "Good Soup");
        translationBuilder.add(HCItems.SUPERB_SOUP, "Superb Soup");
        translationBuilder.add(HCItems.DUBIOUS_FOOD, "Dubious Food");
        translationBuilder.add("tooltip.hyliacraft.dubious_food", "You.. probably shouldn't eat this..");

        translationBuilder.add(HCItems.RUPEE_POUCH, "Rupee Pouch");
        translationBuilder.add(HCItems.GREEN_RUPEE, "Green Rupee");
        translationBuilder.add("tooltip.green_rupee", "Worth 1 Rupee");
        translationBuilder.add(HCItems.BLUE_RUPEE, "Blue Rupee");
        translationBuilder.add("tooltip.blue_rupee", "Worth 5 Rupees");
        translationBuilder.add(HCItems.YELLOW_RUPEE, "Yellow Rupee");
        translationBuilder.add("tooltip.yellow_rupee", "Worth 10 Rupees");
        translationBuilder.add(HCItems.RED_RUPEE, "Red Rupee");
        translationBuilder.add("tooltip.red_rupee", "Worth 20 Rupees");
        translationBuilder.add(HCItems.PURPLE_RUPEE, "Purple Rupee");
        translationBuilder.add("tooltip.purple_rupee", "Worth 50 Rupees");
        translationBuilder.add(HCItems.ORANGE_RUPEE, "Orange Rupee");
        translationBuilder.add("tooltip.orange_rupee", "Worth 100 Rupees");
        translationBuilder.add(HCItems.SILVER_RUPEE, "Silver Rupee");
        translationBuilder.add("tooltip.silver_rupee", "Worth 200 Rupees");
        translationBuilder.add(HCItems.GOLD_RUPEE, "Gold Rupee");
        translationBuilder.add("tooltip.gold_rupee", "Worth 300 Rupees");

        translationBuilder.add(HCItems.NAYRU_FLAME, "§9Nayru's Flame");
        translationBuilder.add(HCItems.DIN_FLAME, "§cDin's Flame");
        translationBuilder.add(HCItems.FARORE_FLAME, "§aFarore's Flame");

        translationBuilder.add(HCItems.GORON_SPICE, "Goron Spice");
        //translationBuilder.add(HCItems.FAIRY_BOTTLE, "Fairy in a Bottle");

        /** BLOCKS **/

        translationBuilder.add(HCBlocks.CLAY_POT, "Clay Pot");
        translationBuilder.add(HCBlocks.NATURAL_CLAY_POT, "Natural Clay Pot");
        translationBuilder.add(HCBlocks.CLAY_POT_WRITING, "Clay Pot with Writing");
        translationBuilder.add(HCBlocks.NATURAL_CLAY_POT_WRITING, "Natural Clay Pot with Writing");
        translationBuilder.add(HCBlocks.BLUE_CLAY_POT, "Blue Clay Pot");
        translationBuilder.add(HCBlocks.NATURAL_BLUE_CLAY_POT, "Natural Blue Clay Pot");
        translationBuilder.add(HCBlocks.HATENO_CLAY_POT, "Hateno Clay Pot");

        translationBuilder.add(HCBlocks.ARMORANTH, "Armoranth");
        translationBuilder.add(HCBlocks.BLUE_NIGHTSHADE, "Blue Nightshade");
        translationBuilder.add(HCBlocks.SILENT_PRINCESS, "Silent Princess");
        translationBuilder.add(HCBlocks.SWIFT_VIOLETS, "Swift Violets");

        translationBuilder.add(HCBlocks.IRON_CHEST, "Iron Chest");

        /** Entities **/

        translationBuilder.add(HCEntities.GODDESS_SWORD_BEAM, "Goddess Sword Beam");
        translationBuilder.add(HCEntities.GODDESS_LONGSWORD_BEAM, "Goddess Longsword Beam");
        translationBuilder.add(HCEntities.GODDESS_WHITE_SWORD_BEAM, "Goddess White Sword Beam");
        translationBuilder.add(HCEntities.MASTER_SWORD_BEAM, "Master Sword Beam");
        translationBuilder.add(HCEntities.TRUE_MASTER_SWORD_BEAM, "True Master Sword Beam");

        /** Paintings **/

        translationBuilder.add("painting.hyliacraft.breath_of_the_wild.author", "Hidemaro Fujibayashi & Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.breath_of_the_wild.title", "Breath of the Wild / 2017");
        translationBuilder.add("painting.hyliacraft.excuse_me_princess.author", "The Legend of Zelda Animated Cartoon 1989");
        translationBuilder.add("painting.hyliacraft.excuse_me_princess.title", "Well excuuuse me Princess!");
        translationBuilder.add("painting.hyliacraft.link_between_worlds.author", "Hiromasa Shikata & Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.link_between_worlds.title", "A Link between Worlds / 2013");
        translationBuilder.add("painting.hyliacraft.majoras_mask.author", "Eiji Aonuma, Yoshiaki Koizumi & Shigeru Miyamoto");
        translationBuilder.add("painting.hyliacraft.majoras_mask.title", "Majoras Mask / 2000 + 2015");
        translationBuilder.add("painting.hyliacraft.minish_cap.author", "Hidemaro Fujibayashi & Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.minish_cap.title", "The Minish Cap / 2004");
        translationBuilder.add("painting.hyliacraft.ocarina_of_time.author", "Shigeru Miyamoto & Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.ocarina_of_time.title", "Ocarina of Time / 1998");
        translationBuilder.add("painting.hyliacraft.phantom_hourglass.author", "Daiki Iwamoto");
        translationBuilder.add("painting.hyliacraft.phantom_hourglass.title", "Phantom Hourglass / 2007");
        translationBuilder.add("painting.hyliacraft.skyward_sword.author", "Hidemaro Fujibayashi & Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.skyward_sword.title", "Skyward Sword / 2011 + 2021");
        translationBuilder.add("painting.hyliacraft.twilight_princess.author", "Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.twilight_princess.title", "Twilight Princess / 2006 + 2016");
        translationBuilder.add("painting.hyliacraft.wind_waker.author", "Eiji Aonuma");
        translationBuilder.add("painting.hyliacraft.wind_waker.title", "The Wind Waker / 2002 + 2013");

        /** Components **/

        translationBuilder.add("container.hyliacraft.iron_chest", "Iron Chest");

        translationBuilder.add("itemGroup.hyliacraft.gear", "HC Gear");
        translationBuilder.add("itemGroup.hyliacraft.blocks", "HC Blocks");
        translationBuilder.add("itemGroup.hyliacraft.coloured_blocks", "HC Coloured Blocks");
        translationBuilder.add("itemGroup.hyliacraft.consumables", "HC Consumables");
        translationBuilder.add("itemGroup.hyliacraft.misc", "HC Misc");

        translationBuilder.add("tooltip.hyliacraft.wip", "This feature has not been fully implemented so therefore it may not work fully or as intended");
        translationBuilder.add("tooltip.hyliacraft.two_handed_weapon", "§9Only usable with both hands.");

        translationBuilder.add("tooltip.hyliacraft.shift_down_info", "Hold §6SHIFT§r for more information");
        translationBuilder.add("tooltip.hyliacraft.shifted_down_info", "Hold §8SHIFT§r for more information");

        translationBuilder.add("tag.item.hyliacraft.endermask", "Endermask");
        translationBuilder.add("tag.item.hyliacraft.sickles", "Sickles");
        translationBuilder.add("tag.item.hyliacraft.short_weapon", "Short Weapons");
        translationBuilder.add("tag.item.hyliacraft.slingshot_ammo", "Slingshot Ammo");
        translationBuilder.add("tag.item.hyliacraft.milk_buckets", "Milk Buckets");
        translationBuilder.add("tag.item.hyliacraft.shingles", "Shingle Blocks");
        translationBuilder.add("tag.item.hyliacraft.shingle_stairs", "Shingle Stairs");
        translationBuilder.add("tag.item.hyliacraft.shingle_slabs", "Shingle Slabs");
        translationBuilder.add("tag.item.hyliacraft.shingle_walls", "Shingle Walls");
        translationBuilder.add("tag.item.hyliacraft.green_rupees", "Green Rupees");
        translationBuilder.add("tag.item.hyliacraft.blue_rupees", "Blue Rupees");
        translationBuilder.add("tag.item.hyliacraft.yellow_rupees", "Yellow Rupees");
        translationBuilder.add("tag.item.hyliacraft.red_rupees", "Red Rupees");
        translationBuilder.add("tag.item.hyliacraft.purple_rupees", "Purple Rupees");
        translationBuilder.add("tag.item.hyliacraft.orange_rupees", "Orange Rupees");
        translationBuilder.add("tag.item.hyliacraft.silver_rupees", "Silver Rupees");
        translationBuilder.add("tag.item.hyliacraft.gold_rupees", "Gold Rupees");



        /** Coloured Blocks **/

        translationBuilder.add(HCBlocks.WHITE_SHINGLES, "White Shingles");
        translationBuilder.add(HCBlocks.WHITE_SHINGLE_STAIRS, "White Shingle Stairs");
        translationBuilder.add(HCBlocks.WHITE_SHINGLE_SLAB, "White Shingle Slab");
        translationBuilder.add(HCBlocks.WHITE_SHINGLE_WALL, "White Shingle Wall");
        translationBuilder.add(HCBlocks.LIGHT_GRAY_SHINGLES, "Light Gray Shingles");
        translationBuilder.add(HCBlocks.LIGHT_GRAY_SHINGLE_STAIRS, "Light Gray Shingle Stairs");
        translationBuilder.add(HCBlocks.LIGHT_GRAY_SHINGLE_SLAB, "Light Gray Shingle Slab");
        translationBuilder.add(HCBlocks.LIGHT_GRAY_SHINGLE_WALL, "Light Gray Shingle Wall");
        translationBuilder.add(HCBlocks.GRAY_SHINGLES, "Gray Shingles");
        translationBuilder.add(HCBlocks.GRAY_SHINGLE_STAIRS, "Gray Shingle Stairs");
        translationBuilder.add(HCBlocks.GRAY_SHINGLE_SLAB, "Gray Shingle Slab");
        translationBuilder.add(HCBlocks.GRAY_SHINGLE_WALL, "Gray Shingle Wall");
        translationBuilder.add(HCBlocks.BLACK_SHINGLES, "Black Shingles");
        translationBuilder.add(HCBlocks.BLACK_SHINGLE_STAIRS, "Black Shingle Stairs");
        translationBuilder.add(HCBlocks.BLACK_SHINGLE_SLAB, "Black Shingle Slab");
        translationBuilder.add(HCBlocks.BLACK_SHINGLE_WALL, "Black Shingle Wall");
        translationBuilder.add(HCBlocks.BROWN_SHINGLES, "Brown Shingles");
        translationBuilder.add(HCBlocks.BROWN_SHINGLE_STAIRS, "Brown Shingle Stairs");
        translationBuilder.add(HCBlocks.BROWN_SHINGLE_SLAB, "Brown Shingle Slab");
        translationBuilder.add(HCBlocks.BROWN_SHINGLE_WALL, "Brown Shingle Wall");
        translationBuilder.add(HCBlocks.RED_SHINGLES, "Red Shingles");
        translationBuilder.add(HCBlocks.RED_SHINGLE_STAIRS, "Red Shingle Stairs");
        translationBuilder.add(HCBlocks.RED_SHINGLE_SLAB, "Red Shingle Slab");
        translationBuilder.add(HCBlocks.RED_SHINGLE_WALL, "Red Shingle Wall");
        translationBuilder.add(HCBlocks.ORANGE_SHINGLES, "Orange Shingles");
        translationBuilder.add(HCBlocks.ORANGE_SHINGLE_STAIRS, "Orange Shingle Stairs");
        translationBuilder.add(HCBlocks.ORANGE_SHINGLE_SLAB, "Orange Shingle Slab");
        translationBuilder.add(HCBlocks.ORANGE_SHINGLE_WALL, "Orange Shingle Wall");
        translationBuilder.add(HCBlocks.YELLOW_SHINGLES, "Yellow Shingles");
        translationBuilder.add(HCBlocks.YELLOW_SHINGLE_STAIRS, "Yellow Shingle Stairs");
        translationBuilder.add(HCBlocks.YELLOW_SHINGLE_SLAB, "Yellow Shingle Slab");
        translationBuilder.add(HCBlocks.YELLOW_SHINGLE_WALL, "Yellow Shingle Wall");
        translationBuilder.add(HCBlocks.LIME_SHINGLES, "Lime Shingles");
        translationBuilder.add(HCBlocks.LIME_SHINGLE_STAIRS, "Lime Shingle Stairs");
        translationBuilder.add(HCBlocks.LIME_SHINGLE_SLAB, "Lime Shingle Slab");
        translationBuilder.add(HCBlocks.LIME_SHINGLE_WALL, "Lime Shingle Wall");
        translationBuilder.add(HCBlocks.GREEN_SHINGLES, "Green Shingles");
        translationBuilder.add(HCBlocks.GREEN_SHINGLE_STAIRS, "Green Shingle Stairs");
        translationBuilder.add(HCBlocks.GREEN_SHINGLE_SLAB, "Green Shingle Slab");
        translationBuilder.add(HCBlocks.GREEN_SHINGLE_WALL, "Green Shingle Wall");
        translationBuilder.add(HCBlocks.CYAN_SHINGLES, "Cyan Shingles");
        translationBuilder.add(HCBlocks.CYAN_SHINGLE_STAIRS, "Cyan Shingle Stairs");
        translationBuilder.add(HCBlocks.CYAN_SHINGLE_SLAB, "Cyan Shingle Slab");
        translationBuilder.add(HCBlocks.CYAN_SHINGLE_WALL, "Cyan Shingle Wall");
        translationBuilder.add(HCBlocks.LIGHT_BLUE_SHINGLES, "Light Blue Shingles");
        translationBuilder.add(HCBlocks.LIGHT_BLUE_SHINGLE_STAIRS, "Light Blue Shingle Stairs");
        translationBuilder.add(HCBlocks.LIGHT_BLUE_SHINGLE_SLAB, "Light Blue Shingle Slab");
        translationBuilder.add(HCBlocks.LIGHT_BLUE_SHINGLE_WALL, "Light Blue Shingle Wall");
        translationBuilder.add(HCBlocks.BLUE_SHINGLES, "Blue Shingles");
        translationBuilder.add(HCBlocks.BLUE_SHINGLE_STAIRS, "Blue Shingle Stairs");
        translationBuilder.add(HCBlocks.BLUE_SHINGLE_SLAB, "Blue Shingle Slab");
        translationBuilder.add(HCBlocks.BLUE_SHINGLE_WALL, "Blue Shingle Wall");
        translationBuilder.add(HCBlocks.PURPLE_SHINGLES, "Purple Shingles");
        translationBuilder.add(HCBlocks.PURPLE_SHINGLE_STAIRS, "Purple Shingle Stairs");
        translationBuilder.add(HCBlocks.PURPLE_SHINGLE_SLAB, "Purple Shingle Slab");
        translationBuilder.add(HCBlocks.PURPLE_SHINGLE_WALL, "Purple Shingle Wall");
        translationBuilder.add(HCBlocks.MAGENTA_SHINGLES, "Magenta Shingles");
        translationBuilder.add(HCBlocks.MAGENTA_SHINGLE_STAIRS, "Magenta Shingle Stairs");
        translationBuilder.add(HCBlocks.MAGENTA_SHINGLE_SLAB, "Magenta Shingle Slab");
        translationBuilder.add(HCBlocks.MAGENTA_SHINGLE_WALL, "Magenta Shingle Wall");
        translationBuilder.add(HCBlocks.PINK_SHINGLES, "Pink Shingles");
        translationBuilder.add(HCBlocks.PINK_SHINGLE_STAIRS, "Pink Shingle Stairs");
        translationBuilder.add(HCBlocks.PINK_SHINGLE_SLAB, "Pink Shingle Slab");
        translationBuilder.add(HCBlocks.PINK_SHINGLE_WALL, "Pink Shingle Wall");
        
        /** Banner Stuff **/

        translationBuilder.add("block.minecraft.banner.hyliacraft.din.black", "Black Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.blue", "Blue Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.brown", "Brown Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.cyan", "Cyan Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.gray", "Gray Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.green", "Green Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.light_blue", "Light Blue Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.light_gray", "Light Gray Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.lime", "Lime Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.magenta", "Magenta Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.orange", "Orange Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.pink", "Pink Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.purple", "Purple Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.red", "Red Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.white", "White Din");
        translationBuilder.add("block.minecraft.banner.hyliacraft.din.yellow", "Yellow Din");

        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.black", "Black Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.blue", "Blue Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.brown", "Brown Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.cyan", "Cyan Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.gray", "Gray Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.green", "Green Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.light_blue", "Light Blue Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.light_gray", "Light Gray Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.lime", "Lime Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.magenta", "Magenta Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.orange", "Orange Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.pink", "Pink Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.purple", "Purple Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.red", "Red Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.white", "White Farore");
        translationBuilder.add("block.minecraft.banner.hyliacraft.farore.yellow", "Yellow Farore");

        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.black", "Black Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.blue", "Blue Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.brown", "Brown Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.cyan", "Cyan Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.gray", "Gray Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.green", "Green Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.light_blue", "Light Blue Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.light_gray", "Light Gray Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.lime", "Lime Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.magenta", "Magenta Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.orange", "Orange Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.pink", "Pink Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.purple", "Purple Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.red", "Red Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.white", "White Gerudo");
        translationBuilder.add("block.minecraft.banner.hyliacraft.gerudo.yellow", "Yellow Gerudo");

        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.black", "Black Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.blue", "Blue Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.brown", "Brown Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.cyan", "Cyan Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.gray", "Gray Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.green", "Green Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.light_blue", "Light Blue Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.light_gray", "Light Gray Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.lime", "Lime Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.magenta", "Magenta Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.orange", "Orange Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.pink", "Pink Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.purple", "Purple Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.red", "Red Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.white", "White Goron");
        translationBuilder.add("block.minecraft.banner.hyliacraft.goron.yellow", "Yellow Goron");

        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.black", "Black Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.blue", "Blue Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.brown", "Brown Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.cyan", "Cyan Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.gray", "Gray Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.green", "Green Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.light_blue", "Light Blue Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.light_gray", "Light Gray Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.lime", "Lime Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.magenta", "Magenta Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.orange", "Orange Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.pink", "Pink Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.purple", "Purple Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.red", "Red Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.white", "White Hylia");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylia.yellow", "Yellow Hylia");

        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.black", "Black Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.blue", "Blue Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.brown", "Brown Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.cyan", "Cyan Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.gray", "Gray Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.green", "Green Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.light_blue", "Light Blue Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.light_gray", "Light Gray Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.lime", "Lime Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.magenta", "Magenta Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.orange", "Orange Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.pink", "Pink Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.purple", "Purple Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.red", "Red Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.white", "White Hylian");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hylian.yellow", "Yellow Hylian");

        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.black", "Black Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.blue", "Blue Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.brown", "Brown Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.cyan", "Cyan Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.gray", "Gray Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.green", "Green Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.light_blue", "Light Blue Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.light_gray", "Light Gray Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.lime", "Lime Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.magenta", "Magenta Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.orange", "Orange Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.pink", "Pink Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.purple", "Purple Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.red", "Red Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.white", "White Hyrule");
        translationBuilder.add("block.minecraft.banner.hyliacraft.hyrule.yellow", "Yellow Hyrule");

        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.black", "Black Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.blue", "Blue Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.brown", "Brown Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.cyan", "Cyan Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.gray", "Gray Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.green", "Green Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.light_blue", "Light Blue Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.light_gray", "Light Gray Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.lime", "Lime Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.magenta", "Magenta Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.orange", "Orange Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.pink", "Pink Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.purple", "Purple Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.red", "Red Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.white", "White Kokiri");
        translationBuilder.add("block.minecraft.banner.hyliacraft.kokiri.yellow", "Yellow Kokiri");

        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.black", "Black Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.blue", "Blue Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.brown", "Brown Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.cyan", "Cyan Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.gray", "Gray Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.green", "Green Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.light_blue", "Light Blue Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.light_gray", "Light Gray Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.lime", "Lime Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.magenta", "Magenta Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.orange", "Orange Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.pink", "Pink Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.purple", "Purple Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.red", "Red Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.white", "White Nayru");
        translationBuilder.add("block.minecraft.banner.hyliacraft.nayru.yellow", "Yellow Nayru");

        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.black", "Black Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.blue", "Blue Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.brown", "Brown Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.cyan", "Cyan Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.gray", "Gray Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.green", "Green Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.light_blue", "Light Blue Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.light_gray", "Light Gray Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.lime", "Lime Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.magenta", "Magenta Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.orange", "Orange Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.pink", "Pink Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.purple", "Purple Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.red", "Red Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.white", "White Rito");
        translationBuilder.add("block.minecraft.banner.hyliacraft.rito.yellow", "Yellow Rito");

        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.black", "Black Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.blue", "Blue Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.brown", "Brown Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.cyan", "Cyan Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.gray", "Gray Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.green", "Green Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.light_blue", "Light Blue Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.light_gray", "Light Gray Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.lime", "Lime Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.magenta", "Magenta Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.orange", "Orange Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.pink", "Pink Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.purple", "Purple Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.red", "Red Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.white", "White Sheikah");
        translationBuilder.add("block.minecraft.banner.hyliacraft.sheikah.yellow", "Yellow Sheikah");

        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.black", "Black Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.blue", "Blue Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.brown", "Brown Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.cyan", "Cyan Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.gray", "Gray Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.green", "Green Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.light_blue", "Light Blue Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.light_gray", "Light Gray Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.lime", "Lime Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.magenta", "Magenta Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.orange", "Orange Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.pink", "Pink Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.purple", "Purple Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.red", "Red Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.white", "White Triforce");
        translationBuilder.add("block.minecraft.banner.hyliacraft.triforce.yellow", "Yellow Triforce");

        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.black", "Black Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.blue", "Blue Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.brown", "Brown Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.cyan", "Cyan Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.gray", "Gray Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.green", "Green Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.light_blue", "Light Blue Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.light_gray", "Light Gray Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.lime", "Lime Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.magenta", "Magenta Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.orange", "Orange Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.pink", "Pink Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.purple", "Purple Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.red", "Red Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.white", "White Twili");
        translationBuilder.add("block.minecraft.banner.hyliacraft.twili.yellow", "Yellow Twili");

        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.black", "Black Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.blue", "Blue Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.brown", "Brown Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.cyan", "Cyan Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.gray", "Gray Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.green", "Green Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.light_blue", "Light Blue Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.light_gray", "Light Gray Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.lime", "Lime Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.magenta", "Magenta Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.orange", "Orange Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.pink", "Pink Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.purple", "Purple Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.red", "Red Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.white", "White Yiga");
        translationBuilder.add("block.minecraft.banner.hyliacraft.yiga.yellow", "Yellow Yiga");

        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.black", "Black Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.blue", "Blue Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.brown", "Brown Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.cyan", "Cyan Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.gray", "Gray Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.green", "Green Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.light_blue", "Light Blue Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.light_gray", "Light Gray Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.lime", "Lime Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.magenta", "Magenta Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.orange", "Orange Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.pink", "Pink Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.purple", "Purple Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.red", "Red Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.white", "White Zora");
        translationBuilder.add("block.minecraft.banner.hyliacraft.zora.yellow", "Yellow Zora");

    }
}
