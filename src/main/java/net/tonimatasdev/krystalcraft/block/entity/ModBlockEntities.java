package net.tonimatasdev.krystalcraft.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.ModBlocks;
import net.tonimatasdev.krystalcraft.block.entity.custom.CoalCombinerBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.CoalCrusherBlockEntity;
import net.tonimatasdev.krystalcraft.block.entity.custom.GemCuttingStationBlockEntity;

@SuppressWarnings("DataFlowIssue")
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, KrystalCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("gem_cutting_station_block_entity", () -> BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new, ModBlocks.GEM_CUTTING_STATION.get()).build(null));
    public static final RegistryObject<BlockEntityType<CoalCrusherBlockEntity>> COAL_CRUSHER_BLOCK_ENTITY = BLOCK_ENTITIES.register("coal_crusher_block_entity", () -> BlockEntityType.Builder.of(CoalCrusherBlockEntity::new, ModBlocks.COAL_CRUSHER.get()).build(null));
    public static final RegistryObject<BlockEntityType<CoalCombinerBlockEntity>> COAL_COMBINER_BLOCK_ENTITY = BLOCK_ENTITIES.register("coal_combiner_block_entity", () -> BlockEntityType.Builder.of(CoalCombinerBlockEntity::new, ModBlocks.COAL_COMBINER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
