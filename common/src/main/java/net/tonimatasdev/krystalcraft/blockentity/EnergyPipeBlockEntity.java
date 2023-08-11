package net.tonimatasdev.krystalcraft.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;

public class EnergyPipeBlockEntity extends AbstractMachineBlockEntity {
    public EnergyPipeBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.ENERGY_PIPE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        // TODO: Add energy pipe logic
    }
}
