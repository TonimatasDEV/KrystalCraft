package net.tonimatasdev.krystalcraft.plorix.energy;

public interface EnergyStorage {
    void insert(long amount, boolean simulate);
    void extract(long amount, boolean simulate);
    long getEnergy();
    void setEnergy(long amount);
    long getCapacity();
}
