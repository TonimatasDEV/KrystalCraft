package dev.tonimatas.krystalcraft.menu;

import dev.tonimatas.krystalcraft.blockentity.CuttingFactoryBlockEntity;
import dev.tonimatas.krystalcraft.menu.base.FactoryMenu;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import dev.tonimatas.krystalcraft.menu.slots.BatterySlot;
import dev.tonimatas.krystalcraft.menu.slots.FluidSlot;
import dev.tonimatas.krystalcraft.menu.slots.ResultSlot;
import dev.tonimatas.krystalcraft.menu.slots.UpgradeSlot;
import dev.tonimatas.krystalcraft.registry.ModMenus;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.material.Fluids;

import java.util.Optional;

@SuppressWarnings("DataFlowIssue")
public class CuttingFactoryMenu extends FactoryMenu<CuttingFactoryBlockEntity> {
    public final DataSlot tankAmount;
    
    public CuttingFactoryMenu(int syncId, Inventory inventory, Optional<BlockPosContent> blockPosContent) {
        this(syncId, inventory, (CuttingFactoryBlockEntity) BlockPosContent.getOrNull(blockPosContent, inventory.player.level()));
    }

    public CuttingFactoryMenu(int syncId, Inventory inventory, CuttingFactoryBlockEntity blockEntity) {
        super(ModMenus.CUTTING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 50),
                        new BatterySlot(blockEntity, 2, 129, 41),
                        new UpgradeSlot(blockEntity, 3, 106, -12),
                        new UpgradeSlot(blockEntity, 4, 126, -12),
                        new FluidSlot(blockEntity, 5, 6, 5, Fluids.WATER),
                        new ResultSlot(blockEntity, 6, 6, 40)
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
}