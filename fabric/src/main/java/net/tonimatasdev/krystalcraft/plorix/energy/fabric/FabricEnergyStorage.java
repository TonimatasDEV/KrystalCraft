package net.tonimatasdev.krystalcraft.plorix.energy.fabric;

import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.tonimatasdev.krystalcraft.plorix.energy.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

@SuppressWarnings("UnstableApiUsage")
public class FabricEnergyStorage extends SimpleEnergyStorage implements EnergyStorage {

    public FabricEnergyStorage(long capacity, long maxTransfer) {
        super(capacity, maxTransfer, maxTransfer);
    }

    public void insert(long amount, boolean simulate) {
        try (Transaction transaction = Transaction.openOuter()) {
            super.insert(amount, transaction);
            transaction.commit();
        }
    }

    public void extract(long amount, boolean simulate) {
        try (Transaction transaction = Transaction.openOuter()) {
            super.extract(amount, transaction);
            transaction.commit();
        }
    }

    public long getEnergy() {
        return super.getCapacity();
    }

    public void setEnergy(long amount) {
        this.amount = amount;
    }

    public long getCapacity() {
        return super.getCapacity();
    }
}
