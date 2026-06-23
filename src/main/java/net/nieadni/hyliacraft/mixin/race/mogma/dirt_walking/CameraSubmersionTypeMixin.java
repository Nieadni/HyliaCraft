package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import net.minecraft.block.enums.CameraSubmersionType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CameraSubmersionType.class)
public enum CameraSubmersionTypeMixin {
    
    HYLIACRAFT_DIRT_WALKING
}
