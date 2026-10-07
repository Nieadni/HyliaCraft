package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.MidnaHelmItem;
import software.bernie.geckolib.model.GeoModel;

public class MidnaHelmModel extends GeoModel<MidnaHelmItem> {

    @Override
    public Identifier getModelResource(MidnaHelmItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/midna_helm.geo.json");
    }

    @Override
    public Identifier getTextureResource(MidnaHelmItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/midna_helm.png");
    }

    @Override
    public Identifier getAnimationResource(MidnaHelmItem animatable) {
        return null;
    }
}