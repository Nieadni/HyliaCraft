package net.nieadni.hyliacraft.mixin.race.mogma.dirt_walking;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public class BlocksMixin {

    @Definition(id = "XYZ", field = "Lnet/minecraft/block/AbstractBlock$OffsetType;XYZ:Lnet/minecraft/block/AbstractBlock$OffsetType;")
    @Expression("XYZ")
    @ModifyExpressionValue(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=short_grass")), at = @At(value = "MIXINEXTRAS:EXPRESSION", ordinal = 0))
    private static AbstractBlock.OffsetType modifyOffsetType(AbstractBlock.OffsetType original) {
        return AbstractBlock.OffsetType.XZ;
    }
}
