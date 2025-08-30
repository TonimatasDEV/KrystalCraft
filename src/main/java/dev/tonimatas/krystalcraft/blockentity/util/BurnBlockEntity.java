package dev.tonimatas.krystalcraft.blockentity.util;
/*
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BurnBlockEntity extends BaseBlockEntity {
    protected int burnTime;
    protected int burnTimeTotal;
    protected int progress;

    public BurnBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.progress = compoundTag.getInt("Progress");
        this.burnTime = compoundTag.getInt("BurnTime");
        this.burnTimeTotal = compoundTag.getInt("BurnTimeTotal");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("Progress", this.progress);
        compoundTag.putInt("BurnTime", this.burnTime);
        compoundTag.putInt("BurnTimeTotal", this.burnTimeTotal);
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return super.canPlaceItemThroughFace(slot, stack, dir);
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
*/