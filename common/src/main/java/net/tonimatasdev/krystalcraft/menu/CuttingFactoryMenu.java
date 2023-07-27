package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.block.entity.custom.CuttingFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CuttingFactoryMenu extends FactoryMenu<CuttingFactoryBlockEntity> {
    public CuttingFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CuttingFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CuttingFactoryMenu(int syncId, Inventory inventory, CuttingFactoryBlockEntity blockEntity) {
        super(ModMenus.CUTTING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new Slot(blockEntity, 1, 80, 50)
                });
    }
}