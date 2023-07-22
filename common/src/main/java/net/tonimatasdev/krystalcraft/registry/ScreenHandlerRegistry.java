package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.client.handler.CoalCombinerMenuHandler;
import net.tonimatasdev.krystalcraft.client.handler.CoalCrusherMenuHandler;
import net.tonimatasdev.krystalcraft.client.handler.GemCuttingMenuHandler;

import java.util.function.Supplier;

public class ScreenHandlerRegistry {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<GemCuttingMenuHandler>> GEM_CUTTING_MENU = create("gem_cutting_menu", () -> new MenuType<>(GemCuttingMenuHandler::new, FeatureFlags.VANILLA_SET));
    public static final RegistrySupplier<MenuType<CoalCrusherMenuHandler>> COAL_CRUSHER_MENU = create("coal_crusher_menu",  () -> new MenuType<>(CoalCrusherMenuHandler::new, FeatureFlags.VANILLA_SET));
    public static final RegistrySupplier<MenuType<CoalCombinerMenuHandler>> COAL_COMBINER_MENU = create("coal_combiner_menu", () -> new MenuType<>(CoalCombinerMenuHandler::new, FeatureFlags.VANILLA_SET));

    private static <T extends MenuType<?>> RegistrySupplier<T> create(String name, Supplier<T> type) {
        return MENUS.register(name, type);
    }

    public static void init() {
        MENUS.register();
    }
}
