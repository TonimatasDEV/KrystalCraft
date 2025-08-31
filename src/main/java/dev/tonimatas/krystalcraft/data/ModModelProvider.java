package dev.tonimatas.krystalcraft.data;

import dev.tonimatas.krystalcraft.registry.ModBlocks;
import dev.tonimatas.krystalcraft.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JADE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JADE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_JADE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LEAD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PLATINUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPERIENCE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BATTERY, Models.GENERATED);
        
        // Bronze
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_BOOTS, Models.GENERATED);
        
        // Copper
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BOOTS, Models.GENERATED);
        
        // Jade
        itemModelGenerator.register(ModItems.RAW_JADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JADE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JADE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JADE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JADE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JADE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_BOOTS, Models.GENERATED);
        
        // Lead
        itemModelGenerator.register(ModItems.RAW_LEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_BOOTS, Models.GENERATED);
        
        // Platinum
        itemModelGenerator.register(ModItems.RAW_PLATINUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_BOOTS, Models.GENERATED);
        
        // Ruby
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_BOOTS, Models.GENERATED);
        
        // Sapphire
        itemModelGenerator.register(ModItems.RAW_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_BOOTS, Models.GENERATED);

        // Silver
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_BOOTS, Models.GENERATED);

        // Tin
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_BOOTS, Models.GENERATED);

        // Topaz
        itemModelGenerator.register(ModItems.RAW_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_BOOTS, Models.GENERATED);

        // Other
        itemModelGenerator.register(ModItems.DIAMOND_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_LAPIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_REDSTONE, Models.GENERATED);
    }
}
