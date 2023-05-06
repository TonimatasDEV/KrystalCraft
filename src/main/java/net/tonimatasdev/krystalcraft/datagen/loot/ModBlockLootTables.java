package net.tonimatasdev.krystalcraft.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.block.ModBlocks;
import net.tonimatasdev.krystalcraft.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.COAL_COMBINER.get());
        this.dropSelf(ModBlocks.COAL_CRUSHER.get());
        this.dropSelf(ModBlocks.GEM_CUTTING_STATION.get());
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.LEAD_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        this.dropWhenSilkTouch(ModBlocks.EXPERIENCE_ORE.get());
        this.dropWhenSilkTouch(ModBlocks.DEEPSLATE_EXPERIENCE_ORE.get());

        this.add(ModBlocks.DEEPSLATE_JADE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_JADE_ORE.get(), ModItems.RAW_JADE.get()));
        this.add(ModBlocks.DEEPSLATE_LEAD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        this.add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));
        this.add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), ModItems.RAW_TOPAZ.get()));

        this.add(ModBlocks.JADE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.JADE_ORE.get(), ModItems.RAW_JADE.get()));
        this.add(ModBlocks.LEAD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        this.add(ModBlocks.PLATINUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get()));
        this.add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.SILVER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.TIN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
        this.add(ModBlocks.TOPAZ_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TOPAZ_ORE.get(), ModItems.RAW_TOPAZ.get()));

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        Collection<RegistryObject<Block>> entries = new ArrayList<>();
        entries.addAll(ModBlocks.BLOCKS.getEntries());
        entries.addAll(ModBlocks.BLOCK_ENTITIES.getEntries());
        return entries.stream().map(RegistryObject::get)::iterator;
    }
}
