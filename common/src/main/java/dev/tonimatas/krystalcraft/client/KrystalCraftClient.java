package dev.tonimatas.krystalcraft.client;

import dev.architectury.registry.menu.MenuRegistry;
import dev.tonimatas.krystalcraft.client.screen.*;
import dev.tonimatas.krystalcraft.registry.ModMenus;

public class KrystalCraftClient {
    public static void init() {
        MenuRegistry.registerScreenFactory(ModMenus.COMBINING_STATION_MENU.get(), CombiningStationScreen::new);
        MenuRegistry.registerScreenFactory(ModMenus.COMBINING_FACTORY_MENU.get(), CombiningFactoryScreen::new);
        MenuRegistry.registerScreenFactory(ModMenus.CRUSHING_STATION_MENU.get(), CrushingStationScreen::new);
        MenuRegistry.registerScreenFactory(ModMenus.CRUSHING_FACTORY_MENU.get(), CrushingFactoryScreen::new);
        MenuRegistry.registerScreenFactory(ModMenus.CUTTING_STATION_MENU.get(), CuttingStationScreen::new);
        MenuRegistry.registerScreenFactory(ModMenus.CUTTING_FACTORY_MENU.get(), CuttingFactoryScreen::new);
        MenuRegistry.registerScreenFactory(ModMenus.COMBUSTION_GENERATOR_MENU.get(), CombustionGeneratorScreen::new);
    }
}
