package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.block.entity.custom.FactoryBlockEntity;

public abstract class FactoryMenu<T extends FactoryBlockEntity> extends AbstractMachineMenu<T> {
    private final DataSlot progress;
    private final DataSlot energyReaming;
    private final DataSlot energyMaxCapacity;

    public FactoryMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId, inventory, entity, slots);
        this.progress = this.addDataSlot(DataSlot.standalone());
        this.energyReaming = this.addDataSlot(DataSlot.standalone());
        this.energyMaxCapacity = this.addDataSlot(DataSlot.standalone());
    }

    public int getProgress() {
        return this.progress.get();
    }

    public int getEnergyReaming() {
        return energyReaming.get();
    }

    public int getEnergyMaxCapacity() {
        return this.energyMaxCapacity.get();
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

    @Override
    public int getPlayerInventoryOffset() {
        return -2;
    }
}
