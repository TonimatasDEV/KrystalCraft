package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.base.BotariumEnergyBlock;
import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.item.custom.BatteryItem;

public abstract class FactoryBlockEntity extends AbstractMachineBlockEntity implements BotariumEnergyBlock<WrappedBlockEnergyContainer> {
    protected int progress;
    protected WrappedBlockEnergyContainer energyContainer;


    public FactoryBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.progress = compoundTag.getInt("Progress");
        getEnergyStorage().setEnergy(compoundTag.getLong("Energy"));
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("Progress", this.progress);
        compoundTag.putLong("Energy", this.getEnergyStorage().getStoredEnergy());
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return 20;
    }

    public void insertEnergyFromBattery(int batterySlot) {
        if (getItem(batterySlot).isEmpty()) {
            if (getItem(batterySlot).getItem() instanceof BatteryItem item) {
                EnergyContainer itemEnergyContainer = item.getEnergyStorage(getItem(3));

                if (itemEnergyContainer.getStoredEnergy() > 0) {
                    itemEnergyContainer.internalExtract(10, true);
                    itemEnergyContainer.internalExtract(10, false);
                    getEnergyStorage().internalInsert(10, true);
                    getEnergyStorage().internalInsert(10, false);
                }
            }
        }
    }
}
