package net.nieadni.hyliacraft.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class HCFoodComponents {
    public static final FoodComponent PUMPKIN_SOUP = createSoup(6,0.3F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,400,1,false,false),1f).alwaysEdible().build();

    private static FoodComponent.Builder createSoup(int nutrition, float saturation) {
        return (new FoodComponent.Builder()).nutrition(nutrition).saturationModifier(saturation).usingConvertsTo(Items.GLASS_BOTTLE);
    }

}
