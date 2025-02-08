package dev.tonimatas.krystalcraft.fabric;

import dev.tonimatas.krystalcraft.client.KrystalCraftClient;
import net.fabricmc.api.ClientModInitializer;

public class KrystalCraftClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KrystalCraftClient.init();
    }
}
