package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.screen.CombiningStationScreenHandler;
import dev.tonimatas.krystalcraft.screen.CrushingStationScreenHandler;
import dev.tonimatas.krystalcraft.screen.CuttingStationScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CuttingStationScreenHandler> CUTTING_STATION_SCREEN_HANDLER = registerScreenHandler("cutting_station_screen_handler",
            new ExtendedScreenHandlerType<>(CuttingStationScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CrushingStationScreenHandler> CRUSHING_STATION_SCREEN_HANDLER = registerScreenHandler("crushing_station_screen_handler",
            new ExtendedScreenHandlerType<>(CrushingStationScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CombiningStationScreenHandler> COMBINING_STATION_SCREEN_HANDLER = registerScreenHandler("combining_station_screen_handler",
            new ExtendedScreenHandlerType<>(CombiningStationScreenHandler::new, BlockPos.PACKET_CODEC));
    
    //public static final RegistryEntry<MenuType<CuttingFactoryMenu>> CUTTING_FACTORY_MENU = MENUS.register("cutting_factory_menu", () -> MenuContentHelper.create(CuttingFactoryMenu::new, BlockPosContent.SERIALIZER));
    //public static final RegistryEntry<MenuType<CrushingFactoryMenu>> CRUSHING_FACTORY_MENU = MENUS.register("crushing_factory_menu", () -> MenuContentHelper.create(CrushingFactoryMenu::new, BlockPosContent.SERIALIZER));
    //public static final RegistryEntry<MenuType<CombiningFactoryMenu>> COMBINING_FACTORY_MENU = MENUS.register("combining_factory_menu", () -> MenuContentHelper.create(CombiningFactoryMenu::new, BlockPosContent.SERIALIZER));
    //public static final RegistryEntry<MenuType<CombustionGeneratorMenu>> COMBUSTION_GENERATOR_MENU = MENUS.register("combustion_generator_menu", () -> MenuContentHelper.create(CombustionGeneratorMenu::new, BlockPosContent.SERIALIZER));
    public static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandler(String name, ScreenHandlerType<T> screenHandlerType) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(KrystalCraft.MOD_ID, name), screenHandlerType);
    }
    
    public static void initialize() {
        // Initialize the class
    }
}
