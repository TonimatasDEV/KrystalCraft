package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.base.BotariumEnergyBlock;
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.util.AbstractBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;

public class EnergyPipeBlockEntity extends AbstractBlockEntity implements BotariumEnergyBlock<WrappedBlockEnergyContainer> {

    public EnergyPipeBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.ENERGY_PIPE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;
        // TODO: Add block entity energy pipe logic
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return new WrappedBlockEnergyContainer(this, new SimpleEnergyContainer(500));
    }
}
