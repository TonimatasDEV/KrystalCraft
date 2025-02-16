package dev.tonimatas.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.tonimatas.krystalcraft.KrystalCraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final ResourcefulRegistry<CreativeModeTab> TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, KrystalCraft.MOD_ID);

    public static final RegistryEntry<CreativeModeTab> KRYSTALCRAFT = TABS.register(KrystalCraft.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModBlocks.CUTTING_FACTORY.get()))
            .title(Component.translatable("itemGroup.krystalcraft"))
            .displayItems(((itemDisplayParameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))).build());
}
