package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PhantomChestplateItem;
import software.bernie.geckolib.model.GeoModel;

public class PhantomChestplateModel extends GeoModel<PhantomChestplateItem> {

    @Override
    public Identifier getModelResource(PhantomChestplateItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/phantom_chestplate.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhantomChestplateItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phantom_chestplate.png");
    }

    @Override
    public Identifier getAnimationResource(PhantomChestplateItem animatable) {
        return null;
    }
}