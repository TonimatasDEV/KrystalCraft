package net.tonimatasmc.krystalcraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.block.ModBlocks;
import net.tonimatasmc.krystalcraft.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, KrystalCraft.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags() {
        tag(ModTags.Blocks.EXPERIENCE_ORE).add(ModBlocks.EXPERIENCE_ORE.get(), ModBlocks.DEEPSLATE_EXPERIENCE_ORE.get());
        tag(ModTags.Blocks.JADE_ORE).add(ModBlocks.JADE_ORE.get(), ModBlocks.DEEPSLATE_JADE_ORE.get());
        tag(ModTags.Blocks.LEAD_ORE).add(ModBlocks.LEAD_ORE.get(), ModBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(ModTags.Blocks.PLATINUM_ORE).add(ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        tag(ModTags.Blocks.RUBY_ORE).add(ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get());
        tag(ModTags.Blocks.SAPPHIRE_ORE).add(ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(ModTags.Blocks.SILVER_ORE).add(ModBlocks.SILVER_ORE.get(), ModBlocks.DEEPSLATE_SILVER_ORE.get());
        tag(ModTags.Blocks.TIN_ORE).add(ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get());
        tag(ModTags.Blocks.TOPAZ_ORE).add(ModBlocks.TOPAZ_ORE.get(), ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        tag(ModTags.Blocks.ORES).add(ModBlocks.EXPERIENCE_ORE.get(), ModBlocks.DEEPSLATE_EXPERIENCE_ORE.get(), ModBlocks.JADE_ORE.get(), ModBlocks.DEEPSLATE_JADE_ORE.get(), ModBlocks.LEAD_ORE.get(), ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.SILVER_ORE.get(), ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get(), ModBlocks.TOPAZ_ORE.get(), ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        tag(ModTags.Blocks.BRONZE_BLOCK).add(ModBlocks.BRONZE_BLOCK.get());
        tag(ModTags.Blocks.JADE_BLOCK).add(ModBlocks.JADE_BLOCK.get());
        tag(ModTags.Blocks.LEAD_BLOCK).add(ModBlocks.LEAD_BLOCK.get());
        tag(ModTags.Blocks.PLATINUM_BLOCK).add(ModBlocks.PLATINUM_BLOCK.get());
        tag(ModTags.Blocks.RUBY_BLOCK).add(ModBlocks.RUBY_BLOCK.get());
        tag(ModTags.Blocks.SAPPHIRE_BLOCK).add(ModBlocks.SAPPHIRE_BLOCK.get());
        tag(ModTags.Blocks.SILVER_BLOCK).add(ModBlocks.SILVER_BLOCK.get());
        tag(ModTags.Blocks.TIN_BLOCK).add(ModBlocks.TIN_BLOCK.get());
        tag(ModTags.Blocks.TOPAZ_BLOCK).add(ModBlocks.TOPAZ_BLOCK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS).add(ModBlocks.BRONZE_BLOCK.get(), ModBlocks.JADE_BLOCK.get(), ModBlocks.LEAD_BLOCK.get(), ModBlocks.PLATINUM_BLOCK.get(), ModBlocks.RUBY_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SILVER_BLOCK.get(), ModBlocks.TIN_BLOCK.get(), ModBlocks.TOPAZ_BLOCK.get());
    }
}
