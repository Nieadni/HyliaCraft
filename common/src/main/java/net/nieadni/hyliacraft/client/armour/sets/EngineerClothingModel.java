package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.EngineerClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class EngineerClothingModel extends GeoModel<EngineerClothingItem> {

    @Override
    public Identifier getModelResource(EngineerClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(EngineerClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/engineer.png");
    }

    @Override
    public Identifier getAnimationResource(EngineerClothingItem animatable) {
        return null;
    }
}