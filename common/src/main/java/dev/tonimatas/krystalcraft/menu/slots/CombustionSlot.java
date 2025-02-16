package dev.tonimatas.krystalcraft.menu.slots;

import dev.tonimatas.krystalcraft.energy.Energy;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CombustionSlot extends Slot {
    public CombustionSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return Energy.getBurnTime(itemStack) > 0;
    }
}
