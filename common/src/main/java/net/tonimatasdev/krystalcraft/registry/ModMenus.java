package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import earth.terrarium.botarium.common.registry.RegistryHelpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.menu.*;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<CuttingStationMenu>> CUTTING_STATION_MENU = MENUS.register("cutting_station_menu", () -> RegistryHelpers.createMenuType(CuttingStationMenu::new));
    public static final RegistrySupplier<MenuType<CuttingFactoryMenu>> CUTTING_FACTORY_MENU = MENUS.register("cutting_factory_menu", () -> RegistryHelpers.createMenuType(CuttingFactoryMenu::new));
    public static final RegistrySupplier<MenuType<CrushingStationMenu>> CRUSHING_STATION_MENU = MENUS.register("crushing_station_menu", () -> RegistryHelpers.createMenuType(CrushingStationMenu::new));
    public static final RegistrySupplier<MenuType<CrushingFactoryMenu>> CRUSHING_FACTORY_MENU = MENUS.register("crushing_factory_menu", () -> RegistryHelpers.createMenuType(CrushingFactoryMenu::new));
    public static final RegistrySupplier<MenuType<CombiningStationMenu>> COMBINING_STATION_MENU = MENUS.register("combining_station_menu", () -> RegistryHelpers.createMenuType(CombiningStationMenu::new));
    public static final RegistrySupplier<MenuType<CombiningFactoryMenu>> COMBINING_FACTORY_MENU = MENUS.register("combining_factory_menu", () -> RegistryHelpers.createMenuType(CombiningFactoryMenu::new));
    public static final RegistrySupplier<MenuType<CombustionGeneratorMenu>> COMBUSTION_GENERATOR_MENU = MENUS.register("combustion_generator_menu", () -> RegistryHelpers.createMenuType(CombustionGeneratorMenu::new));
}
