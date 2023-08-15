package net.tonimatasdev.krystalcraft.block.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tonimatasdev.krystalcraft.blockentity.util.AbstractBlockEntity;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public abstract class PipeBlock extends Block implements EntityBlock {
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty EAST = BooleanProperty.create("east");

    public PipeBlock() {
        super(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.METAL));
        registerDefaultState(this.defaultBlockState().setValue(UP, false).setValue(DOWN, false).setValue(NORTH, false).setValue(SOUTH, false).setValue(EAST, false).setValue(WEST, false));
    }

    public BooleanProperty getProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
            case UP -> UP;
            default -> DOWN;
        };
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return (entityWorld, pos, entityState, blockEntity) -> {
            if (blockEntity instanceof AbstractBlockEntity machine) {
                machine.tick();
            }
        };
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.tick(blockState, serverLevel, blockPos, randomSource);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        updatePipe(blockState, level, blockPos);
        super.onPlace(blockState, level, blockPos, blockState2, bl);
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        updatePipe(blockState, level, blockPos);
        super.neighborChanged(blockState, level, blockPos, block, blockPos2, bl);
    }

    public void updatePipe(BlockState blockState, Level level, BlockPos blockPos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = blockPos.offset(direction.getNormal());
            BlockState neighborState = level.getBlockState(neighborPos);

            BlockEntity blockEntity = level.getBlockEntity(neighborPos);
            if (blockEntity == null) {
                blockState = blockState.setValue(getProperty(direction), false);
                continue;
            }

            if (canConnect(blockEntity, direction)) {
                blockState = blockState.setValue(getProperty(direction), true);

                if (neighborState.getBlock() instanceof PipeBlock) {
                    if (neighborState.getValue(getProperty(direction.getOpposite()))) continue;
                    level.setBlockAndUpdate(neighborPos, neighborState.setValue(getProperty(direction.getOpposite()), true));
                }
            } else {
                blockState = blockState.setValue(getProperty(direction), false);
            }
        }

        level.setBlockAndUpdate(blockPos, blockState);
    }

    public abstract boolean canConnect(BlockEntity blockEntity, Direction direction);

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = Shapes.box(0.3125, 0.3125, 0.3125, 0.6875, 0.6875, 0.6875);

        if (blockState.getValue(DOWN)) shape = Shapes.join(shape, Shapes.box(0.375, 0, 0.375, 0.625, 0.3125, 0.625), BooleanOp.OR);
        if (blockState.getValue(UP)) shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.375, 0.625, 1, 0.625), BooleanOp.OR);
        if (blockState.getValue(NORTH)) shape = Shapes.join(shape, Shapes.box(0.375, 0.375, 0, 0.625, 0.625, 0.3125), BooleanOp.OR);
        if (blockState.getValue(SOUTH)) shape = Shapes.join(shape, Shapes.box(0.375, 0.375, 0.6875, 0.625, 0.625, 1), BooleanOp.OR);
        if (blockState.getValue(WEST)) shape = Shapes.join(shape, Shapes.box(0, 0.375, 0.375, 0.3125, 0.625, 0.625), BooleanOp.OR);
        if (blockState.getValue(EAST)) shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.375, 1, 0.625, 0.625), BooleanOp.OR);

        return shape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DOWN, UP, NORTH, SOUTH, WEST, EAST);
    }
}
