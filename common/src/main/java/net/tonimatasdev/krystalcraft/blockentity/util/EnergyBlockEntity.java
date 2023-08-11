package net.tonimatasdev.krystalcraft.blockentity.util;

import earth.terrarium.botarium.common.energy.EnergyApi;
import earth.terrarium.botarium.common.energy.base.BotariumEnergyBlock;
import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import earth.terrarium.botarium.common.energy.util.EnergyHooks;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.AbstractMachineBlockEntity;

@SuppressWarnings("deprecation")
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
        EnergyHooks.moveBlockToBlockEnergy(from, to, amount);
    }

    public void energyMoveBetweenContainers(EnergyContainer from, EnergyContainer to, long amount) {
        EnergyApi.moveEnergy(from, to, amount, false);
    }

    public void energyMoveBetweenItems(ItemStackHolder from, ItemStackHolder to, long amount) {
        EnergyHooks.safeMoveItemToItemEnergy(from, to, amount);
    }

    public long energyMoveItemToBlock(ItemStackHolder from, BlockEntity to, long amount) {
        return EnergyHooks.safeMoveItemToBlockEnergy(from, to, null, amount);
    }

    public long energyMoveBlockToItem(BlockEntity from, ItemStackHolder to, long amount) {
        return EnergyHooks.safeMoveBlockToItemEnergy(from, null, to, amount);
    }

    public void energyInsertToEnergyOutputSlot(int energyOutputSlot, int amount) {
        if (!getItem(energyOutputSlot).isEmpty()) {
            ItemStackHolder stackHolder = new ItemStackHolder(getItem(energyOutputSlot));

            if (energyMoveBlockToItem(this, stackHolder, amount) != 0) {
                if (stackHolder.isDirty()) setItem(energyOutputSlot, stackHolder.getStack());
            }
        }
    }

    public void energyExtractFromEnergyOutputSlot(int energyOutputSlot, int amount) {
        if (!getItem(energyOutputSlot).isEmpty()) {
            ItemStackHolder stackHolder = new ItemStackHolder(getItem(energyOutputSlot));

            if (energyMoveItemToBlock(stackHolder, this, amount) != 0) {
                if (stackHolder.isDirty()) setItem(energyOutputSlot, stackHolder.getStack());
            }
        }
    }
}
