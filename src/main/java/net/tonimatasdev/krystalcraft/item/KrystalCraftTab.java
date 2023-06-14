package net.tonimatasdev.krystalcraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.ModBlocks;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrystalCraftTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KrystalCraft.MOD_ID);
    public static final RegistryObject<CreativeModeTab> KRYSTALCRAFT_TAB = CREATIVE_MODE_TABS.register("krystalcraft", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.krystalcraft"))
            .icon(() -> new ItemStack(ModItems.JADE_PICKAXE.get()))
            .build());

    @SubscribeEvent
    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == KrystalCraftTab.KRYSTALCRAFT_TAB.get()) {
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                event.accept(item.get());
            }

            for (RegistryObject<Item> item : ModItems.TOOL_ITEMS.getEntries()) {
                event.accept(item.get());
            }

            for (RegistryObject<Item> item : ModItems.ARMOR_ITEMS.getEntries()) {
                event.accept(item.get());
            }

            for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                event.accept(block.get());
            }

            for (RegistryObject<Block> block : ModBlocks.BLOCK_ENTITIES.getEntries()) {
                event.accept(block.get());
            }
        }
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
