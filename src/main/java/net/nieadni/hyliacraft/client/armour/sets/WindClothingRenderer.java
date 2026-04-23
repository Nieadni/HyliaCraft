package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.WindClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WindClothingRenderer extends GeoArmorRenderer<WindClothingItem> {

    public WindClothingRenderer() {
        super(new WindClothingModel());
    }
}