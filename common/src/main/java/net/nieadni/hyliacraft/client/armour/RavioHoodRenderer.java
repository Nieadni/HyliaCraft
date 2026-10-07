package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.RavioHoodItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RavioHoodRenderer extends GeoArmorRenderer<RavioHoodItem> {

    public RavioHoodRenderer() {
        super(new RavioHoodModel());
    }
}