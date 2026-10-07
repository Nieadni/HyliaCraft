package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.TingleHoodItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TingleHoodRenderer extends GeoArmorRenderer<TingleHoodItem> {

    public TingleHoodRenderer() {
        super(new TingleHoodModel());
    }
}