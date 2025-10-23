package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.PhrygianCapItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhrygianCapRenderer extends GeoArmorRenderer<PhrygianCapItem> {

    public PhrygianCapRenderer() {
        super(new PhrygianCapModel());
    }
}