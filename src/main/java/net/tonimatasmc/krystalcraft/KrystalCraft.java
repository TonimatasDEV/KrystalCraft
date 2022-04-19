package net.tonimatasmc.krystalcraft;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tonimatasmc.krystalcraft.block.ModBlocks;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModCommonConfigs;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModClientConfigs;
import net.tonimatasmc.krystalcraft.item.ModItems;

@Mod(KrystalCraft.MOD_ID)
public class KrystalCraft {
    public static final String MOD_ID = "krystalcraft";

    public KrystalCraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, KrystalCraftModClientConfigs.SPEC, "krystalcraft-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KrystalCraftModCommonConfigs.SPEC, "krystalcraft-common.toml");
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Client {
        private Client() {
        }

        private void doClientStuff(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
            });
        }
    }
}
