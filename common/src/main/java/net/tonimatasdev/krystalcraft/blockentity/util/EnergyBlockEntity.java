package net.tonimatasdev.krystalcraft.blockentity.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.plorix.energy.EnergyApi;
import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.PlorixEnergyBlock;
import net.tonimatasdev.krystalcraft.plorix.energy.impl.WrappedBlockEnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.item.ItemStackHolder;

public abstract class EnergyBlockEntity extends AbstractBlockEntity implements PlorixEnergyBlock<WrappedBlockEnergyContainer> {
    protected WrappedBlockEnergyContainer energyContainer;

    public EnergyBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        energySet(compoundTag.getLong("Energy"));
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putLong("Energy", energyAmount());
    }

    public long energyAmount() {
        return getEnergyStorage().getStoredEnergy();
    }

    public long energyCapacity() {
        return getEnergyStorage().getMaxCapacity();
    }

    public void energySet(long energy) {
        getEnergyStorage().setEnergy(energy);
    }

    public void energyExtract(long energy) {
        getEnergyStorage().internalExtract(energy, false);
    }

    public void energyInsert(long energy) {
        getEnergyStorage().internalInsert(energy, false);
    }

    public void energyDistributeNearby(long amount) {
        EnergyApi.distributeEnergyNearby(this, amount);
    }

    public void energyMoveBetweenBlocks(BlockEntity from, BlockEntity to, long amount) {
        EnergyApi.moveEnergy(from, to, amount, false);
    }

    public void energyMoveBetweenContainers(EnergyContainer from, EnergyContainer to, long amount) {
        EnergyApi.moveEnergy(from, to, amount, false);
    }

    public void energyMoveBetweenItems(ItemStackHolder from, ItemStackHolder to, long amount) {
        EnergyApi.moveEnergy(from, to, amount, false);
    }

    public long energyMoveItemToBlock(ItemStackHolder from, BlockEntity to, long amount) {
        return EnergyApi.moveEnergy(from, to, null, amount, false);
    }

    public long energyMoveBlockToItem(BlockEntity from, ItemStackHolder to, long amount) {
        return EnergyApi.moveEnergy(from, null, to, EnergyApi.moveEnergy(from, null, to, amount, true), false);
    }

    public void energyInsertToEnergySlot(int energyOutputSlot, int amount) {
        if (getItem(energyOutputSlot).isEmpty()) return;
        ItemStackHolder stackHolder = new ItemStackHolder(getItem(energyOutputSlot));
        if (energyMoveBlockToItem(this, stackHolder, amount) != 0 && stackHolder.isDirty()) setItem(energyOutputSlot, stackHolder.getStack());
    }

    public void energyExtractFromEnergySlot(int energyOutputSlot, int amount) {
        if (getItem(energyOutputSlot).isEmpty()) return;
        ItemStackHolder stackHolder = new ItemStackHolder(getItem(energyOutputSlot));
        if (energyMoveItemToBlock(stackHolder, this, amount) != 0 && stackHolder.isDirty()) setItem(energyOutputSlot, stackHolder.getStack());
    }
}
