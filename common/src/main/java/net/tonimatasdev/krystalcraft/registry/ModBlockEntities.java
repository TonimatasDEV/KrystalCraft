package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import earth.terrarium.botarium.common.registry.RegistryHelpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.blockentity.*;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create( KrystalCraft.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CuttingStationBlockEntity>> CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_station", () -> RegistryHelpers.createBlockEntityType(CuttingStationBlockEntity::new, ModBlocks.CUTTING_STATION.get()));
    public static final RegistrySupplier<BlockEntityType<CuttingFactoryBlockEntity>> CUTTING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_factory", () -> RegistryHelpers.createBlockEntityType(CuttingFactoryBlockEntity::new, ModBlocks.CUTTING_FACTORY.get()));
    public static final RegistrySupplier<BlockEntityType<CrushingStationBlockEntity>> CRUSHING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_station", () -> RegistryHelpers.createBlockEntityType(CrushingStationBlockEntity::new, ModBlocks.CRUSHING_STATION.get()));
    public static final RegistrySupplier<BlockEntityType<CrushingFactoryBlockEntity>> CRUSHING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_factory", () -> RegistryHelpers.createBlockEntityType(CrushingFactoryBlockEntity::new, ModBlocks.CRUSHING_FACTORY.get()));
    public static final RegistrySupplier<BlockEntityType<CombiningStationBlockEntity>> COMBINING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_station", () -> RegistryHelpers.createBlockEntityType(CombiningStationBlockEntity::new, ModBlocks.COMBINING_STATION.get()));
    public static final RegistrySupplier<BlockEntityType<CombiningFactoryBlockEntity>> COMBINING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_factory", () -> RegistryHelpers.createBlockEntityType(CombiningFactoryBlockEntity::new, ModBlocks.COMBINING_FACTORY.get()));
    public static final RegistrySupplier<BlockEntityType<CombustionGeneratorBlockEntity>> COMBUSTION_GENERATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("combustion_generator", () -> RegistryHelpers.createBlockEntityType(CombustionGeneratorBlockEntity::new, ModBlocks.COMBUSTION_GENERATOR.get()));
}