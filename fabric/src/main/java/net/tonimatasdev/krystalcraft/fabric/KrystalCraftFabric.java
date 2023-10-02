package net.tonimatasdev.krystalcraft.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.plorix.PlorixFabric;

public class KrystalCraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PlorixFabric.init();
        KrystalCraft.init();

        addOre("experience_ore");
        addOre("jade_ore");
        addOre("lead_ore");
        addOre("platinum_ore");
        addOre("ruby_ore");
        addOre("sapphire_ore");
        addOre("silver_ore");
        addOre("tin_ore");
        addOre("topaz_ore");
    }

    private void addOre(String name) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(KrystalCraft.MOD_ID, name)));
    }
}