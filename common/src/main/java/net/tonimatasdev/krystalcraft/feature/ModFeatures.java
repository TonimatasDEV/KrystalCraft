package net.tonimatasdev.krystalcraft.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.tonimatasdev.krystalcraft.KrystalCraft;

import java.util.List;

public class ModFeatures {
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_EXPERIENCE_ORE = FeatureUtils.createKey(find("experience"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_JADE_ORE = FeatureUtils.createKey(find("jade"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_LEAD_ORE = FeatureUtils.createKey(find("lead"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PLATINUM_ORE = FeatureUtils.createKey(find("platinum"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_RUBY_ORE = FeatureUtils.createKey(find("ruby"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_SAPPHIRE_ORE = FeatureUtils.createKey(find("sapphire"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_SILVER_ORE = FeatureUtils.createKey(find("silver"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_TIN_ORE = FeatureUtils.createKey(find("tin"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_TOPAZ_ORE = FeatureUtils.createKey(find("topaz"));
    private static final ResourceKey<PlacedFeature> PLACED_EXPERIENCE_ORE = PlacementUtils.createKey(find("experience"));
    private static final ResourceKey<PlacedFeature> PLACED_JADE_ORE = PlacementUtils.createKey(find("jade"));
    private static final ResourceKey<PlacedFeature> PLACED_LEAD_ORE = PlacementUtils.createKey(find("lead"));
    private static final ResourceKey<PlacedFeature> PLACED_PLATINUM_ORE = PlacementUtils.createKey(find("platinum"));
    private static final ResourceKey<PlacedFeature> PLACED_RUBY_ORE = PlacementUtils.createKey(find("ruby"));
    private static final ResourceKey<PlacedFeature> PLACED_SAPPHIRE_ORE = PlacementUtils.createKey(find("sapphire"));
    private static final ResourceKey<PlacedFeature> PLACED_SILVER_ORE = PlacementUtils.createKey(find("silver"));
    private static final ResourceKey<PlacedFeature> PLACED_TIN_ORE = PlacementUtils.createKey(find("tin"));
    private static final ResourceKey<PlacedFeature> PLACED_TOPAZ_ORE = PlacementUtils.createKey(find("topaz"));

    public static void configuredBootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstrap) {
        List<OreConfiguration.TargetBlockState> experienceList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.EXPERIENCE_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_EXPERIENCE_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_EXPERIENCE_ORE, Feature.ORE, new OreConfiguration(experienceList, 10));

        List<OreConfiguration.TargetBlockState> jadeList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.JADE_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_JADE_ORE, Feature.ORE, new OreConfiguration(jadeList, 3));

        List<OreConfiguration.TargetBlockState> leadList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_LEAD_ORE, Feature.ORE, new OreConfiguration(leadList, 4));

        List<OreConfiguration.TargetBlockState> platinumList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_PLATINUM_ORE, Feature.ORE, new OreConfiguration(platinumList, 3));

        List<OreConfiguration.TargetBlockState> rubyList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_RUBY_ORE, Feature.ORE, new OreConfiguration(rubyList, 5));

        List<OreConfiguration.TargetBlockState> sapphireList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_SAPPHIRE_ORE, Feature.ORE, new OreConfiguration(sapphireList, 3));

        List<OreConfiguration.TargetBlockState> silverList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_SILVER_ORE, Feature.ORE, new OreConfiguration(silverList, 8));

        List<OreConfiguration.TargetBlockState> tinList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_TIN_ORE, Feature.ORE, new OreConfiguration(tinList, 9));

        List<OreConfiguration.TargetBlockState> topazList = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));
        FeatureUtils.register(bootstrap, CONFIGURED_TOPAZ_ORE, Feature.ORE, new OreConfiguration(topazList, 5));
    }

    public static void placedBootstrap(BootstapContext<PlacedFeature> bootstrap) {
        PlacementUtils.register(bootstrap, PLACED_EXPERIENCE_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_EXPERIENCE_ORE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_JADE_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_JADE_ORE), List.of(CountPlacement.of(6), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_LEAD_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_LEAD_ORE), List.of(CountPlacement.of(6), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_PLATINUM_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_PLATINUM_ORE), List.of(CountPlacement.of(3), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_RUBY_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_RUBY_ORE), List.of(CountPlacement.of(5), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_SAPPHIRE_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_SAPPHIRE_ORE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_SILVER_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_SILVER_ORE), List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_TIN_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_TIN_ORE), List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120)), BiomeFilter.biome()));
        PlacementUtils.register(bootstrap, PLACED_TOPAZ_ORE, bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CONFIGURED_TOPAZ_ORE), List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)), BiomeFilter.biome()));
    }

    private static String find(String name) {
        return KrystalCraft.MOD_ID + ":" + name + "_ore";
    }
}
