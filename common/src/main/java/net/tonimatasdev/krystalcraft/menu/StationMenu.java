package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.blockentity.util.BurnProcessingBlockEntity;

public abstract class StationMenu<T extends BurnProcessingBlockEntity> extends AbstractMachineMenu<T> {
    private final DataSlot progress;
    private final DataSlot burnTime;
    private final DataSlot burnTimeTotal;

    public StationMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId, inventory, entity, slots);
        this.progress = this.addDataSlot(DataSlot.standalone());
        this.burnTime = this.addDataSlot(DataSlot.standalone());
        this.burnTimeTotal = this.addDataSlot(DataSlot.standalone());
    }

    @Override
    public void syncClientScreen() {
        this.burnTime.set(this.machine.getBurnTime());
        this.burnTimeTotal.set(this.machine.getBurnTimeTotal());
        this.progress.set(this.machine.getProgress());
    }

    public int getBurnTime() {
        return burnTime.get();
    }

    public int getBurnTimeTotal() {
        return burnTimeTotal.get();
    }

    public int getProgress() {
        return progress.get();
    }

    public int getMaxProgress() {
        return machine.getMaxProgress();
    }
}
