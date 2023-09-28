package net.tonimatasdev.krystalcraft.plorix.energy.fabric;

import net.tonimatasdev.krystalcraft.plorix.energy.EnergyStorage;

public class EnergyStorageUtilsImpl {
    public static EnergyStorage create(long capacity, long maxTransfer) {
        return new FabricEnergyStorage(capacity, maxTransfer);
    }
}
