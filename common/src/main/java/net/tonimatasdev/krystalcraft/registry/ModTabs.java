package net.tonimatasdev.krystalcraft.registry;

import dev.tonimatas.mythlib.registry.MythRegistries;
import dev.tonimatas.mythlib.registry.MythRegistry;
import dev.tonimatas.mythlib.registry.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class ModTabs {
    public static final MythRegistry<CreativeModeTab> TABS = MythRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, KrystalCraft.MOD_ID);

    public static final RegistryEntry<CreativeModeTab> KRYSTALCRAFT = TABS.register(KrystalCraft.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModBlocks.CUTTING_FACTORY.get()))
            .title(Component.translatable("itemGroup.krystalcraft"))
            .displayItems(((itemDisplayParameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))).build());
}
