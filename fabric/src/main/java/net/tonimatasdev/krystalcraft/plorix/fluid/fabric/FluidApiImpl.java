package net.tonimatasdev.krystalcraft.plorix.fluid.fabric;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.ItemFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.PlatformFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.PlatformFluidItemHandler;
import net.tonimatasdev.krystalcraft.plorix.item.ItemStackHolder;
import net.tonimatasdev.krystalcraft.plorix.item.ItemStackStorage;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("ALL")
public class FluidApiImpl {
    public static ItemFluidContainer getItemFluidContainer(ItemStackHolder stack) {
        return new PlatformFluidItemHandler(stack);
    }

    public static FluidContainer getBlockFluidContainer(BlockEntity entity, @Nullable Direction direction) {
        return new PlatformFluidContainer(FluidStorage.SIDED.find(entity.getLevel(), entity.getBlockPos(), direction));
    }

    public static boolean isFluidContainingBlock(BlockEntity entity, @Nullable Direction direction) {
        return FluidStorage.SIDED.find(entity.getLevel(), entity.getBlockPos(), direction) != null;
    }

    public static boolean isFluidContainingItem(ItemStack stack) {
        return FluidStorage.ITEM.find(stack, ItemStackStorage.of(stack)) != null;
    }
}
