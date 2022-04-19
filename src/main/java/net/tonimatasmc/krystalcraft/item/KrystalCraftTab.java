package net.tonimatasmc.krystalcraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class KrystalCraftTab {
    public static final CreativeModeTab KRYSTALCRAFT = new CreativeModeTab("KrystalCraft") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SILVER_INGOT.get());
        } 
    };
}
