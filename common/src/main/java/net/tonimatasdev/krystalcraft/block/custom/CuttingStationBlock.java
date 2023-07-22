package net.tonimatasdev.krystalcraft.block.custom;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CuttingStationBlock extends AbstractMachineBlock {
    public CuttingStationBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion());
    }

    @Override
    protected boolean useFacing() {
        return true;
    }

    @Override
    protected boolean useLit() {
        return true;
    }
}