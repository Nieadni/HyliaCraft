package net.nieadni.hyliacraft.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.nieadni.hyliacraft.block.entity.HCBlockEntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class IronChestBlock extends ChestBlock {
    public IronChestBlock(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier) {
        super(settings.mapColor(MapColor.IRON_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable().requiresTool(), supplier);
    }

    // REMOVE THIS ONCE ITEM HAS BEEN FULLY ADDED
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, @NotNull List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.hyliacraft.wip").formatted(Formatting.DARK_PURPLE));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return HCBlockEntityType.IRON_CHEST_BLOCK_ENTITY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

}
