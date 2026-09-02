package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PhantomArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class PhantomGreavesModel extends GeoModel<PhantomArmorItem> {

    @Override
    public Identifier getModelResource(PhantomArmorItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhantomArmorItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phantom_greaves.png");
    }

    @Override
    public Identifier getAnimationResource(PhantomArmorItem animatable) {
        return null;
    }
}