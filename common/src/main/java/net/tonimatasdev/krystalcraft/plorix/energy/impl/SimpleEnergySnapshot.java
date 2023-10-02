package net.tonimatasdev.krystalcraft.plorix.energy.impl;

import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergySnapshot;

public class SimpleEnergySnapshot implements EnergySnapshot {
    private final long energy;

    public SimpleEnergySnapshot(EnergyContainer container) {
        this.energy = container.getStoredEnergy();
    }

    @Override
    public void loadSnapshot(EnergyContainer container) {
        container.setEnergy(energy);
    }
}
