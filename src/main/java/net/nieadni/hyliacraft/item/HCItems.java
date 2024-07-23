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
import net.nieadni.hyliacraft.item.custom.GoddessSwordItem;
import net.nieadni.hyliacraft.item.custom.PumpkinSoupItem;
import net.nieadni.hyliacraft.item.materials.GoddessSwordMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    /** Misc Items **/

    public static final Item GREEN_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.green_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "green_rupee");

    public static final Item BLUE_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.blue_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "blue_rupee");

    public static final Item YELLOW_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.yellow_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "yellow_rupee");

    public static final Item RED_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.red_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "red_rupee");

    public static final Item PURPLE_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.purple_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "purple_rupee");

    public static final Item ORANGE_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.orange_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "orange_rupee");

    public static final Item SILVER_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silver_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "silver_rupee");

    public static final Item GOLD_RUPEE = register(new Item(new Item.Settings().maxCount(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.gold_rupee").formatted(Formatting.GRAY));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, "gold_rupee");

    public static void registerHCItems() {
        HyliaCraft.LOGGER.info("Registering Mod Items for " + HyliaCraft.MOD_ID);
    }
    public static void initialize() {
    }
}
