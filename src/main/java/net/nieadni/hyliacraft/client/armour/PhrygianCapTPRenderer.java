package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.PhrygianCapSSItem;
import net.nieadni.hyliacraft.item.armour.PhrygianCapTPItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhrygianCapTPRenderer extends GeoArmorRenderer<PhrygianCapTPItem> {

    public PhrygianCapTPRenderer() {
        super(new PhrygianCapTPModel());
    }
}