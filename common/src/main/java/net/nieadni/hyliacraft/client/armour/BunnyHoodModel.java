package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.BunnyHoodItem;
import software.bernie.geckolib.model.GeoModel;

public class BunnyHoodModel extends GeoModel<BunnyHoodItem> {

    @Override
    public Identifier getModelResource(BunnyHoodItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/bunny_hood.geo.json");
    }

    @Override
    public Identifier getTextureResource(BunnyHoodItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/bunny_hood.png");
    }

    @Override
    public Identifier getAnimationResource(BunnyHoodItem animatable) {
        return null;
    }
}