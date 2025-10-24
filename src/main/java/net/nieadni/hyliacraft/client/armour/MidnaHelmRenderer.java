package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.MidnaHelmItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MidnaHelmRenderer extends GeoArmorRenderer<MidnaHelmItem> {

    public MidnaHelmRenderer() {
        super(new MidnaHelmModel());
    }
}