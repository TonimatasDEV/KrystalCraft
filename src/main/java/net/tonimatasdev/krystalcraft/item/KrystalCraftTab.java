package net.tonimatasdev.krystalcraft.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.ModBlocks;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrystalCraftTab {
    public static CreativeModeTab ITEMS_TAB;
    public static CreativeModeTab BLOCKS_TAB;
    public static CreativeModeTab TOOLS_TAB;
    public static CreativeModeTab ARMORS_TAB;


    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ITEMS_TAB = event.registerCreativeModeTab(new ResourceLocation(KrystalCraft.MOD_ID, "krystalcraft_items_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.GEM_CUTTER_TOOL.get())).title(Component.translatable("itemGroup.items_tab")).build());
        BLOCKS_TAB = event.registerCreativeModeTab(new ResourceLocation(KrystalCraft.MOD_ID, "krystalcraft_block_tab"), builder -> builder.icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK.get())).title(Component.translatable("itemGroup.blocks_tab")).build());
        TOOLS_TAB = event.registerCreativeModeTab(new ResourceLocation(KrystalCraft.MOD_ID, "krystalcraft_tools_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.JADE_PICKAXE.get())).title(Component.translatable("itemGroup.tools_tab")).build());
        ARMORS_TAB = event.registerCreativeModeTab(new ResourceLocation(KrystalCraft.MOD_ID, "krystalcraft_armors_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.LEAD_CHESTPLATE.get())).title(Component.translatable("itemGroup.armors_tab")).build());
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == KrystalCraftTab.ITEMS_TAB) {
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }

        if (event.getTab() == KrystalCraftTab.BLOCKS_TAB) {
            for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                event.accept(block.get());
            }

            for (RegistryObject<Block> block : ModBlocks.BLOCK_ENTITIES.getEntries()) {
                event.accept(block.get());
            }
        }

        if (event.getTab() == KrystalCraftTab.TOOLS_TAB) {
            for (RegistryObject<Item> item : ModItems.TOOL_ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }

        if (event.getTab() == KrystalCraftTab.ARMORS_TAB) {
            for (RegistryObject<Item> item : ModItems.ARMOR_ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
