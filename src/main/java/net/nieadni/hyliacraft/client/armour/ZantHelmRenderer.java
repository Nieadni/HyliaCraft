package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.ZantHelmItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ZantHelmRenderer extends GeoArmorRenderer<ZantHelmItem> {

    public ZantHelmRenderer() {
        super(new ZantHelmModel());
    }
}