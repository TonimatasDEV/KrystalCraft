package dev.tonimatas.krystalcraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.util.List;

public class BatteryItem extends Item implements SimpleEnergyItem {

    public BatteryItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(getStoredEnergy(stack) + "/" + getEnergyCapacity(stack) + " FE").setStyle(Style.EMPTY.withColor(Formatting.GOLD)));
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public long getEnergyCapacity(ItemStack stack) {
        return 10000;
    }

    @Override
    public long getEnergyMaxInput(ItemStack stack) {
        return 10;
    }

    @Override
    public long getEnergyMaxOutput(ItemStack stack) {
        return 10;
    }
}
