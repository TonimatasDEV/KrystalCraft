package net.tonimatasdev.krystalcraft.plorix.energy.base;

import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.plorix.util.Updatable;

public interface PlorixEnergyItem<T extends EnergyContainer & Updatable<ItemStack>> {
    T getEnergyStorage(ItemStack holder);
}
