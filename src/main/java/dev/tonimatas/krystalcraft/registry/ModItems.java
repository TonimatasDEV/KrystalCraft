package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.item.BatteryItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyItem;

public class ModItems {
    public static final Item SILVER_INGOT = register("silver_ingot", new Item(new Item.Settings()));
    public static final Item SILVER_NUGGET = register("silver_nugget", new Item(new Item.Settings()));
    public static final Item SILVER_DUST = register("silver_dust", new Item(new Item.Settings()));
    public static final Item RAW_SILVER = register("raw_silver", new Item(new Item.Settings()));
    public static final Item SILVER_HELMET = register("silver_helmet", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item SILVER_CHESTPLATE = register("silver_chestplate", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item SILVER_LEGGINGS = register("silver_leggings", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item SILVER_BOOTS = register("silver_boots", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item SILVER_SWORD = register("silver_sword", new SwordItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.SILVER, 4, -2.4F))));
    public static final Item SILVER_PICKAXE = register("silver_pickaxe", new PickaxeItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.SILVER, 3, -2.8F))));
    public static final Item SILVER_AXE = register("silver_axe", new AxeItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.SILVER, 8, -3.1F))));
    public static final Item SILVER_SHOVEL = register("silver_shovel", new ShovelItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.SILVER, 4, -3.0F))));
    public static final Item SILVER_HOE = register("silver_hoe", new HoeItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.SILVER, 0, -1.0F))));

    //------------------------------------------------------------------------------------------------------------------Jade
    public static final Item JADE = register("jade", new Item(new Item.Settings()));
    public static final Item JADE_DUST = register("jade_dust", new Item(new Item.Settings()));
    public static final Item RAW_JADE = register("raw_jade", new Item(new Item.Settings()));
    public static final Item JADE_HELMET = register("jade_helmet", new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item JADE_CHESTPLATE = register("jade_chestplate", new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item JADE_LEGGINGS = register("jade_leggings", new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item JADE_BOOTS = register("jade_boots", new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item JADE_SWORD = register("jade_sword", new SwordItem(ModToolMaterials.JADE, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.JADE, 4, -2.4f))));
    public static final Item JADE_PICKAXE = register("jade_pickaxe", new PickaxeItem(ModToolMaterials.JADE, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.JADE, 3, -2.8f))));
    public static final Item JADE_AXE = register("jade_axe", new AxeItem(ModToolMaterials.JADE, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.JADE, 6, -3.1f))));
    public static final Item JADE_SHOVEL = register("jade_shovel", new ShovelItem(ModToolMaterials.JADE, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.JADE, 1, -3.4f))));
    public static final Item JADE_HOE = register("jade_hoe", new HoeItem(ModToolMaterials.JADE, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.JADE, -1, -1f))));

    //-------------------------------------------------------------------------------------------------------------Topaz
    public static final Item TOPAZ = register("topaz", new Item(new Item.Settings()));
    public static final Item TOPAZ_DUST = register("topaz_dust", new Item(new Item.Settings()));
    public static final Item RAW_TOPAZ = register("raw_topaz", new Item(new Item.Settings()));
    public static final Item TOPAZ_HELMET = register("topaz_helmet", new ArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item TOPAZ_CHESTPLATE = register("topaz_chestplate", new ArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item TOPAZ_LEGGINGS = register("topaz_leggings", new ArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item TOPAZ_BOOTS = register("topaz_boots", new ArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item TOPAZ_SWORD = register("topaz_sword", new SwordItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 3, -2.4f))));
    public static final Item TOPAZ_PICKAXE = register("topaz_pickaxe", new PickaxeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 2, -2.8f))));
    public static final Item TOPAZ_AXE = register("topaz_axe", new AxeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 5, -3.1f))));
    public static final Item TOPAZ_SHOVEL = register("topaz_shovel", new ShovelItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 0, -3.4f))));
    public static final Item TOPAZ_HOE = register("topaz_hoe", new HoeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.TOPAZ, -1, -1f))));

    //--------------------------------------------------------------------------------------------------------------Lead
    public static final Item LEAD_INGOT = register("lead_ingot", new Item(new Item.Settings()));
    public static final Item LEAD_NUGGET = register("lead_nugget", new Item(new Item.Settings()));
    public static final Item LEAD_DUST = register("lead_dust", new Item(new Item.Settings()));
    public static final Item RAW_LEAD = register("raw_lead", new Item(new Item.Settings()));
    public static final Item LEAD_HELMET = register("lead_helmet", new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item LEAD_CHESTPLATE = register("lead_chestplate", new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item LEAD_LEGGINGS = register("lead_leggings", new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item LEAD_BOOTS = register("lead_boots", new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item LEAD_SWORD = register("lead_sword", new SwordItem(ModToolMaterials.LEAD, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.LEAD, 6, -2.4f))));
    public static final Item LEAD_PICKAXE = register("lead_pickaxe", new PickaxeItem(ModToolMaterials.LEAD, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.LEAD, 3, -2.8f))));
    public static final Item LEAD_AXE = register("lead_axe", new AxeItem(ModToolMaterials.LEAD, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.LEAD, 8, -3.1f))));
    public static final Item LEAD_SHOVEL = register("lead_shovel", new ShovelItem(ModToolMaterials.LEAD, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.LEAD, 4, -3.0f))));
    public static final Item LEAD_HOE = register("lead_hoe", new HoeItem(ModToolMaterials.LEAD, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.LEAD, 0, -1f))));

    //-------------------------------------------------------------------------------------------------------------------Tin
    public static final Item TIN_INGOT = register("tin_ingot", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = register("tin_nugget", new Item(new Item.Settings()));
    public static final Item TIN_DUST = register("tin_dust", new Item(new Item.Settings()));
    public static final Item RAW_TIN = register("raw_tin", new Item(new Item.Settings()));
    public static final Item TIN_HELMET = register("tin_helmet", new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item TIN_CHESTPLATE = register("tin_chestplate", new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item TIN_LEGGINGS = register("tin_leggings", new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item TIN_BOOTS = register("tin_boots", new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item TIN_SWORD = register("tin_sword", new SwordItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.TIN, 3, -2.4f))));
    public static final Item TIN_PICKAXE = register("tin_pickaxe", new PickaxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.TIN, 2, -2.8f))));
    public static final Item TIN_AXE = register("tin_axe", new AxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.TIN, 8.0F, -3.2f))));
    public static final Item TIN_SHOVEL = register("tin_shovel", new ShovelItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.TIN, 3.0F, -3.0f))));
    public static final Item TIN_HOE = register("tin_hoe", new HoeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.TIN, 0, -2.0F))));

    //----------------------------------------------------------------------------------------------------------------Copper
    public static final Item COPPER_NUGGET = register("copper_nugget", new Item(new Item.Settings()));
    public static final Item COPPER_DUST = register("copper_dust", new Item(new Item.Settings()));
    public static final Item COPPER_HELMET = register("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item COPPER_LEGGINGS = register("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item COPPER_BOOTS = register("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item COPPER_SWORD = register("copper_sword", new SwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 4, -2.4f))));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 2, -2.8f))));
    public static final Item COPPER_AXE = register("copper_axe", new AxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 8.0F, -3.2f))));
    public static final Item COPPER_SHOVEL = register("copper_shovel", new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER, 3.0F, -3.0f))));
    public static final Item COPPER_HOE = register("copper_hoe", new HoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.COPPER, 0, -2.0F))));

    //--------------------------------------------------------------------------------------------------------------Platinum
    public static final Item PLATINUM_INGOT = register("platinum_ingot", new Item(new Item.Settings()));
    public static final Item PLATINUM_NUGGET = register("platinum_nugget", new Item(new Item.Settings()));
    public static final Item PLATINUM_DUST = register("platinum_dust", new Item(new Item.Settings()));
    public static final Item RAW_PLATINUM = register("raw_platinum", new Item(new Item.Settings()));
    public static final Item PLATINUM_HELMET = register("platinum_helmet", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item PLATINUM_CHESTPLATE = register("platinum_chestplate", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item PLATINUM_LEGGINGS = register("platinum_leggings", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item PLATINUM_BOOTS = register("platinum_boots", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item PLATINUM_SWORD = register("platinum_sword", new SwordItem(ModToolMaterials.PLATINUM, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.PLATINUM, 7, -2.4f))));
    public static final Item PLATINUM_PICKAXE = register("platinum_pickaxe", new PickaxeItem(ModToolMaterials.PLATINUM, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.PLATINUM, 2, -2.8f))));
    public static final Item PLATINUM_AXE = register("platinum_axe", new AxeItem(ModToolMaterials.PLATINUM, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.PLATINUM, 8.0F, -3.0f))));
    public static final Item PLATINUM_SHOVEL = register("platinum_shovel", new ShovelItem(ModToolMaterials.PLATINUM, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.PLATINUM, 5.0F, -3.0f))));
    public static final Item PLATINUM_HOE = register("platinum_hoe", new HoeItem(ModToolMaterials.PLATINUM, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.PLATINUM, 0, 0.0F))));

