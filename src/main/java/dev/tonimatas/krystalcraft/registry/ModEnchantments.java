package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.enchantment.*;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModEnchantments {
    public static final RegistryKey<Enchantment> FREEZING = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(KrystalCraft.MOD_ID, "freezing"));
    public static final RegistryKey<Enchantment> LIGHTNING_STRIKER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(KrystalCraft.MOD_ID, "lightning_striker"));
    public static final RegistryKey<Enchantment> VENOM = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(KrystalCraft.MOD_ID, "venom"));
    public static final RegistryKey<Enchantment> LIFE_LEECH = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(KrystalCraft.MOD_ID, "life_leech"));
    public static final RegistryKey<Enchantment> XP_LEECH = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(KrystalCraft.MOD_ID, "xp_leech"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);
        
        register(registerable, FREEZING, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                3,
                Enchantment.leveledCost(5, 7),
                Enchantment.leveledCost(25, 9),
                2,
                AttributeModifierSlot.MAINHAND))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM, new FreezingEnchantmentEffect()));

        register(registerable, LIGHTNING_STRIKER, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        2,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM, new LightningStrikeEnchantmentEffect()));

        register(registerable, VENOM, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        3,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM, new VenomEnchantmentEffect()));

        register(registerable, LIFE_LEECH, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        3,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM, new LifeLeechEnchantmentEffect()));

        register(registerable, XP_LEECH, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        5,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM, new XpLeechEnchantmentEffect()));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
