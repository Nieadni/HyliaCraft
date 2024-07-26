package net.nieadni.hyliacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;
import net.nieadni.hyliacraft.block.HCBlocks;

public class HCItemGroup {
    public static final ItemGroup GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "1-gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.gear"))
                    .icon(() -> new ItemStack(HCItems.GODDESS_SWORD)).entries((displayContext, entries) -> {
                        entries.add(HCItems.MAJORAS_MASK);

                        entries.add(HCItems.GODDESS_SWORD);
                        entries.add(HCItems.GODDESS_LONGSWORD);
                        entries.add(HCItems.GODDESS_WHITE_SWORD);
                        entries.add(HCItems.MASTER_SWORD);
                        entries.add(HCItems.TRUE_MASTER_SWORD);

                        entries.add(HCItems.DIGGING_MITT);
                        entries.add(HCItems.PARAGLIDER);

                    }).build());

    public static final ItemGroup MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "2-misc"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.misc"))
                    .icon(() -> new ItemStack(HCItems.GREEN_RUPEE)).entries((displayContext, entries) -> {
                        entries.add(HCItems.PUMPKIN_SOUP);
                        entries.add(HCItems.GREEN_RUPEE);
                        entries.add(HCItems.BLUE_RUPEE);
                        entries.add(HCItems.YELLOW_RUPEE);
                        entries.add(HCItems.RED_RUPEE);
                        entries.add(HCItems.PURPLE_RUPEE);
                        entries.add(HCItems.ORANGE_RUPEE);
                        entries.add(HCItems.SILVER_RUPEE);
                        entries.add(HCItems.GOLD_RUPEE);
                        entries.add(HCBlocks.CLAY_POT.asItem());
                        entries.add(HCBlocks.NATURAL_CLAY_POT.asItem());
                        entries.add(HCBlocks.CLAY_POT_WRITING.asItem());
                        entries.add(HCBlocks.NATURAL_CLAY_POT_WRITING.asItem());
                        entries.add(HCBlocks.BLUE_CLAY_POT.asItem());
                        entries.add(HCBlocks.NATURAL_BLUE_CLAY_POT.asItem());
                    }).build());


    public static void registerItemGroups() {
        HyliaCraft.LOGGER.info("Registering Item Groups for " + HyliaCraft.MOD_ID);
    }
}