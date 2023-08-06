package net.tonimatasdev.krystalcraft.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.util.BurnProcessingBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CrushingStationMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;

public class CrushingStationBlockEntity extends BurnProcessingBlockEntity {
    public CrushingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUSHING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CrushingStationMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 3;
    }

    @Override
    public void tick() {

    }
}