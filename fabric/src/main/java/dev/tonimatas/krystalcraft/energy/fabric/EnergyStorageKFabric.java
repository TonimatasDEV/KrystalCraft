package dev.tonimatas.krystalcraft.energy.fabric;

import dev.tonimatas.krystalcraft.energy.EnergyStorageK;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class EnergyStorageKFabric extends SimpleEnergyStorage implements EnergyStorageK {
    public EnergyStorageKFabric(long capacity, long maxInsert, long maxExtract) {
        super(capacity, maxInsert, maxExtract);
    }

    @Override
    public long getStoredEnergy() {
        return super.getAmount();
    }

    @Override
    public long getMaxInsert() {
        return super.maxInsert;
    }

    @Override
    public long getMaxExtract() {
        return super.maxExtract;
    }

    @Override
    public long extract(long amount, boolean simulate) {
        long transferred;

        try (Transaction tx = Transaction.openOuter()) {
            transferred = super.extract(amount, tx);
            tx.commit();
        }

        return transferred;
    }

    @Override
    public long insert(long amount, boolean simulate) {
        long transferred;
        
        try (Transaction tx = Transaction.openOuter()) {
            transferred = super.insert(amount, tx);
            tx.commit();
        }

        return transferred;
    }

    @Override
    public void setEnergy(long amount) {

    }
}
