package net.tonimatasdev.krystalcraft.blockentity.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BurnProcessingBlockEntity extends AbstractBlockEntity {
    protected int burnTime;
    protected int burnTimeTotal;
    protected int progress;

    public BurnProcessingBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.progress = compoundTag.getInt("Progress");
        this.burnTime = compoundTag.getInt("BurnTime");
        this.burnTimeTotal = compoundTag.getInt("BurnTimeTotal");
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("Progress", this.progress);
        compoundTag.putInt("BurnTime", this.burnTime);
        compoundTag.putInt("BurnTimeTotal", this.burnTimeTotal);
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public int getBurnTimeTotal() {
        return this.burnTimeTotal;
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return 100;
    }
}
