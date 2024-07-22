package net.nieadni.hyliacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nieadni.hyliacraft.HyliaCraft;

public class HCItemGroup {
    public static final ItemGroup GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.gear"))
                    .icon(() -> new ItemStack(HCItems.GODDESS_SWORD)).entries((displayContext, entries) -> {
                        entries.add(HCItems.GODDESS_SWORD);

                    }).build());
    public static final ItemGroup CONSUMABLES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HyliaCraft.MOD_ID, "consumables"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hyliacraft.consumables"))
                    .icon(() -> new ItemStack(HCItems.PUMPKIN_SOUP)).entries((displayContext, entries) -> {
                        entries.add(HCItems.PUMPKIN_SOUP);

                    }).build());


    public static void registerItemGroups() {
        HyliaCraft.LOGGER.info("Registering Item Groups for " + HyliaCraft.MOD_ID);
    }
}