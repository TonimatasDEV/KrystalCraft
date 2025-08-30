package dev.tonimatas.krystalcraft.screen.slots;

import dev.tonimatas.krystalcraft.item.custom.UpgradeItem;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class UpgradeSlot extends Slot {
    public UpgradeSlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof UpgradeItem;
    }
}
