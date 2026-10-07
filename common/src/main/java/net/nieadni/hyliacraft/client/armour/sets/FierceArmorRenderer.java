package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.FierceArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FierceArmorRenderer extends GeoArmorRenderer<FierceArmorItem> {

    public FierceArmorRenderer() {
        super(new FierceArmorModel());
    }
}