package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> JADE = registerArmorMaterial("jade", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 6);
            }), 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.JADE), 
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "jade"))), 1.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TOPAZ = registerArmorMaterial("topaz", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 7);
            }), 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.TOPAZ),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "topaz"))), 1.2f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SILVER = registerArmorMaterial("silver", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 7);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModItems.SILVER_INGOT),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "silver"))), 0.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> LEAD = registerArmorMaterial("lead", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 8);
            }), 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.LEAD_INGOT),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "lead"))), 1.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TIN = registerArmorMaterial("tin", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 6, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, () -> Ingredient.ofItems(ModItems.TIN_INGOT),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "tin"))), 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> PLATINUM = registerArmorMaterial("platinum", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 9);
            }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.PLATINUM_INGOT),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "platinum"))), 2.0f, 1.0f));

    public static final RegistryEntry<ArmorMaterial> COPPER = registerArmorMaterial("copper", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.COPPER_INGOT),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "copper"))), 0.2f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = registerArmorMaterial("sapphire", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }), 28, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.SAPPHIRE),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "sapphire"))), 1.3f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> RUBY = registerArmorMaterial("ruby", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 6);
            }), 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.RUBY),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "ruby"))), 1.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> BRONZE = registerArmorMaterial("bronze", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 6);
            }), 7, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT),
            List.of(new ArmorMaterial.Layer(Identifier.of(KrystalCraft.MOD_ID, "bronze"))), 1.0f, 0.0f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(KrystalCraft.MOD_ID, name), material.get());
    }
}