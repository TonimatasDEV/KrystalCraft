package dev.tonimatas.krystalcraft.menu.base;

import dev.tonimatas.krystalcraft.blockentity.util.BurnBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

public abstract class StationMenu<T extends BurnBlockEntity> extends BaseMenu<T> {
    public final DataSlot progress;
    public final DataSlot burnTime;
    public final DataSlot burnTimeTotal;

    public StationMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId, inventory, entity, slots);
        this.progress = this.addDataSlot(DataSlot.standalone());
        this.burnTime = this.addDataSlot(DataSlot.standalone());
        this.burnTimeTotal = this.addDataSlot(DataSlot.standalone());
    }

    public int getMaxProgress() {
        return machine.getMaxProgress();
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        this.progress.set(this.machine.getProgress());
        this.burnTime.set(this.machine.getBurnTime());
        this.burnTimeTotal.set(this.machine.getBurnTimeTotal());
    }
}
