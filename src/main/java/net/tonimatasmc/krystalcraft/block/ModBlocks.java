package net.tonimatasmc.krystalcraft.block;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.item.KrystalCraftTab;
import net.tonimatasmc.krystalcraft.item.ModItems;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);

    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0F, 6.0F).strength(2).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).strength(2).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> JADE_BLOCK = register("jade_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4, 10).strength(3).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> JADE_ORE = register("jade_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4, 10).strength(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> TOPAZ_BLOCK = register("topaz_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3, 9).strength(3).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> TOPAZ_ORE = register("topaz_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3, 9).strength(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> LEAD_BLOCK = register("lead_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0F, 6.0F).strength(3).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LEAD_ORE = register("lead_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).strength(2).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0F, 6.0F).strength(1).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> TIN_ORE = register("tin_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).strength(1).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> PLATINUM_BLOCK = register("platinum_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0F, 6.0F).strength(3).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PLATINUM_ORE = register("platinum_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).strength(2).requiresCorrectToolForDrops().sound(SoundType.STONE)));



    public static void register(IEventBus iEventBus) {
            BLOCKS.register(iEventBus);
    }

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(KrystalCraftTab.KRYSTALCRAFT)));
        return ret;
    }

    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, KrystalCraft.MOD_ID);
    }
}
