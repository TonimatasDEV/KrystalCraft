package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(7f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block JADE_BLOCK = registerBlock("jade_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block JADE_ORE = registerBlock("jade_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(7f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(7f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block LEAD_ORE = registerBlock("lead_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(7f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(6f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(7f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(8f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(7f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(6f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block EXPERIENCE_ORE = registerBlock("experience_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(15, 30), AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_EXPERIENCE_ORE = registerBlock("deepslate_experience_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(20, 40), AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));

    // Block Entities
    public static final Block CUTTING_STATION = registerBlock("cutting_station",
            new CuttingStationBlock(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque()));
    public static final Block CUTTING_FACTORY = registerBlock("cutting_factory",
            new CuttingFactoryBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block CRUSHING_STATION = registerBlock("crushing_station",
            new CrushingStationBlock(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque()));
    public static final Block CRUSHING_FACTORY = registerBlock("crushing_factory",
            new CrushingFactoryBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block COMBINING_STATION = registerBlock("combining_station",
            new CombiningStationBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block COMBINING_FACTORY = registerBlock("combining_factory",
            new CombiningFactoryBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block COMBUSTION_GENERATOR = registerBlock("combustion_generator",
            new CombustionGeneratorBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KrystalCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(KrystalCraft.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {
        // Initialize the class
    }
}
