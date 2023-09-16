package net.tonimatasdev.krystalcraft.menu.slots;

import earth.terrarium.botarium.util.CommonHooks;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CombustionSlot extends Slot {
    public CombustionSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return CommonHooks.getBurnTime(itemStack) > 0;
    }
}
