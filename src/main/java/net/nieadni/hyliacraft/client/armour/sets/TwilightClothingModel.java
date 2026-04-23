package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.TwilightClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class TwilightClothingModel extends GeoModel<TwilightClothingItem> {

    @Override
    public Identifier getModelResource(TwilightClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(TwilightClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/twilight.png");
    }

    @Override
    public Identifier getAnimationResource(TwilightClothingItem animatable) {
        return null;
    }
}