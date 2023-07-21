package net.tonimatasdev.krystalcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import net.tonimatasdev.krystalcraft.block.entity.ModBlockEntities;
import net.tonimatasdev.krystalcraft.block.entity.custom.GemCuttingStationBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class GemCuttingStationBlock extends KrystalCraftBlock {
    public GemCuttingStationBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(@Nullable BlockState pState, @Nullable BlockGetter pLevel, @Nullable BlockPos pPos, @Nullable CollisionContext pContext) {
        return Block.box(0, 0, 0, 16, 8, 16);
    }

    @Override
    public void onRemove(BlockState pState, @Nullable Level pLevel, @Nullable BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = Objects.requireNonNull(pLevel).getBlockEntity(Objects.requireNonNull(pPos));

            if (blockEntity instanceof GemCuttingStationBlockEntity) {
                ((GemCuttingStationBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(pState, Objects.requireNonNull(pLevel), Objects.requireNonNull(pPos), pNewState, pIsMoving);
    }

    @Override
    public @NotNull InteractionResult use(@Nullable BlockState pState, Level pLevel, @Nullable BlockPos pPos, @Nullable Player pPlayer, @Nullable InteractionHand pHand, @Nullable BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(Objects.requireNonNull(pPos));

            if (entity instanceof GemCuttingStationBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) Objects.requireNonNull(pPlayer)), (GemCuttingStationBlockEntity) entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Override
    public BlockEntity newBlockEntity(@Nullable BlockPos pPos, @Nullable BlockState pState) {
        return new GemCuttingStationBlockEntity(pPos, pState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nullable Level pLevel, @Nullable BlockState pState, @Nullable BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(), GemCuttingStationBlockEntity::tick);
    }
}