package net.nieadni.hyliacraft.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.BlockStatesLoader;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.nieadni.hyliacraft.HyliaCraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class MogmaMittModelLoaderMixin {

    @Shadow protected abstract void addModelToBake(ModelIdentifier id, UnbakedModel model);

    @Inject(method = "<init>", at = @At("RETURN"))
    public void addMogmaMittModel(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<BlockStatesLoader.SourceTrackedData>> blockStates, CallbackInfo ci) {
        this.addModelToBake(new ModelIdentifier(Identifier.of(HyliaCraft.MOD_ID, "models/item/mogma_mitt_3d"), "inventory"),
                jsonUnbakedModels.get(Identifier.of(HyliaCraft.MOD_ID, "models/item/mogma_mitt_3d.json")));
    }
}