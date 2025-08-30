package dev.tonimatas.krystalcraft.menu.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class BatterySlot extends Slot {

    public BatterySlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
        //return EnergyContainer.holdsEnergy(stack);
    }
}
