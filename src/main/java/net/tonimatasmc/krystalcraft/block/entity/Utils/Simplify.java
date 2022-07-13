package net.tonimatasmc.krystalcraft.block.entity.Utils;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.ItemStackHandler;
import net.tonimatasmc.krystalcraft.item.ModItems;

public class Simplify {
    public static boolean hasWaterInWaterSlot(ItemStackHandler itemStackHandler) {
        return itemStackHandler.getStackInSlot(0).getItem() == ModItems.SET_WATER_BOTTLES.get();
    }

    public static boolean hasCoalSlot(ItemStackHandler itemStackHandler, int fuelProgress, int fuelMaxProgress) {
        return itemStackHandler.getStackInSlot(2).getItem() == Items.COAL || fuelProgress <= fuelMaxProgress;
    }

    public static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    public static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }
}
