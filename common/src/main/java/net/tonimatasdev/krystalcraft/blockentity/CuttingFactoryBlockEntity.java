package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.fluid.base.BotariumFluidBlock;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.impl.SimpleFluidContainer;
import earth.terrarium.botarium.common.fluid.impl.WrappedBlockFluidContainer;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.tonimatasdev.krystalcraft.blockentity.util.EnergyProcessingBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CuttingFactoryMenu;
import net.tonimatasdev.krystalcraft.plorix.energy.EnergyStorage;
import net.tonimatasdev.krystalcraft.plorix.energy.EnergyStorageUtils;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CuttingFactoryBlockEntity extends EnergyProcessingBlockEntity implements BotariumFluidBlock<WrappedBlockFluidContainer> {
    protected final EnergyStorage energyStorage = EnergyStorageUtils.create(15000, 128);
    protected final int INPUT_SLOT = 0;
    protected final int RESULT_SLOT = 1;
    protected final int BATTERY_SLOT = 2;
    protected final int UPGRADE1_SLOT = 3;
    protected final int UPGRADE2_SLOT = 4;
    protected final int TANK_INPUT_SLOT = 5;
    protected final int TANK_OUTPUT_SLOT = 6;

    protected WrappedBlockFluidContainer fluidContainer;

    public CuttingFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CUTTING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CuttingFactoryMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 7;
    }

    @Override
    public EnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public WrappedBlockFluidContainer getFluidContainer() {
        return fluidContainer == null ? fluidContainer = new WrappedBlockFluidContainer(this, new SimpleFluidContainer(10000L, 1, (amount, fluid) -> true)) : fluidContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        //energyExtractFromEnergyOutputSlot(BATTERY_SLOT, 10);

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

        // TODO: Logic for upgrades (Slot 3, 4)

        if (hasRecipe(level) && energyAmount() > 0 && getFluidContainer().getFluids().get(0).getFluidAmount() > 0) {
            progress++;
            energyExtract(5);
            FluidHolder fluidHolder = FluidHooks.newFluidHolder(Fluids.WATER, 2, null);
            getFluidContainer().internalExtract(fluidHolder, true);
            getFluidContainer().internalExtract(fluidHolder, false);

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;

        }
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
