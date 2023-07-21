package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> KRYSTALCRAFT = TABS.register(KrystalCraft.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ItemRegistry.JADE_PICKAXE.get()))
            .title(Component.translatable("itemGroup.krystalcraft"))
            .displayItems(((itemDisplayParameters, output) -> {
                ItemRegistry.ITEMS.forEach((item) -> output.accept(item.get()));
                BlockRegistry.BLOCKS.forEach((block) -> output.accept(block.get()));
            })).build());

    public static void init() {
        TABS.register();
    }
}
