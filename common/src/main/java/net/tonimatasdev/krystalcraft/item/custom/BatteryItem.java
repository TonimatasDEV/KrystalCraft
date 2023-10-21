package net.tonimatasdev.krystalcraft.item.custom;

import dev.tonimatas.mythlib.energy.base.MythEnergyItem;
import dev.tonimatas.mythlib.energy.impl.SimpleEnergyContainer;
import dev.tonimatas.mythlib.energy.impl.WrappedItemEnergyContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BatteryItem extends Item implements MythEnergyItem<WrappedItemEnergyContainer> {

    public BatteryItem(Properties properties) {
        super(properties);
    }

    @Override
    public WrappedItemEnergyContainer getEnergyStorage(ItemStack holder) {
        return new WrappedItemEnergyContainer(holder, new SimpleEnergyContainer(7500) {
            @Override
            public long maxInsert() {
                return 10;
            }

            @Override
            public long maxExtract() {
                return 10;
            }
        });
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.literal(getEnergyStorage(itemStack).getStoredEnergy() + "/" + getEnergyStorage(itemStack).getMaxCapacity() + " FE").setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)));
        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }
}
