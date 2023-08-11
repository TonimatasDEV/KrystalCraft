package net.tonimatasdev.krystalcraft.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.tonimatasdev.krystalcraft.block.util.AbstractMachineBlock;

public class MachineBlock extends AbstractMachineBlock {
    public MachineBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion());
    }
}