package net.tonimatasdev.krystalcraft.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class KrystalCraftTab {
    public static void create() {
        CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 2).title(Component.translatable("itemGroup.foodAndDrink")).icon(() -> new ItemStack(ModItems.SILVER_INGOT.get())).displayItems((p_1, p_2, p_3) -> {
            for (RegistryObject<Item> registryObject : ModItems.ITEMS.getEntries()) {
                p_2.accept(registryObject.get());
            }
        }).build();
    }
}
