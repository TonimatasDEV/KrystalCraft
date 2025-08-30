package dev.tonimatas.krystalcraft.menu;
/*
import dev.tonimatas.krystalcraft.blockentity.CrushingFactoryBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.FactoryMenu;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import dev.tonimatas.krystalcraft.menu.slots.BatterySlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.menu.slots.UpgradeSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

import java.util.Optional;

public class CrushingFactoryMenu extends FactoryMenu<CrushingFactoryBlockEntity> {
    public CrushingFactoryMenu(int syncId, Inventory inventory, Optional<BlockPosContent> blockPosContent) {
        this(syncId, inventory, (CrushingFactoryBlockEntity) BlockPosContent.getOrNull(blockPosContent, inventory.player.level()));
    }

    public CrushingFactoryMenu(int syncId, Inventory inventory, CrushingFactoryBlockEntity blockEntity) {
        super(ModMenus.CRUSHING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 50),
                        new BatterySlot(blockEntity, 2, 129, 41),
                        new UpgradeSlot(blockEntity, 3, 106, -12),
                        new UpgradeSlot(blockEntity, 4, 126, -12)
                });
    }
}*/