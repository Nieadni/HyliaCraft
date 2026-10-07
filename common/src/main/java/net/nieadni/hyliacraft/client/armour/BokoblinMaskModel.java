package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.BokoblinMaskItem;
import software.bernie.geckolib.model.GeoModel;

public class BokoblinMaskModel extends GeoModel<BokoblinMaskItem> {

    @Override
    public Identifier getModelResource(BokoblinMaskItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/bokoblin_mask.geo.json");
    }

    @Override
    public Identifier getTextureResource(BokoblinMaskItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/bokoblin_mask.png");
    }

    @Override
    public Identifier getAnimationResource(BokoblinMaskItem animatable) {
        return null;
    }
}