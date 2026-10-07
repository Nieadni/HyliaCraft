package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.TingleClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class TingleClothingModel extends GeoModel<TingleClothingItem> {

    @Override
    public Identifier getModelResource(TingleClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(TingleClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/tingle.png");
    }

    @Override
    public Identifier getAnimationResource(TingleClothingItem animatable) {
        return null;
    }
}