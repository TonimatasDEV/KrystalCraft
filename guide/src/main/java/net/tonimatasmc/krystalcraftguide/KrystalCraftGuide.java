package net.tonimatasmc.krystalcraftguide;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KrystalCraftGuide.MOD_ID)
public class KrystalCraftGuide {
    public static final String MOD_ID = "krystalcraftguide";

    public KrystalCraftGuide() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
