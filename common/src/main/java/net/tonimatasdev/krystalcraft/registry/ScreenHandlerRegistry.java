package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.client.handler.CombiningStationMenuHandler;
import net.tonimatasdev.krystalcraft.client.handler.CrushingStationMenuHandler;
import net.tonimatasdev.krystalcraft.client.handler.CuttingStationMenuHandler;

import java.util.function.Supplier;

public class ScreenHandlerRegistry {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<CuttingStationMenuHandler>> GEM_CUTTING_MENU = create("gem_cutting_menu", () -> new MenuType<>(CuttingStationMenuHandler::new, FeatureFlags.VANILLA_SET));
    public static final RegistrySupplier<MenuType<CrushingStationMenuHandler>> COAL_CRUSHER_MENU = create("coal_crusher_menu",  () -> new MenuType<>(CrushingStationMenuHandler::new, FeatureFlags.VANILLA_SET));
    public static final RegistrySupplier<MenuType<CombiningStationMenuHandler>> COAL_COMBINER_MENU = create("coal_combiner_menu", () -> new MenuType<>(CombiningStationMenuHandler::new, FeatureFlags.VANILLA_SET));

    private static <T extends MenuType<?>> RegistrySupplier<T> create(String name, Supplier<T> type) {
        return MENUS.register(name, type);
    }

    public static void init() {
        MENUS.register();
    }
}
