package dev.tonimatas.krystalcraft.menu;
/*
import dev.tonimatas.krystalcraft.blockentity.CuttingStationBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.StationMenu;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import dev.tonimatas.krystalcraft.menu.slots.FuelSlot;
import dev.tonimatas.krystalcraft.menu.slots.FluidSlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.material.Fluids;

import java.util.Optional;

@SuppressWarnings("DataFlowIssue")
public class CuttingStationMenu extends StationMenu<CuttingStationBlockEntity> {
    public final DataSlot tankAmount;
    
    public CuttingStationMenu(int syncId, Inventory inventory, Optional<BlockPosContent> blockPosContent) {
        this(syncId, inventory, (CuttingStationBlockEntity) BlockPosContent.getOrNull(blockPosContent, inventory.player.level()));
    }

    public CuttingStationMenu(int syncId, Inventory inventory, CuttingStationBlockEntity blockEntity) {
        super(ModMenus.CUTTING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 50),
                        new FuelSlot(blockEntity, 2, 128, 44),
                        new FluidSlot(blockEntity, 3, 6, 5, Fluids.WATER),
                        new ResultSlot(blockEntity, 4, 6, 40)
                });
        this.tankAmount = this.addDataSlot(DataSlot.standalone());
    }

    public long getTankCapacity() {
        return this.machine.getFluidContainer().getTankCapacity(0);
    }

    public FluidHolder getFluidHolder() {
        return this.machine.getFluidContainer().getFirstFluid();
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        this.tankAmount.set((int) this.machine.getFluidContainer().getFirstFluid().getFluidAmount());
    }
}*/