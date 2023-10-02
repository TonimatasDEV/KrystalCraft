package net.tonimatasdev.krystalcraft.plorix.fluid.impl;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidSnapshot;
import net.tonimatasdev.krystalcraft.plorix.util.Updatable;

import java.util.List;
import java.util.Objects;

public record WrappedBlockFluidContainer(BlockEntity block, FluidContainer container) implements FluidContainer, Updatable<BlockEntity> {
    @Override
    public long insertFluid(FluidHolder fluid, boolean simulate) {
        return container.insertFluid(fluid, simulate);
    }

    @Override
    public long internalInsert(FluidHolder fluids, boolean simulate) {
        long inserted = container.internalInsert(fluids, simulate);
        if (!simulate) update(block);
        return inserted;
    }

    @Override
    public FluidHolder extractFluid(FluidHolder fluid, boolean simulate) {
        return container.extractFluid(fluid, simulate);
    }

    @Override
    public FluidHolder internalExtract(FluidHolder fluid, boolean simulate) {
        FluidHolder extracted = container.internalExtract(fluid, simulate);
        if (!simulate) update(block);
        return extracted;
    }

    @Override
    public void setFluid(int slot, FluidHolder fluid) {
        container.setFluid(slot, fluid);
    }

    @Override
    public List<FluidHolder> getFluids() {
        return container.getFluids();
    }

    @Override
    public int getSize() {
        return container.getSize();
    }

    @Override
    public boolean isEmpty() {
        return container.isEmpty();
    }

    @Override
    public FluidContainer copy() {
        return container.copy();
    }

    @Override
    public long getTankCapacity(int tankSlot) {
        return container.getTankCapacity(tankSlot);
    }

    @Override
    public void fromContainer(FluidContainer container) {
        this.container.fromContainer(container);
    }

    @Override
    public long extractFromSlot(FluidHolder fluidHolder, FluidHolder toInsert, Runnable snapshot) {
        long extract = container.extractFromSlot(fluidHolder, toInsert, snapshot);
        update(block);
        return extract;
    }

    @Override
    public boolean allowsInsertion() {
        return container.allowsInsertion();
    }

    @Override
    public boolean allowsExtraction() {
        return container.allowsExtraction();
    }

    @Override
    public FluidSnapshot createSnapshot() {
        return container.createSnapshot();
    }

    @Override
    public CompoundTag serialize(CompoundTag tag) {
        return container.serialize(tag);
    }

    @Override
    public void deserialize(CompoundTag tag) {
        container.deserialize(tag);
    }

    @Override
    public void update(BlockEntity block) {
        block.setChanged();
        Objects.requireNonNull(block.getLevel()).sendBlockUpdated(block.getBlockPos(), block.getBlockState(), block.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void clearContent() {
        container.clearContent();
    }
}
