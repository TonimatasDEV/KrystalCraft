package net.tonimatasdev.krystalcraft.menu.slots;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.tonimatasdev.krystalcraft.plorix.fluid.utils.FluidHooks;

public class FluidSlot extends Slot {
    protected Fluid fluid;
    public FluidSlot(Container container, int i, int j, int k, Fluid fluid) {
        super(container, i, j, k);
        this.fluid = fluid;
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return FluidHooks.isFluidContainingItem(itemStack) && FluidHooks.getItemFluidManager(itemStack).getFluidInTank(0).getFluid() == fluid;
    }
}
