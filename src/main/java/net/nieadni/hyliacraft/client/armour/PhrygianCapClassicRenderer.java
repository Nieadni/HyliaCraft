package net.nieadni.hyliacraft.client.armour;

import net.nieadni.hyliacraft.item.armour.PhrygianCapClassicItem;
import net.nieadni.hyliacraft.item.armour.PhrygianCapSSItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhrygianCapClassicRenderer extends GeoArmorRenderer<PhrygianCapClassicItem> {

    public PhrygianCapClassicRenderer() {
        super(new PhrygianCapClassicModel());
    }
}