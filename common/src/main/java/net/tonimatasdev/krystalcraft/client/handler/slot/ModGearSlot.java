package net.tonimatasdev.krystalcraft.client.handler.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;

public class ModGearSlot extends Slot {
    public ModGearSlot(Container container, int index, int xPosition, int yPosition) {
        super(container, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() == ItemRegistry.GRINDING_GEAR.get();
    }
}
