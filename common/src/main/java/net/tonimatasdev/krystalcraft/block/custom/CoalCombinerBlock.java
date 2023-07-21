package net.tonimatasdev.krystalcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.block.entity.custom.CoalCombinerBlockEntity;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class CoalCombinerBlock extends KrystalCraftBlock {
    public CoalCombinerBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion());
    }

    @Override
    public void onRemove(BlockState state, @Nullable Level level, @Nullable BlockPos blockPos, BlockState blockState, boolean moved) {
        if (state.getBlock() != blockState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);

            if (blockEntity instanceof CoalCombinerBlockEntity) {
                Containers.dropContents(level, blockPos, (CoalCombinerBlockEntity) blockEntity);
                level.updateNeighbourForOutputSignal(blockPos, this);
            }
            super.onRemove(state, level, blockPos, blockState, moved);
        }
    }

    @Override
    public BlockEntity newBlockEntity(@Nullable BlockPos pPos, @Nullable BlockState pState) {
        return new CoalCombinerBlockEntity(pPos, pState);
    }
}