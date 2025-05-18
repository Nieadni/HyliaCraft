package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.PhrygianCapSSItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhrygianCapSSRenderer extends GeoArmorRenderer<PhrygianCapSSItem> {

    public PhrygianCapSSRenderer() {
        super(new PhrygianCapSSModel());
    }
}