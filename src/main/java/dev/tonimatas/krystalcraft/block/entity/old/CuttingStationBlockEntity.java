package dev.tonimatas.krystalcraft.block.entity.old;
/*
import dev.tonimatas.krystalcraft.blockentity.util.BurnBlockEntity;
import dev.tonimatas.krystalcraft.energy.Energy;
import dev.tonimatas.krystalcraft.menu.CuttingStationMenu;
import dev.tonimatas.krystalcraft.recipe.CuttingRecipe;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import earth.terrarium.botarium.common.fluid.base.BotariumFluidBlock;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.impl.SimpleFluidContainer;
import earth.terrarium.botarium.common.fluid.impl.WrappedBlockFluidContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CuttingStationBlockEntity extends BurnBlockEntity implements BotariumFluidBlock<WrappedBlockFluidContainer> {
    protected final int INPUT_SLOT = 0;
    protected final int RESULT_SLOT = 1;
    protected final int COMBUSTION_SLOT = 2;
    protected final int TANK_INPUT_SLOT = 3;
    protected final int TANK_OUTPUT_SLOT = 4;
    protected WrappedBlockFluidContainer fluidContainer;

    public CuttingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        this.fluidContainer = new WrappedBlockFluidContainer(this, new SimpleFluidContainer(10000L, 1, (amount, fluid) -> true));
    }

    @Override
    public @Nullable WrappedBlockFluidContainer getFluidContainer(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity entity, @Nullable Direction direction) {
        return fluidContainer;
    }

    public @Nullable WrappedBlockFluidContainer getFluidContainer() {
        return this.fluidContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        if (getItem(TANK_INPUT_SLOT).is(Items.WATER_BUCKET) && (getItem(TANK_OUTPUT_SLOT).isEmpty() || getItem(TANK_OUTPUT_SLOT).is(Items.BUCKET)) && (fluidContainer.getTankCapacity(0) - fluidContainer.getFluids().get(0).getFluidAmount()) >= 1000) {
            removeItem(TANK_INPUT_SLOT, 1);
            setItem(TANK_OUTPUT_SLOT, new ItemStack(Items.BUCKET, getItem(TANK_OUTPUT_SLOT).getCount() + 1));
            fluidContainer.internalInsert(FluidHolder.of(Fluids.WATER, 1000), false);
        } else if (getItem(TANK_INPUT_SLOT).is(Items.BUCKET) && (getItem(TANK_OUTPUT_SLOT).isEmpty() || getItem(TANK_OUTPUT_SLOT).getMaxStackSize() < getItem(TANK_OUTPUT_SLOT).getCount())) {
            removeItem(TANK_INPUT_SLOT, 1);
            setItem(TANK_OUTPUT_SLOT, new ItemStack(Items.WATER_BUCKET));
            fluidContainer.internalExtract(FluidHolder.of(Fluids.WATER, 1000), false);
        }

        if (hasRecipe(level) && fluidContainer.getFluids().get(0).getFluidAmount() > 0) {
            if (burnTime <= 0) {
                burnTime = Energy.getBurnTime(getItem(COMBUSTION_SLOT));
                burnTimeTotal = burnTime;
                removeItem(COMBUSTION_SLOT, 1);
            } else {
                progress++;
                FluidHolder fluidHolder = FluidHolder.of(Fluids.WATER, 2);
                fluidContainer.internalExtract(fluidHolder, false);
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
        Optional<RecipeHolder<CuttingRecipe>> match = level.getRecipeManager().getRecipeFor(ModRecipes.CUTTING.get(), this, level);
        if (match.isEmpty()) return false;

        ItemStack resultItem = match.get().value().result();
        return (resultItem.is(resultItem.getItem()) || (resultItem.isEmpty()) && (resultItem.getCount() + getItem(RESULT_SLOT).getCount()) <= 64);
    }

    private void craft(Level level) {
        Optional<RecipeHolder<CuttingRecipe>> match = level.getRecipeManager().getRecipeFor(ModRecipes.CUTTING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT_SLOT, 1);
            setItem(RESULT_SLOT, new ItemStack(match.get().value().result().getItem(), getItem(RESULT_SLOT).getCount() + 1));
        }
    }
}*/