//--------------------------------------------------------------------------------------------------------------Sapphire

    public static final Item SAPPHIRE = register("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_DUST = register("sapphire_dust", new Item(new Item.Settings()));
    public static final Item RAW_SAPPHIRE = register("raw_sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_HELMET = register("sapphire_helmet", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item SAPPHIRE_CHESTPLATE = register("sapphire_chestplate", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item SAPPHIRE_LEGGINGS = register("sapphire_leggings", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item SAPPHIRE_BOOTS = register("sapphire_boots", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item SAPPHIRE_SWORD = register("sapphire_sword", new SwordItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3, -2.4f))));
    public static final Item SAPPHIRE_PICKAXE = register("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 2, -2.8f))));
    public static final Item SAPPHIRE_AXE = register("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 5, -3.1f))));
    public static final Item SAPPHIRE_SHOVEL = register("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 0, -3.4f))));
    public static final Item SAPPHIRE_HOE = register("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, -1, -1f))));

    //--------------------------------------------------------------------------------------------------------------Sapphire
    public static final Item RUBY = register("ruby", new Item(new Item.Settings()));
    public static final Item RUBY_DUST = register("ruby_dust", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = register("raw_ruby", new Item(new Item.Settings()));
    public static final Item RUBY_HELMET = register("ruby_helmet", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item RUBY_LEGGINGS = register("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item RUBY_BOOTS = register("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item RUBY_SWORD = register("ruby_sword", new SwordItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 3, -2.6f))));
    public static final Item RUBY_PICKAXE = register("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 2, -3.0f))));
    public static final Item RUBY_AXE = register("ruby_axe", new AxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 5, -3.3f))));
    public static final Item RUBY_SHOVEL = register("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY, 0, -3.6f))));
    public static final Item RUBY_HOE = register("ruby_hoe", new HoeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.RUBY, -1, -1f))));

    //----------------------------------------------------------------------------------------------------------------Bronze
    public static final Item BRONZE_INGOT = register("bronze_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = register("bronze_nugget", new Item(new Item.Settings()));
    public static final Item BRONZE_DUST = register("bronze_dust", new Item(new Item.Settings()));
    public static final Item BRONZE_HELMET = register("bronze_helmet", new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BRONZE_CHESTPLATE = register("bronze_chestplate", new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item BRONZE_LEGGINGS = register("bronze_leggings", new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item BRONZE_BOOTS = register("bronze_boots", new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS,
            new ArmorItem.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item BRONZE_SWORD = register("bronze_sword", new SwordItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE, 4, -2.4F))));
    public static final Item BRONZE_PICKAXE = register("bronze_pickaxe", new PickaxeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(
            PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 3, -2.8F))));
    public static final Item BRONZE_AXE = register("bronze_axe", new AxeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(
            AxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 8, -3.1F))));
    public static final Item BRONZE_SHOVEL = register("bronze_shovel", new ShovelItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(
            ShovelItem.createAttributeModifiers(ModToolMaterials.BRONZE, 4, -3.0F))));
    public static final Item BRONZE_HOE = register("bronze_hoe", new HoeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(
            HoeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 0, -1.0F))));

    //-----------------------------------------------------------------------------------------------------------------Items
    public static final Item RAW_DIAMOND = register("raw_diamond", new Item(new Item.Settings()));
    public static final Item DIAMOND_DUST = register("diamond_dust", new Item(new Item.Settings()));
    public static final Item RAW_EMERALD = register("raw_emerald", new Item(new Item.Settings()));
    public static final Item EMERALD_DUST = register("emerald_dust", new Item(new Item.Settings()));
    public static final Item RAW_LAPIS = register("raw_lapis", new Item(new Item.Settings()));
    public static final Item LAPIS_DUST = register("lapis_dust", new Item(new Item.Settings()));
    public static final Item IRON_DUST = register("iron_dust", new Item(new Item.Settings()));
    public static final Item RAW_REDSTONE = register("raw_redstone", new Item(new Item.Settings()));
    public static final Item BATTERY = register("battery", new BatteryItem(new Item.Settings().maxCount(1)));

    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(KrystalCraft.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
        EnergyStorage.ITEM.registerForItems((itemStack, context) -> {
            if (itemStack.getItem() instanceof BatteryItem batteryItem) {
                return SimpleEnergyItem.createStorage(context,
                        batteryItem.getEnergyCapacity(itemStack),
                        batteryItem.getEnergyMaxInput(itemStack),
                        batteryItem.getEnergyMaxOutput(itemStack)
                );
            }

            return null;
        }, BATTERY);
    }
}
