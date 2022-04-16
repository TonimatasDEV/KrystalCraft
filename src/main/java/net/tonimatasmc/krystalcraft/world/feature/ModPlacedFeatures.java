package net.tonimatasmc.krystalcraft.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModCommonConfigs;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> JADE_ORE_PLACED = PlacementUtils.register("jade_ore_placed",
            ModConfiguredFeatures.JADE_ORE, ModOrePlacement.commonOrePlacement(
                    KrystalCraftModCommonConfigs.JADE_ORE_VEINS_PER_CHUNK.get(),
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(16))));

    public static final Holder<PlacedFeature> SILVER_ORE_PLACED = PlacementUtils.register("silver_ore_placed",
            ModConfiguredFeatures.SILVER_ORE, ModOrePlacement.commonOrePlacement(
                    KrystalCraftModCommonConfigs.SILVER_ORE_VEINS_PER_CHUNK.get(),
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(25), VerticalAnchor.aboveBottom(50))));

    public static final Holder<PlacedFeature> TOPAZ_ORE_PLACED = PlacementUtils.register("topaz_ore_placed",
            ModConfiguredFeatures.TOPAZ_ORE, ModOrePlacement.commonOrePlacement(
                    KrystalCraftModCommonConfigs.TOPAZ_ORE_VEINS_PER_CHUNK.get(),
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(20))));

    public static final Holder<PlacedFeature> LEAD_ORE_PLACED = PlacementUtils.register("lead_ore_placed",
            ModConfiguredFeatures.LEAD_ORE, ModOrePlacement.commonOrePlacement(
                    KrystalCraftModCommonConfigs.LEAD_ORE_VEINS_PER_CHUNK.get(),
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(20))));
}
