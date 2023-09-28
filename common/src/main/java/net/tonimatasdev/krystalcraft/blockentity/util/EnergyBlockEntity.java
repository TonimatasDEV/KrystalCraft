package net.tonimatasdev.krystalcraft.blockentity.util;

import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.plorix.energy.EnergyStorage;

public abstract class EnergyBlockEntity extends AbstractBlockEntity {
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
        return getEnergyStorage().getEnergy();
    }

    public long energyCapacity() {
        return getEnergyStorage().getCapacity();
    }

    public void energySet(long energy) {
        getEnergyStorage().setEnergy(energy);
    }

    public void energyExtract(long energy) {
        getEnergyStorage().extract(energy, false);
    }

    public void energyInsert(long energy) {
        getEnergyStorage().insert(energy, false);
    }

    public void energyDistributeNearby(long amount) {
        //EnergyApi.distributeEnergyNearby(this, amount);
    }

    public void energyMoveBetweenBlocks(BlockEntity from, BlockEntity to, long amount) {
        //EnergyHooks.moveBlockToBlockEnergy(from, to, amount);
    }

    public void energyMoveBetweenContainers(EnergyContainer from, EnergyContainer to, long amount) {
        //EnergyApi.moveEnergy(from, to, amount, false);
    }

    public void energyMoveBetweenItems(ItemStackHolder from, ItemStackHolder to, long amount) {
        //EnergyHooks.safeMoveItemToItemEnergy(from, to, amount);
    }

    //public long energyMoveItemToBlock(ItemStackHolder from, BlockEntity to, long amount) {
    //    return 0; //EnergyHooks.safeMoveItemToBlockEnergy(from, to, null, amount);
    //}

    //public long energyMoveBlockToItem(BlockEntity from, ItemStackHolder to, long amount) {
    //    return 0; //EnergyHooks.safeMoveBlockToItemEnergy(from, null, to, amount);
    //}

    //public void energyInsertToEnergyOutputSlot(int energyOutputSlot, int amount) {
    //    if (!getItem(energyOutputSlot).isEmpty()) {
    //        ItemStackHolder stackHolder = new ItemStackHolder(getItem(energyOutputSlot));
//
    //        if (energyMoveBlockToItem(this, stackHolder, amount) != 0) {
    //            if (stackHolder.isDirty()) setItem(energyOutputSlot, stackHolder.getStack());
    //        }
    //    }
    //}
//
    //public void energyExtractFromEnergyOutputSlot(int energyOutputSlot, int amount) {
    //    if (!getItem(energyOutputSlot).isEmpty()) {
    //        ItemStackHolder stackHolder = new ItemStackHolder(getItem(energyOutputSlot));
//
    //        if (energyMoveItemToBlock(stackHolder, this, amount) != 0) {
    //            if (stackHolder.isDirty()) setItem(energyOutputSlot, stackHolder.getStack());
    //        }
    //    }
    //}

    public abstract EnergyStorage getEnergyStorage();
}
