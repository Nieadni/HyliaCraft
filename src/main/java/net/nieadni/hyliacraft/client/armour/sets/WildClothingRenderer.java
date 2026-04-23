package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.WildClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WildClothingRenderer extends GeoArmorRenderer<WildClothingItem> {

    public WildClothingRenderer() {
        super(new WildClothingModel());
    }
}