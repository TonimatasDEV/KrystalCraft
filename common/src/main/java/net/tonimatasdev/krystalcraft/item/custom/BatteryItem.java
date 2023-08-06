package net.tonimatasdev.krystalcraft.item.custom;

import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem;
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class BatteryItem extends Item implements BotariumEnergyItem<WrappedItemEnergyContainer> {
    protected WrappedItemEnergyContainer energyContainer;

    public BatteryItem(Properties properties) {
        super(properties);
    }

    @Override
    public WrappedItemEnergyContainer getEnergyStorage(ItemStack holder) {
        return energyContainer == null ? energyContainer = new WrappedItemEnergyContainer(this.getDefaultInstance(), new SimpleEnergyContainer(7500)) : this.energyContainer;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.literal(energyContainer.getStoredEnergy() + "/" + energyContainer.getMaxCapacity() + " FE").setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)));
        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }
}
