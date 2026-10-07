package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.SkyClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class SkyClothingModel extends GeoModel<SkyClothingItem> {

    @Override
    public Identifier getModelResource(SkyClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(SkyClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/sky.png");
    }

    @Override
    public Identifier getAnimationResource(SkyClothingItem animatable) {
        return null;
    }
}