package net.tonimatasdev.krystalcraft.plorix;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.impl.transfer.item.InventoryStorageImpl;
import net.tonimatasdev.krystalcraft.plorix.energy.base.EnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.PlorixEnergyBlock;
import net.tonimatasdev.krystalcraft.plorix.energy.base.PlorixEnergyItem;
import net.tonimatasdev.krystalcraft.plorix.energy.base.fabric.FabricBlockEnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.fabric.FabricItemEnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlorixFluidBlock;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlorixFluidItem;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.FabricBlockFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.FabricItemFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.item.ItemContainerBlock;
import team.reborn.energy.api.EnergyStorage;

@SuppressWarnings("UnstableApiUsage")
public class PlorixFabric {
    public static void init() {
        EnergyStorage.SIDED.registerFallback((world, pos, state, blockEntity, context) -> {
            if (blockEntity instanceof PlorixEnergyBlock<?> attachment) {
                EnergyContainer container = attachment.getEnergyStorage().getContainer(context);
                return container == null ? null : new FabricBlockEnergyContainer(container, attachment.getEnergyStorage(), blockEntity);
            }

            return null;
        });

        EnergyStorage.ITEM.registerFallback((itemStack, context) -> {
            if (itemStack.getItem() instanceof PlorixEnergyItem<?> attachment) {
                EnergyContainer energyStorage = attachment.getEnergyStorage(itemStack);
                return energyStorage == null ? null : new FabricItemEnergyContainer(context, energyStorage);
            }

            return null;
        });

        FluidStorage.SIDED.registerFallback((world, pos, state, blockEntity, context) -> {
            if (blockEntity instanceof PlorixFluidBlock<?> attachment) {
                FluidContainer container = attachment.getFluidContainer().getContainer(context);
                return container == null ? null : new FabricBlockFluidContainer(container, attachment.getFluidContainer(), blockEntity);
            }

            return null;
        });


        FluidStorage.ITEM.registerFallback((itemStack, context) -> {
            if (itemStack.getItem() instanceof PlorixFluidItem<?> attachment) {
                FluidContainer fluidContainer = attachment.getFluidContainer(itemStack);
                return fluidContainer == null ? null : new FabricItemFluidContainer(context, fluidContainer);
            }

            return null;
        });

        ItemStorage.SIDED.registerFallback((world, pos, state, blockEntity, context) -> {
            if (blockEntity instanceof ItemContainerBlock energyContainer) {
                return InventoryStorageImpl.of(energyContainer.getContainer(), context);
            }
            return null;
        });
    }
}
