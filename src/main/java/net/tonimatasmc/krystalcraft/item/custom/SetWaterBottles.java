package net.tonimatasmc.krystalcraft.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.tonimatasmc.krystalcraft.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class SetWaterBottles extends Item {
    public SetWaterBottles(Properties properties) {
        super(properties);
    }

    //@Override
    //public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
    //    if (context.getItemInHand().is(ModItems.SET_WATER_BOTTLES.get())) {
    //        if (context.getClickedPos().)
    //    }
    //}

    private void setDurability(ItemStack itemStack) {
        itemStack.setDamageValue(64);
    }
}
