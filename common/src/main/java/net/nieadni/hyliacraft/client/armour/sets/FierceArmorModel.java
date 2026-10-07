package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.FierceArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class FierceArmorModel extends GeoModel<FierceArmorItem> {

    @Override
    public Identifier getModelResource(FierceArmorItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(FierceArmorItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/fierce.png");
    }

    @Override
    public Identifier getAnimationResource(FierceArmorItem animatable) {
        return null;
    }
}