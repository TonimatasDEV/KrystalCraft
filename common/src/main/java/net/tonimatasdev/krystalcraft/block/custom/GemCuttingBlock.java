package net.tonimatasdev.krystalcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.tonimatasdev.krystalcraft.block.entity.custom.GemCuttingBlockEntity;
import net.tonimatasdev.krystalcraft.registry.BlockEntityRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class GemCuttingBlock extends KrystalCraftBlock {
    public GemCuttingBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion());
    }

    @Override
    public void onRemove(BlockState state, @Nullable Level level, @Nullable BlockPos blockPos, BlockState blockState, boolean moved) {
        if (state.getBlock() != blockState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);

            if (blockEntity instanceof GemCuttingBlockEntity) {
                Containers.dropContents(level, blockPos, (GemCuttingBlockEntity) blockEntity);
                level.updateNeighbourForOutputSignal(blockPos, this);
            }
            super.onRemove(state, level, blockPos, blockState, moved);
        }
    }

    @Override
    public BlockEntity newBlockEntity(@Nullable BlockPos pPos, @Nullable BlockState pState) {
        return new GemCuttingBlockEntity(pPos, pState);
    }
}