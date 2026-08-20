package net.nieadni.hyliacraft.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.nieadni.hyliacraft.entity.HappyMaskSalesmanEntity;
import net.nieadni.hyliacraft.shop.RupeeTrade;
import net.nieadni.hyliacraft.shop.ShopEntry;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Opens the salesman's shop, carrying the row list across to the client.
 *
 * <p>The stock is captured once, when the screen opens, rather than read live. A player browsing a shop
 * whose contents reshuffled underneath them mid-click would buy something they had not chosen.
 */
public record ShopScreenFactory(HappyMaskSalesmanEntity salesman, List<RupeeTrade> stock)
        implements ExtendedScreenHandlerFactory<List<ShopEntry>> {

    @Override
    public List<ShopEntry> getScreenOpeningData(ServerPlayerEntity player) {
        return this.stock.stream().map(ShopEntry::of).toList();
    }

    @Override
    public Text getDisplayName() {
        return this.salesman.getDisplayName();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new ShopScreenHandler(syncId, inventory, this.salesman, this.stock);
    }
}
