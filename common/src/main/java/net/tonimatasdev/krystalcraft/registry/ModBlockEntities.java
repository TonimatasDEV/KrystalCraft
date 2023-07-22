package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.botarium.common.registry.RegistryHelpers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.entity.custom.CombiningStationBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.CrushingStationBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.CuttingStationBlockEntity;

public class ModBlockEntities {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITIES = ResourcefulRegistries.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, KrystalCraft.MOD_ID);

    public static final RegistryEntry<BlockEntityType<CuttingStationBlockEntity>> CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_station", () -> RegistryHelpers.createBlockEntityType(CuttingStationBlockEntity::new, ModBlocks.CUTTING_STATION.get()));
    public static final RegistryEntry<BlockEntityType<CrushingStationBlockEntity>> CRUSHING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_station", () -> RegistryHelpers.createBlockEntityType(CrushingStationBlockEntity::new, ModBlocks.CRUSHING_STATION.get()));
    public static final RegistryEntry<BlockEntityType<CombiningStationBlockEntity>> COMBINING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_station", () -> RegistryHelpers.createBlockEntityType(CombiningStationBlockEntity::new, ModBlocks.COMBINING_STATION.get()));
}