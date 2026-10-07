package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.PhantomArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhantomGreavesRenderer extends GeoArmorRenderer<PhantomArmorItem> {

    public PhantomGreavesRenderer() {
        super(new PhantomGreavesModel());
    }
}