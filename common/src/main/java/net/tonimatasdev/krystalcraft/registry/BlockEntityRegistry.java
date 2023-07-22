package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.entity.custom.CombiningStationBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.CrushingStationBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.CuttingStationBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CuttingStationBlockEntity>> CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("cutting_station_block_entity", () -> BlockEntityType.Builder.of(CuttingStationBlockEntity::new, BlockRegistry.CUTTING_STATION.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<CrushingStationBlockEntity>> CRUSHING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("crushing_station_block_entity", () -> BlockEntityType.Builder.of(CrushingStationBlockEntity::new, BlockRegistry.CRUSHING_STATION.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<CombiningStationBlockEntity>> COMBINING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("combining_station_block_entity", () -> BlockEntityType.Builder.of(CombiningStationBlockEntity::new, BlockRegistry.COMBINING_STATION.get()).build(null));

    public static void init() {
        BLOCK_ENTITIES.register();
    }
}
