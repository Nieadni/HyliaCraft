package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.PumpkinMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PumpkinMaskRenderer extends GeoArmorRenderer<PumpkinMaskItem> {
    public PumpkinMaskRenderer() {
        super(new PumpkinMaskModel());
    }
}
