package dev.tonimatas.krystalcraft.energy.neoforge;

import dev.tonimatas.krystalcraft.energy.EnergyStorageK;
import net.minecraft.world.item.ItemStack;

public class EnergyImpl {
    public static EnergyStorageK createEnergyStorage(long capacity, long maxInsert, long maxExtract) {
        return new EnergyStorageKNeoForge((int) capacity, (int) maxInsert, (int) maxExtract, 0);
    }

    public static int getBurnTime(ItemStack itemStack) {
        return itemStack.getBurnTime(null);
    }
}
