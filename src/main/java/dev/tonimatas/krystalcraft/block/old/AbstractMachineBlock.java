package dev.tonimatas.krystalcraft.block.old;
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

public abstract class AbstractMachineBlock extends BlockWithEntity implements BlockEntityProvider {
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