package dev.tonimatas.krystalcraft.neoforge;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.client.KrystalCraftClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = KrystalCraft.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class KrystalCraftClientForge {
    @SubscribeEvent
    public static void onClientSetup(RegisterMenuScreensEvent event) {
        KrystalCraftClient.init();
    }
}
