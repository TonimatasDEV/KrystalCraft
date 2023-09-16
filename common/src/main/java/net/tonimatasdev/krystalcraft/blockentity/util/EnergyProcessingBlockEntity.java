package net.tonimatasdev.krystalcraft.blockentity.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class EnergyProcessingBlockEntity extends EnergyBlockEntity {
    protected int progress;

    public EnergyProcessingBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.progress = compoundTag.getInt("Progress");
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("Progress", this.progress);
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return super.canPlaceItemThroughFace(slot, stack, dir);
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return 20;
    }
}
