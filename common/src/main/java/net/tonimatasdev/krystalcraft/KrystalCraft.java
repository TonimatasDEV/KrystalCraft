package net.tonimatasdev.krystalcraft;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.registry.EnchantmentRegistry;
import net.tonimatasdev.krystalcraft.recipe.ModRecipes;
import net.tonimatasdev.krystalcraft.registry.BlockRegistry;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;
import net.tonimatasdev.krystalcraft.registry.TabRegistry;
import net.tonimatasdev.krystalcraft.screen.CoalCombinerScreen;
import net.tonimatasdev.krystalcraft.screen.CoalCrusherScreen;
import net.tonimatasdev.krystalcraft.screen.GemCuttingStationScreen;
import net.tonimatasdev.krystalcraft.screen.ModMenuTypes;

public class KrystalCraft {
	public static final String MOD_ID = "krystalcraft";

	public static void init() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemRegistry.init();
		BlockRegistry.init();

		//ModBlockEntities.register(eventBus);
		//ModMenuTypes.register(eventBus);
		//ModRecipes.register(eventBus);

		EnchantmentRegistry.init();
		TabRegistry.init();

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
