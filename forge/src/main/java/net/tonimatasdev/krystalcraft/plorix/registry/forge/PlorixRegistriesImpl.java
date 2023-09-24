package net.tonimatasdev.krystalcraft.plorix.registry.forge;

import net.minecraft.core.Registry;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;

public class PlorixRegistriesImpl {
    public static <T> PlorixRegistry<T> create(Registry<T> registry, String id) {
        return new ForgePlorixRegistry<>(registry, id);
    }
}
