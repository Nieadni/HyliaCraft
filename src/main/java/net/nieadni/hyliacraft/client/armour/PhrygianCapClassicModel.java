package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.PhrygianCapClassicItem;
import net.nieadni.hyliacraft.item.armour.PhrygianCapTPItem;
import software.bernie.geckolib.model.GeoModel;

public class PhrygianCapClassicModel extends GeoModel<PhrygianCapClassicItem> {

    @Override
    public Identifier getModelResource(PhrygianCapClassicItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/phrygian_cap_classic.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhrygianCapClassicItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/phrygian_cap_classic.png");
    }

    @Override
    public Identifier getAnimationResource(PhrygianCapClassicItem animatable) {
        return null;
    }
}