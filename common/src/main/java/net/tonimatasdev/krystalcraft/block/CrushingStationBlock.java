package net.tonimatasdev.krystalcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.CrushingStationBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CrushingStationBlock extends MachineBlock {
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CrushingStationBlockEntity(blockPos, blockState);
    }
}
