package net.tonimatasdev.krystalcraft.plorix.energy.forge;

import net.tonimatasdev.krystalcraft.plorix.energy.EnergyStorage;

public class ForgeEnergyStorage extends net.minecraftforge.energy.EnergyStorage implements EnergyStorage {
    public ForgeEnergyStorage(long capacity, long maxTransfer) {
        super(Math.toIntExact(capacity), Math.toIntExact(maxTransfer));
    }

    public void insert(long amount, boolean simulate) {
        super.receiveEnergy(Math.toIntExact(amount), simulate);
    }

    public void extract(long amount, boolean simulate) {
        super.extractEnergy(Math.toIntExact(amount), simulate);
    }

    public long getEnergy() {
        return super.getEnergyStored();
    }

    public void setEnergy(long amount) {
        this.energy = Math.toIntExact(amount);
    }

    public long getCapacity() {
        return super.getMaxEnergyStored();
    }
}
