package net.nieadni.hyliacraft.client.armour.sets;

import net.nieadni.hyliacraft.item.armour.PhantomChestplateItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhantomChestplateRenderer extends GeoArmorRenderer<PhantomChestplateItem> {

    public PhantomChestplateRenderer() {
        super(new PhantomChestplateModel());
    }
}