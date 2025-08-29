package dev.tonimatas.krystalcraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class BatteryItem extends Item implements BotariumEnergyItem<WrappedItemEnergyContainer> {

    public BatteryItem(Settings settings) {
        super(settings);
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(getEnergyStorage(stack).getStoredEnergy() + "/" + getEnergyStorage(stack).getMaxCapacity() + " FE").setStyle(Style.EMPTY.withColor(Formatting.GOLD)));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
