package net.tonimatasdev.krystalcraft.plorix.energy.impl;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.tonimatasdev.krystalcraft.plorix.Plorix;
import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergySnapshot;

public class SimpleEnergyContainer implements EnergyContainer {
    private final long capacity;
    private long energy;

    public SimpleEnergyContainer(long maxCapacity) {
        this.capacity = maxCapacity;
    }

    @Override
    public long insertEnergy(long maxAmount, boolean simulate) {
        long inserted = (long) Mth.clamp(maxAmount, 0, getMaxCapacity() - getStoredEnergy());
        if (simulate) return inserted;
        this.setEnergy(this.energy + inserted);
        return inserted;
    }

    @Override
    public long extractEnergy(long maxAmount, boolean simulate) {
        long extracted = (long) Mth.clamp(maxAmount, 0, getStoredEnergy());
        if (simulate) return extracted;
        this.setEnergy(this.energy - extracted);
        return extracted;
    }

    @Override
    public long internalInsert(long maxAmount, boolean simulate) {
        return insertEnergy(maxAmount, simulate);
    }

    @Override
    public long internalExtract(long maxAmount, boolean simulate) {
        return extractEnergy(maxAmount, simulate);
    }

    @Override
    public void setEnergy(long energy) {
        this.energy = energy;
    }

    @Override
    public long getStoredEnergy() {
        return energy;
    }

    @Override
    public long getMaxCapacity() {
        return capacity;
    }

    @Override
    public long maxInsert() {
        return 1024;
    }

    @Override
    public long maxExtract() {
        return 1024;
    }

    @Override
    public CompoundTag serialize(CompoundTag root) {
        CompoundTag tag = root.getCompound(Plorix.PLORIX_DATA);
        tag.putLong("Energy", this.energy);
        root.put(Plorix.PLORIX_DATA, tag);
        return root;
    }

    @Override
    public void deserialize(CompoundTag root) {
        CompoundTag tag = root.getCompound(Plorix.PLORIX_DATA);
        this.energy = tag.getLong("Energy");
    }

    @Override
    public boolean allowsInsertion() {
        return true;
    }

    @Override
    public boolean allowsExtraction() {
        return true;
    }

    @Override
    public EnergySnapshot createSnapshot() {
        return new SimpleEnergySnapshot(this);
    }

    @Override
    public void clearContent() {
        this.energy = 0;
    }
}
