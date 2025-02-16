package dev.tonimatas.krystalcraft.energy;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.NotImplementedException;

public class Energy {
    @ExpectPlatform
    public static EnergyStorageK createEnergyStorage(long capacity, long maxInsert, long maxExtract) {
        throw new NotImplementedException("Not implemented yet");
    }

    public static EnergyStorageK createInsertEnergyStorage(long capacity, long maxInsert) {
        return createEnergyStorage(capacity, maxInsert, 0);
    }

    public static EnergyStorageK createExtractEnergyStorage(long capacity, long maxExtract) {
        return createEnergyStorage(capacity, 0, maxExtract);
    }
    
    @ExpectPlatform
    public static int getBurnTime(ItemStack itemStack) {
        throw new NotImplementedException("Not implemented yet");
    }
}
