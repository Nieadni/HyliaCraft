package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.WildClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class WildClothingModel extends GeoModel<WildClothingItem> {

    @Override
    public Identifier getModelResource(WildClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(WildClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/wild.png");
    }

    @Override
    public Identifier getAnimationResource(WildClothingItem animatable) {
        return null;
    }
}