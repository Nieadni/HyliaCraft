package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import net.nieadni.hyliacraft.item.armour.PhrygianCapSSItem;
import software.bernie.geckolib.model.GeoModel;

public class PhrygianCapSSModel extends GeoModel<PhrygianCapSSItem> {

    @Override
    public Identifier getModelResource(PhrygianCapSSItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/phrygian_cap_ss.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhrygianCapSSItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phrygian_cap_ss.png");
    }

    @Override
    public Identifier getAnimationResource(PhrygianCapSSItem animatable) {
        return null;
    }
}