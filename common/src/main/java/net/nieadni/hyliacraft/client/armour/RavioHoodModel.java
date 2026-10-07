package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.RavioHoodItem;
import software.bernie.geckolib.model.GeoModel;

public class RavioHoodModel extends GeoModel<RavioHoodItem> {

    @Override
    public Identifier getModelResource(RavioHoodItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/ravio_hood.geo.json");
    }

    @Override
    public Identifier getTextureResource(RavioHoodItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/ravio_hood.png");
    }

    @Override
    public Identifier getAnimationResource(RavioHoodItem animatable) {
        return null;
    }
}