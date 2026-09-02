package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PhantomHelmetItem;
import software.bernie.geckolib.model.GeoModel;

public class PhantomHelmetModel extends GeoModel<PhantomHelmetItem> {

    @Override
    public Identifier getModelResource(PhantomHelmetItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/phantom_helmet.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhantomHelmetItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phantom_helmet.png");
    }

    @Override
    public Identifier getAnimationResource(PhantomHelmetItem animatable) {
        return null;
    }
}