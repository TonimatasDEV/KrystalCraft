package net.tonimatasdev.krystalcraft.plorix.fluid.base;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.tonimatasdev.krystalcraft.plorix.util.Updatable;

public interface PlorixFluidBlock<T extends FluidContainer & Updatable<BlockEntity>> {
    T getFluidContainer();
}