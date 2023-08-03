package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.block.entity.custom.FactoryBlockEntity;

public abstract class FactoryMenu<T extends FactoryBlockEntity> extends AbstractMachineMenu<T> {
    protected DataSlot progress;

    public FactoryMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId, inventory, entity, slots);
        this.progress = this.addDataSlot(DataSlot.standalone());
    }

    public int getProgress() {
        return progress.get();
    }

    @Override
    public void syncClientScreen() {
        this.progress.set(this.machine.getProgress());
    }

    public long getEnergyMaxCapacity() {
        return this.machine.getEnergyStorage().getMaxCapacity();
    }

    public int getMaxProgress() {
        return this.machine.getMaxProgress();
    }

    @Override
    public int getPlayerInventoryOffset() {
        return -2;
    }
}
