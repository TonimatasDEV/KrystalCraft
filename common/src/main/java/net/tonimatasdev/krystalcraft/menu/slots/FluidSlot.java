package net.tonimatasdev.krystalcraft.menu.slots;

import dev.tonimatas.mythlib.fluid.FluidApi;
import dev.tonimatas.mythlib.item.ItemStackHolder;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public class FluidSlot extends Slot {
    protected Fluid fluid;
    public FluidSlot(Container container, int i, int j, int k, Fluid fluid) {
        super(container, i, j, k);
        this.fluid = fluid;
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return FluidApi.isFluidContainingItem(itemStack) && FluidApi.getItemFluidContainer(new ItemStackHolder(itemStack)).getFluids().get(0).getFluid() == fluid;
    }
}
