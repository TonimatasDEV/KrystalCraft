package dev.tonimatas.krystalcraft.screen.slots;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class FuelSlot extends Slot {
    public FuelSlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return AbstractFurnaceBlockEntity.canUseAsFuel(stack);
    }
}
