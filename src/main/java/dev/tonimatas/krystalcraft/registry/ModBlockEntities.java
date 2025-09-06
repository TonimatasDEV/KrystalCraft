package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.block.entity.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {
    public static final BlockEntityType<CuttingStationBlockEntity> CUTTING_STATION_BLOCK_ENTITY = registerBlockEntity("cutting_station",
            BlockEntityType.Builder.create(CuttingStationBlockEntity::new, ModBlocks.CUTTING_STATION).build(null));
    public static final BlockEntityType<CrushingStationBlockEntity> CRUSHING_STATION_BLOCK_ENTITY = registerBlockEntity("crushing_station",
            BlockEntityType.Builder.create(CrushingStationBlockEntity::new, ModBlocks.CRUSHING_STATION).build(null));
    public static final BlockEntityType<CrushingFactoryBlockEntity> CRUSHING_FACTORY_BLOCK_ENTITY = registerBlockEntity("crushing_factory",
            BlockEntityType.Builder.create(CrushingFactoryBlockEntity::new, ModBlocks.CRUSHING_FACTORY).build(null));
    public static final BlockEntityType<CombiningStationBlockEntity> COMBINING_STATION_BLOCK_ENTITY = registerBlockEntity("combining_station",
            BlockEntityType.Builder.create(CombiningStationBlockEntity::new, ModBlocks.COMBINING_STATION).build(null));
    public static final BlockEntityType<CombiningFactoryBlockEntity> COMBINING_FACTORY_BLOCK_ENTITY = registerBlockEntity("combining_factory",
            BlockEntityType.Builder.create(CombiningFactoryBlockEntity::new, ModBlocks.COMBINING_FACTORY).build(null));
    public static final BlockEntityType<CombustionGeneratorBlockEntity> COMBUSTION_GENERATOR_BLOCK_ENTITY = registerBlockEntity("combustion_generator", 
            BlockEntityType.Builder.create(CombustionGeneratorBlockEntity::new, ModBlocks.COMBUSTION_GENERATOR).build(null));
    
    
    //public static final BlockEntityType<CuttingFactoryBlockEntity> CUTTING_FACTORY_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_factory", () -> BlockEntityType.Builder.of(CuttingFactoryBlockEntity::new, ModBlocks.CUTTING_FACTORY.get()).build(null));
    //public static final BlockEntityType<EnergyPipeBlockEntity> ENERGY_PIPE_BLOCK_ENTITY = BLOCK_ENTITIES.register("energy_pipe", () -> PlorixRegistryUtils.createBlockEntityType(EnergyPipeBlockEntity::new, ModBlocks.ENERGY_PIPE.get()));

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType<T> builder) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(KrystalCraft.MOD_ID, name), builder);
    }
    
    public static void initialize() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, COMBUSTION_GENERATOR_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, CRUSHING_FACTORY_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, COMBINING_FACTORY_BLOCK_ENTITY);
    }
}