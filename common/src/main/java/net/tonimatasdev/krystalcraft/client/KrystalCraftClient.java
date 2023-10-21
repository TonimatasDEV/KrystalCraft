package net.tonimatasdev.krystalcraft.client;

import dev.tonimatas.mythlib.client.RegistryClientHelpers;
import net.tonimatasdev.krystalcraft.client.screen.*;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class KrystalCraftClient {
    public static void init() {
        RegistryClientHelpers.registerMenu(ModMenus.COMBINING_STATION_MENU.get(), CombiningStationScreen::new);
        RegistryClientHelpers.registerMenu(ModMenus.COMBINING_FACTORY_MENU.get(), CombiningFactoryScreen::new);
        RegistryClientHelpers.registerMenu(ModMenus.CRUSHING_STATION_MENU.get(), CrushingStationScreen::new);
        RegistryClientHelpers.registerMenu(ModMenus.CRUSHING_FACTORY_MENU.get(), CrushingFactoryScreen::new);
        RegistryClientHelpers.registerMenu(ModMenus.CUTTING_STATION_MENU.get(), CuttingStationScreen::new);
        RegistryClientHelpers.registerMenu(ModMenus.CUTTING_FACTORY_MENU.get(), CuttingFactoryScreen::new);
        RegistryClientHelpers.registerMenu(ModMenus.COMBUSTION_GENERATOR_MENU.get(), CombustionGeneratorScreen::new);
    }
}
