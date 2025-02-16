package dev.tonimatas.krystalcraft.energy.fabric;

import dev.tonimatas.krystalcraft.energy.EnergyStorageK;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.world.item.ItemStack;

public class EnergyImpl {
    public static EnergyStorageK createEnergyStorage(long capacity, long maxInsert, long maxExtract) {
        return new EnergyStorageKFabric(capacity, maxInsert, maxExtract);
    }

    public static int getBurnTime(ItemStack itemStack) {
        return FuelRegistryImpl.INSTANCE.get(itemStack.getItem());
    }
}
