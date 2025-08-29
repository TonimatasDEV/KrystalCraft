package dev.tonimatas.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.item.ModArmorTier;
import dev.tonimatas.krystalcraft.item.ModItemTier;
import dev.tonimatas.krystalcraft.item.custom.BatteryItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {
    public static final Item SILVER_INGOT = register("silver_ingot", new Item(new Item.Settings()));
    public static final Item SILVER_DUST = register("silver_dust", new Item(new Item.Settings()));
    public static final Item RAW_SILVER = register("raw_silver", new Item(new Item.Settings()));
    public static final Item SILVER_NUGGET = register("silver_nugget", new Item(new Item.Settings()));
    public static final Item SILVER_HELMET = register("silver_helmet", new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item SILVER_CHESTPLATE = register("silver_chestplate", new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item SILVER_LEGGINGS = register("silver_leggings", new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item SILVER_BOOTS = register("silver_boots", new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item SILVER_SWORD = register("silver_sword", new SwordItem(ModItemTier.SILVER, 4, -2.4F, new SwordItem.Settings()));
    public static final Item SILVER_PICKAXE = register("silver_pickaxe", new PickaxeItem(ModItemTier.SILVER, 3, -2.8F, new PickaxeItem.Settings()));
    public static final Item SILVER_AXE = register("silver_axe", new AxeItem(ModItemTier.SILVER, 8, -3.1F, new AxeItem.Settings()));
    public static final Item SILVER_SHOVEL = register("silver_shovel", new ShovelItem(ModItemTier.SILVER, 4, -3.0F, new ShovelItem.Settings()));
    public static final Item SILVER_HOE = register("silver_hoe", new HoeItem(ModItemTier.SILVER, 0, -1.0F, new HoeItem.Settings()));

//------------------------------------------------------------------------------------------------------------------Jade
    public static final Item JADE = register("jade", new Item(new Item.Settings()));
    public static final Item JADE_DUST = register("jade_dust", new Item(new Item.Settings()));
    public static final Item RAW_JADE = register("raw_jade", new Item(new Item.Settings()));
    public static final Item JADE_HELMET = register("jade_helmet", new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item JADE_CHESTPLATE = register("jade_chestplate", new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item JADE_LEGGINGS = register("jade_leggings", new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item JADE_BOOTS = register("jade_boots", new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item JADE_SWORD = register("jade_sword", new SwordItem(ModItemTier.JADE, 4, -2.4f, new SwordItem.Settings()));
    public static final Item JADE_PICKAXE = register("jade_pickaxe", new PickaxeItem(ModItemTier.JADE, 3, -2.8f, new PickaxeItem.Settings()));
    public static final Item JADE_AXE = register("jade_axe", new AxeItem(ModItemTier.JADE, 6, -3.1f, new AxeItem.Settings()));
    public static final Item JADE_SHOVEL = register("jade_shovel", new ShovelItem(ModItemTier.JADE, 1, -3.4f, new ShovelItem.Settings()));
    public static final Item JADE_HOE = register("jade_hoe", new HoeItem(ModItemTier.JADE, -1, -1f, new HoeItem.Settings()));

    //-------------------------------------------------------------------------------------------------------------Topaz
    public static final Item TOPAZ = register("topaz", new Item(new Item.Settings()));
    public static final Item TOPAZ_DUST = register("topaz_dust", new Item(new Item.Settings()));
    public static final Item RAW_TOPAZ = register("raw_topaz", new Item(new Item.Settings()));
    public static final Item TOPAZ_HELMET = register("topaz_helmet", new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item TOPAZ_CHESTPLATE = register("topaz_chestplate", new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item TOPAZ_LEGGINGS = register("topaz_leggings", new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item TOPAZ_BOOTS = register("topaz_boots", new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item TOPAZ_SWORD = register("topaz_sword", new SwordItem(ModItemTier.TOPAZ, 3, -2.4f, new SwordItem.Settings()));
    public static final Item TOPAZ_PICKAXE = register("topaz_pickaxe", new PickaxeItem(ModItemTier.TOPAZ, 2, -2.8f, new PickaxeItem.Settings()));
    public static final Item TOPAZ_AXE = register("topaz_axe", new AxeItem(ModItemTier.TOPAZ, 5, -3.1f, new AxeItem.Settings()));
    public static final Item TOPAZ_SHOVEL = register("topaz_shovel", new ShovelItem(ModItemTier.TOPAZ, 0, -3.4f, new ShovelItem.Settings()));
    public static final Item TOPAZ_HOE = register("topaz_hoe", new HoeItem(ModItemTier.TOPAZ, -1, -1f, new HoeItem.Settings()));

    //--------------------------------------------------------------------------------------------------------------Lead
    public static final Item LEAD_INGOT = register("lead_ingot", new Item(new Item.Settings()));
    public static final Item LEAD_DUST = register("lead_dust", new Item(new Item.Settings()));
    public static final Item RAW_LEAD = register("raw_lead", new Item(new Item.Settings()));
    public static final Item LEAD_NUGGET = register("lead_nugget", new Item(new Item.Settings()));
    public static final Item LEAD_HELMET = register("lead_helmet", new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item LEAD_CHESTPLATE = register("lead_chestplate", new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item LEAD_LEGGINGS = register("lead_leggings", new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item LEAD_BOOTS = register("lead_boots", new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item LEAD_SWORD = register("lead_sword", new SwordItem(ModItemTier.LEAD, 6, -2.4f, new SwordItem.Settings()));
    public static final Item LEAD_PICKAXE = register("lead_pickaxe", new PickaxeItem(ModItemTier.LEAD, 3, -2.8f, new PickaxeItem.Settings()));
    public static final Item LEAD_AXE = register("lead_axe", new AxeItem(ModItemTier.LEAD, 8, -3.1f, new AxeItem.Settings()));
    public static final Item LEAD_SHOVEL = register("lead_shovel", new ShovelItem(ModItemTier.LEAD, 4, -3.0f, new ShovelItem.Settings()));
    public static final Item LEAD_HOE = register("lead_hoe", new HoeItem(ModItemTier.LEAD, 0, -1f, new HoeItem.Settings()));

//-------------------------------------------------------------------------------------------------------------------Tin
    public static final Item TIN_INGOT = register("tin_ingot", new Item(new Item.Settings()));
    public static final Item TIN_DUST = register("tin_dust", new Item(new Item.Settings()));
    public static final Item RAW_TIN = register("raw_tin", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = register("tin_nugget", new Item(new Item.Settings()));
    public static final Item TIN_HELMET = register("tin_helmet", new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item TIN_CHESTPLATE = register("tin_chestplate", new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item TIN_LEGGINGS = register("tin_leggings", new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item TIN_BOOTS = register("tin_boots", new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item TIN_SWORD = register("tin_sword", new SwordItem(ModItemTier.TIN, 3, -2.4f, new SwordItem.Settings()));
    public static final Item TIN_PICKAXE = register("tin_pickaxe", new PickaxeItem(ModItemTier.TIN, 2, -2.8f, new PickaxeItem.Settings()));
    public static final Item TIN_AXE = register("tin_axe", new AxeItem(ModItemTier.TIN, 8.0F, -3.2f, new AxeItem.Settings()));
    public static final Item TIN_SHOVEL = register("tin_shovel", new ShovelItem(ModItemTier.TIN, 3.0F, -3.0f, new ShovelItem.Settings()));
    public static final Item TIN_HOE = register("tin_hoe", new HoeItem(ModItemTier.TIN, 0, -2.0F, new HoeItem.Settings()));

//----------------------------------------------------------------------------------------------------------------Copper
    public static final Item COPPER_NUGGET = register("copper_nugget", new Item(new Item.Settings()));
    public static final Item COPPER_DUST = register("copper_dust", new Item(new Item.Settings()));
    public static final Item COPPER_HELMET = register("copper_helmet", new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item COPPER_LEGGINGS = register("copper_leggings", new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item COPPER_BOOTS = register("copper_boots", new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item COPPER_SWORD = register("copper_sword", new SwordItem(ModItemTier.COPPER, 4, -2.4f, new SwordItem.Settings()));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", new PickaxeItem(ModItemTier.COPPER, 2, -2.8f, new PickaxeItem.Settings()));
    public static final Item COPPER_AXE = register("copper_axe", new AxeItem(ModItemTier.COPPER, 8.0F, -3.2f, new AxeItem.Settings()));
    public static final Item COPPER_SHOVEL = register("copper_shovel", new ShovelItem(ModItemTier.COPPER, 3.0F, -3.0f, new ShovelItem.Settings()));
    public static final Item COPPER_HOE = register("copper_hoe", new HoeItem(ModItemTier.COPPER, 0, -2.0F, new HoeItem.Settings()));

//--------------------------------------------------------------------------------------------------------------Platinum
    public static final Item PLATINUM_INGOT = register("platinum_ingot", new Item(new Item.Settings()));
    public static final Item PLATINUM_DUST = register("platinum_dust", new Item(new Item.Settings()));
    public static final Item RAW_PLATINUM = register("raw_platinum", new Item(new Item.Settings()));
    public static final Item PLATINUM_NUGGET = register("platinum_nugget", new Item(new Item.Settings()));
    public static final Item PLATINUM_HELMET = register("platinum_helmet", new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item PLATINUM_CHESTPLATE = register("platinum_chestplate", new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item PLATINUM_LEGGINGS = register("platinum_leggings", new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item PLATINUM_BOOTS = register("platinum_boots", new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item PLATINUM_SWORD = register("platinum_sword", new SwordItem(ModItemTier.PLATINUM, 7, -2.4f, new SwordItem.Settings()));
    public static final Item PLATINUM_PICKAXE = register("platinum_pickaxe", new PickaxeItem(ModItemTier.PLATINUM, 2, -2.8f, new PickaxeItem.Settings()));
    public static final Item PLATINUM_AXE = register("platinum_axe", new AxeItem(ModItemTier.PLATINUM, 8.0F, -3.0f, new AxeItem.Settings()));
    public static final Item PLATINUM_SHOVEL = register("platinum_shovel", new ShovelItem(ModItemTier.PLATINUM, 5.0F, -3.0f, new ShovelItem.Settings()));
    public static final Item PLATINUM_HOE = register("platinum_hoe", new HoeItem(ModItemTier.PLATINUM, 0, 0.0F, new HoeItem.Settings()));

//--------------------------------------------------------------------------------------------------------------Sapphire

    public static final Item SAPPHIRE = register("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_DUST = register("sapphire_dust", new Item(new Item.Settings()));
    public static final Item RAW_SAPPHIRE = register("raw_sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_HELMET = register("sapphire_helmet", new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item SAPPHIRE_CHESTPLATE = register("sapphire_chestplate", new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item SAPPHIRE_LEGGINGS = register("sapphire_leggings", new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item SAPPHIRE_BOOTS = register("sapphire_boots", new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item SAPPHIRE_SWORD = register("sapphire_sword", new SwordItem(ModItemTier.SAPPHIRE, 3, -2.4f, new SwordItem.Settings()));
    public static final Item SAPPHIRE_PICKAXE = register("sapphire_pickaxe", new PickaxeItem(ModItemTier.SAPPHIRE, 2, -2.8f, new PickaxeItem.Settings()));
    public static final Item SAPPHIRE_AXE = register("sapphire_axe", new AxeItem(ModItemTier.SAPPHIRE, 5, -3.1f, new AxeItem.Settings()));
    public static final Item SAPPHIRE_SHOVEL = register("sapphire_shovel", new ShovelItem(ModItemTier.SAPPHIRE, 0, -3.4f, new ShovelItem.Settings()));
    public static final Item SAPPHIRE_HOE = register("sapphire_hoe", new HoeItem(ModItemTier.SAPPHIRE, -1, -1f, new HoeItem.Settings()));

//--------------------------------------------------------------------------------------------------------------Sapphire
    public static final Item RUBY = register("ruby", new Item(new Item.Settings()));
    public static final Item RUBY_DUST = register("ruby_dust", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = register("raw_ruby", new Item(new Item.Settings()));
    public static final Item RUBY_HELMET = register("ruby_helmet", new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item RUBY_LEGGINGS = register("ruby_leggings", new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item RUBY_BOOTS = register("ruby_boots", new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item RUBY_SWORD = register("ruby_sword", new SwordItem(ModItemTier.RUBY, 3, -2.6f, new SwordItem.Settings()));
    public static final Item RUBY_PICKAXE = register("ruby_pickaxe", new PickaxeItem(ModItemTier.RUBY, 2, -3.0f, new PickaxeItem.Settings()));
    public static final Item RUBY_AXE = register("ruby_axe", new AxeItem(ModItemTier.RUBY, 5, -3.3f, new AxeItem.Settings()));
    public static final Item RUBY_SHOVEL = register("ruby_shovel", new ShovelItem(ModItemTier.RUBY, 0, -3.6f, new ShovelItem.Settings()));
    public static final Item RUBY_HOE = register("ruby_hoe", new HoeItem(ModItemTier.RUBY, -1, -1f, new HoeItem.Settings()));

//----------------------------------------------------------------------------------------------------------------Bronze
    public static final Item BRONZE_INGOT = register("bronze_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_DUST = register("bronze_dust", new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = register("bronze_nugget", new Item(new Item.Settings()));
    public static final Item BRONZE_HELMET = register("bronze_helmet", new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.HELMET, new ArmorItem.Settings()));
    public static final Item BRONZE_CHESTPLATE = register("bronze_chestplate", new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Settings()));
    public static final Item BRONZE_LEGGINGS = register("bronze_leggings", new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.LEGGINGS, new ArmorItem.Settings()));
    public static final Item BRONZE_BOOTS = register("bronze_boots", new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.BOOTS, new ArmorItem.Settings()));
    public static final Item BRONZE_SWORD = register("bronze_sword", new SwordItem(ModItemTier.BRONZE, 4, -2.4F, new SwordItem.Settings()));
    public static final Item BRONZE_PICKAXE = register("bronze_pickaxe", new PickaxeItem(ModItemTier.BRONZE, 3, -2.8F, new PickaxeItem.Settings()));
    public static final Item BRONZE_AXE = register("bronze_axe", new AxeItem(ModItemTier.BRONZE, 8, -3.1F, new AxeItem.Settings()));
    public static final Item BRONZE_SHOVEL = register("bronze_shovel", new ShovelItem(ModItemTier.BRONZE, 4, -3.0F, new ShovelItem.Settings()));
    public static final Item BRONZE_HOE = register("bronze_hoe", new HoeItem(ModItemTier.BRONZE, 0, -1.0F, new HoeItem.Settings()));

//-----------------------------------------------------------------------------------------------------------------Items
    public static final Item RAW_DIAMOND = register("raw_diamond", new Item(new Item.Settings()));
    public static final Item DIAMOND_DUST = register("diamond_dust", new Item(new Item.Settings()));
    public static final Item RAW_EMERALD = register("raw_emerald", new Item(new Item.Settings()));
    public static final Item EMERALD_DUST = register("emerald_dust", new Item(new Item.Settings()));
    public static final Item RAW_LAPIS = register("raw_lapis", new Item(new Item.Settings()));
    public static final Item LAPIS_DUST = register("lapis_dust", new Item(new Item.Settings()));
    public static final Item IRON_DUST = register("iron_dust", new Item(new Item.Settings()));
    public static final Item RAW_REDSTONE = register("raw_redstone", new Item(new Item.Settings()));
    public static final Item BATTERY = register("battery", new BatteryItem(new Item.Settings().stacksTo(1)));

    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(KrystalCraft.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
    
    public static void initialize() {
        // Initialize the class
    }
}
