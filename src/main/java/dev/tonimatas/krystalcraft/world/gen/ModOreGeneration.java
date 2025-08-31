package dev.tonimatas.krystalcraft.world.gen;

import dev.tonimatas.krystalcraft.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Predicate;

public class ModOreGeneration {
    public static void initialize() {
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.EXPERIENCE_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.JADE_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.LEAD_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.PLATINUM_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.RUBY_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.SAPPHIRE_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.SILVER_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.TIN_ORE_PLACED_KEY);
        register(BiomeSelectors.foundInOverworld(), ModPlacedFeatures.TOPAZ_ORE_PLACED_KEY);
    }

    private static void register(Predicate<BiomeSelectionContext> selector, RegistryKey<PlacedFeature> placedFeature) {
        BiomeModifications.addFeature(selector, GenerationStep.Feature.UNDERGROUND_ORES, placedFeature);
    }
}
