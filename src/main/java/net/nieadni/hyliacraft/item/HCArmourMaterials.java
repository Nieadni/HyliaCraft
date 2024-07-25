package net.nieadni.hyliacraft.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class HCArmourMaterials {

    public static void initialize() {};
    public static final int MAJORAS_MASK_DURABILITY_MULTIPLIER = 60;

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(HyliaCraft.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(HyliaCraft.MOD_ID, id), material);
        return RegistryEntry.of(material);
    }

    public static final RegistryEntry<ArmorMaterial> MAJORAS_MASK = registerMaterial("majoras_mask",
            Map.of(
                    ArmorItem.Type.HELMET, 4,
                    ArmorItem.Type.CHESTPLATE, 1,
                    ArmorItem.Type.LEGGINGS, 1,
                    ArmorItem.Type.BOOTS, 1
            ),
            // Enchantability //
            35,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
            () -> Ingredient.ofItems(Items.AIR),
            2.0F,
            0.5F,
            false);
}