package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.menu.CombiningStationMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CombiningStationBlockEntity extends StationBlockEntity {
    public CombiningStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBINING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }


    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.krystalcraft.combining_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CombiningStationMenu(syncId, inventory, this);
    }

    @Override
    public void tick() {

    }

    @Override
    public int getContainerSize() {
        return 0;
    }
}