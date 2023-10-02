package net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.nbt.CompoundTag;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidSnapshot;
import net.tonimatasdev.krystalcraft.plorix.fluid.impl.SimpleFluidSnapshot;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public record PlatformFluidContainer(Storage<FluidVariant> storage) implements FluidContainer {

    @Override
    public long insertFluid(FluidHolder fluid, boolean simulate) {
        try (Transaction transaction = Transaction.openOuter()) {
            FabricFluidHolder fabricFluidHolder = FabricFluidHolder.of(fluid);
            long inserted = storage.insert(fabricFluidHolder.toVariant(), fabricFluidHolder.getAmount(), transaction);
            if (!simulate) {
                transaction.commit();
            }
            return inserted;
        }
    }

    @Override
    public FluidHolder extractFluid(FluidHolder fluid, boolean simulate) {
        try (Transaction transaction = Transaction.openOuter()) {
            FabricFluidHolder fabricFluidHolder = FabricFluidHolder.of(fluid);
            long extracted = storage.extract(fabricFluidHolder.toVariant(), fabricFluidHolder.getAmount(), transaction);
            if (!simulate) {
                transaction.commit();
            }
            return extracted == 0 ? FabricFluidHolder.of(fabricFluidHolder.toVariant(), extracted) : fluid;
        }
    }

    @Override
    public void setFluid(int slot, FluidHolder fluid) {

    }

    @Override
    public List<FluidHolder> getFluids() {
        List<FluidHolder> fluids = new ArrayList<>();
        storage.iterator().forEachRemaining(variant -> fluids.add(FabricFluidHolder.of(variant.getResource(), variant.getAmount())));
        return fluids;
    }

    @Override
    public int getSize() {
        return getFluids().size();
    }

    @Override
    public boolean isEmpty() {
        return getFluids().isEmpty() || getFluids().stream().allMatch(FluidHolder::isEmpty);
    }

    @Override
    public FluidContainer copy() {
        throw new UnsupportedOperationException("You may not copy a PlatformFluidContainer");
    }

    @Override
    public long getTankCapacity(int tank) {
        List<StorageView<FluidVariant>> fluids = new ArrayList<>();
        storage.iterator().forEachRemaining(fluids::add);
        return fluids.get(tank).getCapacity();
    }

    @Override
    public void fromContainer(FluidContainer container) {
        throw new UnsupportedOperationException("You may not overwrite a PlatformFluidContainer");
    }

    @Override
    public long extractFromSlot(FluidHolder fluidHolder, FluidHolder toInsert, Runnable snapshot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean allowsInsertion() {
        return storage.supportsInsertion();
    }

    @Override
    public boolean allowsExtraction() {
        return storage.supportsExtraction();
    }

    @Override
    public FluidSnapshot createSnapshot() {
        return new SimpleFluidSnapshot(this);
    }

    @Override
    public void deserialize(CompoundTag nbt) {

    }

    @Override
    public CompoundTag serialize(CompoundTag nbt) {
        return nbt;
    }

    @Override
    public void clearContent() {
        storage.iterator().forEachRemaining(variant -> storage.extract(variant.getResource(), variant.getAmount(), Transaction.openOuter()));
    }
}
