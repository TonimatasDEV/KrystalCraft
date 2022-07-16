package net.tonimatasmc.krystalcraft.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.config.KrystalCraftModCommonConfigs;

@SuppressWarnings({"unchecked", "unused"})
public class ModPlacedFeatures {
        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
                DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, KrystalCraft.MOD_ID);

        public static final RegistryObject<PlacedFeature> JADE_ORE_PLACED = PLACED_FEATURES.register("jade_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.JADE_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.JADE_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.JADE_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.JADE_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED = PLACED_FEATURES.register("silver_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.SILVER_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.SILVER_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SILVER_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SILVER_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> TOPAZ_ORE_PLACED = PLACED_FEATURES.register("topaz_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.TOPAZ_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.TOPAZ_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TOPAZ_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TOPAZ_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> LEAD_ORE_PLACED = PLACED_FEATURES.register("lead_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.LEAD_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.LEAD_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.LEAD_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.LEAD_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> TIN_ORE_PLACED = PLACED_FEATURES.register("tin_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.TIN_ORE, ModOrePlacement.commonOrePlacement(
                         KrystalCraftModCommonConfigs.TIN_ORE_VEINS_PER_CHUNK.get(),
                         HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TIN_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.TIN_ORE_MAXIMUN_HEIGHT.get())))));
        
        public static final RegistryObject<PlacedFeature> PLATINUM_ORE_PLACED = PLACED_FEATURES.register("platinum_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.PLATINUM_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.PLATINUM_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.PLATINUM_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.PLATINUM_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE_PLACED = PLACED_FEATURES.register("sapphire_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.SAPPHIRE_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.SAPPHIRE_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SAPPHIRE_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.SAPPHIRE_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> RUBY_ORE_PLACED = PLACED_FEATURES.register("ruby_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.RUBY_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.RUBY_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.RUBY_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.RUBY_ORE_MAXIMUN_HEIGHT.get())))));

        public static final RegistryObject<PlacedFeature> EXPERIENCE_ORE_PLACED = PLACED_FEATURES.register("experience_ore_placed",
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        ModConfiguredFeatures.EXPERIENCE_ORE, ModOrePlacement.commonOrePlacement(
                        KrystalCraftModCommonConfigs.EXPERIENCE_ORE_VEINS_PER_CHUNK.get(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.EXPERIENCE_ORE_MINIMUN_HEIGHT.get()), VerticalAnchor.aboveBottom(KrystalCraftModCommonConfigs.EXPERIENCE_ORE_MAXIMUN_HEIGHT.get())))));

        public static void register(IEventBus eventBus) {
                PLACED_FEATURES.register(eventBus);
        }
}
