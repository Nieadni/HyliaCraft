package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.HeroClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HeroClothingRenderer extends GeoArmorRenderer<HeroClothingItem> {

    public HeroClothingRenderer() {
        super(new HeroClothingModel());
    }
}