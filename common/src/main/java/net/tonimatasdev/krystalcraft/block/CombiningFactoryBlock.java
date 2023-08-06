package net.tonimatasdev.krystalcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.CombiningFactoryBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CombiningFactoryBlock extends MachineBlock {
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CombiningFactoryBlockEntity(blockPos, blockState);
    }
}
