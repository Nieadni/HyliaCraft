package net.nieadni.hyliacraft.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BombFlowerItem extends Item {
    private final Block bombFlowerBlock;

    //TODO: Regular use will throw an entity like primed tnt but bomb flower (just use cross model of the item),
    // and this will only explode a specific tag (cobblestone and any of the cracked blocks)
    // Also it should deal half the amount of damage of exploding TNT and half the size of exploding TNT.

    public BombFlowerItem(Block bombFlowerBlock, Settings settings) {
        super(settings);
        this.bombFlowerBlock = bombFlowerBlock;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();
        World world = context.getWorld();

        if (user == null || !user.isSneaking()) {
            return ActionResult.PASS;
        }

        if (context.getSide() != Direction.UP) {
            return ActionResult.PASS;
        }

        BlockPos targetPos = context.getBlockPos().up();
        BlockState placedState = bombFlowerBlock.getDefaultState();

        if (!placedState.canPlaceAt(world, targetPos)) {
            return ActionResult.FAIL;
        }

        if (!world.getBlockState(targetPos).isReplaceable()) {
            return ActionResult.PASS;
        }

        if (!world.isClient) {
            world.setBlockState(targetPos, placedState, Block.NOTIFY_ALL);
            world.playSound(null, targetPos, SoundEvents.BLOCK_GRASS_PLACE,
                    SoundCategory.BLOCKS, 1.0f, 1.0f);

            if (!user.isCreative()) {
                context.getStack().decrement(1);
            }
        }

        return ActionResult.success(world.isClient);
    }

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }

}
