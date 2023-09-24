package net.tonimatasdev.krystalcraft.plorix.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import org.apache.commons.lang3.NotImplementedException;

public class PlorixRegistries {
    public static <T> PlorixRegistry<T> create(PlorixRegistry<T> parent) {
        return new PlorixRegistryImpl<>(parent);
    }

    @ExpectPlatform
    public static <T> PlorixRegistry<T> create(Registry<T> registry, String id) {
        throw new NotImplementedException();
    }
}
