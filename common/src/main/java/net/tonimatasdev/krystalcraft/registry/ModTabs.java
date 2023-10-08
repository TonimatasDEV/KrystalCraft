package net.tonimatasdev.krystalcraft.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistries;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;

public class ModTabs {
    public static final PlorixRegistry<CreativeModeTab> TABS = PlorixRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, KrystalCraft.MOD_ID);

    public static final RegistryEntry<CreativeModeTab> KRYSTALCRAFT = TABS.register(KrystalCraft.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModBlocks.CUTTING_FACTORY.get()))
            .title(Component.translatable("itemGroup.krystalcraft"))
            .displayItems(((itemDisplayParameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))).build());
}
