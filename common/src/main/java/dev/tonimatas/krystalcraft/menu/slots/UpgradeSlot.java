package dev.tonimatas.krystalcraft.menu.slots;

import dev.tonimatas.krystalcraft.item.custom.UpgradeItem;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class UpgradeSlot extends Slot {
    public UpgradeSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return itemStack.getItem() instanceof UpgradeItem;
    }
}
