package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;

import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PumpkinMaskItem;

import software.bernie.geckolib.model.GeoModel;

public class PumpkinMaskModel extends GeoModel<PumpkinMaskItem> {

    @Override
    public Identifier getModelResource(PumpkinMaskItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/pumpkin_mask.geo.json");
    }

    @Override
    public Identifier getTextureResource(PumpkinMaskItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/pumpkin_mask.png");
    }

    @Override
    public Identifier getAnimationResource(PumpkinMaskItem animatable) {
        return null;
    }
}