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
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.JADE_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.JADE_ORE_MAXIMUN_HEIGHT.get()))));

        public static final Holder<PlacedFeature> SILVER_ORE_PLACED = PlacementUtils.register("silver_ore_placed",
                ModConfiguredFeatures.SILVER_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.SILVER_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SILVER_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SILVER_ORE_MAXIMUN_HEIGHT.get()))));

        public static final Holder<PlacedFeature> TOPAZ_ORE_PLACED = PlacementUtils.register("topaz_ore_placed",
                ModConfiguredFeatures.TOPAZ_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.TOPAZ_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TOPAZ_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TOPAZ_ORE_MAXIMUN_HEIGHT.get()))));

        public static final Holder<PlacedFeature> LEAD_ORE_PLACED = PlacementUtils.register("lead_ore_placed",
                ModConfiguredFeatures.LEAD_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.LEAD_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.LEAD_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.LEAD_ORE_MAXIMUN_HEIGHT.get()))));

        public static final Holder<PlacedFeature> TIN_ORE_PLACED = PlacementUtils.register("tin_ore_placed",
                ModConfiguredFeatures.TIN_ORE, ModOrePlacement.commonOrePlacement(
                         KrystalCraftModCommonConfigs.TIN_ORE_VEINS_PER_CHUNK.get(),
                         HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TIN_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TIN_ORE_MAXIMUN_HEIGHT.get()))));
        
        public static final Holder<PlacedFeature> PLATINUM_ORE_PLACED = PlacementUtils.register("platinum_ore_placed",
                ModConfiguredFeatures.PLATINUM_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.PLATINUM_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.PLATINUM_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.PLATINUM_ORE_MAXIMUN_HEIGHT.get()))));

        public static final Holder<PlacedFeature> SAPPHIRE_ORE_PLACED = PlacementUtils.register("platinum_ore_placed",
                ModConfiguredFeatures.SAPPHIRE_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.SAPPHIRE_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SAPPHIRE_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SAPPHIRE_ORE_MAXIMUN_HEIGHT.get()))));

}
