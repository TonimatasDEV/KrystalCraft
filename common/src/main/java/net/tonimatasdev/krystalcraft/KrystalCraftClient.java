package net.tonimatasdev.krystalcraft;

import dev.architectury.registry.menu.MenuRegistry;
import net.tonimatasdev.krystalcraft.client.CoalCombinerMenu;
import net.tonimatasdev.krystalcraft.client.CoalCrusherMenu;
import net.tonimatasdev.krystalcraft.client.GemCuttingMenu;
import net.tonimatasdev.krystalcraft.registry.ScreenHandlerRegistry;

public class KrystalCraftClient {
    public static void init() {
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.COAL_COMBINER_MENU.get(), CoalCombinerMenu::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.COAL_CRUSHER_MENU.get(), CoalCrusherMenu::new);
        MenuRegistry.registerScreenFactory(ScreenHandlerRegistry.GEM_CUTTING_MENU.get(), GemCuttingMenu::new);
    }
}
