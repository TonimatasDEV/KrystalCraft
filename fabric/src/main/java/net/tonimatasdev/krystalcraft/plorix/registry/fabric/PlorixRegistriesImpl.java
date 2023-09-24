package net.tonimatasdev.krystalcraft.plorix.registry.fabric;

import net.minecraft.core.Registry;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;

public class PlorixRegistriesImpl {
    public static <T> PlorixRegistry<T> create(Registry<T> registry, String id) {
        return new FabricPlorixRegistry<>(registry, id);
    }
}
