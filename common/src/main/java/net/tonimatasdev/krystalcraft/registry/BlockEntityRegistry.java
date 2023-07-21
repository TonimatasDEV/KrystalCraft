package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.entity.custom.CoalCombinerBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.CoalCrusherBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.GemCuttingStationBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("gem_cutting_station_block_entity", () -> BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new, BlockRegistry.GEM_CUTTING_STATION.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<CoalCrusherBlockEntity>> COAL_CRUSHER_BLOCK_ENTITY = BLOCK_ENTITIES.register("coal_crusher_block_entity", () -> BlockEntityType.Builder.of(CoalCrusherBlockEntity::new, BlockRegistry.COAL_CRUSHER.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<CoalCombinerBlockEntity>> COAL_COMBINER_BLOCK_ENTITY = BLOCK_ENTITIES.register("coal_combiner_block_entity", () -> BlockEntityType.Builder.of(CoalCombinerBlockEntity::new, BlockRegistry.COAL_COMBINER.get()).build(null));

    public static void init() {
        BLOCK_ENTITIES.register();
    }
}
