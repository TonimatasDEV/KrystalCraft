package net.tonimatasdev.krystalcraft.plorix.fluid.base;

import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.plorix.util.Updatable;

public interface PlorixFluidItem<T extends ItemFluidContainer & Updatable<ItemStack>> {
    T getFluidContainer(ItemStack holder);
}