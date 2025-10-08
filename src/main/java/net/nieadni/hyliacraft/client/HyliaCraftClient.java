package net.nieadni.hyliacraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.nieadni.hyliacraft.network.RaceAbilityC2SPayload;
import net.nieadni.hyliacraft.network.RaceS2CPayload;
import net.nieadni.hyliacraft.race.ChooseRaceScreen;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import net.nieadni.hyliacraft.block.HCBlocks;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import net.nieadni.hyliacraft.block.entity.IronChestBlockEntityRenderer;
import net.nieadni.hyliacraft.entity.HCEntities;
import net.nieadni.hyliacraft.entity.sword_beam_entity_renderers.*;
import org.lwjgl.glfw.GLFW;

public class HyliaCraftClient implements ClientModInitializer {

    public static HyliaCraftRace race = null;
    private static int ticksSinceLastRaceAbilityUse = 0;

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                HCBlocks.ARMORANTH,
                HCBlocks.ARMORANTH_POT,
                HCBlocks.BLUE_NIGHTSHADE,
                HCBlocks.BLUE_NIGHTSHADE_POT,
                HCBlocks.SILENT_PRINCESS,
                HCBlocks.SILENT_PRINCESS_POT,
                HCBlocks.SWIFT_VIOLETS,
                HCBlocks.SWIFT_VIOLETS_POT,
                HCBlocks.NATURAL_BLUE_CLAY_POT,
                HCBlocks.NATURAL_CLAY_POT_WRITING,
                HCBlocks.NATURAL_CLAY_POT,
                HCBlocks.BLUE_CLAY_POT,
                HCBlocks.CLAY_POT_WRITING,
                HCBlocks.CLAY_POT,
                HCBlocks.HATENO_CLAY_POT
        );
        HCModelPredicates.registerHCModelPredicates();
        BlockEntityRendererFactories.register(HCBlockEntityType.IRON_CHEST, IronChestBlockEntityRenderer::new);
        //EntityRendererRegistry.register(HCEntities.ROCK_PROJECTILE, RockProjectileRenderer::new);
        EntityRendererRegistry.register(HCEntities.GODDESS_SWORD_BEAM, GoddessSwordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.GODDESS_LONGSWORD_BEAM, GoddessLongswordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.GODDESS_WHITE_SWORD_BEAM, GoddessWhiteSwordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.MASTER_SWORD_BEAM, MasterSwordBeamEntityRenderer::new);
        EntityRendererRegistry.register(HCEntities.TRUE_MASTER_SWORD_BEAM, TrueMasterSwordBeamEntityRenderer::new);

        // Register packet receiver for the choose race payload
        ClientPlayNetworking.registerGlobalReceiver(RaceS2CPayload.ID, (payload, context) -> {
            HyliaCraftRace race = payload.race();
            if (race == null) {
                // Show the race selection screen
                context.client().setScreen(new ChooseRaceScreen(Text.translatable("hyliacraft.race.selector.title")));
            } else {
                HyliaCraftClient.race = race;
            }
        });

        registerRaceAbilityKeybind();
    }

    private void registerRaceAbilityKeybind() {
        KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hyliacraft.race_ability",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                "category.hyliacraft.main"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ticksSinceLastRaceAbilityUse = Math.min(ticksSinceLastRaceAbilityUse + 1, getAbilityCooldown());
            while (keyBinding.wasPressed()) {
                useRaceAbility(client);
            }
        });
    }

    private static int getAbilityCooldown() {
        return race == null ? 0 : race.abilityCooldown;
    }

    private static void useRaceAbility(MinecraftClient client) {
        if (ticksSinceLastRaceAbilityUse >= getAbilityCooldown()) {
            ticksSinceLastRaceAbilityUse = 0;
            ClientPlayNetworking.send(RaceAbilityC2SPayload.INSTANCE);
            ClientPlayerEntity player = client.player;
            HyliaCraftRace race = HyliaCraftRace.getRace(player);
            if (race != null)
                race.useRaceAbility(player);
        }
    }
}