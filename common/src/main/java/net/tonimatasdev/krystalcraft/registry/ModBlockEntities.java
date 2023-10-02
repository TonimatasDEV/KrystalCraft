package net.tonimatasdev.krystalcraft.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.blockentity.*;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistries;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryHelpers;

public class ModBlockEntities {
    public static final PlorixRegistry<BlockEntityType<?>> BLOCK_ENTITIES = PlorixRegistries.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, KrystalCraft.MOD_ID);

    public static final RegistryEntry<BlockEntityType<CuttingStationBlockEntity>> CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_station", () -> RegistryHelpers.createBlockEntityType(CuttingStationBlockEntity::new, ModBlocks.CUTTING_STATION.get()));
    public static final RegistryEntry<BlockEntityType<CuttingFactoryBlockEntity>> CUTTING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_factory", () -> RegistryHelpers.createBlockEntityType(CuttingFactoryBlockEntity::new, ModBlocks.CUTTING_FACTORY.get()));
    public static final RegistryEntry<BlockEntityType<CrushingStationBlockEntity>> CRUSHING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_station", () -> RegistryHelpers.createBlockEntityType(CrushingStationBlockEntity::new, ModBlocks.CRUSHING_STATION.get()));
    public static final RegistryEntry<BlockEntityType<CrushingFactoryBlockEntity>> CRUSHING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_factory", () -> RegistryHelpers.createBlockEntityType(CrushingFactoryBlockEntity::new, ModBlocks.CRUSHING_FACTORY.get()));
    public static final RegistryEntry<BlockEntityType<CombiningStationBlockEntity>> COMBINING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_station", () -> RegistryHelpers.createBlockEntityType(CombiningStationBlockEntity::new, ModBlocks.COMBINING_STATION.get()));
    public static final RegistryEntry<BlockEntityType<CombiningFactoryBlockEntity>> COMBINING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_factory", () -> RegistryHelpers.createBlockEntityType(CombiningFactoryBlockEntity::new, ModBlocks.COMBINING_FACTORY.get()));
    public static final RegistryEntry<BlockEntityType<CombustionGeneratorBlockEntity>> COMBUSTION_GENERATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("combustion_generator", () -> RegistryHelpers.createBlockEntityType(CombustionGeneratorBlockEntity::new, ModBlocks.COMBUSTION_GENERATOR.get()));
    //public static final RegistryEntry<BlockEntityType<EnergyPipeBlockEntity>> ENERGY_PIPE_BLOCK_ENTITY = BLOCK_ENTITIES.register("energy_pipe", () -> PlorixRegistryUtils.createBlockEntityType(EnergyPipeBlockEntity::new, ModBlocks.ENERGY_PIPE.get()));
}