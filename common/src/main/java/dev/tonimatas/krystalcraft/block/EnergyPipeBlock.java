package dev.tonimatas.krystalcraft.block;

//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import dev.tonimatas.krystalcraft.block.PipeBlock;
//import dev.tonimatas.krystalcraft.blockentity.EnergyPipeBlockEntity;
//import dev.tonimatas.krystalcraft.plorix.convert.common.energy.EnergyApi;
//import org.jetbrains.annotations.Nullable;
//
//public class EnergyPipeBlock extends PipeBlock {
//
//    @Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
//        return new EnergyPipeBlockEntity(blockPos, blockState);
//    }
//
//    @Override
//    public boolean canConnect(BlockEntity blockEntity, Direction direction) {
//        return EnergyApi.isEnergyBlock(blockEntity, direction) || blockEntity instanceof EnergyPipeBlockEntity;
//    }
//}
