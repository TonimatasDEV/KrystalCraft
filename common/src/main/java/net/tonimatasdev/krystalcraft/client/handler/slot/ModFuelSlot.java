package net.tonimatasdev.krystalcraft.client.handler.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModFuelSlot extends Slot {
    public ModFuelSlot(Container container, int index, int xPosition, int yPosition) {
        super(container, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() == Items.COAL || stack.getItem() == Items.CHARCOAL;
    }
}
