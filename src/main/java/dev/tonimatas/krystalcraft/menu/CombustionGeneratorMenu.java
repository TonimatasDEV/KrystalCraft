package dev.tonimatas.krystalcraft.menu;
/*
import dev.tonimatas.krystalcraft.blockentity.CombustionGeneratorBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.BaseMenu;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import dev.tonimatas.krystalcraft.menu.slots.BatterySlot;
import dev.tonimatas.krystalcraft.menu.slots.CombustionSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;

import java.util.Optional;

public class CombustionGeneratorMenu extends BaseMenu<CombustionGeneratorBlockEntity> {
    public final DataSlot burnTime;
    public final DataSlot totalBurnTime;
    public final DataSlot energyAmount;

    public CombustionGeneratorMenu(int syncId, Inventory inventory, Optional<BlockPosContent> blockPosContent) {
        this(syncId, inventory, (CombustionGeneratorBlockEntity) BlockPosContent.getOrNull(blockPosContent, inventory.player.level()));
    }

    public CombustionGeneratorMenu(int syncId, Inventory inventory, CombustionGeneratorBlockEntity blockEntity) {
        super(ModMenus.COMBUSTION_GENERATOR_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new CombustionSlot(blockEntity, 0, 80, 0),
                        new BatterySlot(blockEntity, 1, 129, 41)
                });

        this.burnTime = this.addDataSlot(DataSlot.standalone());
        this.totalBurnTime = this.addDataSlot(DataSlot.standalone());
        this.energyAmount = this.addDataSlot(DataSlot.standalone());
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        burnTime.set(machine.getBurnTime());
        totalBurnTime.set(machine.getTotalBurnTime());
        energyAmount.set((int) machine.getEnergyStorage().getStoredEnergy());
    }
    
    public long getMaxEnergyCapacity() {
        return this.machine.getEnergyStorage().getCapacity();
    }
}*/