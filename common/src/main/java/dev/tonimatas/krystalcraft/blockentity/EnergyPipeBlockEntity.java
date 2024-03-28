package dev.tonimatas.krystalcraft.blockentity;

//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.state.BlockState;
//import dev.tonimatas.krystalcraft.blockentity.util.AbstractBlockEntity;
//import dev.tonimatas.krystalcraft.plorix.convert.common.energy.base.PlorixEnergyBlock;
//import dev.tonimatas.krystalcraft.plorix.convert.common.energy.impl.WrappedBlockEnergyContainer;
//import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
//
//public class EnergyPipeBlockEntity extends AbstractBlockEntity implements PlorixEnergyBlock<WrappedBlockEnergyContainer> {
//
//    public EnergyPipeBlockEntity(BlockPos blockPos, BlockState blockState) {
//        super(ModBlockEntities.ENERGY_PIPE_BLOCK_ENTITY.get(), blockPos, blockState);
//    }
//
//    @Override
//    public void tick() {
//        if (level == null) return;
//        if (level.isClientSide) return;
//        // TODO: Add block entity energy pipe logic
//    }
//
//    @Override
//    public WrappedBlockEnergyContainer getEnergyStorage() {
//        return null;
//    }
//}
