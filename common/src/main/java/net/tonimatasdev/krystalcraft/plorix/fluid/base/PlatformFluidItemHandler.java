package net.tonimatasdev.krystalcraft.plorix.fluid.base;

import net.tonimatasdev.krystalcraft.plorix.item.ItemStackHolder;

public interface PlatformFluidItemHandler {
    long insertFluid(ItemStackHolder item, FluidHolder fluid, boolean simulate);

    FluidHolder extractFluid(ItemStackHolder item, FluidHolder fluid, boolean simulate);

    int getTankAmount();

    FluidHolder getFluidInTank(int tank);

    long getTankCapacity(int tank);

    boolean supportsInsertion();

    boolean supportsExtraction();
}
