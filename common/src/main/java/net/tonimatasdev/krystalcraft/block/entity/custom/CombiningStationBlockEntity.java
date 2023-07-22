package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.menu.CombiningStationMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CombiningStationBlockEntity extends StationBlockEntity {
    public CombiningStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBINING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CombiningStationMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 4;
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return slot == 0;
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return false;
    }

    @Override
    public void tick() {

    }
}