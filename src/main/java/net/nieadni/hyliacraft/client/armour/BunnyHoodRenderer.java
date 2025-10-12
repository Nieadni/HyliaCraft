package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.BunnyHoodItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class BunnyHoodRenderer extends GeoArmorRenderer<BunnyHoodItem> {

    public BunnyHoodRenderer() {
        super(new BunnyHoodModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}