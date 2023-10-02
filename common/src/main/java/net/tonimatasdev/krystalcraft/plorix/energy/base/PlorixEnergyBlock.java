package net.tonimatasdev.krystalcraft.plorix.energy.base;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.tonimatasdev.krystalcraft.plorix.util.Updatable;

public interface PlorixEnergyBlock<T extends EnergyContainer & Updatable<BlockEntity>> {
    T getEnergyStorage();
}
