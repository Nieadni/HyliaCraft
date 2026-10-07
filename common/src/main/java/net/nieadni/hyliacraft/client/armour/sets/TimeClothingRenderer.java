package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.TimeClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TimeClothingRenderer extends GeoArmorRenderer<TimeClothingItem> {

    public TimeClothingRenderer() {
        super(new TimeClothingModel());
    }
}