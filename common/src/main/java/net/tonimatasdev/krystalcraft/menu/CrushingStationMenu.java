package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.block.entity.custom.CrushingStationBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CrushingStationMenu extends StationMenu<CrushingStationBlockEntity> {
    public CrushingStationMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CrushingStationBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CrushingStationMenu(int syncId, Inventory inventory, CrushingStationBlockEntity blockEntity) {
        super(ModMenus.CRUSHING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 70, 31),
                        new Slot(blockEntity, 1, 88, 31),
                        new Slot(blockEntity, 2, 80, 64),
                        new Slot(blockEntity, 3, 80, 86)
                });
    }

    @Override
    public int getPlayerInventoryOffset() {
        return 23;
    }
}