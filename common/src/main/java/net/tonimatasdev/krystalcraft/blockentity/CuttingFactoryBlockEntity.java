package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.impl.InsertOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.menu.CuttingFactoryMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CuttingFactoryBlockEntity extends FactoryBlockEntity {
    public CuttingFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CUTTING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CuttingFactoryMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 2;
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(30000)) : this.energyContainer;
    }

    @Override
    public void tick() {

    }
}
