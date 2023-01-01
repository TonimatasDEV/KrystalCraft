package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.item.ModItems;
import net.tonimatasdev.krystalcraft.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), providerCompletableFuture, blockTagsProvider, KrystalCraft.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.Items.SILVER_DUST).add(ModItems.SILVER_DUST.get());
        tag(ModTags.Items.BRONZE_DUST).add(ModItems.BRONZE_DUST.get());
        tag(ModTags.Items.DIAMOND_DUST).add(ModItems.DIAMOND_DUST.get());
        tag(ModTags.Items.EMERALD_DUST).add(ModItems.EMERALD_DUST.get());
        tag(ModTags.Items.JADE_DUST).add(ModItems.JADE_DUST.get());
        tag(ModTags.Items.LAPIS_DUST).add(ModItems.LAPIS_DUST.get());
        tag(ModTags.Items.LEAD_DUST).add(ModItems.LEAD_DUST.get());
        tag(ModTags.Items.PLATINUM_DUST).add(ModItems.PLATINUM_DUST.get());
        tag(ModTags.Items.RUBY_DUST).add(ModItems.RUBY_DUST.get());
        tag(ModTags.Items.SAPPHIRE_DUST).add(ModItems.SAPPHIRE_DUST.get());
        tag(ModTags.Items.TIN_DUST).add(ModItems.TIN_DUST.get());
        tag(ModTags.Items.TOPAZ_DUST).add(ModItems.TOPAZ_DUST.get());
        tag(ModTags.Items.COPPER_DUST).add(ModItems.COPPER_DUST.get());
        tag(ModTags.Items.DUSTS).add(ModItems.SILVER_DUST.get(), ModItems.BRONZE_DUST.get(), ModItems.DIAMOND_DUST.get(), ModItems.EMERALD_DUST.get(), ModItems.JADE_DUST.get(), ModItems.LAPIS_DUST.get(), ModItems.LEAD_DUST.get(), ModItems.PLATINUM_DUST.get(), ModItems.RUBY_DUST.get(), ModItems.SAPPHIRE_DUST.get(), ModItems.TIN_DUST.get(), ModItems.TOPAZ_DUST.get(), ModItems.COPPER_DUST.get());
        tag(ModTags.Items.JADE_GEM).add(ModItems.JADE.get());
        tag(ModTags.Items.RUBY_GEM).add(ModItems.RUBY.get());
        tag(ModTags.Items.SAPPHIRE_GEM).add(ModItems.SAPPHIRE.get());
        tag(ModTags.Items.TOPAZ_GEM).add(ModItems.TOPAZ.get());
        tag(ModTags.Items.GEMS).add(ModItems.JADE.get(), ModItems.RUBY.get(), ModItems.SAPPHIRE.get(), ModItems.TOPAZ.get());
        tag(ModTags.Items.SILVER_INGOT).add(ModItems.SILVER_INGOT.get());
        tag(ModTags.Items.PLATINUM_INGOT).add(ModItems.PLATINUM_INGOT.get());
        tag(ModTags.Items.LEAD_INGOT).add(ModItems.LEAD_INGOT.get());
        tag(ModTags.Items.TIN_INGOT).add(ModItems.TIN_INGOT.get());
        tag(ModTags.Items.BRONZE_INGOT).add(ModItems.BRONZE_INGOT.get());
        tag(ModTags.Items.INGOTS).add(ModItems.SILVER_INGOT.get(), ModItems.PLATINUM_INGOT.get(), ModItems.LEAD_INGOT.get(), ModItems.TIN_INGOT.get(), ModItems.BRONZE_INGOT.get());
        tag(ModTags.Items.BRONZE_NUGGETS).add(ModItems.BRONZE_NUGGET.get());
        tag(ModTags.Items.LEAD_NUGGETS).add(ModItems.LEAD_NUGGET.get());
        tag(ModTags.Items.PLATINUM_NUGGETS).add(ModItems.PLATINUM_NUGGET.get());
        tag(ModTags.Items.SILVER_NUGGETS).add(ModItems.SILVER_INGOT.get());
        tag(ModTags.Items.TIN_NUGGETS).add(ModItems.TIN_INGOT.get());
        tag(ModTags.Items.NUGGETS).add(ModItems.BRONZE_NUGGET.get(), ModItems.LEAD_NUGGET.get(), ModItems.PLATINUM_NUGGET.get(), ModItems.COPPER_NUGGET.get(), ModItems.TIN_NUGGET.get());
        tag(ModTags.Items.JADE_RAW_MATERIAL).add(ModItems.RAW_JADE.get());
        tag(ModTags.Items.LEAD_RAW_MATERIAL).add(ModItems.RAW_LEAD.get());
        tag(ModTags.Items.PLATINUM_RAW_MATERIAL).add(ModItems.RAW_PLATINUM.get());
        tag(ModTags.Items.RUBY_RAW_MATERIAL).add(ModItems.RAW_RUBY.get());
        tag(ModTags.Items.SAPPHIRE_RAW_MATERIAL).add(ModItems.RAW_SAPPHIRE.get());
        tag(ModTags.Items.SILVER_RAW_MATERIAL).add(ModItems.RAW_SILVER.get());
        tag(ModTags.Items.TIN_RAW_MATERIAL).add(ModItems.RAW_TIN.get());
        tag(ModTags.Items.TOPAZ_RAW_MATERIAL).add(ModItems.RAW_TOPAZ.get());
        tag(ModTags.Items.DIAMOND_RAW_MATERIAL).add(ModItems.RAW_DIAMOND.get());
        tag(ModTags.Items.EMERALD_RAW_MATERIAL).add(ModItems.RAW_EMERALD.get());
        tag(ModTags.Items.LAPIS_RAW_MATERIAL).add(ModItems.RAW_LAPIS.get());
        tag(ModTags.Items.REDSTONE_RAW_MATERIAL).add(ModItems.RAW_REDSTONE.get());
        tag(ModTags.Items.RAW_MATERIALS).add(ModItems.RAW_REDSTONE.get(), ModItems.RAW_LAPIS.get(), ModItems.RAW_EMERALD.get(), ModItems.RAW_DIAMOND.get(), ModItems.RAW_TOPAZ.get(), ModItems.RAW_TIN.get(), ModItems.RAW_SILVER.get(), ModItems.RAW_SAPPHIRE.get(), ModItems.RAW_RUBY.get(), ModItems.RAW_PLATINUM.get(), ModItems.RAW_LEAD.get(), ModItems.RAW_JADE.get());
        copy(ModTags.Blocks.EXPERIENCE_ORE, ModTags.Items.EXPERIENCE_ORE);
        copy(ModTags.Blocks.JADE_ORE, ModTags.Items.JADE_ORE);
        copy(ModTags.Blocks.LEAD_ORE, ModTags.Items.LEAD_ORE);
        copy(ModTags.Blocks.PLATINUM_ORE, ModTags.Items.PLATINUM_ORE);
        copy(ModTags.Blocks.RUBY_ORE, ModTags.Items.RUBY_ORE);
        copy(ModTags.Blocks.SAPPHIRE_ORE, ModTags.Items.SAPPHIRE_ORE);
        copy(ModTags.Blocks.SILVER_ORE, ModTags.Items.SILVER_ORE);
        copy(ModTags.Blocks.TIN_ORE, ModTags.Items.TIN_ORE);
        copy(ModTags.Blocks.TOPAZ_ORE, ModTags.Items.TOPAZ_ORE);
        copy(ModTags.Blocks.ORES, ModTags.Items.ORES);
        copy(ModTags.Blocks.BRONZE_BLOCK, ModTags.Items.BRONZE_BLOCK);
        copy(ModTags.Blocks.JADE_BLOCK, ModTags.Items.JADE_BLOCK);
        copy(ModTags.Blocks.LEAD_BLOCK, ModTags.Items.LEAD_BLOCK);
        copy(ModTags.Blocks.PLATINUM_BLOCK, ModTags.Items.PLATINUM_BLOCK);
        copy(ModTags.Blocks.RUBY_BLOCK, ModTags.Items.RUBY_BLOCK);
        copy(ModTags.Blocks.SAPPHIRE_BLOCK, ModTags.Items.SAPPHIRE_BLOCK);
        copy(ModTags.Blocks.SILVER_BLOCK, ModTags.Items.SILVER_BLOCK);
        copy(ModTags.Blocks.TIN_BLOCK, ModTags.Items.TIN_BLOCK);
        copy(ModTags.Blocks.TOPAZ_BLOCK, ModTags.Items.TOPAZ_BLOCK);
        copy(ModTags.Blocks.STORAGE_BLOCKS, ModTags.Items.STORAGE_BLOCKS);
    }
}
