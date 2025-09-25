package dev.tonimatas.krystalcraft.screen.slots;

import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class FluidSlot extends Slot {
    protected Fluid fluid;
    public FluidSlot(Inventory inventory, int i, int j, int k, Fluid fluid) {
        super(inventory, i, j, k);
        this.fluid = fluid;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isOf(Items.WATER_BUCKET) || stack.isOf(Items.BUCKET);
    }
}
