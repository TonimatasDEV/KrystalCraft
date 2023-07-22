package net.tonimatasdev.krystalcraft.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.tonimatasdev.krystalcraft.client.screen.CombiningStationScreen;
import net.tonimatasdev.krystalcraft.client.screen.CrushingStationScreen;
import net.tonimatasdev.krystalcraft.client.screen.CuttingStationScreen;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class KrystalCraftClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenus.COMBINING_STATION_MENU.get(), CombiningStationScreen::new);
        MenuScreens.register(ModMenus.CRUSHING_STATION_MENU.get(), CrushingStationScreen::new);
        MenuScreens.register(ModMenus.CUTTING_STATION_MENU.get(), CuttingStationScreen::new);
    }
}
