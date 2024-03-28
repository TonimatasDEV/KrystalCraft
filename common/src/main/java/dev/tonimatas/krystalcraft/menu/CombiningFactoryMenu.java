package dev.tonimatas.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import dev.tonimatas.krystalcraft.blockentity.CombiningFactoryBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.FactoryMenu;
import dev.tonimatas.krystalcraft.menu.slots.BatterySlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.menu.slots.UpgradeSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;

public class CombiningFactoryMenu extends FactoryMenu<CombiningFactoryBlockEntity> {
    public CombiningFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CombiningFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CombiningFactoryMenu(int syncId, Inventory inventory, CombiningFactoryBlockEntity blockEntity) {
        super(ModMenus.COMBINING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, -8),
                        new Slot(blockEntity, 1, 80, 9),
                        new ResultSlot(blockEntity, 2, 80, 50),
                        new BatterySlot(blockEntity, 3, 129, 41),
                        new UpgradeSlot(blockEntity, 4, 106, -12),
                        new UpgradeSlot(blockEntity, 5, 126, -12)
                });
    }
}