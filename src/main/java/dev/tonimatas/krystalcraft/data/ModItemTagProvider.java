package dev.tonimatas.krystalcraft.data;

import dev.tonimatas.krystalcraft.registry.ModBlocks;
import dev.tonimatas.krystalcraft.registry.ModItems;
import dev.tonimatas.krystalcraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Common tags - INGOTS
        getOrCreateTagBuilder(ConventionalItemTags.INGOTS)
                .addTag(ModTags.Items.BRONZE_INGOTS)
                .addTag(ModTags.Items.LEAD_INGOTS)
                .addTag(ModTags.Items.PLATINUM_INGOTS)
                .addTag(ModTags.Items.SILVER_INGOTS)
                .addTag(ModTags.Items.TIN_INGOTS);

        getOrCreateTagBuilder(ModTags.Items.BRONZE_INGOTS).add(ModItems.BRONZE_INGOT);
        getOrCreateTagBuilder(ModTags.Items.LEAD_INGOTS).add(ModItems.LEAD_INGOT);
        getOrCreateTagBuilder(ModTags.Items.PLATINUM_INGOTS).add(ModItems.PLATINUM_INGOT);
        getOrCreateTagBuilder(ModTags.Items.SILVER_INGOTS).add(ModItems.SILVER_INGOT);
        getOrCreateTagBuilder(ModTags.Items.TIN_INGOTS).add(ModItems.TIN_INGOT);

        // Common tags - NUGGETS
        getOrCreateTagBuilder(ConventionalItemTags.NUGGETS)
                .addTag(ModTags.Items.BRONZE_NUGGETS)
                .addTag(ModTags.Items.LEAD_NUGGETS)
                .addTag(ModTags.Items.PLATINUM_NUGGETS)
                .addTag(ModTags.Items.SILVER_NUGGETS)
                .addTag(ModTags.Items.TIN_NUGGETS)
                .addTag(ModTags.Items.COPPER_NUGGETS);

        getOrCreateTagBuilder(ModTags.Items.BRONZE_NUGGETS).add(ModItems.BRONZE_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.LEAD_NUGGETS).add(ModItems.LEAD_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.PLATINUM_NUGGETS).add(ModItems.PLATINUM_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.SILVER_NUGGETS).add(ModItems.SILVER_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.TIN_NUGGETS).add(ModItems.TIN_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.COPPER_NUGGETS).add(ModItems.COPPER_NUGGET);

        // Common tags - DUSTS
        getOrCreateTagBuilder(ConventionalItemTags.DUSTS)
                .addTag(ModTags.Items.BRONZE_DUSTS)
                .addTag(ModTags.Items.JADE_DUSTS)
                .addTag(ModTags.Items.LEAD_DUSTS)
                .addTag(ModTags.Items.PLATINUM_DUSTS)
                .addTag(ModTags.Items.RUBY_DUSTS)
                .addTag(ModTags.Items.SAPPHIRE_DUSTS)
                .addTag(ModTags.Items.SILVER_DUSTS)
                .addTag(ModTags.Items.TIN_DUSTS)
                .addTag(ModTags.Items.TOPAZ_DUSTS)
                .addTag(ModTags.Items.COPPER_DUSTS)
                .addTag(ModTags.Items.DIAMOND_DUSTS)
                .addTag(ModTags.Items.LAPIS_DUSTS)
                .addTag(ModTags.Items.EMERALD_DUSTS)
                .addTag(ModTags.Items.IRON_DUSTS);

        getOrCreateTagBuilder(ModTags.Items.BRONZE_DUSTS).add(ModItems.BRONZE_DUST);
        getOrCreateTagBuilder(ModTags.Items.JADE_DUSTS).add(ModItems.JADE_DUST);
        getOrCreateTagBuilder(ModTags.Items.LEAD_DUSTS).add(ModItems.LEAD_DUST);
        getOrCreateTagBuilder(ModTags.Items.PLATINUM_DUSTS).add(ModItems.PLATINUM_DUST);
        getOrCreateTagBuilder(ModTags.Items.RUBY_DUSTS).add(ModItems.RUBY_DUST);
        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_DUSTS).add(ModItems.SAPPHIRE_DUST);
        getOrCreateTagBuilder(ModTags.Items.SILVER_DUSTS).add(ModItems.SILVER_DUST);
        getOrCreateTagBuilder(ModTags.Items.TIN_DUSTS).add(ModItems.TIN_DUST);
        getOrCreateTagBuilder(ModTags.Items.TOPAZ_DUSTS).add(ModItems.TOPAZ_DUST);
        getOrCreateTagBuilder(ModTags.Items.COPPER_DUSTS).add(ModItems.COPPER_DUST);
        getOrCreateTagBuilder(ModTags.Items.DIAMOND_DUSTS).add(ModItems.DIAMOND_DUST);
        getOrCreateTagBuilder(ModTags.Items.LAPIS_DUSTS).add(ModItems.LAPIS_DUST);
        getOrCreateTagBuilder(ModTags.Items.EMERALD_DUSTS).add(ModItems.EMERALD_DUST);
        getOrCreateTagBuilder(ModTags.Items.IRON_DUSTS).add(ModItems.IRON_DUST);

        // Common tags - RAW MATERIALS
        getOrCreateTagBuilder(ConventionalItemTags.RAW_MATERIALS)
                .addTag(ModTags.Items.JADE_RAW_MATERIALS)
                .addTag(ModTags.Items.LEAD_RAW_MATERIALS)
                .addTag(ModTags.Items.PLATINUM_RAW_MATERIALS)
                .addTag(ModTags.Items.RUBY_RAW_MATERIALS)
                .addTag(ModTags.Items.SAPPHIRE_RAW_MATERIALS)
                .addTag(ModTags.Items.SILVER_RAW_MATERIALS)
                .addTag(ModTags.Items.TIN_RAW_MATERIALS)
                .addTag(ModTags.Items.TOPAZ_RAW_MATERIALS)
                .addTag(ModTags.Items.DIAMOND_RAW_MATERIALS)
                .addTag(ModTags.Items.LAPIS_RAW_MATERIALS)
                .addTag(ModTags.Items.EMERALD_RAW_MATERIALS)
                .addTag(ModTags.Items.REDSTONE_RAW_MATERIALS);

        getOrCreateTagBuilder(ModTags.Items.JADE_RAW_MATERIALS).add(ModItems.RAW_JADE);
        getOrCreateTagBuilder(ModTags.Items.LEAD_RAW_MATERIALS).add(ModItems.RAW_LEAD);
        getOrCreateTagBuilder(ModTags.Items.PLATINUM_RAW_MATERIALS).add(ModItems.RAW_PLATINUM);
        getOrCreateTagBuilder(ModTags.Items.RUBY_RAW_MATERIALS).add(ModItems.RAW_RUBY);
        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_RAW_MATERIALS).add(ModItems.RAW_SAPPHIRE);
        getOrCreateTagBuilder(ModTags.Items.SILVER_RAW_MATERIALS).add(ModItems.RAW_SILVER);
        getOrCreateTagBuilder(ModTags.Items.TIN_RAW_MATERIALS).add(ModItems.RAW_TIN);
        getOrCreateTagBuilder(ModTags.Items.TOPAZ_RAW_MATERIALS).add(ModItems.RAW_TOPAZ);
        getOrCreateTagBuilder(ModTags.Items.DIAMOND_RAW_MATERIALS).add(ModItems.RAW_DIAMOND);
        getOrCreateTagBuilder(ModTags.Items.LAPIS_RAW_MATERIALS).add(ModItems.RAW_LAPIS);
        getOrCreateTagBuilder(ModTags.Items.EMERALD_RAW_MATERIALS).add(ModItems.RAW_EMERALD);
        getOrCreateTagBuilder(ModTags.Items.REDSTONE_RAW_MATERIALS).add(ModItems.RAW_REDSTONE);

        // Common tags - GEMS
        getOrCreateTagBuilder(ConventionalItemTags.GEMS)
                .addTag(ModTags.Items.JADE_GEMS)
                .addTag(ModTags.Items.RUBY_GEMS)
                .addTag(ModTags.Items.SAPPHIRE_GEMS)
                .addTag(ModTags.Items.TOPAZ_GEMS);

        getOrCreateTagBuilder(ModTags.Items.JADE_GEMS).add(ModItems.JADE);
        getOrCreateTagBuilder(ModTags.Items.RUBY_GEMS).add(ModItems.RUBY);
        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_GEMS).add(ModItems.SAPPHIRE);
        getOrCreateTagBuilder(ModTags.Items.TOPAZ_GEMS).add(ModItems.TOPAZ);


        // Common Tags - ORES
        getOrCreateTagBuilder(ConventionalItemTags.ORES)
                .addTag(ModTags.Items.EXPERIENCE_ORES)
                .addTag(ModTags.Items.JADE_ORES)
                .addTag(ModTags.Items.LEAD_ORES)
                .addTag(ModTags.Items.PLATINUM_ORES)
                .addTag(ModTags.Items.RUBY_ORES)
                .addTag(ModTags.Items.SAPPHIRE_ORES)
                .addTag(ModTags.Items.SILVER_ORES)
                .addTag(ModTags.Items.TIN_ORES)
                .addTag(ModTags.Items.TOPAZ_ORES);

        getOrCreateTagBuilder(ModTags.Items.EXPERIENCE_ORES)
                .add(ModBlocks.EXPERIENCE_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.JADE_ORES)
                .add(ModBlocks.JADE_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_JADE_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.LEAD_ORES)
                .add(ModBlocks.LEAD_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_LEAD_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.PLATINUM_ORES)
                .add(ModBlocks.PLATINUM_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.RUBY_ORES)
                .add(ModBlocks.RUBY_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_ORES)
                .add(ModBlocks.SAPPHIRE_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.SILVER_ORES)
                .add(ModBlocks.SILVER_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.TIN_ORES)
                .add(ModBlocks.TIN_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.asItem());

        getOrCreateTagBuilder(ModTags.Items.TOPAZ_ORES)
                .add(ModBlocks.TOPAZ_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE.asItem());

        // Common Tags - STORAGE BLOCKS
        getOrCreateTagBuilder(ConventionalItemTags.STORAGE_BLOCKS)
                .addTag(ModTags.Items.BRONZE_BLOCKS)
                .addTag(ModTags.Items.JADE_BLOCKS)
                .addTag(ModTags.Items.LEAD_BLOCKS)
                .addTag(ModTags.Items.PLATINUM_BLOCKS)
                .addTag(ModTags.Items.RUBY_BLOCKS)
                .addTag(ModTags.Items.SAPPHIRE_BLOCKS)
                .addTag(ModTags.Items.SILVER_BLOCKS)
                .addTag(ModTags.Items.TIN_BLOCKS)
                .addTag(ModTags.Items.TOPAZ_BLOCKS);

        getOrCreateTagBuilder(ModTags.Items.BRONZE_BLOCKS).add(ModBlocks.BRONZE_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.JADE_BLOCKS).add(ModBlocks.JADE_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.LEAD_BLOCKS).add(ModBlocks.LEAD_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.PLATINUM_BLOCKS).add(ModBlocks.PLATINUM_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.RUBY_BLOCKS).add(ModBlocks.RUBY_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_BLOCKS).add(ModBlocks.SAPPHIRE_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.SILVER_BLOCKS).add(ModBlocks.SILVER_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.TIN_BLOCKS).add(ModBlocks.TIN_BLOCK.asItem());
        getOrCreateTagBuilder(ModTags.Items.TOPAZ_BLOCKS).add(ModBlocks.TOPAZ_BLOCK.asItem());
    }
}
