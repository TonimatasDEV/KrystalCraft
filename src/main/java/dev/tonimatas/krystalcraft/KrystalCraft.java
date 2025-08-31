package dev.tonimatas.krystalcraft;

import dev.tonimatas.krystalcraft.registry.*;
import dev.tonimatas.krystalcraft.util.ModLootTableModifiers;
import dev.tonimatas.krystalcraft.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KrystalCraft implements ModInitializer {
    public static final String MOD_ID = "krystalcraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();

        ModEnchantmentEffects.initialize();

        ModBlockEntities.initialize();
        ModScreenHandlers.initialize();

        ModRecipes.initialize();

        ModTabs.initialize();
        ModWorldGeneration.initialize();
        ModLootTableModifiers.initialize();

        LOGGER.info("KystalCraft started successfully.");
    }
}