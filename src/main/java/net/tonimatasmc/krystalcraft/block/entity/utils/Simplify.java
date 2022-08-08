package net.tonimatasmc.krystalcraft.block.entity.utils;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.tonimatasmc.krystalcraft.item.ModItems;

public class Simplify {
    public static boolean hasGrindingGearInGearSlot(ItemStackHandler itemStackHandler, int slot) {
        return itemStackHandler.getStackInSlot(slot).getItem() == ModItems.GRINDING_GEAR.get();
    }

    public static boolean hasWaterInWaterSlot(ItemStackHandler itemStackHandler, int slot) {
        return itemStackHandler.getStackInSlot(slot).getItem() == ModItems.SET_WATER_BOTTLES.get();
    }

    public static boolean hasToolsInToolSlot(ItemStackHandler itemStackHandler, int slot) {
        return itemStackHandler.getStackInSlot(slot).getItem() == ModItems.GEM_CUTTER_TOOL.get();
    }

    public static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output, int slot) {
        return inventory.getItem(slot).getItem() == output.getItem() || inventory.getItem(slot).isEmpty();
    }

    public static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory, int slot) {
        return inventory.getItem(slot).getMaxStackSize() > inventory.getItem(slot).getCount();
    }
}
