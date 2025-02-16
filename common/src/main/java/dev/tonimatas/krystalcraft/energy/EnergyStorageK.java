package dev.tonimatas.krystalcraft.energy;

public interface EnergyStorageK {
    long getStoredEnergy();
    
    long getCapacity();
    
    long getMaxInsert();
    
    long getMaxExtract();
    
    long extract(long amount, boolean simulate);
    
    long insert(long amount, boolean simulate);
    
    void setEnergy(long amount);
}
