package net.tonimatasdev.krystalcraft.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.custom.CoalCombinerBlock;
import net.tonimatasdev.krystalcraft.block.custom.CoalCrusherBlock;
import net.tonimatasdev.krystalcraft.block.custom.GemCuttingStationBlock;
import net.tonimatasdev.krystalcraft.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KrystalCraft.MOD_ID);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> JADE_ORE = registerBlock("jade_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(8f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> EXPERIENCE_ORE = registerBlock("experience_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(15, 30)));
    public static final RegistryObject<Block> DEEPSLATE_EXPERIENCE_ORE = registerBlock("deepslate_experience_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(20, 40)));
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    // Block Entities
    public static final RegistryObject<Block> GEM_CUTTING_STATION = registerBlock("gem_cutting_station", () -> new GemCuttingStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> COAL_CRUSHER = registerBlock("coal_crusher", () -> new CoalCrusherBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> COAL_COMBINER = registerBlock("coal_combiner", () -> new CoalCombinerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
}
