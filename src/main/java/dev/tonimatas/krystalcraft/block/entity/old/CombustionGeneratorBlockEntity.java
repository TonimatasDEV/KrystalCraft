package dev.tonimatas.krystalcraft.block.entity.old;
/*
import dev.tonimatas.krystalcraft.blockentity.util.EnergyBlockEntity;
import dev.tonimatas.krystalcraft.energy.Energy;
import dev.tonimatas.krystalcraft.menu.CombustionGeneratorMenu;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import earth.terrarium.botarium.common.energy.EnergyApi;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CombustionGeneratorBlockEntity extends EnergyBlockEntity {
    protected int burnTime;
    protected int totalBurnTime;
    protected final int INPUT = 0;
    protected final int BATTERY = 1;

    public CombustionGeneratorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBUSTION_GENERATOR_BLOCK_ENTITY.get(), blockPos, blockState);
        this.energyContainer = Energy.createExtractEnergyStorage(15000, 100);
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        energyInsertToEnergySlot(BATTERY, 10);

        System.out.println(energyContainer.getStoredEnergy());

        if (burnTime == 0) {
            int newBurnTime = Energy.getBurnTime(getItem(INPUT));

            if (newBurnTime != 0) {
                removeItem(INPUT, 1);
                totalBurnTime = newBurnTime;
                burnTime = newBurnTime;
            }

        } else if (energyContainer.getStoredEnergy() < energyContainer.getCapacity()) {
            burnTime--;
            energyContainer.insert(10, false);
        }

        EnergyApi.distributeEnergyNearby(this, 50);
    }

    public int getBurnTime() {
        return burnTime;
    }

    public int getTotalBurnTime() {
        return totalBurnTime;
    }
}
*/