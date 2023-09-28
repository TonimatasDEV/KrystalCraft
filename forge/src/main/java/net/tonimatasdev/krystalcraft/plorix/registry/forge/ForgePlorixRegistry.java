package net.tonimatasdev.krystalcraft.plorix.registry.forge;

import net.minecraft.core.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntries;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;

import java.util.Collection;
import java.util.function.Supplier;

public class ForgePlorixRegistry<T> implements PlorixRegistry<T> {
    private final DeferredRegister<T> register;
    private final RegistryEntries<T> entries = new RegistryEntries<>();

    public ForgePlorixRegistry(Registry<T> registry, String id) {
        this.register = DeferredRegister.create(registry.key(), id);
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return this.entries.add(new ForgeRegistryEntry<>(register.register(id, supplier)));
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return this.entries.getEntries();
    }

    @Override
    public void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        register.register(bus);
    }
}