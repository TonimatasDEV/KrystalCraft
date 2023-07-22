package net.tonimatasdev.krystalcraft;

import net.tonimatasdev.krystalcraft.registry.*;

public class KrystalCraft {
	public static final String MOD_ID = "krystalcraft";

	public static void init() {
		ItemRegistry.init();
		BlockRegistry.init();
		BlockEntityRegistry.init();
		ScreenHandlerRegistry.init();
		RecipeSerializerRegistry.init();
		RecipeTypeRegistry.init();
		EnchantmentRegistry.init();
		TabRegistry.init();
	}
}
