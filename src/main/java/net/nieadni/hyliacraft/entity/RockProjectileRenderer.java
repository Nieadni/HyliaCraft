package net.nieadni.hyliacraft.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

@Environment(EnvType.CLIENT)
public class RockProjectileRenderer extends ProjectileEntityRenderer {
    public RockProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return Identifier.of(HyliaCraft.MOD_ID,"textures/entity/projectiles/rock.png");
    }

}