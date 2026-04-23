package net.nieadni.hyliacraft.client.armour.sets;

import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.item.armour.WindClothingItem;
import software.bernie.geckolib.model.GeoModel;

public class WindClothingModel extends GeoModel<WindClothingItem> {

    @Override
    public Identifier getModelResource(WindClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "geo/armor/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(WindClothingItem animatable) {
        return Identifier.of(HyliaCraft.MOD_ID, "textures/models/armor/wind.png");
    }

    @Override
    public Identifier getAnimationResource(WindClothingItem animatable) {
        return null;
    }
}