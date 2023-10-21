package net.tonimatasdev.krystalcraft.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.client.KrystalCraftClient;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrystalCraftClientForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        KrystalCraftClient.init();
    }
}
