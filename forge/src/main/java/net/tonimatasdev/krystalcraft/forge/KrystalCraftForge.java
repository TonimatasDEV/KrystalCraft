package net.tonimatasdev.krystalcraft.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.tonimatasdev.krystalcraft.KrystalCraft;

@Mod(KrystalCraft.MOD_ID)
public class KrystalCraftForge {
    public KrystalCraftForge() {
        KrystalCraft.init();
        MinecraftForge.EVENT_BUS.register(this);
    }
}