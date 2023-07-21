package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;
import net.tonimatasdev.krystalcraft.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagLookup<Block>> blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, blockTagsProvider, KrystalCraft.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.Items.SILVER_DUST).add(ItemRegistry.SILVER_DUST.get());
        tag(ModTags.Items.BRONZE_DUST).add(ItemRegistry.BRONZE_DUST.get());
        tag(ModTags.Items.DIAMOND_DUST).add(ItemRegistry.DIAMOND_DUST.get());
        tag(ModTags.Items.EMERALD_DUST).add(ItemRegistry.EMERALD_DUST.get());
        tag(ModTags.Items.JADE_DUST).add(ItemRegistry.JADE_DUST.get());
        tag(ModTags.Items.LAPIS_DUST).add(ItemRegistry.LAPIS_DUST.get());
        tag(ModTags.Items.IRON_DUST).add(ItemRegistry.IRON_DUST.get());
        tag(ModTags.Items.LEAD_DUST).add(ItemRegistry.LEAD_DUST.get());
        tag(ModTags.Items.PLATINUM_DUST).add(ItemRegistry.PLATINUM_DUST.get());
        tag(ModTags.Items.RUBY_DUST).add(ItemRegistry.RUBY_DUST.get());
        tag(ModTags.Items.SAPPHIRE_DUST).add(ItemRegistry.SAPPHIRE_DUST.get());
        tag(ModTags.Items.TIN_DUST).add(ItemRegistry.TIN_DUST.get());
        tag(ModTags.Items.TOPAZ_DUST).add(ItemRegistry.TOPAZ_DUST.get());
        tag(ModTags.Items.COPPER_DUST).add(ItemRegistry.COPPER_DUST.get());
        tag(ModTags.Items.DUSTS).add(ItemRegistry.SILVER_DUST.get(), ItemRegistry.BRONZE_DUST.get(), ItemRegistry.DIAMOND_DUST.get(), ItemRegistry.EMERALD_DUST.get(), ItemRegistry.JADE_DUST.get(), ItemRegistry.LAPIS_DUST.get(), ItemRegistry.IRON_DUST.get(), ItemRegistry.LEAD_DUST.get(), ItemRegistry.PLATINUM_DUST.get(), ItemRegistry.RUBY_DUST.get(), ItemRegistry.SAPPHIRE_DUST.get(), ItemRegistry.TIN_DUST.get(), ItemRegistry.TOPAZ_DUST.get(), ItemRegistry.COPPER_DUST.get());
        tag(ModTags.Items.JADE_GEM).add(ItemRegistry.JADE.get());
        tag(ModTags.Items.RUBY_GEM).add(ItemRegistry.RUBY.get());
        tag(ModTags.Items.SAPPHIRE_GEM).add(ItemRegistry.SAPPHIRE.get());
        tag(ModTags.Items.TOPAZ_GEM).add(ItemRegistry.TOPAZ.get());
        tag(ModTags.Items.GEMS).add(ItemRegistry.JADE.get(), ItemRegistry.RUBY.get(), ItemRegistry.SAPPHIRE.get(), ItemRegistry.TOPAZ.get());
        tag(ModTags.Items.SILVER_INGOT).add(ItemRegistry.SILVER_INGOT.get());
        tag(ModTags.Items.PLATINUM_INGOT).add(ItemRegistry.PLATINUM_INGOT.get());
        tag(ModTags.Items.LEAD_INGOT).add(ItemRegistry.LEAD_INGOT.get());
        tag(ModTags.Items.TIN_INGOT).add(ItemRegistry.TIN_INGOT.get());
        tag(ModTags.Items.BRONZE_INGOT).add(ItemRegistry.BRONZE_INGOT.get());
        tag(ModTags.Items.INGOTS).add(ItemRegistry.SILVER_INGOT.get(), ItemRegistry.PLATINUM_INGOT.get(), ItemRegistry.LEAD_INGOT.get(), ItemRegistry.TIN_INGOT.get(), ItemRegistry.BRONZE_INGOT.get());
        tag(ModTags.Items.BRONZE_NUGGETS).add(ItemRegistry.BRONZE_NUGGET.get());
        tag(ModTags.Items.LEAD_NUGGETS).add(ItemRegistry.LEAD_NUGGET.get());
        tag(ModTags.Items.PLATINUM_NUGGETS).add(ItemRegistry.PLATINUM_NUGGET.get());
        tag(ModTags.Items.SILVER_NUGGETS).add(ItemRegistry.SILVER_INGOT.get());
        tag(ModTags.Items.TIN_NUGGETS).add(ItemRegistry.TIN_INGOT.get());
        tag(ModTags.Items.NUGGETS).add(ItemRegistry.BRONZE_NUGGET.get(), ItemRegistry.LEAD_NUGGET.get(), ItemRegistry.PLATINUM_NUGGET.get(), ItemRegistry.COPPER_NUGGET.get(), ItemRegistry.TIN_NUGGET.get());
        tag(ModTags.Items.JADE_RAW_MATERIAL).add(ItemRegistry.RAW_JADE.get());
        tag(ModTags.Items.LEAD_RAW_MATERIAL).add(ItemRegistry.RAW_LEAD.get());
        tag(ModTags.Items.PLATINUM_RAW_MATERIAL).add(ItemRegistry.RAW_PLATINUM.get());
        tag(ModTags.Items.RUBY_RAW_MATERIAL).add(ItemRegistry.RAW_RUBY.get());
        tag(ModTags.Items.SAPPHIRE_RAW_MATERIAL).add(ItemRegistry.RAW_SAPPHIRE.get());
        tag(ModTags.Items.SILVER_RAW_MATERIAL).add(ItemRegistry.RAW_SILVER.get());
        tag(ModTags.Items.TIN_RAW_MATERIAL).add(ItemRegistry.RAW_TIN.get());
        tag(ModTags.Items.TOPAZ_RAW_MATERIAL).add(ItemRegistry.RAW_TOPAZ.get());
        tag(ModTags.Items.DIAMOND_RAW_MATERIAL).add(ItemRegistry.RAW_DIAMOND.get());
        tag(ModTags.Items.EMERALD_RAW_MATERIAL).add(ItemRegistry.RAW_EMERALD.get());
        tag(ModTags.Items.LAPIS_RAW_MATERIAL).add(ItemRegistry.RAW_LAPIS.get());
        tag(ModTags.Items.REDSTONE_RAW_MATERIAL).add(ItemRegistry.RAW_REDSTONE.get());
        tag(ModTags.Items.RAW_MATERIALS).add(ItemRegistry.RAW_REDSTONE.get(), ItemRegistry.RAW_LAPIS.get(), ItemRegistry.RAW_EMERALD.get(), ItemRegistry.RAW_DIAMOND.get(), ItemRegistry.RAW_TOPAZ.get(), ItemRegistry.RAW_TIN.get(), ItemRegistry.RAW_SILVER.get(), ItemRegistry.RAW_SAPPHIRE.get(), ItemRegistry.RAW_RUBY.get(), ItemRegistry.RAW_PLATINUM.get(), ItemRegistry.RAW_LEAD.get(), ItemRegistry.RAW_JADE.get());
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
