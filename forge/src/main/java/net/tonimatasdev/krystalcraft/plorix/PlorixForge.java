package net.tonimatasdev.krystalcraft.plorix;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.plorix.energy.base.PlorixEnergyBlock;
import net.tonimatasdev.krystalcraft.plorix.energy.base.PlorixEnergyItem;
import net.tonimatasdev.krystalcraft.plorix.energy.base.forge.ForgeEnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.energy.base.forge.ForgeItemEnergyContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlorixFluidBlock;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.PlorixFluidItem;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.forge.ForgeFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.forge.ForgeItemFluidContainer;
import net.tonimatasdev.krystalcraft.plorix.item.ItemContainerBlock;
import net.tonimatasdev.krystalcraft.plorix.item.ItemContainerWrapper;

public class PlorixForge {
    public static void init(IEventBus eventBus) {
        eventBus.addGenericListener(BlockEntity.class, PlorixForge::attachBlockCapabilities);
        eventBus.addGenericListener(ItemStack.class, PlorixForge::attachItemCapabilities);
    }

    public static void attachBlockCapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof PlorixEnergyBlock<?> energyBlock) {
            event.addCapability(new ResourceLocation(KrystalCraft.MOD_ID, "energy"), new ForgeEnergyContainer<>(energyBlock.getEnergyStorage(), event.getObject()));
        }

        if (event.getObject() instanceof PlorixFluidBlock<?> fluidHoldingBlock) {
            event.addCapability(new ResourceLocation(KrystalCraft.MOD_ID, "fluid"), new ForgeFluidContainer<>(fluidHoldingBlock.getFluidContainer(), event.getObject()));
        }

        if (event.getObject() instanceof ItemContainerBlock itemContainerBlock) {
            event.addCapability(new ResourceLocation(KrystalCraft.MOD_ID, "item"), new ItemContainerWrapper(itemContainerBlock.getContainer()));
        }
    }

    public static void attachItemCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() instanceof PlorixEnergyItem<?> energyItem) {
            event.addCapability(new ResourceLocation(KrystalCraft.MOD_ID, "energy"), new ForgeItemEnergyContainer<>(energyItem.getEnergyStorage(event.getObject()), event.getObject()));
        }

        if (event.getObject().getItem() instanceof PlorixFluidItem<?> fluidHoldingItem) {
            event.addCapability(new ResourceLocation(KrystalCraft.MOD_ID, "fluid"), new ForgeItemFluidContainer<>(fluidHoldingItem.getFluidContainer(event.getObject()), event.getObject()));
        }
    }
}
