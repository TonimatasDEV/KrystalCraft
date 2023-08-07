package net.tonimatasdev.krystalcraft.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.tonimatasdev.krystalcraft.client.screen.*;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class KrystalCraftClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenus.COMBINING_STATION_MENU.get(), CombiningStationScreen::new);
        MenuScreens.register(ModMenus.COMBINING_FACTORY_MENU.get(), CombiningFactoryScreen::new);
        MenuScreens.register(ModMenus.CRUSHING_STATION_MENU.get(), CrushingStationScreen::new);
        MenuScreens.register(ModMenus.CRUSHING_FACTORY_MENU.get(), CrushingFactoryScreen::new);
        MenuScreens.register(ModMenus.CUTTING_STATION_MENU.get(), CuttingStationScreen::new);
        MenuScreens.register(ModMenus.CUTTING_FACTORY_MENU.get(), CuttingFactoryScreen::new);
        MenuScreens.register(ModMenus.COMBUSTION_GENERATOR_MENU.get(), CombustionGeneratorScreen::new);
    }
}
