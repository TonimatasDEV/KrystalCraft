package dev.tonimatas.krystalcraft.energy.neoforge;

import dev.tonimatas.krystalcraft.energy.EnergyStorageK;
import net.neoforged.neoforge.energy.EnergyStorage;

public class EnergyStorageKNeoForge extends EnergyStorage implements EnergyStorageK {
    public EnergyStorageKNeoForge(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public long getStoredEnergy() {
        return super.getEnergyStored();
    }

    @Override
    public long getCapacity() {
        return super.getMaxEnergyStored();
    }

    @Override
    public long getMaxInsert() {
        return super.maxReceive;
    }

    @Override
    public long getMaxExtract() {
        return super.maxExtract;
    }

    @Override
    public long extract(long amount, boolean simulate) {
        return super.extractEnergy((int) amount, simulate);
    }

    @Override
    public long insert(long amount, boolean simulate) {
        return super.extractEnergy((int) amount, simulate);
    }

    @Override
    public void setEnergy(long amount) {
        this.energy = (int) amount;
    }
}
