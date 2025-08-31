package dev.tonimatas.krystalcraft.util;

import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class FabricUtils {
    public static int getBurnTime(ItemStack itemStack) {
        Integer fuel = FuelRegistryImpl.INSTANCE.get(itemStack.getItem());
        return Objects.requireNonNullElse(fuel, 0);
    }
}
