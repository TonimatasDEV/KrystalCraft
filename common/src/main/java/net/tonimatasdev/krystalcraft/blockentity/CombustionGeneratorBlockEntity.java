package net.tonimatasdev.krystalcraft.blockentity;

import com.teamresourceful.resourcefullib.ResourcefulLib;
import earth.terrarium.botarium.common.energy.base.BotariumEnergyBlock;
import earth.terrarium.botarium.common.energy.impl.ExtractOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.InsertOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer;
import earth.terrarium.botarium.common.energy.util.EnergyHooks;
import earth.terrarium.botarium.util.CommonHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceFuelSlot;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.item.custom.BatteryItem;
import net.tonimatasdev.krystalcraft.menu.CombiningFactoryMenu;
import net.tonimatasdev.krystalcraft.menu.CombustionGeneratorMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModItems;
import org.jetbrains.annotations.Nullable;

public class CombustionGeneratorBlockEntity extends AbstractMachineBlockEntity implements BotariumEnergyBlock<WrappedBlockEnergyContainer> {
    protected int burnTime;
    protected int totalBurnTime;
    protected WrappedBlockEnergyContainer energyContainer;
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
        this.energyContainer.setEnergy(compoundTag.getLong("Energy"));
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("BurnTime", this.burnTime);
        compoundTag.putInt("TotalBurnTime", this.totalBurnTime);
        compoundTag.putLong("Energy", this.energyContainer.getStoredEnergy());
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
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new ExtractOnlyEnergyContainer(30000)) : energyContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        if (getItem(BATTERY).getItem() instanceof BatteryItem item) {
            WrappedItemEnergyContainer itemEnergyContainer = item.getEnergyStorage(getItem(BATTERY));

            if (itemEnergyContainer.getStoredEnergy() < itemEnergyContainer.getMaxCapacity() && energyContainer.getStoredEnergy() > 0) {
                itemEnergyContainer.internalInsert(10, false);
                itemEnergyContainer.internalInsert(10, true);
                getEnergyStorage().internalExtract(10, false);
                getEnergyStorage().internalExtract(10, true);
            }
        }

        if (burnTime == 0) {
            int newBurnTime = CommonHooks.getBurnTime(getItem(INPUT));

            if (newBurnTime != 0) {
                removeItem(INPUT, 1);
                totalBurnTime = newBurnTime;
                burnTime = newBurnTime;
            }

        } else if (energyContainer.getStoredEnergy() < getEnergyStorage().getMaxCapacity()) {
            burnTime--;
            getEnergyStorage().internalInsert(10, false);
            getEnergyStorage().internalInsert(10, true);
        }

        EnergyHooks.distributeEnergyNearby(this, 50);
    }

    public int getBurnTime() {
        return burnTime;
    }

    public int getTotalBurnTime() {
        return totalBurnTime;
    }
}
