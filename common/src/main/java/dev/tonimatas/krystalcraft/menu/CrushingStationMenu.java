package dev.tonimatas.krystalcraft.menu;

import dev.tonimatas.krystalcraft.blockentity.CrushingStationBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.StationMenu;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import dev.tonimatas.krystalcraft.menu.slots.CombustionSlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

import java.util.Optional;

public class CrushingStationMenu extends StationMenu<CrushingStationBlockEntity> {
    public CrushingStationMenu(int syncId, Inventory inventory, Optional<BlockPosContent> blockPosContent) {
        this(syncId, inventory, (CrushingStationBlockEntity) BlockPosContent.getOrNull(blockPosContent, inventory.player.level()));
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