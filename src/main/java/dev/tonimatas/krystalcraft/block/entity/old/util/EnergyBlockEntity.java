package dev.tonimatas.krystalcraft.block.entity.old.util;
/*
import dev.tonimatas.krystalcraft.energy.EnergyStorageK;
import earth.terrarium.botarium.common.energy.EnergyApi;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class EnergyBlockEntity extends BaseBlockEntity {
    protected EnergyStorageK energyContainer;

    public EnergyBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public EnergyStorageK getEnergyStorage() {
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
*/