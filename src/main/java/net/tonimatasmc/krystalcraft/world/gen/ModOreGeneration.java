package net.tonimatasmc.krystalcraft.world.gen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.tonimatasmc.krystalcraft.world.feature.ModPlacedFeatures;

import java.util.List;

@SuppressWarnings("StatementWithEmptyBody")
public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.JADE_ORE_PLACED);
        base.add(ModPlacedFeatures.SILVER_ORE_PLACED);
        base.add(ModPlacedFeatures.TOPAZ_ORE_PLACED);
        base.add(ModPlacedFeatures.LEAD_ORE_PLACED);

        if(event.getCategory() == Biome.BiomeCategory.THEEND) {
        }

        if(event.getCategory() == Biome.BiomeCategory.NETHER) {
        }
    }
}