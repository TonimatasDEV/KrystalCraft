package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.block.entity.custom.CombiningFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CombiningFactoryMenu extends FactoryMenu<CombiningFactoryBlockEntity> {
    public CombiningFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CombiningFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CombiningFactoryMenu(int syncId, Inventory inventory, CombiningFactoryBlockEntity blockEntity) {
        super(ModMenus.COMBINING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 70, 6),
                        new Slot(blockEntity, 1, 90, 6),
                        new Slot(blockEntity, 2, 80, 50)
                });
    }
}