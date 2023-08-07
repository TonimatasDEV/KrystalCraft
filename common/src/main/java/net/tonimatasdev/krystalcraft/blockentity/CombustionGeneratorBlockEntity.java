package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.impl.ExtractOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import earth.terrarium.botarium.util.CommonHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.util.EnergyBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CombustionGeneratorMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CombustionGeneratorBlockEntity extends EnergyBlockEntity {
    protected int burnTime;
    protected int totalBurnTime;
    protected final int INPUT = 0;
    protected final int BATTERY = 1;

    public CombustionGeneratorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBUSTION_GENERATOR_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.burnTime = compoundTag.getInt("BurnTime");
        this.totalBurnTime = compoundTag.getInt("TotalBurnTime");
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("BurnTime", this.burnTime);
        compoundTag.putInt("TotalBurnTime", this.totalBurnTime);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CombustionGeneratorMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 2;
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new ExtractOnlyEnergyContainer(15000)) : energyContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;


        energyInsertToEnergyOutputSlot(BATTERY, 10);


        if (burnTime == 0) {
            int newBurnTime = CommonHooks.getBurnTime(getItem(INPUT));

            if (newBurnTime != 0) {
                removeItem(INPUT, 1);
                totalBurnTime = newBurnTime;
                burnTime = newBurnTime;
            }

        } else if (energyAmount() < energyCapacity()) {
            burnTime--;
            energyInternalInsert(10);
        }

        energyDistributeNearby(50);
    }

    public int getBurnTime() {
        return burnTime;
    }

    public int getTotalBurnTime() {
        return totalBurnTime;
    }
}
