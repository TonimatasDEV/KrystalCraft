package dev.tonimatas.krystalcraft.screen.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import team.reborn.energy.api.EnergyStorage;

public class EnergySlot extends Slot {

    public EnergySlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        EnergyStorage storage = EnergyStorage.ITEM.find(stack, null);
        return storage != null;
    }
}
