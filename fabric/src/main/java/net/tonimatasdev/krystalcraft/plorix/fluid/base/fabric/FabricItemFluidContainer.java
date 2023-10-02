package net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidSnapshot;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("UnstableApiUsage")
public class FabricItemFluidContainer extends ExtendedFluidContainer implements Storage<FluidVariant>, ManualSyncing {
    private final FluidContainer container;
    private final ContainerItemContext ctx;

    public FabricItemFluidContainer(ContainerItemContext ctx, FluidContainer container) {
        this.container = container;
        this.ctx = ctx;
        CompoundTag nbt = ctx.getItemVariant().getNbt();
        if (nbt != null) container.deserialize(nbt);
    }

    @Override
    public long insert(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        updateSnapshots(transaction);
        long inserted = container.insertFluid(FabricFluidHolder.of(resource, maxAmount), false);
        setChanged(transaction);
        return inserted;
    }

    @Override
    public long extract(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        updateSnapshots(transaction);
        long extracted = container.extractFluid(FabricFluidHolder.of(resource, maxAmount), false).getFluidAmount();
        setChanged(transaction);
        return extracted;
    }

    @Override
    public @NotNull Iterator<StorageView<FluidVariant>> iterator() {
        List<FluidHolder> fluids = container.getFluids();
        return IntStream.range(0, fluids.size()).mapToObj(index -> new WrappedFluidHolder(this, fluids.get(index), container::extractFromSlot, container.getTankCapacity(index))).map(holder -> (StorageView<FluidVariant>) holder).iterator();
    }

    @Override
    public void onFinalCommit() {

    }

    @Override
    public FluidSnapshot createSnapshot() {
        return container.createSnapshot();
    }

    @Override
    public void readSnapshot(FluidSnapshot snapshot) {
        container.readSnapshot(snapshot);
    }

    @Override
    public void setChanged(TransactionContext transaction) {
        ItemStack stack = ctx.getItemVariant().toStack();
        this.container.serialize(stack.getOrCreateTag());
        ctx.exchange(ItemVariant.of(stack), ctx.getAmount(), transaction);
    }
}
