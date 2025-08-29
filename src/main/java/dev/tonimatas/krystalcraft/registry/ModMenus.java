package dev.tonimatas.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.menu.MenuContentHelper;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.tonimatas.krystalcraft.menu.*;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(BuiltInRegistries.MENU, KrystalCraft.MOD_ID);

    public static final RegistryEntry<MenuType<CuttingStationMenu>> CUTTING_STATION_MENU = MENUS.register("cutting_station_menu", () -> MenuContentHelper.create(CuttingStationMenu::new, BlockPosContent.SERIALIZER));
    public static final RegistryEntry<MenuType<CuttingFactoryMenu>> CUTTING_FACTORY_MENU = MENUS.register("cutting_factory_menu", () -> MenuContentHelper.create(CuttingFactoryMenu::new, BlockPosContent.SERIALIZER));
    public static final RegistryEntry<MenuType<CrushingStationMenu>> CRUSHING_STATION_MENU = MENUS.register("crushing_station_menu", () -> MenuContentHelper.create(CrushingStationMenu::new, BlockPosContent.SERIALIZER));
    public static final RegistryEntry<MenuType<CrushingFactoryMenu>> CRUSHING_FACTORY_MENU = MENUS.register("crushing_factory_menu", () -> MenuContentHelper.create(CrushingFactoryMenu::new, BlockPosContent.SERIALIZER));
    public static final RegistryEntry<MenuType<CombiningStationMenu>> COMBINING_STATION_MENU = MENUS.register("combining_station_menu", () -> MenuContentHelper.create(CombiningStationMenu::new, BlockPosContent.SERIALIZER));
    public static final RegistryEntry<MenuType<CombiningFactoryMenu>> COMBINING_FACTORY_MENU = MENUS.register("combining_factory_menu", () -> MenuContentHelper.create(CombiningFactoryMenu::new, BlockPosContent.SERIALIZER));
    public static final RegistryEntry<MenuType<CombustionGeneratorMenu>> COMBUSTION_GENERATOR_MENU = MENUS.register("combustion_generator_menu", () -> MenuContentHelper.create(CombustionGeneratorMenu::new, BlockPosContent.SERIALIZER));
}
