package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.impl.InsertOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import earth.terrarium.botarium.common.fluid.base.BotariumFluidBlock;
import earth.terrarium.botarium.common.fluid.base.FluidContainer;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.impl.SimpleFluidContainer;
import earth.terrarium.botarium.common.fluid.impl.WrappedBlockFluidContainer;
import earth.terrarium.botarium.common.fluid.utils.FluidIngredient;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.tonimatasdev.krystalcraft.menu.CuttingFactoryMenu;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiPredicate;

public class CuttingFactoryBlockEntity extends FactoryBlockEntity implements BotariumFluidBlock<WrappedBlockFluidContainer> {
    private final int INPUT_SLOT = 0;
    private final int RESULT_SLOT = 1;
    private final int BATTERY_SLOT = 2;
    private final int UPGRADE1_SLOT = 3;
    private final int UPGRADE2_SLOT = 4;
    private final int TANK_INPUT_SLOT = 5;
    private final int TANK_OUTPUT_SLOT = 6;

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
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(15000)) : energyContainer;
    }

    @Override
    public WrappedBlockFluidContainer getFluidContainer() {
        return fluidContainer == null ? fluidContainer = new WrappedBlockFluidContainer(this, new SimpleFluidContainer(10000L, 1, (amount, fluid) -> true)) : fluidContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        insertEnergyFromBattery(BATTERY_SLOT);

        if (getItem(TANK_INPUT_SLOT).is(Items.WATER_BUCKET) && (getItem(TANK_OUTPUT_SLOT).isEmpty() || getItem(TANK_OUTPUT_SLOT).is(Items.BUCKET))) {
            removeItem(TANK_INPUT_SLOT, 1);
            setItem(TANK_OUTPUT_SLOT, new ItemStack(Items.BUCKET, getItem(TANK_OUTPUT_SLOT).getCount() + 1));
            getFluidContainer().internalInsert(FluidHolder.of(Fluids.WATER), true);
            getFluidContainer().internalInsert(FluidHolder.of(Fluids.WATER), false);
        } else if (getItem(TANK_INPUT_SLOT).is(Items.BUCKET) && (getItem(TANK_OUTPUT_SLOT).isEmpty() || getItem(TANK_OUTPUT_SLOT).is(Items.WATER_BUCKET))) {
            removeItem(TANK_INPUT_SLOT, 1);
            setItem(TANK_OUTPUT_SLOT, new ItemStack(Items.WATER_BUCKET, getItem(TANK_OUTPUT_SLOT).getCount() + 1));
            getFluidContainer().internalExtract(FluidHolder.of(Fluids.WATER), true);
            getFluidContainer().internalExtract(FluidHolder.of(Fluids.WATER), false);
        }

        // TODO: Logic for upgrades (Slot 3, 4)
    }
}
