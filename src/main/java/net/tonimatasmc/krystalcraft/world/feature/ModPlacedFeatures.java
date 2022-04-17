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
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(30), VerticalAnchor.aboveBottom(90))));

        public static final Holder<PlacedFeature> SILVER_ORE_PLACED = PlacementUtils.register("silver_ore_placed",
                ModConfiguredFeatures.SILVER_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.SILVER_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(70), VerticalAnchor.aboveBottom(140))));

        public static final Holder<PlacedFeature> TOPAZ_ORE_PLACED = PlacementUtils.register("topaz_ore_placed",
                ModConfiguredFeatures.TOPAZ_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.TOPAZ_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(40), VerticalAnchor.aboveBottom(90))));

        public static final Holder<PlacedFeature> LEAD_ORE_PLACED = PlacementUtils.register("lead_ore_placed",
                ModConfiguredFeatures.LEAD_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.LEAD_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(110))));

        public static final Holder<PlacedFeature> TIN_ORE_PLACED = PlacementUtils.register("tin_ore_placed",
                ModConfiguredFeatures.TIN_ORE, ModOrePlacement.commonOrePlacement(
                         KrystalCraftModCommonConfigs.TIN_ORE_VEINS_PER_CHUNK.get(),
                         HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(100), VerticalAnchor.aboveBottom(200))));
        
        public static final Holder<PlacedFeature> PLATINUM_ORE_PLACED = PlacementUtils.register("tin_ore_placed",
                ModConfiguredFeatures.PLATINUM_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.PLATINUM_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(90))));
                                
}
