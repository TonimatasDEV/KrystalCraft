package net.tonimatasdev.krystalcraft;

import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.registry.*;

public class KrystalCraft {
	public static final String MOD_ID = "krystalcraft";

	public static void init() {
		ModBlocks.BLOCKS.register();
		ModItems.ITEMS.register();
		ModBlockEntities.BLOCK_ENTITIES.register();
		ModMenus.MENUS.register();
		ModRecipeSerializers.RECIPE_SERIALIZERS.register();
		ModRecipes.RECIPE_TYPES.register();
		ModEnchants.ENCHANTMENTS.register();
		ModTabs.TABS.register();
		NetworkHandler.init();
	}
}
