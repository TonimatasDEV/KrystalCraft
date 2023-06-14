package net.tonimatasdev.krystalcraft;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tonimatasdev.krystalcraft.block.ModBlocks;
import net.tonimatasdev.krystalcraft.block.entity.ModBlockEntities;
import net.tonimatasdev.krystalcraft.enchantment.ModEnchantments;
import net.tonimatasdev.krystalcraft.item.KrystalCraftTab;
import net.tonimatasdev.krystalcraft.item.ModItems;
import net.tonimatasdev.krystalcraft.recipe.ModRecipes;
import net.tonimatasdev.krystalcraft.screen.CoalCombinerScreen;
import net.tonimatasdev.krystalcraft.screen.CoalCrusherScreen;
import net.tonimatasdev.krystalcraft.screen.GemCuttingStationScreen;
import net.tonimatasdev.krystalcraft.screen.ModMenuTypes;

@Mod(KrystalCraft.MOD_ID)
public class KrystalCraft {
    public static final String MOD_ID = "krystalcraft";

    public KrystalCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);
        ModEnchantments.register(eventBus);
        KrystalCraftTab.register(eventBus);

        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, KrystalCraftModClientConfigs.SPEC, "krystalcraft-client.toml");
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KrystalCraftModCommonConfigs.SPEC, "krystalcraft-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
            MenuScreens.register(ModMenuTypes.COAL_CRUSHER_MENU.get(), CoalCrusherScreen::new);
            MenuScreens.register(ModMenuTypes.COAL_COMBINER_MENU.get(), CoalCombinerScreen::new);
        }
    }
}
