package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.TingleClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TingleClothingRenderer extends GeoArmorRenderer<TingleClothingItem> {

    public TingleClothingRenderer() {
        super(new TingleClothingModel());
    }
}