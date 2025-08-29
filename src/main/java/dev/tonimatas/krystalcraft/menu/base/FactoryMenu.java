package dev.tonimatas.krystalcraft.menu.base;

import dev.tonimatas.krystalcraft.blockentity.util.FactoryBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

public abstract class FactoryMenu<T extends FactoryBlockEntity> extends BaseMenu<T> {
    public final DataSlot progress;
    public final DataSlot energy;

    public FactoryMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId, inventory, entity, slots);
        this.progress = this.addDataSlot(DataSlot.standalone());
        this.energy = this.addDataSlot(DataSlot.standalone());
    }
    public int getMaxProgress() {
        return this.machine.getMaxProgress();
    }

    public long getEnergyMaxCapacity() {
        return this.machine.getEnergyStorage().getCapacity();
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        this.energy.set((int) this.machine.getEnergyStorage().getStoredEnergy());
        this.progress.set(this.machine.getProgress());
    }
}
