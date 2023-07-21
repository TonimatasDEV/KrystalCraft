package net.tonimatasdev.krystalcraft.fabric;

import net.fabricmc.api.ModInitializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class KrystalCraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KrystalCraft.init();
    }
}