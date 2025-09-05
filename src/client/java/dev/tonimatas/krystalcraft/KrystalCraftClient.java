package dev.tonimatas.krystalcraft;

import dev.tonimatas.krystalcraft.registry.ModScreenHandlers;
import dev.tonimatas.krystalcraft.screen.*;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class KrystalCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.COMBINING_STATION_SCREEN_HANDLER, CombiningStationScreen::new);
        //HandledScreens.register(ModScreenHandlers.COMBINING_FACTORY_SCREEN_HANDLER, CombiningFactoryScreen::new);
        HandledScreens.register(ModScreenHandlers.CRUSHING_STATION_SCREEN_HANDLER, CrushingStationScreen::new);
        HandledScreens.register(ModScreenHandlers.CRUSHING_FACTORY_SCREEN_HANDLER, CrushingFactoryScreen::new);
        HandledScreens.register(ModScreenHandlers.CUTTING_STATION_SCREEN_HANDLER, CuttingStationScreen::new);
        //HandledScreens.register(ModScreenHandlers.CUTTING_FACTORY_SCREEN_HANDLER, CuttingFactoryScreen::new);
        HandledScreens.register(ModScreenHandlers.COMBUSTION_GENERATOR_SCREEN_HANDLER, CombustionGeneratorScreen::new);
    }
}
