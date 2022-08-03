package net.tonimatasmc.krystalcraft;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tonimatasmc.krystalcraft.block.ModBlocks;
import net.tonimatasmc.krystalcraft.block.entity.ModBlockEntities;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModClientConfigs;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModCommonConfigs;
import net.tonimatasmc.krystalcraft.enchantment.ModEnchantments;
import net.tonimatasmc.krystalcraft.item.ModItems;
import net.tonimatasmc.krystalcraft.recipe.ModRecipes;
import net.tonimatasmc.krystalcraft.screen.CoalCombinerScreen;
import net.tonimatasmc.krystalcraft.screen.CoalCrusherScreen;
import net.tonimatasmc.krystalcraft.screen.GemCuttingStationScreen;
import net.tonimatasmc.krystalcraft.screen.ModMenuTypes;
import net.tonimatasmc.krystalcraft.world.biomemods.ModBiomeModifiers;
import net.tonimatasmc.krystalcraft.world.feature.ModPlacedFeatures;

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

        ModBiomeModifiers.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::clientSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, KrystalCraftModClientConfigs.SPEC, "krystalcraft-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KrystalCraftModCommonConfigs.SPEC, "krystalcraft-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
        MenuScreens.register(ModMenuTypes.COAL_CRUSHER_MENU.get(), CoalCrusherScreen::new);
        MenuScreens.register(ModMenuTypes.COAL_COMBINER_MENU.get(), CoalCombinerScreen::new);
    }
}
