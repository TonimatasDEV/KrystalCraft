package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.blockentity.CombiningStationBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CombiningStationMenu extends StationMenu<CombiningStationBlockEntity> {
    public CombiningStationMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CombiningStationBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CombiningStationMenu(int syncId, Inventory inventory, CombiningStationBlockEntity blockEntity) {
        super(ModMenus.COMBINING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, -8),
                        new Slot(blockEntity, 1, 80, 9),
                        new Slot(blockEntity, 2, 80, 50),
                        new Slot(blockEntity, 3, 128, 53)
                });
    }
}