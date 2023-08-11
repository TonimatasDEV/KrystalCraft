package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.EnergyPipeBlock;
import net.tonimatasdev.krystalcraft.block.MachineBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, KrystalCraft.MOD_ID);

    public static final RegistryEntry<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> SILVER_ORE = registerBlock("silver_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> JADE_BLOCK = registerBlock("jade_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> JADE_ORE = registerBlock("jade_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> TOPAZ_BLOCK = registerBlock("topaz_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> TOPAZ_ORE = registerBlock("topaz_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> LEAD_BLOCK = registerBlock("lead_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> LEAD_ORE = registerBlock("lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> TIN_BLOCK = registerBlock("tin_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> TIN_ORE = registerBlock("tin_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> PLATINUM_BLOCK = registerBlock("platinum_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(7f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> PLATINUM_ORE = registerBlock("platinum_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(8f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(7f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryEntry<Block> RUBY_ORE = registerBlock("ruby_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryEntry<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryEntry<Block> EXPERIENCE_ORE = registerBlock("experience_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(15, 30)));
    public static final RegistryEntry<Block> DEEPSLATE_EXPERIENCE_ORE = registerBlock("deepslate_experience_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(20, 40)));
    public static final RegistryEntry<Block> BRONZE_BLOCK = registerBlock("bronze_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    // Custom Blocks
    public static final RegistryEntry<Block> CUTTING_STATION = registerBlock("cutting_station", MachineBlock::new);
    public static final RegistryEntry<Block> CUTTING_FACTORY = registerBlock("cutting_factory", MachineBlock::new);
    public static final RegistryEntry<Block> CRUSHING_STATION = registerBlock("crushing_station", MachineBlock::new);
    public static final RegistryEntry<Block> CRUSHING_FACTORY = registerBlock("crushing_factory", MachineBlock::new);
    public static final RegistryEntry<Block> COMBINING_STATION = registerBlock("combining_station", MachineBlock::new);
    public static final RegistryEntry<Block> COMBINING_FACTORY = registerBlock("combining_factory", MachineBlock::new);
    public static final RegistryEntry<Block> COMBUSTION_GENERATOR = registerBlock("combustion_generator", MachineBlock::new);
    public static final RegistryEntry<Block> ENERGY_PIPE = registerBlock("energy_pipe", EnergyPipeBlock::new);

    private static <T extends Block> RegistryEntry<T> registerBlock(String name, Supplier<T> block) {
        RegistryEntry<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }
}
