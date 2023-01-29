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
    public static CreativeModeTab KRYSTALCRAFT_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        KRYSTALCRAFT_TAB = event.registerCreativeModeTab(new ResourceLocation(KrystalCraft.MOD_ID, "krystalcraft_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.JADE_PICKAXE.get())).title(Component.translatable("itemGroup.krystalcraft")).build());
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == KrystalCraftTab.KRYSTALCRAFT_TAB) {
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                event.accept(item.get());
            }

            for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                event.accept(block.get());
            }
        }
    }
}
