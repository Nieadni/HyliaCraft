package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class MajorasMaskRenderer extends GeoArmorRenderer<MajorasMaskItem> {

    public MajorasMaskRenderer() {
        super(new MajorasMaskModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}