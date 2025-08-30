package dev.tonimatas.krystalcraft.menu.slots;

import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class CombustionSlot extends Slot {
    public CombustionSlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return FuelRegistryImpl.INSTANCE.get(stack.getItem()) > 0;
    }
}
