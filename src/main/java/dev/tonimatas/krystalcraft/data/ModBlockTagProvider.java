package dev.tonimatas.krystalcraft.data;

import dev.tonimatas.krystalcraft.registry.ModBlocks;
import dev.tonimatas.krystalcraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CUTTING_STATION)
                .add(ModBlocks.CRUSHING_STATION)
                .add(ModBlocks.COMBINING_STATION)
                .add(ModBlocks.PLATINUM_BLOCK)
                .add(ModBlocks.PLATINUM_ORE)
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE)
                .add(ModBlocks.LEAD_BLOCK)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.JADE_BLOCK)
                .add(ModBlocks.JADE_ORE)
                .add(ModBlocks.DEEPSLATE_JADE_ORE)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE)
                .add(ModBlocks.EXPERIENCE_ORE)
                .add(ModBlocks.COMBUSTION_GENERATOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.COMBINING_STATION)
                .add(ModBlocks.CRUSHING_STATION)
                .add(ModBlocks.CUTTING_STATION)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE)
                .add(ModBlocks.EXPERIENCE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LEAD_BLOCK)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.JADE_BLOCK)
                .add(ModBlocks.JADE_ORE)
                .add(ModBlocks.DEEPSLATE_JADE_ORE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.COMBUSTION_GENERATOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PLATINUM_BLOCK)
                .add(ModBlocks.PLATINUM_ORE)
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE);
        
        // Common Tags - ORES
        getOrCreateTagBuilder(ConventionalBlockTags.ORES)
                .addTag(ModTags.Blocks.EXPERIENCE_ORES)
                .addTag(ModTags.Blocks.JADE_ORES)
                .addTag(ModTags.Blocks.LEAD_ORES)
                .addTag(ModTags.Blocks.PLATINUM_ORES)
                .addTag(ModTags.Blocks.RUBY_ORES)
                .addTag(ModTags.Blocks.SAPPHIRE_ORES)
                .addTag(ModTags.Blocks.SILVER_ORES)
                .addTag(ModTags.Blocks.TIN_ORES)
                .addTag(ModTags.Blocks.TOPAZ_ORES);

        getOrCreateTagBuilder(ModTags.Blocks.EXPERIENCE_ORES)
                .add(ModBlocks.EXPERIENCE_ORE)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);
        
        getOrCreateTagBuilder(ModTags.Blocks.JADE_ORES)
                .add(ModBlocks.JADE_ORE)
                .add(ModBlocks.DEEPSLATE_JADE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.LEAD_ORES)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.PLATINUM_ORES)
                .add(ModBlocks.PLATINUM_ORE)
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.RUBY_ORES)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.SAPPHIRE_ORES)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.SILVER_ORES)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.TIN_ORES)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.TOPAZ_ORES)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE);

        // Common Tags - STORAGE BLOCKS
        getOrCreateTagBuilder(ConventionalBlockTags.STORAGE_BLOCKS)
                .addTag(ModTags.Blocks.BRONZE_BLOCKS)
                .addTag(ModTags.Blocks.JADE_BLOCKS)
                .addTag(ModTags.Blocks.LEAD_BLOCKS)
                .addTag(ModTags.Blocks.PLATINUM_BLOCKS)
                .addTag(ModTags.Blocks.RUBY_BLOCKS)
                .addTag(ModTags.Blocks.SAPPHIRE_BLOCKS)
                .addTag(ModTags.Blocks.SILVER_BLOCKS)
                .addTag(ModTags.Blocks.TIN_BLOCKS)
                .addTag(ModTags.Blocks.TOPAZ_BLOCKS);

        getOrCreateTagBuilder(ModTags.Blocks.BRONZE_BLOCKS).add(ModBlocks.BRONZE_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.JADE_BLOCKS).add(ModBlocks.JADE_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.LEAD_BLOCKS).add(ModBlocks.LEAD_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.PLATINUM_BLOCKS).add(ModBlocks.PLATINUM_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.RUBY_BLOCKS).add(ModBlocks.RUBY_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.SAPPHIRE_BLOCKS).add(ModBlocks.SAPPHIRE_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.SILVER_BLOCKS).add(ModBlocks.SILVER_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.TIN_BLOCKS).add(ModBlocks.TIN_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.TOPAZ_BLOCKS).add(ModBlocks.TOPAZ_BLOCK);
    }
}
