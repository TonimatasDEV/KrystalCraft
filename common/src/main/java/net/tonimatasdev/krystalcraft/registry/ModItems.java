package net.tonimatasdev.krystalcraft.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.item.*;
import net.tonimatasdev.krystalcraft.item.custom.BatteryItem;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistries;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;

public class ModItems {
    public static final PlorixRegistry<Item> ITEMS = PlorixRegistries.create(BuiltInRegistries.ITEM, KrystalCraft.MOD_ID);

    public static final RegistryEntry<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> SILVER_DUST = ITEMS.register("silver_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> SILVER_HELMET = ITEMS.register("silver_helmet", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SILVER_BOOTS = ITEMS.register("silver_boots", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SILVER_SWORD = ITEMS.register("silver_sword", () -> new SwordItem(ModItemTier.SILVER, 4, -2.4F, new SwordItem.Properties()));
    public static final RegistryEntry<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () -> new ModPickaxeItem(ModItemTier.SILVER, 3, -2.8F, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> SILVER_AXE = ITEMS.register("silver_axe", () -> new ModAxeItem(ModItemTier.SILVER, 8, -3.1F, new AxeItem.Properties()));
    public static final RegistryEntry<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () -> new ShovelItem(ModItemTier.SILVER, 4, -3.0F, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> SILVER_HOE = ITEMS.register("silver_hoe", () -> new ModHoeItem(ModItemTier.SILVER, 0, -1.0F, new HoeItem.Properties()));

//------------------------------------------------------------------------------------------------------------------Jade
    public static final RegistryEntry<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> JADE_DUST = ITEMS.register("jade_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_JADE = ITEMS.register("raw_jade", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> JADE_HELMET = ITEMS.register("jade_helmet", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> JADE_BOOTS = ITEMS.register("jade_boots", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> JADE_SWORD = ITEMS.register("jade_sword", () -> new SwordItem(ModItemTier.JADE, 4, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> new ModPickaxeItem(ModItemTier.JADE, 3, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> JADE_AXE = ITEMS.register("jade_axe", () -> new ModAxeItem(ModItemTier.JADE, 6, -3.1f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> new ShovelItem(ModItemTier.JADE, 1, -3.4f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> JADE_HOE = ITEMS.register("jade_hoe", () -> new ModHoeItem(ModItemTier.JADE, -1, -1f, new HoeItem.Properties()));

    //-------------------------------------------------------------------------------------------------------------Topaz
    public static final RegistryEntry<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> TOPAZ_DUST = ITEMS.register("topaz_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_TOPAZ = ITEMS.register("raw_topaz", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> TOPAZ_HELMET = ITEMS.register("topaz_helmet", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_CHESTPLATE = ITEMS.register("topaz_chestplate", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_LEGGINGS = ITEMS.register("topaz_leggings", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_BOOTS = ITEMS.register("topaz_boots", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_SWORD = ITEMS.register("topaz_sword", () -> new SwordItem(ModItemTier.TOPAZ, 3, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_PICKAXE = ITEMS.register("topaz_pickaxe", () -> new ModPickaxeItem(ModItemTier.TOPAZ, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_AXE = ITEMS.register("topaz_axe", () -> new ModAxeItem(ModItemTier.TOPAZ, 5, -3.1f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_SHOVEL = ITEMS.register("topaz_shovel", () -> new ShovelItem(ModItemTier.TOPAZ, 0, -3.4f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> TOPAZ_HOE = ITEMS.register("topaz_hoe", () -> new ModHoeItem(ModItemTier.TOPAZ, -1, -1f, new HoeItem.Properties()));

    //--------------------------------------------------------------------------------------------------------------Lead
    public static final RegistryEntry<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> LEAD_DUST = ITEMS.register("lead_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_LEAD = ITEMS.register("raw_lead", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> LEAD_HELMET = ITEMS.register("lead_helmet", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> LEAD_CHESTPLATE = ITEMS.register("lead_chestplate", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> LEAD_LEGGINGS = ITEMS.register("lead_leggings", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> LEAD_BOOTS = ITEMS.register("lead_boots", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> LEAD_SWORD = ITEMS.register("lead_sword", () -> new SwordItem(ModItemTier.LEAD, 6, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> LEAD_PICKAXE = ITEMS.register("lead_pickaxe", () -> new ModPickaxeItem(ModItemTier.LEAD, 3, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> LEAD_AXE = ITEMS.register("lead_axe", () -> new ModAxeItem(ModItemTier.LEAD, 8, -3.1f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> LEAD_SHOVEL = ITEMS.register("lead_shovel", () -> new ShovelItem(ModItemTier.LEAD, 4, -3.0f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> LEAD_HOE = ITEMS.register("lead_hoe", () -> new ModHoeItem(ModItemTier.LEAD, 0, -1f, new HoeItem.Properties()));

//-------------------------------------------------------------------------------------------------------------------Tin
    public static final RegistryEntry<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> TIN_DUST = ITEMS.register("tin_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> TIN_NUGGET = ITEMS.register("tin_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> TIN_HELMET = ITEMS.register("tin_helmet", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TIN_CHESTPLATE = ITEMS.register("tin_chestplate", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TIN_LEGGINGS = ITEMS.register("tin_leggings", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TIN_BOOTS = ITEMS.register("tin_boots", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> TIN_SWORD = ITEMS.register("tin_sword", () -> new SwordItem(ModItemTier.TIN, 3, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> TIN_PICKAXE = ITEMS.register("tin_pickaxe", () -> new ModPickaxeItem(ModItemTier.TIN, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> TIN_AXE = ITEMS.register("tin_axe", () -> new ModAxeItem(ModItemTier.TIN, 8.0F, -3.2f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> TIN_SHOVEL = ITEMS.register("tin_shovel", () -> new ShovelItem(ModItemTier.TIN, 3.0F, -3.0f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> TIN_HOE = ITEMS.register("tin_hoe", () -> new ModHoeItem(ModItemTier.TIN, 0, -2.0F, new HoeItem.Properties()));

//----------------------------------------------------------------------------------------------------------------Copper
    public static final RegistryEntry<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ModItemTier.COPPER, 4, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new ModPickaxeItem(ModItemTier.COPPER, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new ModAxeItem(ModItemTier.COPPER, 8.0F, -3.2f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ModItemTier.COPPER, 3.0F, -3.0f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new ModHoeItem(ModItemTier.COPPER, 0, -2.0F, new HoeItem.Properties()));

//--------------------------------------------------------------------------------------------------------------Platinum
    public static final RegistryEntry<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_PLATINUM = ITEMS.register("raw_platinum", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () -> new SwordItem(ModItemTier.PLATINUM, 7, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () -> new ModPickaxeItem(ModItemTier.PLATINUM, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new ModAxeItem(ModItemTier.PLATINUM, 8.0F, -3.0f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () -> new ShovelItem(ModItemTier.PLATINUM, 5.0F, -3.0f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () -> new ModHoeItem(ModItemTier.PLATINUM, 0, 0.0F, new HoeItem.Properties()));

//--------------------------------------------------------------------------------------------------------------Sapphire

    public static final RegistryEntry<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SwordItem(ModItemTier.SAPPHIRE, 3, -2.4f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new ModPickaxeItem(ModItemTier.SAPPHIRE, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new ModAxeItem(ModItemTier.SAPPHIRE, 5, -3.1f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new ShovelItem(ModItemTier.SAPPHIRE, 0, -3.4f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new ModHoeItem(ModItemTier.SAPPHIRE, -1, -1f, new HoeItem.Properties()));

//--------------------------------------------------------------------------------------------------------------Sapphire
    public static final RegistryEntry<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RUBY_DUST = ITEMS.register("ruby_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ModItemTier.RUBY, 3, -2.6f, new SwordItem.Properties()));
    public static final RegistryEntry<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new ModPickaxeItem(ModItemTier.RUBY, 2, -3.0f, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new ModAxeItem(ModItemTier.RUBY, 5, -3.3f, new AxeItem.Properties()));
    public static final RegistryEntry<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ModItemTier.RUBY, 0, -3.6f, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new ModHoeItem(ModItemTier.RUBY, -1, -1f, new HoeItem.Properties()));

//----------------------------------------------------------------------------------------------------------------Bronze
    public static final RegistryEntry<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> BRONZE_DUST = ITEMS.register("bronze_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new SwordItem(ModItemTier.BRONZE, 4, -2.4F, new SwordItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new ModPickaxeItem(ModItemTier.BRONZE, 3, -2.8F, new PickaxeItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new ModAxeItem(ModItemTier.BRONZE, 8, -3.1F, new AxeItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () -> new ShovelItem(ModItemTier.BRONZE, 4, -3.0F, new ShovelItem.Properties()));
    public static final RegistryEntry<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () -> new ModHoeItem(ModItemTier.BRONZE, 0, -1.0F, new HoeItem.Properties()));

//-----------------------------------------------------------------------------------------------------------------Items
    public static final RegistryEntry<Item> RAW_DIAMOND = ITEMS.register("raw_diamond", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_EMERALD = ITEMS.register("raw_emerald", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> EMERALD_DUST = ITEMS.register("emerald_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_LAPIS = ITEMS.register("raw_lapis", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> RAW_REDSTONE = ITEMS.register("raw_redstone", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> BATTERY = ITEMS.register("battery", () -> new BatteryItem(new Item.Properties().stacksTo(1)));
}
