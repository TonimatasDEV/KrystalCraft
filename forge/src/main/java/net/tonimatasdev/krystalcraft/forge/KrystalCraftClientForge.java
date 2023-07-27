package net.tonimatasdev.krystalcraft.forge;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.client.screen.*;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrystalCraftClientForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenus.COMBINING_STATION_MENU.get(), CombiningStationScreen::new);
        MenuScreens.register(ModMenus.COMBINING_FACTORY_MENU.get(), CombiningFactoryScreen::new);
        MenuScreens.register(ModMenus.CRUSHING_STATION_MENU.get(), CrushingStationScreen::new);
        MenuScreens.register(ModMenus.CRUSHING_FACTORY_MENU.get(), CrushingFactoryScreen::new);
        MenuScreens.register(ModMenus.CUTTING_STATION_MENU.get(), CuttingStationScreen::new);
        MenuScreens.register(ModMenus.CUTTING_FACTORY_MENU.get(), CuttingFactoryScreen::new);
    }
}
