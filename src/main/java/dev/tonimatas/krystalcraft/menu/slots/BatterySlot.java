package dev.tonimatas.krystalcraft.menu.slots;

import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BatterySlot extends Slot {

    public BatterySlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return EnergyContainer.holdsEnergy(itemStack);
    }
}
