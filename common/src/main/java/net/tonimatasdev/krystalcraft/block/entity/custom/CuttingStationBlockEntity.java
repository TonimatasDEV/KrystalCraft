package net.tonimatasdev.krystalcraft.block.entity.custom;

import earth.terrarium.botarium.common.fluid.base.BotariumFluidBlock;
import earth.terrarium.botarium.common.fluid.base.FluidContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.menu.CuttingStationMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;

public class CuttingStationBlockEntity extends StationBlockEntity implements BotariumFluidBlock {
    public CuttingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CUTTING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CuttingStationMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 5;
    }

    @Override
    public FluidContainer getFluidContainer() {
        return null;
    }

    @Override
    public void tick() {

    }
}