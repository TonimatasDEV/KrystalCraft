package net.tonimatasmc.krystalcraft.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.tonimatasmc.krystalcraft.block.ModBlocks;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModCommonConfigs;

import java.util.List;

public class ModConfiguredFeatures {
        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_JADE_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.JADE_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.JADE_ORE.get().defaultBlockState()));
    
        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SILVER_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()));
    
        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TOPAZ_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TOPAZ_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.TOPAZ_ORE.get().defaultBlockState()));

        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_LEAD_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()));
            
        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TIN_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()));

        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_PLATINUM_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.PLATINUM_ORE.get().defaultBlockState()));

//----------------------------------------------------------------------------------------------------------------------

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> JADE_ORE = FeatureUtils.register("jade_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_JADE_ORES, KrystalCraftModCommonConfigs.JADE_ORE_VEIN_SIZE.get()));

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SILVER_ORE = FeatureUtils.register("silver_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORES, KrystalCraftModCommonConfigs.SILVER_ORE_VEIN_SIZE.get()));

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TOPAZ_ORE = FeatureUtils.register("topaz_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TOPAZ_ORES, KrystalCraftModCommonConfigs.TOPAZ_ORE_VEIN_SIZE.get()));

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> LEAD_ORE = FeatureUtils.register("lead_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_LEAD_ORES, KrystalCraftModCommonConfigs.LEAD_ORE_VEIN_SIZE.get()));

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TIN_ORE = FeatureUtils.register("tin_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES, KrystalCraftModCommonConfigs.TIN_ORE_VEIN_SIZE.get()));

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> PLATINUM_ORE = FeatureUtils.register("platinum_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_PLATINUM_ORES, KrystalCraftModCommonConfigs.PLATINUM_ORE_VEIN_SIZE.get()));
}
