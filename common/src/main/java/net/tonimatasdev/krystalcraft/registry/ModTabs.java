package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class ModTabs {
    public static final ResourcefulRegistry<CreativeModeTab> TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, KrystalCraft.MOD_ID);

    public static final RegistryEntry<CreativeModeTab> KRYSTALCRAFT = TABS.register(KrystalCraft.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModItems.JADE_PICKAXE.get()))
            .title(Component.translatable("itemGroup.krystalcraft"))
            .displayItems(((itemDisplayParameters, output) -> {
                ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get()));
                ModBlocks.BLOCKS.getEntries().forEach((block) -> output.accept(block.get()));
            })).build());
}
