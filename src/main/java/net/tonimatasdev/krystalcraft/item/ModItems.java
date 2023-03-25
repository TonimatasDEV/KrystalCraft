package net.tonimatasdev.krystalcraft.item;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KrystalCraft.MOD_ID);
    public static final DeferredRegister<Item> TOOL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KrystalCraft.MOD_ID);
    public static final DeferredRegister<Item> ARMOR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KrystalCraft.MOD_ID);

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HELMET = ARMOR_ITEMS.register("silver_helmet", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = ARMOR_ITEMS.register("silver_chestplate", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SILVER_LEGGINGS = ARMOR_ITEMS.register("silver_leggings", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SILVER_BOOTS = ARMOR_ITEMS.register("silver_boots", () -> new ArmorItem(ModArmorTier.SILVER, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SILVER_SWORD = TOOL_ITEMS.register("silver_sword", () -> new SwordItem(ModItemTier.SILVER, 4, -2.4F, new SwordItem.Properties()));
    public static final RegistryObject<Item> SILVER_PICKAXE = TOOL_ITEMS.register("silver_pickaxe", () -> new PickaxeItem(ModItemTier.SILVER, 3, -2.8F, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> SILVER_AXE = TOOL_ITEMS.register("silver_axe", () -> new AxeItem(ModItemTier.SILVER, 8, -3.1F, new AxeItem.Properties()));
    public static final RegistryObject<Item> SILVER_SHOVEL = TOOL_ITEMS.register("silver_shovel", () -> new ShovelItem(ModItemTier.SILVER, 4, -3.0F, new ShovelItem.Properties()));
    public static final RegistryObject<Item> SILVER_HOE = TOOL_ITEMS.register("silver_hoe", () -> new HoeItem(ModItemTier.SILVER, 0, -1.0F, new HoeItem.Properties()));

//------------------------------------------------------------------------------------------------------------------Jade
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE_DUST = ITEMS.register("jade_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_JADE = ITEMS.register("raw_jade", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE_HELMET = ARMOR_ITEMS.register("jade_helmet", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> JADE_CHESTPLATE = ARMOR_ITEMS.register("jade_chestplate", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> JADE_LEGGINGS = ARMOR_ITEMS.register("jade_leggings", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> JADE_BOOTS = ARMOR_ITEMS.register("jade_boots", () -> new ArmorItem(ModArmorTier.JADE, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> JADE_HORSE_ARMOR = ARMOR_ITEMS.register("jade_horse_armor", () -> new HorseArmorItem(9, "jade", new HorseArmorItem.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JADE_SWORD = TOOL_ITEMS.register("jade_sword", () -> new SwordItem(ModItemTier.JADE, 4, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> JADE_PICKAXE = TOOL_ITEMS.register("jade_pickaxe", () -> new PickaxeItem(ModItemTier.JADE, 3, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> JADE_AXE = TOOL_ITEMS.register("jade_axe", () -> new AxeItem(ModItemTier.JADE, 6, -3.1f, new AxeItem.Properties()));
    public static final RegistryObject<Item> JADE_SHOVEL = TOOL_ITEMS.register("jade_shovel", () -> new ShovelItem(ModItemTier.JADE, 1, -3.4f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> JADE_HOE = TOOL_ITEMS.register("jade_hoe", () -> new HoeItem(ModItemTier.JADE, -1, -1f, new HoeItem.Properties()));

    //-------------------------------------------------------------------------------------------------------------Topaz
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_DUST = ITEMS.register("topaz_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TOPAZ = ITEMS.register("raw_topaz", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_HELMET = ARMOR_ITEMS.register("topaz_helmet", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_CHESTPLATE = ARMOR_ITEMS.register("topaz_chestplate", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_LEGGINGS = ARMOR_ITEMS.register("topaz_leggings", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_BOOTS = ARMOR_ITEMS.register("topaz_boots", () -> new ArmorItem(ModArmorTier.TOPAZ, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_SWORD = TOOL_ITEMS.register("topaz_sword", () -> new SwordItem(ModItemTier.TOPAZ, 3, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_PICKAXE = TOOL_ITEMS.register("topaz_pickaxe", () -> new PickaxeItem(ModItemTier.TOPAZ, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_AXE = TOOL_ITEMS.register("topaz_axe", () -> new AxeItem(ModItemTier.TOPAZ, 5, -3.1f, new AxeItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_SHOVEL = TOOL_ITEMS.register("topaz_shovel", () -> new ShovelItem(ModItemTier.TOPAZ, 0, -3.4f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> TOPAZ_HOE = TOOL_ITEMS.register("topaz_hoe", () -> new HoeItem(ModItemTier.TOPAZ, -1, -1f, new HoeItem.Properties()));

    //--------------------------------------------------------------------------------------------------------------Lead
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_HELMET = ARMOR_ITEMS.register("lead_helmet", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> LEAD_CHESTPLATE = ARMOR_ITEMS.register("lead_chestplate", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> LEAD_LEGGINGS = ARMOR_ITEMS.register("lead_leggings", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> LEAD_BOOTS = ARMOR_ITEMS.register("lead_boots", () -> new ArmorItem(ModArmorTier.LEAD, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> LEAD_SWORD = TOOL_ITEMS.register("lead_sword", () -> new SwordItem(ModItemTier.LEAD, 6, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> LEAD_PICKAXE = TOOL_ITEMS.register("lead_pickaxe", () -> new PickaxeItem(ModItemTier.LEAD, 3, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> LEAD_AXE = TOOL_ITEMS.register("lead_axe", () -> new AxeItem(ModItemTier.LEAD, 8, -3.1f, new AxeItem.Properties()));
    public static final RegistryObject<Item> LEAD_SHOVEL = TOOL_ITEMS.register("lead_shovel", () -> new ShovelItem(ModItemTier.LEAD, 4, -3.0f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> LEAD_HOE = TOOL_ITEMS.register("lead_hoe", () -> new HoeItem(ModItemTier.LEAD, 0, -1f, new HoeItem.Properties()));

//-------------------------------------------------------------------------------------------------------------------Tin
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_HELMET = ARMOR_ITEMS.register("tin_helmet", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TIN_CHESTPLATE = ARMOR_ITEMS.register("tin_chestplate", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TIN_LEGGINGS = ARMOR_ITEMS.register("tin_leggings", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TIN_BOOTS = ARMOR_ITEMS.register("tin_boots", () -> new ArmorItem(ModArmorTier.TIN, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> TIN_SWORD = TOOL_ITEMS.register("tin_sword", () -> new SwordItem(ModItemTier.TIN, 3, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> TIN_PICKAXE = TOOL_ITEMS.register("tin_pickaxe", () -> new PickaxeItem(ModItemTier.TIN, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> TIN_AXE = TOOL_ITEMS.register("tin_axe", () -> new AxeItem(ModItemTier.TIN, 8.0F, -3.2f, new AxeItem.Properties()));
    public static final RegistryObject<Item> TIN_SHOVEL = TOOL_ITEMS.register("tin_shovel", () -> new ShovelItem(ModItemTier.TIN, 3.0F, -3.0f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> TIN_HOE = TOOL_ITEMS.register("tin_hoe", () -> new HoeItem(ModItemTier.TIN, 0, -2.0F, new HoeItem.Properties()));

//----------------------------------------------------------------------------------------------------------------Copper
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HELMET = ARMOR_ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ARMOR_ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ARMOR_ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ARMOR_ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorTier.COPPER, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = TOOL_ITEMS.register("copper_sword", () -> new SwordItem(ModItemTier.COPPER, 4, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = TOOL_ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = TOOL_ITEMS.register("copper_axe", () -> new AxeItem(ModItemTier.COPPER, 8.0F, -3.2f, new AxeItem.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = TOOL_ITEMS.register("copper_shovel", () -> new ShovelItem(ModItemTier.COPPER, 3.0F, -3.0f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = TOOL_ITEMS.register("copper_hoe", () -> new HoeItem(ModItemTier.COPPER, 0, -2.0F, new HoeItem.Properties()));

//--------------------------------------------------------------------------------------------------------------Platinum
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_HELMET = ARMOR_ITEMS.register("platinum_helmet", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ARMOR_ITEMS.register("platinum_chestplate", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ARMOR_ITEMS.register("platinum_leggings", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ARMOR_ITEMS.register("platinum_boots", () -> new ArmorItem(ModArmorTier.PLATINUM, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_SWORD = TOOL_ITEMS.register("platinum_sword", () -> new SwordItem(ModItemTier.PLATINUM, 7, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = TOOL_ITEMS.register("platinum_pickaxe", () -> new PickaxeItem(ModItemTier.PLATINUM, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_AXE = TOOL_ITEMS.register("platinum_axe", () -> new AxeItem(ModItemTier.PLATINUM, 8.0F, -3.0f, new AxeItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = TOOL_ITEMS.register("platinum_shovel", () -> new ShovelItem(ModItemTier.PLATINUM, 5.0F, -3.0f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> PLATINUM_HOE = TOOL_ITEMS.register("platinum_hoe", () -> new HoeItem(ModItemTier.PLATINUM, 0, 0.0F, new HoeItem.Properties()));

//--------------------------------------------------------------------------------------------------------------Sapphire

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ARMOR_ITEMS.register("sapphire_helmet", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ARMOR_ITEMS.register("sapphire_chestplate", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ARMOR_ITEMS.register("sapphire_leggings", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ARMOR_ITEMS.register("sapphire_boots", () -> new ArmorItem(ModArmorTier.SAPPHIRE, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = TOOL_ITEMS.register("sapphire_sword", () -> new SwordItem(ModItemTier.SAPPHIRE, 3, -2.4f, new SwordItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = TOOL_ITEMS.register("sapphire_pickaxe", () -> new PickaxeItem(ModItemTier.SAPPHIRE, 2, -2.8f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = TOOL_ITEMS.register("sapphire_axe", () -> new AxeItem(ModItemTier.SAPPHIRE, 5, -3.1f, new AxeItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = TOOL_ITEMS.register("sapphire_shovel", () -> new ShovelItem(ModItemTier.SAPPHIRE, 0, -3.4f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = TOOL_ITEMS.register("sapphire_hoe", () -> new HoeItem(ModItemTier.SAPPHIRE, -1, -1f, new HoeItem.Properties()));

//--------------------------------------------------------------------------------------------------------------Sapphire
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_DUST = ITEMS.register("ruby_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HELMET = ARMOR_ITEMS.register("ruby_helmet", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ARMOR_ITEMS.register("ruby_chestplate", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ARMOR_ITEMS.register("ruby_leggings", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ARMOR_ITEMS.register("ruby_boots", () -> new ArmorItem(ModArmorTier.RUBY, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> RUBY_SWORD = TOOL_ITEMS.register("ruby_sword", () -> new SwordItem(ModItemTier.RUBY, 3, -2.6f, new SwordItem.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = TOOL_ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModItemTier.RUBY, 2, -3.0f, new PickaxeItem.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = TOOL_ITEMS.register("ruby_axe", () -> new AxeItem(ModItemTier.RUBY, 5, -3.3f, new AxeItem.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = TOOL_ITEMS.register("ruby_shovel", () -> new ShovelItem(ModItemTier.RUBY, 0, -3.6f, new ShovelItem.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = TOOL_ITEMS.register("ruby_hoe", () -> new HoeItem(ModItemTier.RUBY, -1, -1f, new HoeItem.Properties()));

//----------------------------------------------------------------------------------------------------------------Bronze
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_HELMET = ARMOR_ITEMS.register("bronze_helmet", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.HELMET, new ArmorItem.Properties()));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = ARMOR_ITEMS.register("bronze_chestplate", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.CHESTPLATE, new ArmorItem.Properties()));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = ARMOR_ITEMS.register("bronze_leggings", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.LEGGINGS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> BRONZE_BOOTS = ARMOR_ITEMS.register("bronze_boots", () -> new ArmorItem(ModArmorTier.BRONZE, ArmorItem.Type.BOOTS, new ArmorItem.Properties()));
    public static final RegistryObject<Item> BRONZE_SWORD = TOOL_ITEMS.register("bronze_sword", () -> new SwordItem(ModItemTier.BRONZE, 4, -2.4F, (new SwordItem.Properties())));
    public static final RegistryObject<Item> BRONZE_PICKAXE = TOOL_ITEMS.register("bronze_pickaxe", () -> new PickaxeItem(ModItemTier.BRONZE, 3, -2.8F, (new PickaxeItem.Properties())));
    public static final RegistryObject<Item> BRONZE_AXE = TOOL_ITEMS.register("bronze_axe", () -> new AxeItem(ModItemTier.BRONZE, 8, -3.1F, new AxeItem.Properties()));
    public static final RegistryObject<Item> BRONZE_SHOVEL = TOOL_ITEMS.register("bronze_shovel", () -> new ShovelItem(ModItemTier.BRONZE, 4, -3.0F, new ShovelItem.Properties()));
    public static final RegistryObject<Item> BRONZE_HOE = TOOL_ITEMS.register("bronze_hoe", () -> new HoeItem(ModItemTier.BRONZE, 0, -1.0F, new HoeItem.Properties()));

//-----------------------------------------------------------------------------------------------------------------Items
    public static final RegistryObject<Item> RAW_DIAMOND = ITEMS.register("raw_diamond", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_EMERALD = ITEMS.register("raw_emerald", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LAPIS = ITEMS.register("raw_lapis", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_REDSTONE = ITEMS.register("raw_redstone", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_CUTTER_TOOL = ITEMS.register("gem_cutter_tool", () -> new Item(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> SET_WATER_BOTTLES = ITEMS.register("set_water_bottles", () -> new Item(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> GRINDING_GEAR = ITEMS.register("grinding_gear", () -> new Item(new Item.Properties().durability(512)));
}
