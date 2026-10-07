package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.PhantomHelmetItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhantomHelmetRenderer extends GeoArmorRenderer<PhantomHelmetItem> {

    public PhantomHelmetRenderer() {
        super(new PhantomHelmetModel());
    }
}