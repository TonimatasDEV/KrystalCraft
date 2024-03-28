package dev.tonimatas.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import dev.tonimatas.krystalcraft.blockentity.CombiningStationBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.StationMenu;
import dev.tonimatas.krystalcraft.menu.slots.CombustionSlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;

public class CombiningStationMenu extends StationMenu<CombiningStationBlockEntity> {
    public CombiningStationMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CombiningStationBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CombiningStationMenu(int syncId, Inventory inventory, CombiningStationBlockEntity blockEntity) {
        super(ModMenus.COMBINING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, -8),
                        new Slot(blockEntity, 1, 80, 9),
                        new ResultSlot(blockEntity, 2, 80, 50),
                        new CombustionSlot(blockEntity, 3, 128, 53)

                });
    }
}