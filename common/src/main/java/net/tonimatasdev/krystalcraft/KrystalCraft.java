package net.tonimatasdev.krystalcraft;

import net.tonimatasdev.krystalcraft.registry.*;

public class KrystalCraft {
	public static final String MOD_ID = "krystalcraft";

	public static void init() {
		BlockRegistry.init();
		ItemRegistry.init();
		BlockEntityRegistry.init();
		ScreenHandlerRegistry.init();
		RecipeSerializerRegistry.init();
		RecipeTypeRegistry.init();
		EnchantmentRegistry.init();
		TabRegistry.init();
	}
}
