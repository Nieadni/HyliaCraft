package net.nieadni.hyliacraft.mixin.race.rito.shader;

import net.minecraft.client.Keyboard;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    
    @Redirect(method = "onKey(JIIII)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;togglePostProcessorEnabled()V"))
    private void togglePostProcessorEnabled(GameRenderer instance) {}
}
