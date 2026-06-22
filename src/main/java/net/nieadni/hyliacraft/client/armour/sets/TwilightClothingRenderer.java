package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.TwilightClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TwilightClothingRenderer extends GeoArmorRenderer<TwilightClothingItem> {

    public TwilightClothingRenderer() {
        super(new TwilightClothingModel());
    }
}