package net.tonimatasdev.krystalcraft.item.custom;

import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem;
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BatteryItem extends Item implements BotariumEnergyItem<WrappedItemEnergyContainer> {
    protected WrappedItemEnergyContainer energyContainer;

    public BatteryItem(Properties properties) {
        super(properties);
    }

    @Override
    public WrappedItemEnergyContainer getEnergyStorage(ItemStack holder) {
        return energyContainer == null ? energyContainer = new WrappedItemEnergyContainer(this.getDefaultInstance(), new SimpleEnergyContainer(7500)) : this.energyContainer;
    }
}
