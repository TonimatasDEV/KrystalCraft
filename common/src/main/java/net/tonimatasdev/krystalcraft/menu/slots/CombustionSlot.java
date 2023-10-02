package net.tonimatasdev.krystalcraft.menu.slots;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.plorix.util.Hooks;

public class CombustionSlot extends Slot {
    public CombustionSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return Hooks.getBurnTime(itemStack) > 0;
    }
}
