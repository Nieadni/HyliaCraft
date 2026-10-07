package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.BokoblinMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BokoblinMaskRenderer extends GeoArmorRenderer<BokoblinMaskItem> {

    public BokoblinMaskRenderer() {
        super(new BokoblinMaskModel());
    }
}