package dev.tonimatas.krystalcraft.block;
/*
import dev.tonimatas.krystalcraft.blockentity.util.BaseBlockEntity;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@SuppressWarnings("deprecation")
public abstract class AbstractMachineBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public AbstractMachineBlock(Settings properties) {
        super(properties);
        this.registerDefaultState(this.buildDefaultState());
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (entityWorld, pos, entityState, blockEntity) -> {
            if (blockEntity instanceof BaseBlockEntity machine) {
                machine.tick();
            }
        };
    }

    protected BlockState buildDefaultState() {
        BlockState state = this.stateDefinition.any();

        if (this.useFacing()) {
            state = state.setValue(FACING, Direction.NORTH);
        }

        return state;
    }

    protected boolean useFacing() {
        return true;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            if (level.getBlockEntity(blockPos) instanceof BaseBlockEntity machineBlock) {
                MenuContentHelper.open((ServerPlayer) player, machineBlock);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        if (this.useFacing()) {
            return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
        } else {
            return state;
        }
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.getBlock() != state.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BaseBlockEntity machineBlock) {
                if (machineBlock.getInventorySize() > 0) {
                    if (this.removeOutput()) {
                        machineBlock.removeItemNoUpdate(machineBlock.getInventorySize() - 1);
                    }
                    Containers.dropContents(world, pos, machineBlock);
                    world.updateNeighbourForOutputSignal(pos, this);
                }
            }
            super.onBroken(world, pos, state);
        }
    }

    public boolean removeOutput() {
        return false;
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {

        if (this.useFacing()) {
            builder.add(FACING);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState state = this.defaultBlockState();
        return this.useFacing() ? state.setValue(FACING, ctx.getHorizontalDirection().getOpposite()) : state;
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(world, pos, state);
        if (world.getBlockEntity(pos) instanceof BaseBlockEntity machineBlock) {
            CompoundTag tag = stack.getOrCreateTag();
            Inventories.saveAllItems(tag, machineBlock.getItems());

            if (EnergyApi.getEnergyBlock(machineBlock.getType()) != null) {
                tag.putLong("Energy", Objects.requireNonNull(EnergyApi.getEnergyBlock(machineBlock.getType())).getEnergyStorage(machineBlock.getLevel(), blockPos, blockState, machineBlock, null).getStoredEnergy());
            }
        }
        return stack;
    }
}*/