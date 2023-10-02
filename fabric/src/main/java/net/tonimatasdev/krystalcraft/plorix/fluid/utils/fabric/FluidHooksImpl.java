package net.tonimatasdev.krystalcraft.plorix.fluid.utils.fabric;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlatformFluidHandler;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlatformFluidItemHandler;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.FabricFluidHandler;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.FabricFluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.FabricFluidItemHandler;
import net.tonimatasdev.krystalcraft.plorix.item.ItemStackStorage;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("UnstableApiUsage")
public class FluidHooksImpl {
    public static FluidHolder newFluidHolder(Fluid fluid, long amount, CompoundTag tag) {
        return FabricFluidHolder.of(fluid, tag, amount);
    }

    public static FluidHolder fluidFromCompound(CompoundTag compoundTag) {
        FabricFluidHolder fluid = FabricFluidHolder.of(null, 0);
        fluid.deserialize(compoundTag);
        return fluid;
    }

    public static FluidHolder emptyFluid() {
        return FabricFluidHolder.empty();
    }

    public static PlatformFluidItemHandler getItemFluidManager(ItemStack stack) {
        return new FabricFluidItemHandler(stack);
    }

    public static PlatformFluidHandler getBlockFluidManager(BlockEntity entity, @Nullable Direction direction) {
        return new FabricFluidHandler(FluidStorage.SIDED.find(entity.getLevel(), entity.getBlockPos(), direction));
    }

    public static boolean isFluidContainingBlock(BlockEntity entity, @Nullable Direction direction) {
        return FluidStorage.SIDED.find(entity.getLevel(), entity.getBlockPos(), direction) != null;
    }

    public static boolean isFluidContainingItem(ItemStack stack) {
        return FluidStorage.ITEM.find(stack, ItemStackStorage.of(stack)) != null;
    }

    public static long toMillibuckets(long amount) {
        return amount / 81;
    }

    public static long getBucketAmount() {
        return FluidConstants.BUCKET;
    }

    public static long getBottleAmount() {
        return FluidConstants.BOTTLE;
    }

    public static long getBlockAmount() {
        return FluidConstants.BLOCK;
    }

    public static long getIngotAmount() {
        return FluidConstants.INGOT;
    }

    public static long getNuggetAmount() {
        return FluidConstants.NUGGET;
    }
}
