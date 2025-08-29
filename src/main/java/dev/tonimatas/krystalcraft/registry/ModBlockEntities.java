package dev.tonimatas.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.tonimatas.krystalcraft.blockentity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITIES = ResourcefulRegistries.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, KrystalCraft.MOD_ID);
    
    //public static final RegistryEntry<BlockEntityType<CuttingStationBlockEntity>> CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_station", () -> RegistryHelpers.createBlockEntityType(CuttingStationBlockEntity::new, ModBlocks.CUTTING_STATION.get()));
    public static final RegistryEntry<BlockEntityType<CuttingStationBlockEntity>> CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_station", () -> BlockEntityType.Builder.of(CuttingStationBlockEntity::new, ModBlocks.CUTTING_STATION.get()).build(null));
    public static final RegistryEntry<BlockEntityType<CuttingFactoryBlockEntity>> CUTTING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_factory", () -> BlockEntityType.Builder.of(CuttingFactoryBlockEntity::new, ModBlocks.CUTTING_FACTORY.get()).build(null));
    public static final RegistryEntry<BlockEntityType<CrushingStationBlockEntity>> CRUSHING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_station", () -> BlockEntityType.Builder.of(CrushingStationBlockEntity::new, ModBlocks.CRUSHING_STATION.get()).build(null));
    public static final RegistryEntry<BlockEntityType<CrushingFactoryBlockEntity>> CRUSHING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_factory", () -> BlockEntityType.Builder.of(CrushingFactoryBlockEntity::new, ModBlocks.CRUSHING_FACTORY.get()).build(null));
    public static final RegistryEntry<BlockEntityType<CombiningStationBlockEntity>> COMBINING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_station", () -> BlockEntityType.Builder.of(CombiningStationBlockEntity::new, ModBlocks.COMBINING_STATION.get()).build(null));
    public static final RegistryEntry<BlockEntityType<CombiningFactoryBlockEntity>> COMBINING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_factory", () -> BlockEntityType.Builder.of(CombiningFactoryBlockEntity::new, ModBlocks.COMBINING_FACTORY.get()).build(null));
    public static final RegistryEntry<BlockEntityType<CombustionGeneratorBlockEntity>> COMBUSTION_GENERATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("combustion_generator", () -> BlockEntityType.Builder.of(CombustionGeneratorBlockEntity::new, ModBlocks.COMBUSTION_GENERATOR.get()).build(null));
    //public static final RegistryEntry<BlockEntityType<EnergyPipeBlockEntity>> ENERGY_PIPE_BLOCK_ENTITY = BLOCK_ENTITIES.register("energy_pipe", () -> PlorixRegistryUtils.createBlockEntityType(EnergyPipeBlockEntity::new, ModBlocks.ENERGY_PIPE.get()));
}