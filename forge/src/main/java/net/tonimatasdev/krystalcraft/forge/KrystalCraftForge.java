package net.tonimatasdev.krystalcraft.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tonimatasdev.krystalcraft.KrystalCraft;

@Mod(KrystalCraft.MOD_ID)
public class KrystalCraftForge {
    public KrystalCraftForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(KrystalCraft.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        KrystalCraft.init();
    }
}