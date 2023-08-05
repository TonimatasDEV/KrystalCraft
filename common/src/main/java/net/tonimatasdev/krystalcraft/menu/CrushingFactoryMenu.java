package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.blockentity.CrushingFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CrushingFactoryMenu extends FactoryMenu<CrushingFactoryBlockEntity> {
    public CrushingFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CrushingFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CrushingFactoryMenu(int syncId, Inventory inventory, CrushingFactoryBlockEntity blockEntity) {
        super(ModMenus.CRUSHING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new Slot(blockEntity, 1, 80, 50)
                });
    }
}