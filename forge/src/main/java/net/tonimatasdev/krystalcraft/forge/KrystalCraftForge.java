package net.tonimatasdev.krystalcraft.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.plorix.PlorixForge;

@Mod(KrystalCraft.MOD_ID)
public class KrystalCraftForge {
    public KrystalCraftForge() {
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        PlorixForge.init(eventBus);
        KrystalCraft.init();
        MinecraftForge.EVENT_BUS.register(this);
    }
}