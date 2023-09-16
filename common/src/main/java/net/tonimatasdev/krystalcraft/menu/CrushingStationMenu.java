package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.blockentity.CrushingStationBlockEntity;
import net.tonimatasdev.krystalcraft.menu.slots.CombustionSlot;
import net.tonimatasdev.krystalcraft.menu.slots.ResultSlot;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CrushingStationMenu extends StationMenu<CrushingStationBlockEntity> {
    public CrushingStationMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CrushingStationBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CrushingStationMenu(int syncId, Inventory inventory, CrushingStationBlockEntity blockEntity) {
        super(ModMenus.CRUSHING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 49),
                        new CombustionSlot(blockEntity, 2, 128, 44)
                });
    }
}