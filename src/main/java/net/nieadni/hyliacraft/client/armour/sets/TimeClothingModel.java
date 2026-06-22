package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.TimeClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class TimeClothingModel extends GeoModel<TimeClothingItem> {

    @Override
    public Identifier getModelResource(TimeClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(TimeClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/time.png");
    }

    @Override
    public Identifier getAnimationResource(TimeClothingItem animatable) {
        return null;
    }
}