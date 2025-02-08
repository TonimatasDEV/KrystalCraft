package dev.tonimatas.krystalcraft.blockentity.util;

import earth.terrarium.botarium.common.energy.EnergyApi;
import earth.terrarium.botarium.common.energy.base.BotariumEnergyBlock;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class EnergyBlockEntity extends BaseBlockEntity implements BotariumEnergyBlock<WrappedBlockEnergyContainer> {
    protected WrappedBlockEnergyContainer energyContainer;

    public EnergyBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity entity, @Nullable Direction direction) {
        return this.energyContainer;
    }

    public WrappedBlockEnergyContainer getEnergyStorage() {
        return this.energyContainer;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        energyContainer.setEnergy(compoundTag.getLong("Energy"));
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putLong("Energy", energyContainer.getStoredEnergy());
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
