package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.SkyClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SkyClothingRenderer extends GeoArmorRenderer<SkyClothingItem> {

    public SkyClothingRenderer() {
        super(new SkyClothingModel());
    }
}