package net.tonimatasdev.krystalcraft.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.tonimatasdev.krystalcraft.KrystalCraftClient;

public class KrystalCraftClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KrystalCraftClient.init();
    }
}
