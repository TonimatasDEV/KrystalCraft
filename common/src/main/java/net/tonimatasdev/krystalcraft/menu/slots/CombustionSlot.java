package net.tonimatasdev.krystalcraft.menu.slots;

import dev.tonimatas.mythlib.util.Hooks;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CombustionSlot extends Slot {
    public CombustionSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return Hooks.getBurnTime(itemStack) > 0;
    }
}
