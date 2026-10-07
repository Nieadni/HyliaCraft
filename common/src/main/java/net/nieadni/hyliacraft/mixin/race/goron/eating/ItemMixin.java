package net.nieadni.hyliacraft.mixin.race.goron.eating;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.client.HyliaCraftClient;
import net.nieadni.hyliacraft.item.HCItemTags;
import net.nieadni.hyliacraft.race.HyliaCraftRace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;", at = @At("HEAD"), cancellable = true)
    private void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (HyliaCraftRace.getRace(user) == HyliaCraftRace.GORON) {
            ItemStack stack = user.getStackInHand(hand);
            if (stack.isIn(HCItemTags.GORON_EDIBLE) && user.canConsume(false)) {
                user.setCurrentHand(hand);
                cir.setReturnValue(TypedActionResult.consume(stack));
            }
        }
    }

    @Inject(method = "getMaxUseTime(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/LivingEntity;)I", at = @At("HEAD"), cancellable = true)
    private void getMaxUseTime(ItemStack stack, LivingEntity user, CallbackInfoReturnable<Integer> cir) {
        if (user instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON && stack.isIn(HCItemTags.GORON_EDIBLE)) {
            cir.setReturnValue(32);
        }
    }

    @Inject(method = "getUseAction(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/util/UseAction;", at = @At("HEAD"), cancellable = true)
    private void getUseAction(ItemStack stack, CallbackInfoReturnable<UseAction> cir) {
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT && HyliaCraftClient.race == HyliaCraftRace.GORON && stack.isIn(HCItemTags.GORON_EDIBLE)) {
            cir.setReturnValue(UseAction.EAT);
        }
    }

    @Inject(method = "finishUsing(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;)Lnet/minecraft/item/ItemStack;", at = @At("HEAD"), cancellable = true)
    private void getFoodComponent(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user instanceof PlayerEntity player && HyliaCraftRace.getRace(player) == HyliaCraftRace.GORON) {
            if (stack.isIn(HCItemTags.GORON_EDIBLE)) {
                HyliaCraft.LOGGER.info("Returning a different component");
                cir.setReturnValue(user.eatFood(world, stack, HyliaCraftRace.GORON_EATING_COMPONENT));
            } else {
                FoodComponent component = stack.get(DataComponentTypes.FOOD);
                if (component == null) {
                    cir.setReturnValue(stack);
                } else {
                    FoodComponent reducedComponent = new FoodComponent(
                            component.nutrition() / 2,
                            component.saturation() / 2,
                            component.canAlwaysEat(),
                            component.eatSeconds(),
                            component.usingConvertsTo(),
                            component.effects()
                    );
                    cir.setReturnValue(user.eatFood(world, stack, reducedComponent));
                }
            }
        }
    }
}
