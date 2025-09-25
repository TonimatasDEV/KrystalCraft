package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.screen.*;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandler(String name, ScreenHandlerType<T> screenHandlerType) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(KrystalCraft.MOD_ID, name), screenHandlerType);
    }    public static final ScreenHandlerType<CuttingStationScreenHandler> CUTTING_STATION_SCREEN_HANDLER = registerScreenHandler("cutting_station_screen_handler",
            new ExtendedScreenHandlerType<>(CuttingStationScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void initialize() {
        // Initialize the class
    }    public static final ScreenHandlerType<CuttingFactoryScreenHandler> CUTTING_FACTORY_SCREEN_HANDLER = registerScreenHandler("cutting_factory_screen_handler",
            new ExtendedScreenHandlerType<>(CuttingFactoryScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CrushingStationScreenHandler> CRUSHING_STATION_SCREEN_HANDLER = registerScreenHandler("crushing_station_screen_handler",
            new ExtendedScreenHandlerType<>(CrushingStationScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CrushingFactoryScreenHandler> CRUSHING_FACTORY_SCREEN_HANDLER = registerScreenHandler("crushing_factory_screen_handler",
            new ExtendedScreenHandlerType<>(CrushingFactoryScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CombiningStationScreenHandler> COMBINING_STATION_SCREEN_HANDLER = registerScreenHandler("combining_station_screen_handler",
            new ExtendedScreenHandlerType<>(CombiningStationScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CombiningFactoryScreenHandler> COMBINING_FACTORY_SCREEN_HANDLER = registerScreenHandler("combining_factory_screen_handler",
            new ExtendedScreenHandlerType<>(CombiningFactoryScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<CombustionGeneratorScreenHandler> COMBUSTION_GENERATOR_SCREEN_HANDLER = registerScreenHandler("combustion_generator_screen_handler",
            new ExtendedScreenHandlerType<>(CombustionGeneratorScreenHandler::new, BlockPos.PACKET_CODEC));




}
