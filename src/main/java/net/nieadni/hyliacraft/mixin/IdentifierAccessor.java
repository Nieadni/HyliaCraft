package net.nieadni.hyliacraft.mixin;

import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Identifier.class)
public interface IdentifierAccessor {
    @Invoker("<init>")
    static Identifier callConstructor(String namespace, String path) {
        throw new AssertionError();
    }
}
