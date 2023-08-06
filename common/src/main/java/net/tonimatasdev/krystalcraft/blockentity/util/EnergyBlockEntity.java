package net.tonimatasdev.krystalcraft.blockentity.util;

import earth.terrarium.botarium.common.energy.EnergyApi;
import earth.terrarium.botarium.common.energy.base.BotariumEnergyBlock;
import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.AbstractMachineBlockEntity;

public abstract class EnergyBlockEntity extends AbstractMachineBlockEntity implements BotariumEnergyBlock<WrappedBlockEnergyContainer> {
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
        getEnergyStorage().extractEnergy(energy, false);
    }

    public void energyInsert(long energy) {
        getEnergyStorage().insertEnergy(energy, false);
    }

    public void energyInternalExtract(long energy) {
        getEnergyStorage().internalExtract(energy, false);
    }

    public void energyInternalInsert(long energy) {
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

    public void energyMoveBetweenItems(ItemStack from, ItemStack to, long amount) {
        ItemStackHolder fromItemStackHolder = new ItemStackHolder(from);
        ItemStackHolder toItemStackHolder = new ItemStackHolder(to);
        EnergyApi.moveEnergy(fromItemStackHolder, toItemStackHolder, amount, false);
    }

    public void energyMoveItemToBlock(ItemStack from, BlockEntity to, long amount) {
        ItemStackHolder fromItemStackHolder = new ItemStackHolder(from);
        EnergyApi.moveEnergy(fromItemStackHolder, to, null, amount, false);
    }

    public void energyMoveBlockToItem(BlockEntity from, ItemStack to, long amount) {
        ItemStackHolder toItemStackHolder = new ItemStackHolder(to);
        EnergyApi.moveEnergy(from, null, toItemStackHolder, amount, false);
    }

    public void energyInsertToBattery(int batterySlot, int amount) {
        if (!getItem(batterySlot).isEmpty()) {
            energyMoveBetweenContainers(getEnergyStorage(), EnergyApi.getItemEnergyContainer(new ItemStackHolder(getItem(batterySlot))), amount);
        }
    }

    public void energyInsertOfBattery(int batterySlot, int amount) {
        if (!getItem(batterySlot).isEmpty()) {
            energyMoveBetweenContainers(EnergyApi.getItemEnergyContainer(new ItemStackHolder(getItem(batterySlot))), getEnergyStorage(), amount);
        }
    }
}
