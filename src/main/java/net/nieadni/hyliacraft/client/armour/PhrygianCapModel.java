package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PhrygianCapItem;
import software.bernie.geckolib.model.GeoModel;

public class PhrygianCapModel extends GeoModel<PhrygianCapItem> {

    @Override
    public Identifier getModelResource(PhrygianCapItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/phrygian_cap.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhrygianCapItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phrygian_cap.png");
    }

    @Override
    public Identifier getAnimationResource(PhrygianCapItem animatable) {
        return null;
    }
}