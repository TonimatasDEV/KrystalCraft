package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.block.entity.custom.StationBlockEntity;

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

    public int getScaledProgress() {
        int progress = this.getProgress();
        int maxProgress = this.getMaxProgress();
        int progressArrowSize = 14;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getFuelScaledProgress() {
        int progress = this.getProgress();
        int progressArrowSize = 14;

        return progress != 0 ? progress * progressArrowSize / 8 : 0;
    }
}
