package net.tonimatasdev.krystalcraft.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.tonimatasdev.krystalcraft.blockentity.util.BurnProcessingBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CuttingStationMenu;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlorixFluidBlock;
import net.tonimatasdev.krystalcraft.plorix.fluid.impl.SimpleFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.impl.WrappedBlockFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.util.FluidHooks;
import net.tonimatasdev.krystalcraft.plorix.util.Hooks;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CuttingStationBlockEntity extends BurnProcessingBlockEntity implements PlorixFluidBlock<WrappedBlockFluidContainer> {
    protected final int INPUT_SLOT = 0;
    protected final int RESULT_SLOT = 1;
    protected final int COMBUSTION_SLOT = 2;
    protected final int TANK_INPUT_SLOT = 3;
    protected final int TANK_OUTPUT_SLOT = 4;
    protected WrappedBlockFluidContainer fluidContainer;

    public CuttingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CUTTING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public @NotNull AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CuttingStationMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 5;
    }

    @Override
    public WrappedBlockFluidContainer getFluidContainer() {
        return fluidContainer == null ? fluidContainer = new WrappedBlockFluidContainer(this, new SimpleFluidContainer(10000L, 1, (amount, fluid) -> true)) : fluidContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        if (getItem(TANK_INPUT_SLOT).is(Items.WATER_BUCKET) && (getItem(TANK_OUTPUT_SLOT).isEmpty() || getItem(TANK_OUTPUT_SLOT).is(Items.BUCKET)) && (getFluidContainer().getTankCapacity(0) - getFluidContainer().getFluids().get(0).getFluidAmount()) >= 1000) {
            removeItem(TANK_INPUT_SLOT, 1);
            setItem(TANK_OUTPUT_SLOT, new ItemStack(Items.BUCKET, getItem(TANK_OUTPUT_SLOT).getCount() + 1));
            getFluidContainer().internalInsert(FluidHolder.of(Fluids.WATER), true);
            getFluidContainer().internalInsert(FluidHolder.of(Fluids.WATER), false);
        } else if (getItem(TANK_INPUT_SLOT).is(Items.BUCKET) && (getItem(TANK_OUTPUT_SLOT).isEmpty() || getItem(TANK_OUTPUT_SLOT).getMaxStackSize() < getItem(TANK_OUTPUT_SLOT).getCount())) {
            removeItem(TANK_INPUT_SLOT, 1);
            setItem(TANK_OUTPUT_SLOT, new ItemStack(Items.WATER_BUCKET));
            getFluidContainer().internalExtract(FluidHolder.of(Fluids.WATER), true);
            getFluidContainer().internalExtract(FluidHolder.of(Fluids.WATER), false);
        }

        if (hasRecipe(level) && getFluidContainer().getFluids().get(0).getFluidAmount() > 0) {
            if (burnTime <= 0) {
                burnTime = Hooks.getBurnTime(getItem(COMBUSTION_SLOT));
                burnTimeTotal = burnTime;
                removeItem(COMBUSTION_SLOT, 1);
            } else {
                progress++;
                FluidHolder fluidHolder = FluidHooks.newFluidHolder(Fluids.WATER, 2, null);
                getFluidContainer().internalExtract(fluidHolder, true);
                getFluidContainer().internalExtract(fluidHolder, false);
            }

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;
        }

        if (burnTime > 0) burnTime--;
    }

    private boolean hasRecipe(Level level) {
        Optional<CuttingRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.CUTTING.get(), this, level);
        if (match.isEmpty()) return false;

        ItemStack resultItem = match.get().getResultItem(level.registryAccess());
        return (resultItem.is(resultItem.getItem()) || (resultItem.isEmpty()) && (resultItem.getCount() + getItem(RESULT_SLOT).getCount()) <= 64);
    }

    private void craft(Level level) {
        Optional<CuttingRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.CUTTING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT_SLOT, 1);
            setItem(RESULT_SLOT, new ItemStack(match.get().getResultItem(level.registryAccess()).getItem(), getItem(RESULT_SLOT).getCount() + 1));
        }
    }
}