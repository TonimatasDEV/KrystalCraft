package dev.tonimatas.krystalcraft.data;

import dev.tonimatas.krystalcraft.registry.ModBlocks;
import dev.tonimatas.krystalcraft.registry.ModItems;
import dev.tonimatas.krystalcraft.registry.ModTabs;
import dev.tonimatas.krystalcraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // Silver
        translationBuilder.add(ModItems.RAW_SILVER, "Raw Silver");
        translationBuilder.add(ModItems.SILVER_INGOT, "Silver Ingot");
        translationBuilder.add(ModItems.SILVER_NUGGET, "Silver Nugget");
        translationBuilder.add(ModItems.SILVER_DUST, "Silver Dust");
        translationBuilder.add(ModItems.SILVER_HELMET, "Silver Helmet");
        translationBuilder.add(ModItems.SILVER_CHESTPLATE, "Silver Chestplate");
        translationBuilder.add(ModItems.SILVER_LEGGINGS, "Silver Leggings");
        translationBuilder.add(ModItems.SILVER_BOOTS, "Silver Boots");
        translationBuilder.add(ModItems.SILVER_SWORD, "Silver Sword");
        translationBuilder.add(ModItems.SILVER_PICKAXE, "Silver Pickaxe");
        translationBuilder.add(ModItems.SILVER_AXE, "Silver Axe");
        translationBuilder.add(ModItems.SILVER_SHOVEL, "Silver Shovel");
        translationBuilder.add(ModItems.SILVER_HOE, "Silver Hoe");
        translationBuilder.add(ModBlocks.SILVER_BLOCK, "Silver Block");
        translationBuilder.add(ModBlocks.SILVER_ORE, "Silver Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_SILVER_ORE, "Deepslate Silver Ore");

        // Tin
        translationBuilder.add(ModItems.RAW_TIN, "Raw Tin");
        translationBuilder.add(ModItems.TIN_INGOT, "Tin Ingot");
        translationBuilder.add(ModItems.TIN_NUGGET, "Tin Nugget");
        translationBuilder.add(ModItems.TIN_DUST, "Tin Dust");
        translationBuilder.add(ModItems.TIN_HELMET, "Tin Helmet");
        translationBuilder.add(ModItems.TIN_CHESTPLATE, "Tin Chestplate");
        translationBuilder.add(ModItems.TIN_LEGGINGS, "Tin Leggings");
        translationBuilder.add(ModItems.TIN_BOOTS, "Tin Boots");
        translationBuilder.add(ModItems.TIN_SWORD, "Tin Sword");
        translationBuilder.add(ModItems.TIN_PICKAXE, "Tin Pickaxe");
        translationBuilder.add(ModItems.TIN_AXE, "Tin Axe");
        translationBuilder.add(ModItems.TIN_SHOVEL, "Tin Shovel");
        translationBuilder.add(ModItems.TIN_HOE, "Tin Hoe");
        translationBuilder.add(ModBlocks.TIN_BLOCK, "Tin Block");
        translationBuilder.add(ModBlocks.TIN_ORE, "Tin Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");

        // Copper
        translationBuilder.add(ModItems.COPPER_NUGGET, "Copper Nugget");
        translationBuilder.add(ModItems.COPPER_DUST, "Copper Dust");
        translationBuilder.add(ModItems.COPPER_HELMET, "Copper Helmet");
        translationBuilder.add(ModItems.COPPER_CHESTPLATE, "Copper Chestplate");
        translationBuilder.add(ModItems.COPPER_LEGGINGS, "Copper Leggings");
        translationBuilder.add(ModItems.COPPER_BOOTS, "Copper Boots");
        translationBuilder.add(ModItems.COPPER_SWORD, "Copper Sword");
        translationBuilder.add(ModItems.COPPER_PICKAXE, "Copper Pickaxe");
        translationBuilder.add(ModItems.COPPER_AXE, "Copper Axe");
        translationBuilder.add(ModItems.COPPER_SHOVEL, "Copper Shovel");
        translationBuilder.add(ModItems.COPPER_HOE, "Copper Hoe");

        // Lead
        translationBuilder.add(ModItems.RAW_LEAD, "Raw Lead");
        translationBuilder.add(ModItems.LEAD_INGOT, "Lead Ingot");
        translationBuilder.add(ModItems.LEAD_NUGGET, "Lead Nugget");
        translationBuilder.add(ModItems.LEAD_DUST, "Lead Dust");
        translationBuilder.add(ModItems.LEAD_HELMET, "Lead Helmet");
        translationBuilder.add(ModItems.LEAD_CHESTPLATE, "Lead Chestplate");
        translationBuilder.add(ModItems.LEAD_LEGGINGS, "Lead Leggings");
        translationBuilder.add(ModItems.LEAD_BOOTS, "Lead Boots");
        translationBuilder.add(ModItems.LEAD_SWORD, "Lead Sword");
        translationBuilder.add(ModItems.LEAD_PICKAXE, "Lead Pickaxe");
        translationBuilder.add(ModItems.LEAD_AXE, "Lead Axe");
        translationBuilder.add(ModItems.LEAD_SHOVEL, "Lead Shovel");
        translationBuilder.add(ModItems.LEAD_HOE, "Lead Hoe");
        translationBuilder.add(ModBlocks.LEAD_BLOCK, "Lead Block");
        translationBuilder.add(ModBlocks.LEAD_ORE, "Lead Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_LEAD_ORE, "Deepslate Lead Ore");

        // Platinum
        translationBuilder.add(ModItems.RAW_PLATINUM, "Raw Platinum");
        translationBuilder.add(ModItems.PLATINUM_INGOT, "Platinum Ingot");
        translationBuilder.add(ModItems.PLATINUM_NUGGET, "Platinum Nugget");
        translationBuilder.add(ModItems.PLATINUM_DUST, "Platinum Dust");
        translationBuilder.add(ModItems.PLATINUM_HELMET, "Platinum Helmet");
        translationBuilder.add(ModItems.PLATINUM_CHESTPLATE, "Platinum Chestplate");
        translationBuilder.add(ModItems.PLATINUM_LEGGINGS, "Platinum Leggings");
        translationBuilder.add(ModItems.PLATINUM_BOOTS, "Platinum Boots");
        translationBuilder.add(ModItems.PLATINUM_SWORD, "Platinum Sword");
        translationBuilder.add(ModItems.PLATINUM_PICKAXE, "Platinum Pickaxe");
        translationBuilder.add(ModItems.PLATINUM_AXE, "Platinum Axe");
        translationBuilder.add(ModItems.PLATINUM_SHOVEL, "Platinum Shovel");
        translationBuilder.add(ModItems.PLATINUM_HOE, "Platinum Hoe");
        translationBuilder.add(ModBlocks.PLATINUM_BLOCK, "Platinum Block");
        translationBuilder.add(ModBlocks.PLATINUM_ORE, "Platinum Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_PLATINUM_ORE, "Deepslate Platinum Ore");

        // Jade
        translationBuilder.add(ModItems.RAW_JADE, "Raw Jade");
        translationBuilder.add(ModItems.JADE, "Jade");
        translationBuilder.add(ModItems.JADE_DUST, "Jade Dust");
        translationBuilder.add(ModItems.JADE_HELMET, "Jade Helmet");
        translationBuilder.add(ModItems.JADE_CHESTPLATE, "Jade Chestplate");
        translationBuilder.add(ModItems.JADE_LEGGINGS, "Jade Leggings");
        translationBuilder.add(ModItems.JADE_BOOTS, "Jade Boots");
        translationBuilder.add(ModItems.JADE_SWORD, "Jade Sword");
        translationBuilder.add(ModItems.JADE_PICKAXE, "Jade Pickaxe");
        translationBuilder.add(ModItems.JADE_AXE, "Jade Axe");
        translationBuilder.add(ModItems.JADE_SHOVEL, "Jade Shovel");
        translationBuilder.add(ModItems.JADE_HOE, "Jade Hoe");
        translationBuilder.add(ModBlocks.JADE_BLOCK, "Jade Block");
        translationBuilder.add(ModBlocks.JADE_ORE, "Jade Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_JADE_ORE, "Deepslate Jade Ore");

        // Topaz
        translationBuilder.add(ModItems.RAW_TOPAZ, "Raw Topaz");
        translationBuilder.add(ModItems.TOPAZ, "Topaz");
        translationBuilder.add(ModItems.TOPAZ_DUST, "Topaz Dust");
        translationBuilder.add(ModItems.TOPAZ_HELMET, "Topaz Helmet");
        translationBuilder.add(ModItems.TOPAZ_CHESTPLATE, "Topaz Chestplate");
        translationBuilder.add(ModItems.TOPAZ_LEGGINGS, "Topaz Leggings");
        translationBuilder.add(ModItems.TOPAZ_BOOTS, "Topaz Boots");
        translationBuilder.add(ModItems.TOPAZ_SWORD, "Topaz Sword");
        translationBuilder.add(ModItems.TOPAZ_PICKAXE, "Topaz Pickaxe");
        translationBuilder.add(ModItems.TOPAZ_AXE, "Topaz Axe");
        translationBuilder.add(ModItems.TOPAZ_SHOVEL, "Topaz Shovel");
        translationBuilder.add(ModItems.TOPAZ_HOE, "Topaz Hoe");
        translationBuilder.add(ModBlocks.TOPAZ_BLOCK, "Topaz Block");
        translationBuilder.add(ModBlocks.TOPAZ_ORE, "Topaz Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_TOPAZ_ORE, "Deepslate Topaz Ore");

        // Sapphire
        translationBuilder.add(ModItems.RAW_SAPPHIRE, "Raw Sapphire");
        translationBuilder.add(ModItems.SAPPHIRE, "Sapphire");
        translationBuilder.add(ModItems.SAPPHIRE_DUST, "Sapphire Dust");
        translationBuilder.add(ModItems.SAPPHIRE_HELMET, "Sapphire Helmet");
        translationBuilder.add(ModItems.SAPPHIRE_CHESTPLATE, "Sapphire Chestplate");
        translationBuilder.add(ModItems.SAPPHIRE_LEGGINGS, "Sapphire Leggings");
        translationBuilder.add(ModItems.SAPPHIRE_BOOTS, "Sapphire Boots");
        translationBuilder.add(ModItems.SAPPHIRE_SWORD, "Sapphire Sword");
        translationBuilder.add(ModItems.SAPPHIRE_PICKAXE, "Sapphire Pickaxe");
        translationBuilder.add(ModItems.SAPPHIRE_AXE, "Sapphire Axe");
        translationBuilder.add(ModItems.SAPPHIRE_SHOVEL, "Sapphire Shovel");
        translationBuilder.add(ModItems.SAPPHIRE_HOE, "Sapphire Hoe");
        translationBuilder.add(ModBlocks.SAPPHIRE_BLOCK, "Sapphire Block");
        translationBuilder.add(ModBlocks.SAPPHIRE_ORE, "Sapphire Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, "Deepslate Sapphire Ore");

        // Ruby
        translationBuilder.add(ModItems.RAW_RUBY, "Raw Ruby");
        translationBuilder.add(ModItems.RUBY, "Ruby");
        translationBuilder.add(ModItems.RUBY_DUST, "Ruby Dust");
        translationBuilder.add(ModItems.RUBY_HELMET, "Ruby Helmet");
        translationBuilder.add(ModItems.RUBY_CHESTPLATE, "Ruby Chestplate");
        translationBuilder.add(ModItems.RUBY_LEGGINGS, "Ruby Leggings");
        translationBuilder.add(ModItems.RUBY_BOOTS, "Ruby Boots");
        translationBuilder.add(ModItems.RUBY_SWORD, "Ruby Sword");
        translationBuilder.add(ModItems.RUBY_PICKAXE, "Ruby Pickaxe");
        translationBuilder.add(ModItems.RUBY_AXE, "Ruby Axe");
        translationBuilder.add(ModItems.RUBY_SHOVEL, "Ruby Shovel");
        translationBuilder.add(ModItems.RUBY_HOE, "Ruby Hoe");
        translationBuilder.add(ModBlocks.RUBY_BLOCK, "Ruby Block");
        translationBuilder.add(ModBlocks.RUBY_ORE, "Ruby Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_RUBY_ORE, "Deepslate Ruby Ore");

        // Bronze
        translationBuilder.add(ModItems.BRONZE_INGOT, "Bronze Ingot");
        translationBuilder.add(ModItems.BRONZE_NUGGET, "Bronze Nugget");
        translationBuilder.add(ModItems.BRONZE_DUST, "Bronze Dust");
        translationBuilder.add(ModItems.BRONZE_HELMET, "Bronze Helmet");
        translationBuilder.add(ModItems.BRONZE_CHESTPLATE, "Bronze Chestplate");
        translationBuilder.add(ModItems.BRONZE_LEGGINGS, "Bronze Leggings");
        translationBuilder.add(ModItems.BRONZE_BOOTS, "Bronze Boots");
        translationBuilder.add(ModItems.BRONZE_SWORD, "Bronze Sword");
        translationBuilder.add(ModItems.BRONZE_PICKAXE, "Bronze Pickaxe");
        translationBuilder.add(ModItems.BRONZE_AXE, "Bronze Axe");
        translationBuilder.add(ModItems.BRONZE_SHOVEL, "Bronze Shovel");
        translationBuilder.add(ModItems.BRONZE_HOE, "Bronze Hoe");
        translationBuilder.add(ModBlocks.BRONZE_BLOCK, "Bronze Block");
        
        // Other
        translationBuilder.add(ModItems.RAW_DIAMOND, "Raw Diamond");
        translationBuilder.add(ModItems.DIAMOND_DUST, "Diamond Dust");
        translationBuilder.add(ModItems.RAW_LAPIS, "Raw Lapis Lazuli");
        translationBuilder.add(ModItems.LAPIS_DUST, "Lapiz Lazuli Dust");
        translationBuilder.add(ModItems.RAW_REDSTONE, "Raw Redstone");
        translationBuilder.add(ModItems.RAW_EMERALD, "Raw Emerald");
        translationBuilder.add(ModItems.EMERALD_DUST, "Emerald Dust");
        translationBuilder.add(ModItems.IRON_DUST, "Iron Dust");
        translationBuilder.add(ModItems.BATTERY, "Battery");
        translationBuilder.add(ModBlocks.EXPERIENCE_ORE, "Experience Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE, "Deepslate Experience Ore");
        translationBuilder.add(ModBlocks.CUTTING_STATION, "Cutting Station");
        translationBuilder.add(ModBlocks.CUTTING_FACTORY, "Cutting Factory");
        translationBuilder.add(ModBlocks.CRUSHING_STATION, "Crushing Station");
        translationBuilder.add(ModBlocks.CRUSHING_FACTORY, "Crushing Factory");
        translationBuilder.add(ModBlocks.COMBINING_STATION, "Combining Station");
        translationBuilder.add(ModBlocks.COMBINING_FACTORY, "Combining Factory");
        translationBuilder.add(ModBlocks.COMBUSTION_GENERATOR, "Combustion Generator");

        Optional<RegistryKey<ItemGroup>> itemGroup = Registries.ITEM_GROUP.getKey(ModTabs.KRYSTALCRAFT);
        itemGroup.ifPresent(itemGroupRegistryKey -> translationBuilder.add(itemGroupRegistryKey, "KrystalCraft"));
        
        // Tags - Dusts
        translationBuilder.add(ModTags.Items.DIAMOND_DUSTS,  "Diamond Dusts Tag");
        translationBuilder.add(ModTags.Items.LEAD_DUSTS,  "Lead Dusts Tag");
        translationBuilder.add(ModTags.Items.COPPER_DUSTS,  "Copper Dusts Tag");
        translationBuilder.add(ModTags.Items.IRON_DUSTS,  "Iron Dusts Tag");
        translationBuilder.add(ModTags.Items.PLATINUM_DUSTS,  "Platinum Dusts Tag");
        translationBuilder.add(ModTags.Items.TIN_DUSTS,  "Tin Dusts Tag");
        translationBuilder.add(ModTags.Items.SILVER_DUSTS,  "Silver Dusts Tag");
        translationBuilder.add(ModTags.Items.JADE_DUSTS,  "Jade Dusts Tag");
        translationBuilder.add(ModTags.Items.EMERALD_DUSTS,  "Emerald Dusts Tag");
        translationBuilder.add(ModTags.Items.LAPIS_DUSTS,  "Lapis Lazuli Dusts Tag");
        translationBuilder.add(ModTags.Items.BRONZE_DUSTS,  "Bronze Dusts Tag");
        translationBuilder.add(ModTags.Items.RUBY_DUSTS,  "Ruby Dusts Tag");
        translationBuilder.add(ModTags.Items.TOPAZ_DUSTS,  "Topaz Dusts Tag");
        translationBuilder.add(ModTags.Items.SAPPHIRE_DUSTS,  "Sapphire Dusts Tag");

        // Tags - Ingots
        translationBuilder.add(ModTags.Items.SILVER_INGOTS,  "Silver Ingots Tag");
        translationBuilder.add(ModTags.Items.PLATINUM_INGOTS,  "Platinum Ingots Tag");
        translationBuilder.add(ModTags.Items.TIN_INGOTS,  "Tin Ingots Tag");
        translationBuilder.add(ModTags.Items.BRONZE_INGOTS,  "Bronze Ingots Tag");
        translationBuilder.add(ModTags.Items.LEAD_INGOTS,  "Lead Ingots Tag");

        // Tags - Gems
        translationBuilder.add(ModTags.Items.RUBY_GEMS,  "Ruby Gems Tag");
        translationBuilder.add(ModTags.Items.SAPPHIRE_GEMS,  "Sapphire Gems Tag");
        translationBuilder.add(ModTags.Items.JADE_GEMS,  "JAde Gems Tag");
        translationBuilder.add(ModTags.Items.TOPAZ_GEMS,  "Topaz Gems Tag");

        // Tags - Raw Materials
        translationBuilder.add(ModTags.Items.DIAMOND_RAW_MATERIALS,  "Diamond Raw Materials Tag");
        translationBuilder.add(ModTags.Items.LEAD_RAW_MATERIALS,  "Lead Raw Materials Tag");
        translationBuilder.add(ModTags.Items.PLATINUM_RAW_MATERIALS,  "Platinum Raw Materials Tag");
        translationBuilder.add(ModTags.Items.TIN_RAW_MATERIALS,  "Tin Raw Materials Tag");
        translationBuilder.add(ModTags.Items.SILVER_RAW_MATERIALS,  "Silver Raw Materials Tag");
        translationBuilder.add(ModTags.Items.JADE_RAW_MATERIALS,  "Jade Raw Materials Tag");
        translationBuilder.add(ModTags.Items.EMERALD_RAW_MATERIALS,  "Emerald Raw Materials Tag");
        translationBuilder.add(ModTags.Items.LAPIS_RAW_MATERIALS,  "Lapis Lazuli Raw Materials Tag");
        translationBuilder.add(ModTags.Items.RUBY_RAW_MATERIALS,  "Ruby Raw Materials Tag");
        translationBuilder.add(ModTags.Items.TOPAZ_RAW_MATERIALS,  "Topaz Raw Materials Tag");
        translationBuilder.add(ModTags.Items.SAPPHIRE_RAW_MATERIALS,  "Sapphire Raw Materials Tag");
        translationBuilder.add(ModTags.Items.REDSTONE_RAW_MATERIALS,  "Redstone Raw Materials Tag");

        // Tags - Nuggets
        translationBuilder.add(ModTags.Items.SILVER_NUGGETS,  "Silver Nuggets Tag");
        translationBuilder.add(ModTags.Items.PLATINUM_NUGGETS,  "Platinum Nuggets Tag");
        translationBuilder.add(ModTags.Items.TIN_NUGGETS,  "Tin Nuggets Tag");
        translationBuilder.add(ModTags.Items.BRONZE_NUGGETS,  "Bronze Nuggets Tag");
        translationBuilder.add(ModTags.Items.LEAD_NUGGETS,  "Lead Nuggets Tag");
        translationBuilder.add(ModTags.Items.COPPER_NUGGETS,  "Copper Nuggets Tag");

        // Tags - Ores
        translationBuilder.add(ModTags.Items.SILVER_ORES,  "Silver Ores Tag");
        translationBuilder.add(ModTags.Items.PLATINUM_ORES,  "Platinum Ores Tag");
        translationBuilder.add(ModTags.Items.TIN_ORES,  "Tin Ores Tag");
        translationBuilder.add(ModTags.Items.LEAD_ORES,  "Lead Ores Tag");
        translationBuilder.add(ModTags.Items.TOPAZ_ORES,  "Topaz Ores Tag");
        translationBuilder.add(ModTags.Items.EXPERIENCE_ORES,  "Experience Ores Tag");
        translationBuilder.add(ModTags.Items.RUBY_ORES,  "Ruby Ores Tag");
        translationBuilder.add(ModTags.Items.JADE_ORES,  "Jade Ores Tag");
        translationBuilder.add(ModTags.Items.SAPPHIRE_ORES,  "Sapphire Ores Tag");

        // Tags - Storage Blocks
        translationBuilder.add(ModTags.Items.SILVER_BLOCKS,  "Silver Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.PLATINUM_BLOCKS,  "Platinum Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.TIN_BLOCKS,  "Tin Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.LEAD_BLOCKS,  "Lead Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.TOPAZ_BLOCKS,  "Topaz Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.RUBY_BLOCKS,  "Ruby Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.JADE_BLOCKS,  "Jade Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.SAPPHIRE_BLOCKS,  "Sapphire Storage Blocks Tag");
        translationBuilder.add(ModTags.Items.BRONZE_BLOCKS,  "Bronze Storage Blocks Tag");
    }
}
