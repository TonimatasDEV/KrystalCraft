package net.tonimatasdev.krystalcraft.plorix.registry;

import java.util.Collection;
import java.util.function.Supplier;

public class PlorixRegistryImpl<T> implements PlorixRegistry<T> {

    private final PlorixRegistry<T> parent;
    private final RegistryEntries<T> entries = new RegistryEntries<>();

    public PlorixRegistryImpl(PlorixRegistry<T> parent) {
        this.parent = parent;
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return this.entries.add(parent.register(id, supplier));
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return entries.getEntries();
    }

    @Override
    public void init() {
        //NO-OP
    }
}
