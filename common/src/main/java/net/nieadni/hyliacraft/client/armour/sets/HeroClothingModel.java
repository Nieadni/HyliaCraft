package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.HeroClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class HeroClothingModel extends GeoModel<HeroClothingItem> {

    @Override
    public Identifier getModelResource(HeroClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(HeroClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/hero.png");
    }

    @Override
    public Identifier getAnimationResource(HeroClothingItem animatable) {
        return null;
    }
}