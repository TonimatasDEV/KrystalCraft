package dev.tonimatas.krystalcraft.screen.slots;

import dev.tonimatas.krystalcraft.util.EnergyUtils;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class EnergySlot extends Slot {

    public EnergySlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return EnergyUtils.isEnergyItem(inventory, getIndex(), stack);
    }
}
