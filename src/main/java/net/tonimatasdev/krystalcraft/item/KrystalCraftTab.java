package net.tonimatasdev.krystalcraft.item;
/*
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.block.ModBlocks;

public class KrystalCraftTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.cr(Registries.CREATIVE_MODE_TAB, CreativeModeTabs::bootstrap);

    public static final ResourceKey<CreativeModeTab> ITEMS_TAB = createKey("krystalcraft_items_tab");
    public static final ResourceKey<CreativeModeTab> BLOCKS_TAB = createKey("krystalcraft_block_tab");
    public static final ResourceKey<CreativeModeTab> TOOLS_TAB = createKey("krystalcraft_tools_tab");
    public static final ResourceKey<CreativeModeTab> ARMORS_TAB = createKey("krystalcraft_armors_tab");

    public static CreativeModeTab bootstrap(Registry<CreativeModeTab> creativeModeTabRegistry) {
        Registry.register(creativeModeTabRegistry, ITEMS_TAB, CreativeModeTab.builder().title(Component.translatable("itemGroup.items_tab")).icon(() -> new ItemStack(ModItems.GEM_CUTTER_TOOL.get())).displayItems((parameters, output) -> {
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                output.accept(item.get());
            }
        }).build());

        Registry.register(creativeModeTabRegistry, BLOCKS_TAB, CreativeModeTab.builder().title(Component.translatable("itemGroup.blocks_tab")).icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK.get())).displayItems((parameters, output) -> {
            for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                output.accept(block.get());
            }

            for (RegistryObject<Block> block : ModBlocks.BLOCK_ENTITIES.getEntries()) {
                output.accept(block.get());
            }
        }).build());
        CreativeModeTab.

                Registry.register(creativeModeTabRegistry, TOOLS_TAB, CreativeModeTab.builder().title(Component.translatable("itemGroup.tools_tab")).icon(() -> new ItemStack(ModItems.JADE_PICKAXE.get())).displayItems((parameters, output) -> {
                    for (RegistryObject<Item> item : ModItems.TOOL_ITEMS.getEntries()) {
                        output.accept(item.get());
                    }
                }).build());

        Registry.register(creativeModeTabRegistry, ARMORS_TAB, CreativeModeTab.builder().title(Component.translatable("itemGroup.armors_tab")).icon(() -> new ItemStack(ModItems.JADE_PICKAXE.get())).displayItems((parameters, output) -> {
            for (RegistryObject<Item> item : ModItems.ARMOR_ITEMS.getEntries()) {
                output.accept(item.get());
            }
        }).build());
    }

    private static ResourceKey<CreativeModeTab> createKey(String resourceKeyName) {
        return ResourceKey.create(CREATIVE_MODE_TAB.getRegistryKey(), new ResourceLocation(resourceKeyName));
    }
}
*/