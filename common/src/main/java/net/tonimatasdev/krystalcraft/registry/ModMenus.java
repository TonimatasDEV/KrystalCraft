package net.tonimatasdev.krystalcraft.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.menu.*;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistries;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryHelpers;

public class ModMenus {
    public static final PlorixRegistry<MenuType<?>> MENUS = PlorixRegistries.create(BuiltInRegistries.MENU, KrystalCraft.MOD_ID);

    public static final RegistryEntry<MenuType<CuttingStationMenu>> CUTTING_STATION_MENU = MENUS.register("cutting_station_menu", () -> RegistryHelpers.createMenuType(CuttingStationMenu::new));
    public static final RegistryEntry<MenuType<CuttingFactoryMenu>> CUTTING_FACTORY_MENU = MENUS.register("cutting_factory_menu", () -> RegistryHelpers.createMenuType(CuttingFactoryMenu::new));
    public static final RegistryEntry<MenuType<CrushingStationMenu>> CRUSHING_STATION_MENU = MENUS.register("crushing_station_menu", () -> RegistryHelpers.createMenuType(CrushingStationMenu::new));
    public static final RegistryEntry<MenuType<CrushingFactoryMenu>> CRUSHING_FACTORY_MENU = MENUS.register("crushing_factory_menu", () -> RegistryHelpers.createMenuType(CrushingFactoryMenu::new));
    public static final RegistryEntry<MenuType<CombiningStationMenu>> COMBINING_STATION_MENU = MENUS.register("combining_station_menu", () -> RegistryHelpers.createMenuType(CombiningStationMenu::new));
    public static final RegistryEntry<MenuType<CombiningFactoryMenu>> COMBINING_FACTORY_MENU = MENUS.register("combining_factory_menu", () -> RegistryHelpers.createMenuType(CombiningFactoryMenu::new));
    public static final RegistryEntry<MenuType<CombustionGeneratorMenu>> COMBUSTION_GENERATOR_MENU = MENUS.register("combustion_generator_menu", () -> RegistryHelpers.createMenuType(CombustionGeneratorMenu::new));
}
