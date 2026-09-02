package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.EngineerClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EngineerClothingRenderer extends GeoArmorRenderer<EngineerClothingItem> {

    public EngineerClothingRenderer() {
        super(new EngineerClothingModel());
    }
}