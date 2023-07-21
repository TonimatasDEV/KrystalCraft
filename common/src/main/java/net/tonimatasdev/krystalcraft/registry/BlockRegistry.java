package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.custom.CoalCombinerBlock;
import net.tonimatasdev.krystalcraft.block.custom.CoalCrusherBlock;
import net.tonimatasdev.krystalcraft.block.custom.GemCuttingStationBlock;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> SILVER_ORE = registerBlock("silver_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> JADE_BLOCK = registerBlock("jade_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> JADE_ORE = registerBlock("jade_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> TOPAZ_BLOCK = registerBlock("topaz_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> TOPAZ_ORE = registerBlock("topaz_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> LEAD_BLOCK = registerBlock("lead_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> LEAD_ORE = registerBlock("lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> TIN_BLOCK = registerBlock("tin_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> TIN_ORE = registerBlock("tin_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> PLATINUM_BLOCK = registerBlock("platinum_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(7f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> PLATINUM_ORE = registerBlock("platinum_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(8f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> RUBY_ORE = registerBlock("ruby_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistrySupplier<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> EXPERIENCE_ORE = registerBlock("experience_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(15, 30)));
    public static final RegistrySupplier<Block> DEEPSLATE_EXPERIENCE_ORE = registerBlock("deepslate_experience_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(20, 40)));
    public static final RegistrySupplier<Block> BRONZE_BLOCK = registerBlock("bronze_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    // Custom Blocks
    public static final RegistrySupplier<Block> GEM_CUTTING_STATION = registerBlock("gem_cutting_station", GemCuttingStationBlock::new);
    public static final RegistrySupplier<Block> COAL_CRUSHER = registerBlock("coal_crusher", () -> new CoalCrusherBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> COAL_COMBINER = registerBlock("coal_combiner", () -> new CoalCombinerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void init() {
        BLOCKS.register();
    }
}