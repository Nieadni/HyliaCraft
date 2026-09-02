package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.TingleHoodItem;
import software.bernie.geckolib.model.GeoModel;

public class TingleHoodModel extends GeoModel<TingleHoodItem> {

    @Override
    public Identifier getModelResource(TingleHoodItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/tingle_hood.geo.json");
    }

    @Override
    public Identifier getTextureResource(TingleHoodItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/tingle_hood.png");
    }

    @Override
    public Identifier getAnimationResource(TingleHoodItem animatable) {
        return null;
    }
}