package net.tonimatasdev.krystalcraft.block;

import earth.terrarium.botarium.common.energy.EnergyApi;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.block.util.PipeBlock;
import net.tonimatasdev.krystalcraft.blockentity.EnergyPipeBlockEntity;
import org.jetbrains.annotations.Nullable;

public class EnergyPipeBlock extends PipeBlock {

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new EnergyPipeBlockEntity(blockPos, blockState);
    }

    @Override
    public boolean canConnect(BlockEntity blockEntity, Direction direction) {
        return EnergyApi.isEnergyBlock(blockEntity, direction);
    }

    @Override
    public void update(BlockState blockState, BlockPos blockPos, BlockState neighborState, BlockPos neighborPos) {
        if (!(blockState.getBlock() instanceof EnergyPipeBlock && neighborState.getBlock() instanceof EnergyPipeBlock)) return;
        //EnergyConnection.addOrCreate(blockPos, neighborPos);
    }
}
