package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.blockentity.StationBlockEntity;

public abstract class StationMenu<T extends StationBlockEntity> extends AbstractMachineMenu<T> {
    private final DataSlot progress;
    private final DataSlot cookTime;
    private final DataSlot cookTimeTotal;

    public StationMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId, inventory, entity, slots);
        this.progress = this.addDataSlot(DataSlot.standalone());
        this.cookTime = this.addDataSlot(DataSlot.standalone());
        this.cookTimeTotal = this.addDataSlot(DataSlot.standalone());
    }

    @Override
    public void syncClientScreen() {
        this.cookTime.set(this.machine.getCookTime());
        this.cookTimeTotal.set(this.machine.getCookTimeTotal());
        this.progress.set(this.machine.getProgress());
    }

    public int getCookTime() {
        return this.cookTime.get();
    }

    public int getCookTimeTotal() {
        return this.cookTimeTotal.get();
    }

    public int getProgress() {
        return this.progress.get();
    }

    public int getMaxProgress() {
        return this.machine.getMaxProgress();
    }
}
