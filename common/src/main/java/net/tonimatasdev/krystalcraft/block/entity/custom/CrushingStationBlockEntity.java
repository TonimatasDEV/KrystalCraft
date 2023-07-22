package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.menu.CrushingStationMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import org.jetbrains.annotations.NotNull;

public class CrushingStationBlockEntity extends StationBlockEntity {
    public CrushingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUSHING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.krystalcraft.crushing_station");
    }

    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CrushingStationMenu(syncId, inventory, this);
    }


    @Override
    public void tick() {

    }

    @Override
    public int getContainerSize() {
        return 0;
    }
}