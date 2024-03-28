package dev.tonimatas.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import dev.tonimatas.krystalcraft.blockentity.CrushingStationBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.StationMenu;
import dev.tonimatas.krystalcraft.menu.slots.CombustionSlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;

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