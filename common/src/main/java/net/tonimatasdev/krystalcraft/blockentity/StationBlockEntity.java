package net.tonimatasdev.krystalcraft.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class StationBlockEntity extends AbstractMachineBlockEntity {
    protected int cookTime;
    protected int cookTimeTotal;
    protected int progress;
    protected int maxProgress = 100;

    public StationBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.progress = compoundTag.getInt("Progress");
        this.cookTime = compoundTag.getInt("CookTime");
        this.cookTimeTotal = compoundTag.getInt("CookTimeTotal");
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("Progress", this.progress);
        compoundTag.putInt("CookTime", this.cookTime);
        compoundTag.putInt("CookTimeTotal", this.cookTimeTotal);
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public int getCookTimeTotal() {
        return this.cookTimeTotal;
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }
}
