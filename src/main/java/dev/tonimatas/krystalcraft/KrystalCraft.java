package dev.tonimatas.krystalcraft;

import dev.tonimatas.krystalcraft.registry.*;

public class KrystalCraft {
	public static final String MOD_ID = "krystalcraft";

	public static void init() {
		ModBlocks.BLOCKS.init();
		ModItems.ITEMS.init();
		ModBlockEntities.BLOCK_ENTITIES.init();
		ModMenus.MENUS.init();
		ModRecipeSerializers.RECIPE_SERIALIZERS.init();
		ModRecipes.RECIPE_TYPES.init();
		ModEnchants.ENCHANTMENTS.init();
		ModTabs.TABS.init();
	}
}
