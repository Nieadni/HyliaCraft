package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PhrygianCapSSItem;
import net.nieadni.hyliacraft.item.armour.PhrygianCapTPItem;
import software.bernie.geckolib.model.GeoModel;

public class PhrygianCapTPModel extends GeoModel<PhrygianCapTPItem> {

    @Override
    public Identifier getModelResource(PhrygianCapTPItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/phrygian_cap_tp.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhrygianCapTPItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phrygian_cap_tp.png");
    }

    @Override
    public Identifier getAnimationResource(PhrygianCapTPItem animatable) {
        return null;
    }
}