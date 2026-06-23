package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.ZantHelmItem;
import software.bernie.geckolib.model.GeoModel;

public class ZantHelmModel extends GeoModel<ZantHelmItem> {

    @Override
    public Identifier getModelResource(ZantHelmItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/zant_helm.geo.json");
    }

    @Override
    public Identifier getTextureResource(ZantHelmItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/zant_helm.png");
    }

    @Override
    public Identifier getAnimationResource(ZantHelmItem animatable) {
        return null;
    }
}