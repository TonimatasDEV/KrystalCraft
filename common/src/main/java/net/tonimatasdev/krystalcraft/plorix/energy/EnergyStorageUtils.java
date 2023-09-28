package net.tonimatasdev.krystalcraft.plorix.energy;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

public abstract class EnergyStorageUtils implements EnergyStorage {
    @ExpectPlatform
    public static EnergyStorage create(long capacity, long maxTransfer) {
        throw new NotImplementedException();
    }
}
