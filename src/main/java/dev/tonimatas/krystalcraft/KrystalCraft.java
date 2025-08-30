package dev.tonimatas.krystalcraft;

import dev.tonimatas.krystalcraft.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
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

        addOre("experience_ore");
        addOre("jade_ore");
        addOre("lead_ore");
        addOre("platinum_ore");
        addOre("ruby_ore");
        addOre("sapphire_ore");
        addOre("silver_ore");
        addOre("tin_ore");
        addOre("topaz_ore");

        LOGGER.info("KystalCraft started successfully.");
    }

    private void addOre(String name) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, name)));
    }
}