package net.tonimatasdev.krystalcraft.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;

public class ModWaterSlot extends SlotItemHandler {
    public ModWaterSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() == ItemRegistry.SET_WATER_BOTTLES.get();
    }
}
