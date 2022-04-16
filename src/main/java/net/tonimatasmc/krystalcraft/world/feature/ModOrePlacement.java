package net.tonimatasmc.krystalcraft.world.feature;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int range, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(range), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int range, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(range), placementModifier);
    }
}