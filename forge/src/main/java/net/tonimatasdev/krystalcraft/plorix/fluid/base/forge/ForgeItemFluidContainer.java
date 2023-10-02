package net.tonimatasdev.krystalcraft.plorix.fluid.base.forge;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.ItemFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.util.Updatable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record ForgeItemFluidContainer<T extends ItemFluidContainer & Updatable<ItemStack>>(T container, ItemStack itemStack) implements IFluidHandlerItem, ICapabilityProvider {

    @Override
    public @NotNull ItemStack getContainer() {
        return container.getContainerItem();
    }

    @Override
    public int getTanks() {
        return container.getSize();
    }

    @Override
    public @NotNull FluidStack getFluidInTank(int i) {
        return new ForgeFluidHolder(container.getFluids().get(i)).getFluidStack();
    }

    @Override
    public int getTankCapacity(int i) {
        return (int) container.getTankCapacity(i);
    }

    @Override
    public boolean isFluidValid(int i, @NotNull FluidStack fluidStack) {
        return getFluidInTank(i).isFluidEqual(fluidStack);
    }

    @Override
    public int fill(FluidStack fluidStack, FluidAction fluidAction) {
        long filled = this.container.insertFluid(new ForgeFluidHolder(fluidStack), fluidAction.simulate());
        container.update(itemStack);
        return (int) filled;
    }

    @Override
    public @NotNull FluidStack drain(FluidStack fluidStack, FluidAction fluidAction) {
        FluidStack drained = new ForgeFluidHolder(this.container.extractFluid(new ForgeFluidHolder(fluidStack), fluidAction.simulate())).getFluidStack();
        container.update(itemStack);
        return drained;
    }

    @Override
    public @NotNull FluidStack drain(int i, FluidAction fluidAction) {
        FluidHolder fluid = this.container.getFluids().get(0).copyHolder();
        if (fluid.isEmpty()) return FluidStack.EMPTY;
        fluid.setAmount(i);
        container.update(itemStack);
        return new ForgeFluidHolder(this.container.extractFluid(fluid, fluidAction.simulate())).getFluidStack();
    }

    @Override
    public @NotNull <Y> LazyOptional<Y> getCapability(@NotNull Capability<Y> capability, @Nullable Direction arg) {
        LazyOptional<IFluidHandlerItem> of = LazyOptional.of(container.getContainer(arg) != null ? () -> this : null);
        return capability.orEmpty(ForgeCapabilities.FLUID_HANDLER_ITEM, of.cast()).cast();
    }
}
