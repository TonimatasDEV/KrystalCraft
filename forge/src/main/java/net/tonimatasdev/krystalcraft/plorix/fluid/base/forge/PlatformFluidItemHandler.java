package net.tonimatasdev.krystalcraft.plorix.fluid.base.forge;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidSnapshot;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.ItemFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.impl.SimpleFluidSnapshot;
import net.tonimatasdev.krystalcraft.plorix.item.ItemStackHolder;

import java.util.ArrayList;
import java.util.List;

public record PlatformFluidItemHandler(ItemStackHolder holder, IFluidHandlerItem handler) implements ItemFluidContainer {

    public PlatformFluidItemHandler(ItemStackHolder holder) {
        this(holder, holder.getStack().getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).orElseThrow(() -> new IllegalStateException("ItemStackHolder does not have a fluid handler capability")));
    }

    @Override
    public long insertFluid(FluidHolder fluid, boolean simulate) {
        int fill = handler.fill(new ForgeFluidHolder(fluid).getFluidStack(), simulate ? IFluidHandler.FluidAction.SIMULATE : IFluidHandler.FluidAction.EXECUTE);
        if(!simulate) holder.setStack(handler.getContainer());
        return fill;
    }

    @Override
    public FluidHolder extractFluid(FluidHolder fluid, boolean simulate) {
        ForgeFluidHolder drained = new ForgeFluidHolder(handler.drain(new ForgeFluidHolder(fluid).getFluidStack(), simulate ? IFluidHandler.FluidAction.SIMULATE : IFluidHandler.FluidAction.EXECUTE));
        if(!simulate) holder.setStack(handler.getContainer());
        return drained;
    }

    @Override
    public void setFluid(int slot, FluidHolder fluid) {
        FluidStack fluidInTank = handler.getFluidInTank(slot);
        handler.drain(fluidInTank, IFluidHandler.FluidAction.EXECUTE);
        insertFluid(fluid, false);
    }

    @Override
    public List<FluidHolder> getFluids() {
        List<FluidHolder> fluids = new ArrayList<>();
        for (int i = 0; i < handler.getTanks(); i++) {
            fluids.add(new ForgeFluidHolder(handler.getFluidInTank(i)));
        }
        return fluids;
    }

    @Override
    public int getSize() {
        return handler.getTanks();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < handler.getTanks(); i++) {
            if (!handler.getFluidInTank(i).isEmpty()) return false;
        }
        return true;
    }

    @Override
    public FluidContainer copy() {
        throw new UnsupportedOperationException("Copying is not supported on PlatformFluidContainers");
    }

    @Override
    public long getTankCapacity(int tank) {
        return handler.getTankCapacity(tank);
    }

    @Override
    public void fromContainer(FluidContainer container) {
        throw new UnsupportedOperationException("Copying is not supported on PlatformFluidContainers");
    }

    @Override
    public long extractFromSlot(FluidHolder fluidHolder, FluidHolder toInsert, Runnable snapshot) {
        return 0;
    }

    @Override
    public boolean allowsInsertion() {
        return true;
    }

    @Override
    public boolean allowsExtraction() {
        return true;
    }

    @Override
    public FluidSnapshot createSnapshot() {
        return new SimpleFluidSnapshot(this);
    }

    @Override
    public void deserialize(CompoundTag nbt) {

    }

    @Override
    public CompoundTag serialize(CompoundTag nbt) {
        return nbt;
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < handler.getTanks(); i++) {
            handler.drain(handler.getFluidInTank(i), IFluidHandler.FluidAction.EXECUTE);
            holder.setStack(handler.getContainer());
        }
    }

    @Override
    public ItemStack getContainerItem() {
        return handler.getContainer();
    }
}
