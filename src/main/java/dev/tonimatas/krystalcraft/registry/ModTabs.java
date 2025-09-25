package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModTabs {
    public static final ItemGroup KRYSTALCRAFT = Registry.register(Registries.ITEM_GROUP, Identifier.of(KrystalCraft.MOD_ID, "krystalcraft"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.CUTTING_FACTORY))
                    .displayName(Text.translatable("itemGroup.krystalcraft"))
                    .entries((displayContext, entries) -> {
                        
                        // Silver
                        entries.add(ModItems.SILVER_INGOT);
                        entries.add(ModItems.SILVER_NUGGET);
                        entries.add(ModItems.SILVER_DUST);
                        entries.add(ModItems.RAW_SILVER);
                        entries.add(ModBlocks.SILVER_BLOCK);
                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
                        entries.add(ModItems.SILVER_HELMET);
                        entries.add(ModItems.SILVER_CHESTPLATE);
                        entries.add(ModItems.SILVER_LEGGINGS);
                        entries.add(ModItems.SILVER_BOOTS);
                        entries.add(ModItems.SILVER_SWORD);
                        entries.add(ModItems.SILVER_PICKAXE);
                        entries.add(ModItems.SILVER_AXE);
                        entries.add(ModItems.SILVER_SHOVEL);
                        entries.add(ModItems.SILVER_HOE);
                        
                        // Jade
                        entries.add(ModItems.JADE);
                        entries.add(ModItems.JADE_DUST);
                        entries.add(ModItems.RAW_JADE);
                        entries.add(ModBlocks.JADE_BLOCK);
                        entries.add(ModBlocks.JADE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_JADE_ORE);
                        entries.add(ModItems.JADE_HELMET);
                        entries.add(ModItems.JADE_CHESTPLATE);
                        entries.add(ModItems.JADE_LEGGINGS);
                        entries.add(ModItems.JADE_BOOTS);
                        entries.add(ModItems.JADE_SWORD);
                        entries.add(ModItems.JADE_PICKAXE);
                        entries.add(ModItems.JADE_AXE);
                        entries.add(ModItems.JADE_SHOVEL);
                        entries.add(ModItems.JADE_HOE);
                        
                        // Topaz
                        entries.add(ModItems.TOPAZ);
                        entries.add(ModItems.TOPAZ_DUST);
                        entries.add(ModItems.RAW_TOPAZ);
                        entries.add(ModBlocks.TOPAZ_BLOCK);
                        entries.add(ModBlocks.TOPAZ_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TOPAZ_ORE);
                        entries.add(ModItems.TOPAZ_HELMET);
                        entries.add(ModItems.TOPAZ_CHESTPLATE);
                        entries.add(ModItems.TOPAZ_LEGGINGS);
                        entries.add(ModItems.TOPAZ_BOOTS);
                        entries.add(ModItems.TOPAZ_SWORD);
                        entries.add(ModItems.TOPAZ_PICKAXE);
                        entries.add(ModItems.TOPAZ_AXE);
                        entries.add(ModItems.TOPAZ_SHOVEL);
                        entries.add(ModItems.TOPAZ_HOE);
                        
                        // Lead
                        entries.add(ModItems.LEAD_INGOT);
                        entries.add(ModItems.LEAD_NUGGET);
                        entries.add(ModItems.LEAD_DUST);
                        entries.add(ModItems.RAW_LEAD);
                        entries.add(ModBlocks.LEAD_BLOCK);
                        entries.add(ModBlocks.LEAD_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LEAD_ORE);
                        entries.add(ModItems.LEAD_HELMET);
                        entries.add(ModItems.LEAD_CHESTPLATE);
                        entries.add(ModItems.LEAD_LEGGINGS);
                        entries.add(ModItems.LEAD_BOOTS);
                        entries.add(ModItems.LEAD_SWORD);
                        entries.add(ModItems.LEAD_PICKAXE);
                        entries.add(ModItems.LEAD_AXE);
                        entries.add(ModItems.LEAD_SHOVEL);
                        entries.add(ModItems.LEAD_HOE);
                        
                        // Tin
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModItems.TIN_NUGGET);
                        entries.add(ModItems.TIN_DUST);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModItems.TIN_HELMET);
                        entries.add(ModItems.TIN_CHESTPLATE);
                        entries.add(ModItems.TIN_LEGGINGS);
                        entries.add(ModItems.TIN_BOOTS);
                        entries.add(ModItems.TIN_SWORD);
                        entries.add(ModItems.TIN_PICKAXE);
                        entries.add(ModItems.TIN_AXE);
                        entries.add(ModItems.TIN_SHOVEL);
                        entries.add(ModItems.TIN_HOE);
                        
                        // Copper
                        entries.add(ModItems.COPPER_NUGGET);
                        entries.add(ModItems.COPPER_DUST);
                        entries.add(ModItems.COPPER_HELMET);
                        entries.add(ModItems.COPPER_CHESTPLATE);
                        entries.add(ModItems.COPPER_LEGGINGS);
                        entries.add(ModItems.COPPER_BOOTS);
                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_SHOVEL);
                        entries.add(ModItems.COPPER_HOE);

                        // Platinum
                        entries.add(ModItems.PLATINUM_INGOT);
                        entries.add(ModItems.PLATINUM_NUGGET);
                        entries.add(ModItems.PLATINUM_DUST);
                        entries.add(ModItems.RAW_PLATINUM);
                        entries.add(ModBlocks.PLATINUM_BLOCK);
                        entries.add(ModBlocks.PLATINUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PLATINUM_ORE);
                        entries.add(ModItems.PLATINUM_HELMET);
                        entries.add(ModItems.PLATINUM_CHESTPLATE);
                        entries.add(ModItems.PLATINUM_LEGGINGS);
                        entries.add(ModItems.PLATINUM_BOOTS);
                        entries.add(ModItems.PLATINUM_SWORD);
                        entries.add(ModItems.PLATINUM_PICKAXE);
                        entries.add(ModItems.PLATINUM_AXE);
                        entries.add(ModItems.PLATINUM_SHOVEL);
                        entries.add(ModItems.PLATINUM_HOE);
                        
                        // Sapphire
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.SAPPHIRE_DUST);
                        entries.add(ModItems.RAW_SAPPHIRE);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        entries.add(ModItems.SAPPHIRE_HELMET);
                        entries.add(ModItems.SAPPHIRE_CHESTPLATE);
                        entries.add(ModItems.SAPPHIRE_LEGGINGS);
                        entries.add(ModItems.SAPPHIRE_BOOTS);
                        entries.add(ModItems.SAPPHIRE_SWORD);
                        entries.add(ModItems.SAPPHIRE_PICKAXE);
                        entries.add(ModItems.SAPPHIRE_AXE);
                        entries.add(ModItems.SAPPHIRE_SHOVEL);
                        entries.add(ModItems.SAPPHIRE_HOE);
                        
                        // Ruby
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RUBY_DUST);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        
                        // Bronze
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.BRONZE_NUGGET);
                        entries.add(ModItems.BRONZE_DUST);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_HOE);
                        
                        // Other
                        entries.add(ModItems.RAW_DIAMOND);
                        entries.add(ModItems.DIAMOND_DUST);
                        entries.add(ModItems.RAW_EMERALD);
                        entries.add(ModItems.EMERALD_DUST);
                        entries.add(ModItems.RAW_LAPIS);
                        entries.add(ModItems.LAPIS_DUST);
                        entries.add(ModItems.IRON_DUST);
                        entries.add(ModItems.RAW_REDSTONE);
                        entries.add(ModItems.BATTERY);
                        entries.add(ModBlocks.EXPERIENCE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);

                        // Machines
                        entries.add(ModBlocks.CUTTING_STATION);
                        entries.add(ModBlocks.CUTTING_FACTORY);
                        entries.add(ModBlocks.CRUSHING_STATION);
                        entries.add(ModBlocks.CRUSHING_FACTORY);
                        entries.add(ModBlocks.COMBINING_STATION);
                        entries.add(ModBlocks.COMBINING_FACTORY);
                        entries.add(ModBlocks.COMBUSTION_GENERATOR);
                    }).build());

    public static void initialize() {
        // Initialize the class
    }
}
