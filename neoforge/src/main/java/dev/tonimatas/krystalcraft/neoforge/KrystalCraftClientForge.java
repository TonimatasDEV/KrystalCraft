package dev.tonimatas.krystalcraft.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.client.screen.*;
import dev.tonimatas.krystalcraft.registry.ModMenus;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrystalCraftClientForge {
    @SubscribeEvent
    public static void onClientSetup(RegisterMenuScreensEvent event) {
        event.register(ModMenus.COMBINING_STATION_MENU.get(), CombiningStationScreen::new);
        event.register(ModMenus.COMBINING_FACTORY_MENU.get(), CombiningFactoryScreen::new);
        event.register(ModMenus.CRUSHING_STATION_MENU.get(), CrushingStationScreen::new);
        event.register(ModMenus.CRUSHING_FACTORY_MENU.get(), CrushingFactoryScreen::new);
        event.register(ModMenus.CUTTING_STATION_MENU.get(), CuttingStationScreen::new);
        event.register(ModMenus.CUTTING_FACTORY_MENU.get(), CuttingFactoryScreen::new);
        event.register(ModMenus.COMBUSTION_GENERATOR_MENU.get(), CombustionGeneratorScreen::new);
    }
}
