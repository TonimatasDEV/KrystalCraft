package net.tonimatasdev.krystalcraft.blockentity;

//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.state.BlockState;
//import net.tonimatasdev.krystalcraft.blockentity.util.AbstractBlockEntity;
//import net.tonimatasdev.krystalcraft.plorix.convert.common.energy.base.PlorixEnergyBlock;
//import net.tonimatasdev.krystalcraft.plorix.convert.common.energy.impl.WrappedBlockEnergyContainer;
//import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
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
