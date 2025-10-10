package net.nieadni.hyliacraft.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCFoodComponents extends FoodComponents {

    public static final FoodComponent PUMPKIN_SOUP = createSoup(6,0.3F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,400,1,false,false),1f).alwaysEdible().build();
    public static final FoodComponent DUBIOUS_FOOD = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON,600,2,false,false),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,600,2,false,false),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,600,2,false,false),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,600,2,false,false),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER,200,0,false,false),1f)
            .alwaysEdible().build();

    private static FoodComponent.Builder createSoup(int nutrition, float saturation) {
        return (new FoodComponent.Builder()).nutrition(nutrition).saturationModifier(saturation).usingConvertsTo(Items.GLASS_BOTTLE);
    }

    public static void registerHCFoodComponents() {
        HyliaCraft.LOGGER.info("Registering Food Components for " + HyliaCraft.MOD_ID);
    }
}