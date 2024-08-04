package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MajorasMaskRenderer extends GeoArmorRenderer<MajorasMaskItem> {

    public MajorasMaskRenderer() {
        super(new MajorasMaskModel());
    }
}