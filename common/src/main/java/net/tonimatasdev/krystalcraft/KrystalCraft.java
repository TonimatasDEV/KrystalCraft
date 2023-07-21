package net.tonimatasdev.krystalcraft;

import net.minecraft.world.item.crafting.RecipeType;
import net.tonimatasdev.krystalcraft.registry.*;
import net.tonimatasdev.krystalcraft.screen.CoalCombinerScreen;
import net.tonimatasdev.krystalcraft.screen.CoalCrusherScreen;
import net.tonimatasdev.krystalcraft.screen.GemCuttingStationScreen;
import net.tonimatasdev.krystalcraft.screen.ModMenuTypes;

public class KrystalCraft {
	public static final String MOD_ID = "krystalcraft";

	public static void init() {
		ItemRegistry.init();
		BlockRegistry.init();
		BlockEntityRegistry.init();

		//ModMenuTypes.register(eventBus);
		RecipeSerializerRegistry.init();
		RecipeTypeRegistry.init();

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
