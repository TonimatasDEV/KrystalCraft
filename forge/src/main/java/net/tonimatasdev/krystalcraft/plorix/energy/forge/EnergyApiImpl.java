package net.tonimatasdev.krystalcraft.plorix.energy.forge;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.tonimatasdev.krystalcraft.plorix.energy.EnergyApi;
import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.forge.PlatformBlockEnergyManager;
import net.tonimatasdev.krystalcraft.plorix.energy.base.forge.PlatformItemEnergyManager;
import net.tonimatasdev.krystalcraft.plorix.item.ItemStackHolder;
import org.jetbrains.annotations.Nullable;

public class EnergyApiImpl {
    @Nullable
    public static EnergyContainer getItemEnergyContainer(ItemStackHolder stack) {
        return EnergyApi.isEnergyItem(stack.getStack()) ? new PlatformItemEnergyManager(stack.getStack()) : null;
    }

    @Nullable
    public static EnergyContainer getBlockEnergyContainer(BlockEntity entity, @Nullable Direction direction) {
        return EnergyApi.isEnergyBlock(entity, direction) ? new PlatformBlockEnergyManager(entity, direction) : null;
    }

    public static boolean isEnergyItem(ItemStack stack) {
        return stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
    }

    public static boolean isEnergyBlock(BlockEntity block, @Nullable Direction direction) {
        return block.getCapability(ForgeCapabilities.ENERGY, direction).isPresent();
    }
}
