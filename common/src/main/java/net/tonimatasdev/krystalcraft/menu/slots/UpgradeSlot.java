package net.tonimatasdev.krystalcraft.menu.slots;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.item.custom.UpgradeItem;

public class UpgradeSlot extends Slot {
    public UpgradeSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return itemStack.getItem() instanceof UpgradeItem;
    }
}
