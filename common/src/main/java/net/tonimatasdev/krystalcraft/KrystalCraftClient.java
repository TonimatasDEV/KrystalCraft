package net.tonimatasdev.krystalcraft;

import dev.architectury.registry.menu.MenuRegistry;
import net.tonimatasdev.krystalcraft.client.CombiningStationMenu;
import net.tonimatasdev.krystalcraft.client.CrushingStationMenu;
import net.tonimatasdev.krystalcraft.client.CuttingStationMenu;
import net.tonimatasdev.krystalcraft.registry.ScreenHandlerRegistry;

public class KrystalCraftClient {
    public static void init() {
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.COAL_COMBINER_MENU.get(), CombiningStationMenu::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.COAL_CRUSHER_MENU.get(), CrushingStationMenu::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.GEM_CUTTING_MENU.get(), CuttingStationMenu::new);
    }
}
