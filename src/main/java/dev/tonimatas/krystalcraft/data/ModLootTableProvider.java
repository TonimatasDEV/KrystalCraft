package dev.tonimatas.krystalcraft.data;

import dev.tonimatas.krystalcraft.registry.ModBlocks;
import dev.tonimatas.krystalcraft.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BRONZE_BLOCK);
        addDrop(ModBlocks.JADE_BLOCK);
        addDrop(ModBlocks.LEAD_BLOCK);
        addDrop(ModBlocks.PLATINUM_BLOCK);
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.SAPPHIRE_BLOCK);
        addDrop(ModBlocks.SILVER_BLOCK);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.TOPAZ_BLOCK);
        addDrop(ModBlocks.COMBINING_STATION);
        addDrop(ModBlocks.CRUSHING_STATION);
        addDrop(ModBlocks.CRUSHING_FACTORY);
        addDrop(ModBlocks.CUTTING_STATION);
        addDrop(ModBlocks.COMBUSTION_GENERATOR);
        
        addDrop(ModBlocks.DEEPSLATE_JADE_ORE, oreDrops(ModBlocks.DEEPSLATE_JADE_ORE, ModItems.RAW_JADE));
        addDrop(ModBlocks.DEEPSLATE_LEAD_ORE, oreDrops(ModBlocks.DEEPSLATE_LEAD_ORE, ModItems.RAW_LEAD));
        addDrop(ModBlocks.DEEPSLATE_PLATINUM_ORE, oreDrops(ModBlocks.DEEPSLATE_PLATINUM_ORE, ModItems.RAW_PLATINUM));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, oreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, oreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE));
        addDrop(ModBlocks.DEEPSLATE_SILVER_ORE, oreDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, oreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, oreDrops(ModBlocks.DEEPSLATE_TOPAZ_ORE, ModItems.RAW_TOPAZ));
        
        addDrop(ModBlocks.JADE_ORE, oreDrops(ModBlocks.JADE_ORE, ModItems.RAW_JADE));
        addDrop(ModBlocks.LEAD_ORE, oreDrops(ModBlocks.LEAD_ORE, ModItems.RAW_LEAD));
        addDrop(ModBlocks.PLATINUM_ORE, oreDrops(ModBlocks.PLATINUM_ORE, ModItems.RAW_PLATINUM));
        addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.SAPPHIRE_ORE, oreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE));
        addDrop(ModBlocks.SILVER_ORE, oreDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER));
        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.TOPAZ_ORE, oreDrops(ModBlocks.TOPAZ_ORE, ModItems.RAW_TOPAZ));
        
        addDropWithSilkTouch(ModBlocks.EXPERIENCE_ORE, ModBlocks.EXPERIENCE_ORE);
        addDropWithSilkTouch(ModBlocks.DEEPSLATE_EXPERIENCE_ORE, ModBlocks.DEEPSLATE_EXPERIENCE_ORE);
    }
}
