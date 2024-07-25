package net.nieadni.hyliacraft.client.armour;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.MajorasMaskItem;
import software.bernie.geckolib.model.GeoModel;

public class MajorasMaskModel extends GeoModel<MajorasMaskItem> {
    @Override
    public Identifier getModelResource(MajorasMaskItem animatable) {
        return new Identifier.of("hyliacraft", "geo/armor/majoras_mask.geo.json");
    }

    @Override
    public Identifier getTextureResource(MajorasMaskItem animatable) {
        return new Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/majoras_mask.png");
    }

    @Override
    public Identifier getAnimationResource(MajorasMaskItem animatable) {
        return null;
    }
}
